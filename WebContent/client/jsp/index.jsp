<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="client/js/jquery.js"></script>
<script src="client/js/custom/home.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="client/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="client/css/style.css">
<title>Shop</title>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <jsp:include page="./static/header.jsp"></jsp:include>
    </div>

    <!-- Show products -->
    <div class="main">
        <div class="container">
            <div class="title-list">Tất cả sản phẩm</div>
            <div class="tools-list flex flex-start">
                <div class="label-tool">Sắp xếp theo</div>
                <button class="btn btn-selected" id="sort-by-id">Mã sản phẩm</button>
                <button class="btn btn-no-selected" id="sort-by-name">Tên sản phẩm</button>
                <button class="btn btn-no-selected" id="sort-by-price">Giá bán</button>
            </div>

            <div class="list-product flex flex-start" id="list-product">
                <!-- List product -->
                <c:forEach items="${products}" var="product">
                    <div class="item-product">
                        <div class="item-wrap">
                            <img src="client/images/${product.img}" class="thumb">
                            <div class="info">
                                <div class="name">
                                    <a href="product?id=${product.id}">${product.name}</a>
                                </div>
                                <div class="price-sale flex">
                                    <div class="price">
                                        <fmt:formatNumber type="number" pattern="###,###" value="${product.price}"></fmt:formatNumber> VNĐ
                                    </div>
                                    <div class="count-sales">${product.category.name}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="paginate flex flex-end">
                <a href="shop?page=1">Xem tất cả sản phẩm</a>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        <jsp:include page="./static/footer.jsp"></jsp:include>
    </div>
</body>
</html>