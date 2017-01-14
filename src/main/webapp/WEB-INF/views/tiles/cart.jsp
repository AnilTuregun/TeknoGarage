<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th class="text-center">Price</th>
                    <th class="text-center">Total</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="shoppingCart" items="${shoppingCarts}">
                <tr class="productRow">

                    <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${shoppingCart.product.productImage}" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${shoppingCart.product.productName}</a></h4>

                            </div>
                        </div></td>
                    <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input onchange="UpdateSubtotal()" type="email" class="form-control" id="productQuantity" value="${shoppingCart.quantity}">
                    </td>
                    <td id="productPrice" class="col-sm-1 col-md-1 text-center"><strong>${shoppingCart.product.productPrice}</strong></td>
                    <td class="col-sm-1 col-md-1 text-center" id="subTotal" >${shoppingCart.quantity*shoppingCart.product.productPrice}</td>
                    <td class="col-sm-1 col-md-1">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span>
                            <a href="/cart/remove/${shoppingCart.product.productName}">Remove</a>

                        </button></td>
                </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><h5>Total</h5></td>
                    <td class="text-right"><h5><strong>$${total}</strong></h5></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="/home"  class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </a></td>
                    <td>
                        <a href="/checkOut" class="btn btn-success" >
                            Check-Out
                        </a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script>
  $(document).ready(function () {
      console.log("sdfaa");
     /*UpdateSubtotal();*/
      console.log("sdfaa");
      Total();
      console.log("fafaaaaaaaf");
  });
    function UpdateSubtotal() {
      /*  $('.productRow').each(function (index) {
            var quantity=$(this).find('input#productQuantity').text();
            var price=$(this).find('td#productPrice').text();
            console.log("sdf");
            console.log(quantity);
            console.log("sdf");
            console.log(price);
            console.log("aaaaaaaaaaaaa");

            $(this).find('td#subTotal').text(quantity);


        });*/
    }
    function Total() {
        var total=0;
        $('#subTotal').each(function (index) {
,
        total +=parseInt( $('#subTotal').index(index).text());



        });
        $(this).find('#total').text(total);
        alert(total);
    }
</script>