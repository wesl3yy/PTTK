<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem sản phẩm - ${product.name}</title>
<meta property="fb:app_id" content="210865283197643"/>
<script src="https://kit.fontawesome.com/8bc099c2d2.js" crossorigin="anonymous"></script>
<script src="client/js/jquery.js"></script>
<script src="client/js/custom/product.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
                <a href="./">Trang chủ</a> > <a href="category?id=${product.category.id}">${product.category.name}</a> > ${product.name}
            </div>
            <div class="box-wrap flex flex-start">
                <div class="image-info">
                    <img src="client/images/${product.img}" class="image-info-img">
                </div>
                <div class="detail-info flex flex-column">
                    <div class="name-info">${product.name}</div>
                    <div class="price-info"><fmt:formatNumber type="number" pattern="###,###" value="${product.price}"></fmt:formatNumber> VNĐ</div>
                    <div class="number-info">
                        Số lượng <input type="number" value="1" min="1" class="input-sweet input-number">
                    </div>
                    <div class="empty-box">
                        <form action="add-to-cart" method="GET">
                            <input type="hidden" name="id" value="${product.id}">
                            <input type="hidden" name="quantity" value="1" id="product-quantity">
                            <input type="submit" value="Thêm vào giỏ hàng" class="check-out"/>
                        </form>
                    </div>
                </div>
            </div>

            <div class="box-wrap">
                <div class="title-sweet">Thông tin chi tiết sản phẩm</div>
                
                    <c:if test = "${product.type == 'magazine'}">
                        <div><p>Ngày xuất bản: ${product.publicdate}</p></div>
                        <div><p>Số trang: ${product.numberofpage}</p></div>
                        <div><p>Ngôn ngữ: ${product.language}</p></div>
                    </c:if>
                
                    <c:if test = "${product.type == 'books'}">
                        <div><p>Ngày xuất bản: ${product.publicdate}</p></div>
                        <div><p>Số trang: ${product.numberofpage}</p></div>
                        <div><p>Ngôn ngữ: ${product.language}</p></div>
                        <div><p>Tác giả: ${product.author}</p></div> 
                        <div><p>Nhà xuất bản: ${product.publisher}</p></div>
                    </c:if>
            </div>
        </div>
    </div>
            
    <!-- Footer -->
    <div class="footer">
        <jsp:include page="./static/footer.jsp"></jsp:include>
    </div>
</body>
</html>