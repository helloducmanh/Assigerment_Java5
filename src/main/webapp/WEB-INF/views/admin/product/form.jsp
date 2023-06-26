<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<div class="bg-login">
    <div class="login-form">
        <h3>Them San Pham</h3>
        <form action="/admin/product/save" method="POST" style="margin-top: 30px;" enctype="multipart/form-data" modelAttribute="product">
            <div class="mt-3">
                <label for="name" class="mb-1">Ten san pham</label>
                <input name="name" type="text" class="form-control" value="${product.name}"  />
            </div>
            <div class="mt-4">
                <label for="" class="mb-1">Gia</label>
                <input name="price" type="text" class="form-control" value="${product.price}"  />
            </div>
            <div class="mt-4">
                <label for="category" class="mb-1">Category</label>
                <select  name="category"    class="form-control  " >
                    <option value="">----------</option>
                    <c:forEach items="${category}" var="category">
                        <option value="${category.id}" ${category.id==product.category.id ? 'selected="selected"':''}>${category.name}</option>
                    </c:forEach>
                </select>
            </div>


            <div class="mb-3">
                <label for="" class="mb-1">Image</label>
                <input name="image" type="file" class="form-control"   />
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
    #img_product:hover{
        cursor: pointer;
    }
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

