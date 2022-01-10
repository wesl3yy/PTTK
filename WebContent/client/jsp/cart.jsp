<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="client/js/jquery.js"></script>
<script src="client/js/custom/cart.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="client/css/style.css">
<title>Giỏ hàng của bạn</title>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <jsp:include page="./static/header.jsp"></jsp:include>
    </div>

    <div class="main">
        <div class="container">
            <div class="breadcumb">
                <a href="./">Trang chủ</a> > Giỏ hàng
            </div>
            <c:if test="${order == null}">
                <p>
                    Giỏ hàng của bạn đang trống
                    <a href="./">Về trang chủ</a>
                </p>
            </c:if>
            <c:if test="${order != null}">
                <div class="box-wrap flex flex-center"
                    style="flex-direction: column; align-items: center;">
                    <div class="table">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Hình ảnh</th>
                                    <th>Tên sản phẩm</th>
                                    <th>SL</th>
                                    <th>Action</th>
                                    <th>Giá</th>
                                    <th>Thành tiền</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1" scope="page"></c:set>
                                <c:forEach items="${order.items}" var="item">
                                    <tr>
                                        <td>${count }</td>
                                        <td><img src="client/images/${item.product.img}" style="width: 50px;"></td>
                                        <td><a href="product?id=${item.product.id}">${item.product.name }</a></td>
                                        <td class="text-center"><input type="number" min="1" class="input-sweet input-number" value="${item.quantity}"></td>
                                        <td><a href="delete-item?product=${item.product.id}"></a></td>
                                        <td><fmt:formatNumber type="number" pattern="###,###" value="${item.product.price}"></fmt:formatNumber> VNĐ</td>
                                        <td><fmt:formatNumber type="number" pattern="###,###" value="${item.product.price * item.quantity}"></fmt:formatNumber> VNĐ</td>
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

                    <div style="margin-top: 30px">
                        <div class="flex">
                            <select name="paymethod" class="input-sweet" required="required"
                                style="margin-right: 10px; margin-bottom: 0px">
                                <option value="cod">COD (thanh toán khi nhận hàng)</option>
                                <option value="atm">Thanh toán qua ATM</option>
                            </select>
                            <a href="order"><button class="btn btn-yes">Tiến hành thanh toán</button></a>
                        </div>
                    </div>
                    <hr>
                </div>
            </c:if>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer fixed-bottom">
        <jsp:include page="./static/footer.jsp"></jsp:include>
    </div>

</body>
</html>