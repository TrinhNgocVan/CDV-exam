<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng ký mới tài khoản ngân hàng </title>
<link rel="stylesheet" type="text/css" href="<c:url value='/themes/login/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/themes/login/css/fontawesome-all.min.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/themes/login/css/iofrm-style.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/themes/login/css/iofrm-theme3.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/themes/login/css/main.css'/>" />
</head>
<body>
	<div class="form-body" class="container-fluid">
		<div class="row">
			<div class="img-holder">
				<div class="bg"></div>
				<div class="info-holder"></div>
			</div>
			<div class="form-holder">

				<div class="form-content">
					<div class="form-items">
						<img src='<c:url value="/themes/login/images/logo_mavin_group.jpg"/>' height="200px" width="400px" style="margin-bottom: 10%">
						<form method="post" id="accountRegisterForm" action="<c:url value='/accountRegister/save'/>">
							<span>Họ tên</span>
							<input class="form-control input-login" type="text" name="appUser.username" placeholder="Họ tên đầy đủ..." required autofocus="autofocus" />
							<span>Số căn cước/CMT công dân </span>
							<input class="form-control input-login" type="text" name="peopleId" placeholder="Số căn cước/CMT công dân..." required />
							<span>Số điện thoại</span>
							<input class="form-control input-login" type="tel" name="telephone" placeholder="Số điện thoại..."" required autofocus="autofocus" />
							<span>Địa chỉ</span>
							<input class="form-control input-login" type="text" name="address" placeholder="Địa chỉ..." required />
							<span>Email</span>
							<input class="form-control input-login" type="email" name="email" placeholder="Email..." required autofocus="autofocus" />
							<div class="form-button">
								<button id="submit" type="submit" class="ibtn btn-login">Đăng ký</button>
							</div>
						</form>
						<div class="other-links">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/themes/login/js/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/themes/login/js/popper.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/themes/login/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/themes/login/js/main.js'/>"></script>
</body>
</html>