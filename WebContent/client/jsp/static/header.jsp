<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="./" id="logo"><i class="fa-solid fa-shop"></i> SHOP </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                     <a class="nav-link active" aria-current="page" href="./">Trang chủ</a>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Sản phẩm
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach items="${categories}" var="category">
                            <li><a class="dropdown-item text-black" href="category?id=${category.id}&page=1">${category.name }</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="invoices">Lịch sử giao dịch</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart">Giỏ hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="account">Tài khoản</a>
                </li>
                <c:if test="${empty login_user}">
                    <li class="nav-item">
                        <a class="nav-link" href="register">Đăng kí</a>
                    </li>
                </c:if>
            </ul>
            <form class="d-flex bg-dark" action="search" method="get">
                <input class="form-control-md me-2" type="text" placeholder="Tìm kiếm..." aria-label="Search" name="keyword">
                <button class="btn-md btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
