<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary p-0">
  <div class="navbar-nav collapse navbar-collapse">
    <a class="nav-item nav-link" href="/admin/category/index  ">Quản lý nhóm sản phẩm</a>
    <a class="nav-item nav-link" href="/admin/product/index">Quản lý sản phẩm</a>
    <a class="nav-item nav-link" href="/admin/account/index">Quản lý tài khoản</a>
    <a class="nav-item nav-link" href="/admin/order/index">Quản lý đơn hàng</a>
    <a class="nav-item nav-link" href="/">Màn hình chính</a>
  </div>

  <ul class="navbar-nav ml-auto">
    <li class="nav-item no-arrow">
      <a class="nav-link dropdown-toggle p-0" data-bs-toggle="dropdown" href="#">
        <img alt="" class="rounded-circle" style="width:60px"
          src="/static/images/user.svg" />${userCurrent.username}
      </a>
      <ul class="dropdown-menu dropdown-menu-end">
        <li>
            <a class="dropdown-item dropdown-menu-end" href="/logout">Đăng xuất</a>
        </li>
      </ul>
    </li>
  </ul>
</nav>