<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Product List</title>
    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      rel="stylesheet" />

    <script>
      function validateForm() {
        var name = document.forms["productForm"]["name"].value;
        var price = document.forms["productForm"]["price"].value;
        if (name === "") {
          alert("Name must be filled out");
          return false;
        }
        if (isNaN(price) || price <= 0) {
          alert("Price must be a positive number");
          return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
    <div class="container">
      <h1 class="my-4">Product List</h1>

      <table class="table table-bordered">
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="product" items="${products}">
            <tr>
              <td>${product.name}</td>
              <td>${product.price}</td>
              <td>${product.description}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

      <h2 class="my-4">Add New Product</h2>
      <form
        name="productForm"
        action="/products/add"
        method="post"
        onsubmit="return validateForm()">
        <div class="form-group">
          <label for="name">Product Name</label>
          <input type="text" class="form-control" id="name" name="name" />
        </div>
        <div class="form-group">
          <label for="price">Price</label>
          <input type="text" class="form-control" id="price" name="price" />
        </div>
        <div class="form-group">
          <label for="description">Description</label>
          <textarea
            class="form-control"
            id="description"
            name="description"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Add Product</button>
      </form>
    </div>
  </body>
</html>
