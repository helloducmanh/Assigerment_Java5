<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary p-0">
    <div class="navbar-nav collapse navbar-collapse">
        <a class="nav-item nav-link active" href="/">Trang chủ</a>
        <a class="nav-item nav-link" href="/about">Giới thiệu</a>
    </div>

    <ul class="navbar-nav ml-auto">
        <li class="nav-item no-arrow">
            <c:if test="${cart.total > 0}">
                <a href="/cart" class="nav-link mt-2 text-light">
                    <img alt="" style="width:40px"
                         src="/static/images/cart.png"/>
                    (${cart.total})
                </a>
            </c:if>
        </li>
        <li class="nav-item no-arrow">
            <a class="nav-link dropdown-toggle p-0" data-bs-toggle="dropdown" href="#">
                <img alt="" class="rounded-circle" style="width:60px"
                     src="/static/images/user.svg"/> ${userCurrent.username}
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
                <li>
                    <c:if test="${userCurrent == null}">
                        <a class="dropdown-item dropdown-menu-end " href="/login">Đăng Nhập</a>
                    </c:if>
                </li>
                <li>
                    <c:if test="${userCurrent != null}">
                        <a class="dropdown-item dropdown-menu-end" href="/logout">Đăng xuất</a>
                    </c:if>
                </li>

                <li>
                    <c:if test="${userCurrent.admin ==true}">
                        <a class="dropdown-item dropdown-menu-end" href="/admin/category/index">Trang quản trị</a>
                    </c:if>
                </li>
            </ul>

        </li>
    </ul>
</nav>