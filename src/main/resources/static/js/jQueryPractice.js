var deleteUserId = -1;

// 操作結果
const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
const appendAlert = (message, type) => {
  const wrapper = document.createElement('div')
  wrapper.innerHTML = [
    `<div class="alert alert-${type} alert-dismissible" role="alert">`,
    `   <div>${message}</div>`,
    '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
    '</div>'
  ].join('')

  alertPlaceholder.append(wrapper)
}


// 削除時ユーザーIdを取得
function getDeleteUserId(userId){
	deleteUserId=userId;
}

//初期化メソッド（自動的に実行）
$(document).ready(function(){
	// 保存ボタンがクリックされた時
	$("#saveBtn").on("click",function(){
		// フォームのデータを取得
		var userName = $("input[aria-label='userName']").val();
		var userSex = $("select[aria-label='sex']").val();
		var address = $("#basic-address").val();
		// ユーザー追加メソッド
		save(userName,userSex,address);
	})
})

// ユーザー追加
function save(userName,userSex,address){
	$.ajax({
		url:'', //　リクエストを送信URL
		type:'', //　HTTPメソッド（GETまたはPOST等）
		data:{
			"userName":userName,
			"userSex":userSex,
			"address":address
		}, //　サーバーに送るデータ（GETでURLに、POSTはリクエストボディに含まれる）
		dataType:'json', // サーバーからのレスポンスのデータタイプ（json,text,html等）
		success:function(response){
			// リクエスト成功時の処理
		},
		error:function(xhr,status,error){
			// エラー時の処理
		},
		complete:function(xhr,status){
			// 完了時の処理
			appendAlert('完了!', 'success');
		}
	})
}

// ユーザー削除操作
function deleteUser(){
	$.ajax({
		url:'', //　リクエストを送信URL
		type:'', //　HTTPメソッド（GETまたはPOST等）
		data:{
			"userId":deleteUserId,
		}, //　サーバーに送るデータ（GETでURLに、POSTはリクエストボディに含まれる）
		dataType:'json', // サーバーからのレスポンスのデータタイプ（json,text,html等）
		success:function(response){
			// リクエスト成功時の処理
		},
		error:function(xhr,status,error){
			// エラー時の処理
		},
		complete:function(xhr,status){
			// 完了時の処理
			appendAlert('完了!', 'warning');
		}
	})
}

// 更新メソッド、練習のために別のページにデータを転送して更新する
function update(userId){
	// ページ履歴に新しいエントリを追加して遷移
    // window.location.assign('https://example.com');
	
	// ページ履歴に残さずに遷移
    // window.location.replace('https://example.com');
	
	// 普通の遷移
	 window.location.href = '/api/users/update?id='+userId;  // 新しいページのURL
}

