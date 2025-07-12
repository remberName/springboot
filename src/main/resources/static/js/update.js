
// ユーザー追加
function save(userId) {

	// フォームのデータを取得
	var userName = $("input[aria-label='userName']").val();
	var userSex = $("select[aria-label='sex']").val();
	var address = $("#basic-address").val();

	$.ajax({
		url: '', //　リクエストを送信URL
		type: '', //　HTTPメソッド（GETまたはPOST等）
		data: {
			"userId":userId,
			"userName": userName,
			"userSex": userSex,
			"address": address
		}, //　サーバーに送るデータ（GETでURLに、POSTはリクエストボディに含まれる）
		dataType: 'json', // サーバーからのレスポンスのデータタイプ（json,text,html等）
		success: function(response) {
			// リクエスト成功時の処理
			 
		},
		error: function(xhr, status, error) {
			// エラー時の処理
		},
		complete: function(xhr, status) {
			// 完了時の処理
			window.location.href = '/api/users';
		}
	})
}