"use strict";
// fetchでデータを取得
fetch('/api/users/') // 請求したいcontrollerクラスのurl
    .then(response => response.json()) // 戻ったデータを解析
    .then(userList => {
    // ここで戻ったデータをJSPに渡す
    console.log("data");
    displayData(userList);
}).catch(error => console.error('Error fetching data:', error)); // 異常処理
// jspでデータを展示する。EL式forEachでいいですか、ここは練習のため、HTMLここで作成
function displayData(userList) {
    // idによってDomを取得
    const userListElement = document.getElementById("data");
    // dom取れるなら、データを展示
    if (userListElement) {
        userList.forEach(user => {
            const showItem = document.createElement("tr");
            showItem.innerHTML = `<td>${user.userName}</td><td>${user.userSex}</td><td>${user.address}</td>`;
            userListElement.appendChild(showItem);
        });
    }
}
// class練習
class Student {
    constructor() {
        this.name = "ss";
        this.age = 14;
    }
}
// 再利用できるメソッド（引数名:引数の型）:戻り値の型
function greet(student) {
    student.name = "マリア";
    return student;
}
//　オブジェクト指向
class Dog {
    //初期化メソッド
    constructor(dogId) {
        // 変更不可なプロパティ
        this.dogId = 110;
        this.dogId = dogId;
        this.animal = { name: "犬", sound: "ワンワン" }; // 初期化
        this.age = 0; // 初期値
    }
    // setメッソド
    setAge(age) {
        this.age = age;
    }
    // getメソッド
    getAge() {
        return this.age;
    }
    // getAnimal
    getAnimal() {
        return this.animal;
    }
    // getDogId
    getDogId() {
        return this.dogId;
    }
}
class Main {
    //　初期化メソッド
    constructor() {
        this.student = new Student();
        this.dog = new Dog(110);
    }
    execute() {
        console.log("studentクラス");
        console.log(`${this.student.name} -> ${this.student.age}`);
        const maria = greet(this.student);
        console.log("greenメソッド");
        console.log(`${maria.name} -> ${maria.age}`);
        this.dog.setAge(10);
        console.log("dogクラス");
        console.log(this.dog.getAnimal().name);
        console.log(this.dog.getAnimal().sound);
        console.log(this.dog.getAge());
        console.log(this.dog.getDogId());
    }
}
// 実行
const mainInstance = new Main();
mainInstance.execute();
