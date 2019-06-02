<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>欢迎登录</title>
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
		<script src="bootstrap/js/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script src="js/login.js"></script>
</head>
<body>
<div class="login_table">
		<h1>欢迎登录</h1>
		<form class="form-horizontal container-fluid">
				
				<div class="form-group row">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-8">
								<input type="email" id="email" class="form-control" placeholder="Email"/>
						</div>
						<label class="col-sm-2">&nbsp;</label>
						<label id="lab_email" class="col-sm-5">&nbsp;</label>
				</div>
				
				<div class="form-group row">
						<label for="password" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-8">
								<input type="password" id="password" class="form-control" placeholder="Password">
						</div>
						<label class="col-sm-2">&nbsp;</label>
						<label id="lab_password" class="col-sm-5">&nbsp;</label>
				</div>
				
				
				<!--3 2 2 2 3-->
				<div class="form-group row btn_group">
						<div class=" col-sm-3"></div>
						<div class=" col-sm-2">
								<button type="submit" class="btn">Sign in</button>
						</div>
						<div class="col-sm-2"></div>
						<div class="col-sm-2">
								<button type="submit" class="btn">Cancel</button>
						</div>
						<div class="col-sm-3"></div>
				</div>
		</form>
		
</div>
</body>
</html>