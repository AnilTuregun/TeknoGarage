<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<!-- Navigation -->

<div id="myModal" class="modal">
    <span class="close">x</span>
    <img class="modal-content" id="img01">
    <div id="caption"></div>
</div>
<div class="content-wrapper">
    <
    <div class="col-md-4">
        <div class="gallery" align="center">

            <div class="preview" align="center">

                <img id="myImg" name="preview" src="${product.productImage}" alt=""/>

            </div>

            <div class="thumbnails">
                <img id="img1" onmouseover="preview.src=img1.src" name="img1" src="${product.productImage}" alt=""/>
                <img id="img2" onmouseover="preview.src=img2.src" name="img2" src="${product.productImage}" alt=""/>
                <img id="img3" onmouseover="preview.src=img3.src" name="img3" src="${product.productImage}" alt=""/>

            </div><br/>


        </div>
    </div>

    <div class="col-md-7">
        <div class="product-title">${product.productShortDesc}</div>
        <div class="product-desc">${product.productLongDesc}</div>
        <div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
        <hr>
        <div class="product-price">${product.productPrice}</div>
        <div class="product-stock">${product.productStock}</div>
        <hr>
        <div class="btn-group cart">
            <button type="button" class="btn btn-success">
                Add to cart
            </button>
        </div>
        <div class="btn-group wishlist">
            <button type="button" class="btn btn-danger">
                Add to wishlist
            </button>
        </div>

</div>
</div>
<div class="container-fluid">
    <div class="col-md-12 product-info">
        <ul id="myTab" class="nav nav-tabs nav_tabs">

            <li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
            <li><a href="#service-two" data-toggle="tab">PRODUCT INFO</a></li>
            <li><a href="#service-three" data-toggle="tab">REVIEWS</a></li>

        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="service-one">

                <section class="container product-info">
                    The Corsair Gaming Series GS600 power supply is the ideal price-performance solution for building or upgrading a Gaming PC. A single +12V rail provides up to 48A of reliable, continuous power for multi-core gaming PCs with multiple graphics cards. The ultra-quiet, dual ball-bearing fan automatically adjusts its speed according to temperature, so it will never intrude on your music and games. Blue LEDs bathe the transparent fan blades in a cool glow. Not feeling blue? You can turn off the lighting with the press of a button.

                    <h3></h3>
                    <li>It supports the latest ATX12V v2.3 standard and is backward compatible with ATX12V 2.2 and ATX12V 2.01 systems</li>
                    <li>An ultra-quiet 140mm double ball-bearing fan delivers great airflow at an very low noise level by varying fan speed in response to temperature</li>
                    <li>80Plus certified to deliver 80% efficiency or higher at normal load conditions (20% to 100% load)</li>
                    <li>0.99 Active Power Factor Correction provides clean and reliable power</li>
                    <li>Universal AC input from 90~264V — no more hassle of flipping that tiny red switch to select the voltage input!</li>
                    <li>Extra long fully-sleeved cables support full tower chassis</li>
                    <li>A three year warranty and lifetime access to Corsair’s legendary technical support and customer service</li>
                    <li>Over Current/Voltage/Power Protection, Under Voltage Protection and Short Circuit Protection provide complete component safety</li>
                    <li>Dimensions: 150mm(W) x 86mm(H) x 160mm(L)</li>
                    <li>MTBF: 100,000 hours</li>
                    <li>Safety Approvals: UL, CUL, CE, CB, FCC Class B, TÜV, CCC, C-tick</li>
                </section>

            </div>
            <div class="tab-pane fade" id="service-two">

                <section class="container">

                </section>

            </div>
            <div class="tab-pane fade" id="service-three">

            </div>
        </div>
        <hr>
    </div>
</div>

<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the image and insert it inside the modal - use its "alt" text as a caption
    var img = document.getElementById('myImg');
    var modalImg = document.getElementById("img01");
    var captionText = document.getElementById("caption");
    img.onclick = function(){
        modal.style.display = "block";
        modalImg.src = this.src;
        captionText.innerHTML = this.alt;
    }

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";

        var ProductImage = document.getElementById("productImg").value;
        document.getElementById("img1").src = ProductImage;
        document.getElementById("img2").src = ProductImage;
        document.getElementById("img3").src = ProductImage;
    }
</script>

<!-- jQuery -->
<script src="/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>


