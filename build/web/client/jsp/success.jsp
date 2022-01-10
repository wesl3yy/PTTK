<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="client/js/jquery.js"></script>
<script src="client/js/custom/home.js"></script>
<script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="client/css/style.css">
<title>Mua hàng thành công</title>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <div class="header">
            <jsp:include page="./static/header.jsp"></jsp:include>
        </div>
    </div>
	
    <!-- Show products -->
    <div class="main">
        <div class="container">
            <p>Cảm ơn quý khách đã mua hàng tại shop.<a href="./">Trang chủ</a></p>
        <</div>	
        </div>
    </div>
	
    <!-- Footer -->
    <div class="footer fixed-bottom">
        <jsp:include page="./static/footer.jsp"></jsp:include>
    </div>
</body>
</html>