<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Đăng nhập - Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="client/css/style.css">
</head>
<body>	
    <div class="main">
        <div class="container flex flex-center justify-content-center">
            <div class="form-login">
                <h2 class="uppercase">ĐĂNG NHẬP</h2>
                <c:if test="${errorMess != null}">
                    <div class="errors-message">
                        ${errorMess}
                    </div>
                </c:if>
                <form action="login" method="POST">
                    <input class="input-sweet" type="text" name="username" placeholder="Nhập vào tên tài khoản">
                    <input class="input-sweet" type="password" name="password" placeholder="Nhập vào mật khẩu">
                    <div class="flex">
                        <button type="submit" class="btn btn-yes">Đăng nhập</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>