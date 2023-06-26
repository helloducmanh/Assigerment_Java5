<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="bg-login">
    <div class="login-form">
        <h3>ADD CATEGORY</h3>
        <form action="/admin/category/save" method="POST" style="margin-top: 30px;" modelAttribute="category">
            <div class="mt-3">
                <label for="id" class="mb-1">Id</label>
                <input  name="id" type="text" class="form-control" value="${category.id}"  />
             </div>
            <div class="mt-3">
                <label for="name" class="mb-1">Name</label>
                <input name="name"  type="text" class="form-control" value="${category.name}"  />
            </div>
            <div class="mt-3">${message}</div>
            <div style="margin-top: 35px;">
                <button type="submit" class="btn btn-primary" style="width: 100%;">ADD</button>
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