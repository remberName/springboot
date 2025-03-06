function calculation(){
  // inputから数字を取得
  let num1 = parseInt(document.getElementById("num1").value);
  let num2 = parseInt(document.getElementById("num2").value);
  // 計算方を取得
  let sgin = parseInt(document.getElementById("sign").value);

  //　選んだ計算記号によって計算する
  let answer = 0;
    switch(sgin){
      // +
      case 1:
          answer = num1+num2;
          break;
      // -
      case 2:
          answer = num1-num2;
          break;
      // *
      case 3:
          answer = num1*num2;
          break;
      // /
      case 4:
          answer = num1/num2;
          break;
    }
  // 結果を表示
  document.getElementById("answer").textContent = answer;
};

function isNumber(){
	// 目標数字を取得
	let num = Number(document.getElementById("num3").value);
    // 判定
    if(num%2===0){
    	// 偶数
		document.getElementById("isNumber").textContent ="偶数";
    }else{
    	// 奇数
        document.getElementById("isNumber").textContent ="奇数";
    }
};

// idはfetchDataのボタンのクリック事件にリスナーを追加  // ボタンクリック時に非同期通信を行う
document.getElementById('fetchData').addEventListener('click', async function() {
      // JSONPlaceholder の API を使ってユーザー情報を取得
      try {
        let response = await fetch('https://jsonplaceholder.typicode.com/users');
        
        // ステータスコードが OK かどうかを確認
        if (!response.ok) {
          throw new Error('ネットワークエラー');
        }
        
        // レスポンスを JSON に変換
        let users = await response.json();
        
        // 取得したデータを HTML に表示
        let userInfo = document.getElementById('userInfo');
        userInfo.innerHTML = '<ol>';
        users.forEach(user => {
          userInfo.innerHTML += '<li>'+user.name +':'+ user.email+'</li>';
        });
        userInfo.innerHTML += '</ol>';
      } catch (error) {
        // エラーが発生した場合
        document.getElementById('userInfo').innerHTML = 'エラー:'+ error.message;
      }
    });

// fetch を使ってデータを送信する
document.getElementById('sendData').addEventListener('click', async function() {
      // 送信するデータ
      const postData = {
        title: "新しい投稿",
        body: "これは新しい投稿です。",
        userId: 1
      };

      try {
        let response = await fetch('https://jsonplaceholder.typicode.com/posts', {
          method: 'POST', // HTTP メソッドを POST に設定
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(postData) // オブジェクトを JSON 文字列に変換して送信
        });

        // レスポンスを JSON として取得
        let result = await response.json();
        
        // 成功した場合のレスポンスを表示
        document.getElementById('responseData').innerHTML = `
          <p>投稿が作成されました！</p>
          <pre>${JSON.stringify(result, null, 2)}</pre>
        `;
      } catch (error) {
        // エラーが発生した場合
        document.getElementById('responseData').innerHTML = `エラー: ${error.message}`;
      }
    });
    
document.getElementById("changeColor").addEventListener("click",function(){
	// 赤
	let red = Math.floor(Math.random()*256);
    // 緑
    let green = Math.floor(Math.random()*256);
    // 黄色
    let yellow = Math.floor(Math.random()*256);
    let color =`rgb(${red},${green},${yellow})`;
    // ボタンを取得
    document.getElementById("changeColor").style.backgroundColor=color;
});