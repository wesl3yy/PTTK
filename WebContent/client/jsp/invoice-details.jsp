<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết hóa đơn</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="client/css/style.css">
</head>
<body>
    <!-- Header -->
    <div class="header">
        <div class="header">
            <jsp:include page="./static/header.jsp"></jsp:include>
        </div>
    </div>

    <div class="main">
        <div class="container">
            <div class="breadcumb">
                <a href="./">Trang chủ</a> > Chi tiết giỏ hàng
            </div>
            <div style="clear:both;"></div>
            <div class="box-wrap flex flex-center" style="flex-direction: column; align-items: center;">
                <div class="table">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tên sản phẩm</th>
                                <th>Giá bán</th>
                                <th>Mã hóa đơn</th>
                                <th>Số lượng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="count" value="1" scope="page"></c:set>
                            <c:forEach items="${items}" var="item">
                                <tr>
                                    <td>${count }</td>
                                    <td>${item.product.name}</td>
                                    <td><fmt:formatNumber type="number" pattern="###,###" value="${item.price}"></fmt:formatNumber> VNĐ</td>
                                    <td>${item.id}</td>
                                    <td>${item.quantity}</td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page"></c:set>
                            </c:forEach>
                            <tr>
                                <td colspan="3"><strong>Tổng cộng : ${quantity }</strong></td>
                                <td colspan="2" style="color: red;"><fmt:formatNumber type="number" pattern="###,###" value="${price}"></fmt:formatNumber> VNĐ</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <hr>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer fixed-bottom">
        <jsp:include page="./static/footer.jsp"></jsp:include>
    </div>
</body>
</html>