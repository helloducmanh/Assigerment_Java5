<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="bg-login">
    <div class="login-form">
        <h3>Đăng Ký</h3>
        <form action="/admin/account/save" method="POST" style="margin-top: 30px;">
            <div class="mt-3">
                <label for="username" class="mb-1">Tên tài khoản</label>
                <input name="username" type="text" class="form-control"  />

            </div>
            <div class="mt-4">
                <label for="password" class="mb-1">Mật khẩu</label>
                <input name="password" type="password" class="form-control" />

            </div>
            <div class="mt-4">
                <label for="fullname" class="mb-1">Full Name</label>
                <input name="fullname" type="text" class="form-control" />

            </div>
            <div class="mt-4">
                <label for="email" class="mb-1">Email</label>
                <input name="email" type="email" class="form-control" />

            </div>
            <div class="mt-3">
                <span id="error" style="color:red">${message}</span>
            </div>
            <div style="margin-top: 35px;">
                <button type="submit" class="btn btn-primary" style="width: 100%;">Đăng Ký</button>
            </div>
        </form>
    </div>
</div>

<style>
    .bg-login {
        position: relative;
        width: 100%;
        min-height: auto;
        background-position: right 0px top 0px;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
    }

    .login-form {
        border: 1px solid #DDD;
        max-width: 400px;
        padding: 20px;
        margin-top: 100px;
        margin-left: auto;
        margin-right: auto;
    }
</style>