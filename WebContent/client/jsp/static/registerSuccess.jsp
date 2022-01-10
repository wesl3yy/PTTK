<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <script src="client/js/jquery.js"></script>
        <script src="client/js/custom/home.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="client/css/style.css">
        <title>Đăng kí thành công</title>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <jsp:include page="header.jsp"></jsp:include>
    </div>
    <div class="main">
        <div class="container">
            Đăng kí thành công. Về trang chủ > <a href="../../../">Home</a>
        </div>
    </div>
    
    <!-- Footer -->
    <div class="footer fixed-bottom">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>