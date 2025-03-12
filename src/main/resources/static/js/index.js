var app = new Vue({
	el: '#app',
	data() {
		return {
			userList: [],  // 初期化は空のリストにしておく
			isAlertVisible: false,
			alertMessage: ""
		};
	},
	mounted() {
		console.log("VUE 初期化成功");
		this.fetchUserData();
	},
	methods: {
		// データをSpring Bootのバックエンドから取得する
		fetchUserData() {
			axios.get('http://localhost:8080/api/users')  // Spring BootのAPIエンドポイントにGETリクエスト
				.then(response => {
					this.userList = response.data;
					this.userList = this.userList.map(user => {
						return {
							...user, // 既存のユーザー情報をそのままコピー
							isReadonly: true, // 新しい属性を追加
							isShowSaveButton: false, // 新しい属性を追加
							isShowUpdateButton: true // 新しい属性を追加
						};
					});
					console.log(response);
				})
				.catch(error => {
					console.error("データ取得エラー:", error);
					this.showAlert("ユーザーデータの取得に失敗しました。");
				});
		},

		// 更新ボタンの処理
		updateButton(index) {
			this.userList[index].isShowUpdateButton = !this.userList[index].isShowUpdateButton;
			this.userList[index].isShowSaveButton = !this.userList[index].isShowSaveButton;
			this.userList[index].isReadonly = false;
		},

		// 保存ボタンの処理
		saveButton(user, index) {
			this.userList[index].isShowUpdateButton = true;
			this.userList[index].isShowSaveButton = false;
			this.userList[index].isReadonly = true;
			this.userList[index] = user;

			// ユーザーIdによって、追加と更新を判断する
			const userId = this.userList[index].userId;


			if (userId === null) {
				// nullの場合は追加
				axios.put(`http://localhost:8080/api/users/addUser`, user)
					.then(response => {
						this.fetchUserData();
						this.showAlert("保存しました");
					})
					.catch(error => {
						console.error("保存エラー:", error);
						this.showAlert("保存に失敗しました。");
					});
			} else {
				// nullではない場合は更新
				axios.put(`http://localhost:8080/api/users/updateUser`, user)
					.then(response => {
						this.fetchUserData();
						this.showAlert("保存しました");
					})
					.catch(error => {
						console.error("保存エラー:", error);
						this.showAlert("保存に失敗しました。");
					});

				this.fetchUserData();
			}
		},

		// 行を追加する
		addRow() {
			this.userList.push({ userId: null, userName: "", userSex: "", address: "", isReadonly: false, isShowSaveButton: true, isShowUpdateButton: false });
		},

		// ユーザーを削除する
		deleteUser(index) {
			const userId = this.userList[index].userId;

			// ユーザーをSpring Bootに削除リクエストする（DELETEリクエスト）
			axios.delete(`http://localhost:8080/api/users/${userId}`)
				.then(response => {
					this.fetchUserData();
					this.showAlert("削除しました");
				})
				.catch(error => {
					console.error("削除エラー:", error);
					this.showAlert("削除に失敗しました。");
				});
		},

		// アラートを表示する
		showAlert(message) {
			this.isAlertVisible = true;
			this.alertMessage = message;
			setTimeout(() => {
				this.isAlertVisible = false;
			}, 2000);
		}
	}
});
