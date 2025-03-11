<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="<c:url value='/js/update.js' />"></script>
</head>
<body class="bg-info container-xl" style="--bs-bg-opacity: .1;">
    <h1 class="text-center">ユーザー情報更新</h1>
    <div class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">
        <!-- 直接显示表单 -->
        <form>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">ユーザー名</span> 
                <input type="text" class="form-control" placeholder="userName" 
                       aria-label="userName" aria-describedby="basic-addon1" value="${user.userName}">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon2">性別</span>
                <select class="form-select" aria-label="sex" aria-describedby="basic-addon2">
                    <option ${user.userSex == '男' ? 'selected' : ''} value="0">男性</option>
                    <option ${user.userSex == '女' ? 'selected' : ''} value="1">女性</option>
                </select>
            </div>

            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text" id="basic-addon3">アドレス</span>
                    <input type="text" class="form-control" id="basic-address" 
                           aria-describedby="basic-address" value="${user.address}">
                </div>
                <div class="form-text">県だけ記入してください</div>
            </div>

            <div class="modal-footer">
                <button type="reset" class="btn btn-secondary">リセット</button>
                <button type="button" class="btn btn-primary" onclick="save(${user.userId })">保存</button>
            </div>
        </form>
    </div>
</body>
</html>