<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="${numberOfOrders != null ? 'active-link' : '' }"><a href="/eshop/admin/home"><i class="fa fa-desktop "></i>Quản lý chung</a></li>
            <li class="${users != null ? 'active-link' : '' }"><a href="/eshop/admin/users-management"><i class="fa fa-qrcode "></i>Quản lý thành viên</a></li>
            <li class="${(orders != null || items != null) ? 'active-link' : '' }"><a href="/eshop/admin/orders-management"><i class="fa fa-bar-chart-o"></i>Quản lý đơn hàng</a></li>
            <li class="${products != null ? 'active-link' : '' }"><a href="/eshop/admin/products-management"><i class="fa fa-edit "></i>Quản lý sản phẩm</a></li>
            <li class="${(categories != null && products == null) ? 'active-link' : '' }"><a href="/eshop/admin/categories-management"><i class="fa fa-table "></i>Quản lý danh mục</a></li>
        </ul>
    </div>
</nav>