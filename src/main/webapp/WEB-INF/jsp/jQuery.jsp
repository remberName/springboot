<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


</head>
<body class="bg-info container-xl" style="--bs-bg-opacity: .1;">
	<h1 class="text-center">ユーザー情報一覧</h1>
	<div class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">
	<div id="liveAlertPlaceholder"></div>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#exampleModal" data-bs-whatever="@mdo">挿入</button>
		<table class="table table-success table-striped">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">name</th>
					<th scope="col">sex</th>
					<th scope="col">address</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.userSex }</td>
						<td>${user.address }</td>
						<td>
							<button type="button" class="btn btn-primary"
								onclick="update(${user.userId })">更新</button>
							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#delete"
								onclick="getDeleteUserId(${user.userId })">削除</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#">最初</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">次へ</a></li>
				<li class="page-item"><a class="page-link" href="#">末尾</a></li>
			</ul>
		</nav>
		<!-- 挿入 -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content bg-primary-subtle">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">挿入</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">ユーザー名</span> <input
									type="text" class="form-control" placeholder="userName"
									aria-label="userName" aria-describedby="basic-addon1">
							</div>

							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon2">性別</span> <select
									class="form-select form-select" aria-label="sex"
									aria-describedby="basic-addon2">
									<option selected value="0">男性</option>
									<option value="1">女性</option>
								</select>
							</div>

							<div class="mb-3">
								<div class="input-group">
									<span class="input-group-text" id="basic-addon3">アドレス</span> <input
										type="text" class="form-control" id="basic-address"
										aria-describedby="basic-address">
								</div>
								<div class="form-text">県だけ記入してください</div>
							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">キャンセル</button>
						<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="saveBtn">保存</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="delete" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">削除確認</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">本当に削除しますか、この操作不可逆です。</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">キャンセル</button>
						<button type="button" onclick="deleteUser()"
							class="btn btn-primary" data-bs-dismiss="modal" >削除</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value='/js/jQueryPractice.js' />"></script>
</body>
</html>