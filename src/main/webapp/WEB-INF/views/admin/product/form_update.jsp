<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<div class="bg-login">
    <div class="login-form">
        <h3>UPDATE San Pham</h3>
        <form action="/admin/product/update/${product.id}" method="POST" style="margin-top: 30px;" enctype="multipart/form-data" modelAttribute="product">
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
                    <div class="mb-3">
                        <label for="img_product" class="mb-1" class="btn btn-primary">Image</label>
                        <input name="image" type="file" class="form-control" id="img_product" style="display:none;" onchange="showImg()"   />
                    </div>

            </div>
            <div class="mb-3">
                <div id="displayImg">
                    <img id = "img_id" src="data:image/jpeg;base64,${product.image}" alt="car_image"
                         style="height: 50px; width: 50px"/>
                </div>
            </div>

            <div class="mt-3">
                <span id="error" style="color:red">${message}</span>
            </div>
            <div style="margin-top: 35px;">
                <button type="submit" class="btn btn-primary" style="width: 100%;">UPDATE</button>
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

<script type="text/javascript">
    function showImg() {
        var files = document.getElementById("img_product").files;
        if (files.length > 0) {
            var file = files[0];
            var fileReader = new FileReader();
            fileReader.onload = function(fileLoaderEvent) {
                var srcData = fileLoaderEvent.target.result;
                var newImg = document.getElementById("img_id");
                newImg.src = srcData;
            }
            fileReader.readAsDataURL(file);
        }
    }
</script>