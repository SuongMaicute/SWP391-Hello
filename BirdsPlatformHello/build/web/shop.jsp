<%-- 
    Document   : shop.jsp
    Created on : Jun 4, 2023, 12:19:30 PM
    Author     : leyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>shop</title>

        <!-- remix icon cdn link  -->
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.0.0/fonts/remixicon.css" rel="stylesheet">

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/total.css">

    </head>

    <body>

        <!-- header section starts  -->

        <header class="header">
            <a href="Homepage.html" class="logo"> <i class="ri-store-2-line"></i> Pet.Hello </a>

            <form action="#" class="search-form">
                <input type="search" placeholder="search in ${requestScope.shophomepage.getShopName()}" id="search-box">
                <label for="search-box" class="ri-search-line"></label>
            </form>

            <div class="icons">
                <div id="menu-btn" class="ri-menu-line"></div>
                <div id="search-btn" class="ri-search-line"></div>
                <div id="cart-btn" class="ri-shopping-cart-line"></div>
                <div id="login-btn" class="ri-user-line"></div>
            </div>
        </header>

        <!-- header section ends  -->


        <!-- closer btn  -->

        <div id="closer" class="ri-close-line"></div>

        <!-- navbar start  -->

        <nav class="navbar">
            <a href="Homepage.jsp">Home</a>
            <a href="shop.html">Shop</a>
            <a href="about.html">About</a>
            <a href="team.html">Team</a>
            <a href="blog.html">Blog</a>
            <a href="contact.html">Contact</a>
        </nav>

        <!-- navbar end  -->


        <!-- shopping cart start  -->

        <div class="shopping-cart">

            <div class="box">
                <i class="ri-close-line close-icon"></i>
                <img src="img/cart-img-1.jpg" alt="">
                <div class="content">
                    <h3>modern furniture</h3>
                    <span class="quantity"> 1 </span>
                    <span class="multiply"> x </span>
                    <span class="price"> $ </span>
                </div>
            </div>

            <div class="box">
                <i class="ri-close-line close-icon"></i>
                <img src="img/cart-img-1.jpg" alt="">
                <div class="content">
                    <h3>modern furniture</h3>
                    <span class="quantity"> 1 </span>
                    <span class="multiply"> x </span>
                    <span class="price"> $ </span>
                </div>
            </div>

            <div class="box">
                <i class="ri-close-line close-icon"></i>
                <img src="img/cart-img-1.jpg" alt="">
                <div class="content">
                    <h3>modern furniture</h3>
                    <span class="quantity"> 1 </span>
                    <span class="multiply"> x </span>
                    <span class="price"> $1</span>
                </div>
            </div>

            <div class="box">
                <i class="ri-close-line close-icon"></i>
                <img src="img/cart-img-1.jpg" alt="">
                <div class="content">
                    <h3>modern furniture</h3>
                    <span class="quantity"> 1 </span>
                    <span class="multiply"> x </span>
                    <span class="price"> $1 </span>
                </div>
            </div>

            <h3 class="total"> total : <span>$560.00</span> </h3>
            <a href="#" class="btn">checkout cart</a>

        </div>
        <!-- shopping cart end  -->


        <!-- login form start  -->

        <div class="login-form">
            <form action="#">
                <h3>login form</h3>
                <input type="email" placeholder="enter your email" class="box">
                <input type="password" placeholder="enter your password" class="box">
                <div class="remember">
                    <input type="checkbox" name="" id="remember-me">
                    <label for="remember-me">remember me</label>
                </div>
                <input type="submit" value="login now" class="btn">
                <p>forget password? <a href="#">click here</a> </p>
                <p>don't have an account? <a href="#">create now</a> </p>
            </form>
        </div>

        <!-- login form end  -->


        <!-- heading section start -->

        <section class="heading">
            <h3>our shop</h3>
            <p> <a href="Homepage.html">home</a> / <span>shop</span> </p>
        </section>

        <!-- heading section end -->


        <!-- category section start -->

        <section class="category">

            <h1 class="title"> <span>our categories</span> <a href="#">view all >></a> </h1>

            <div class="box-container">

                <a href="shop.html" class="box">
                    <img src="img/icon-1.png" alt="">
                    <h3>Pet</h3>
                </a>

                <a href="petfood.html" class="box">
                    <img src="img/icon-2.png" alt="">
                    <h3>Food</h3>
                </a>

                <a href="toy.html" class="box">
                    <img src="img/icon-3.png" alt="">
                    <h3>Store</h3>
                </a>

                <a href="carepet.html" class="box">
                    <img src="img/icon-4.png" alt="">
                    <h3>Pet care</h3>
                </a>



            </div>
        </section>

        <!-- category section end -->


        <!-- products section start -->

        <section class="products">

            <h1 class="title"> <span>our products</span> </h1>

            <div class="box-container">

                <div class="box">
                    <div class="icons">
                        <a href="#" class="ri-shopping-cart-line"></a>
                        <a href="#" class="ri-heart-line"></a>
                        <a href="#" class="ri-eye-line"></a>
                    </div>
                    <div class="image">
                        <img src="img/product-1.png" alt="">
                    </div>
                    <div class="content">
                        <div class="price">$140.00</div>
                        <h3>bird</h3>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <span> (50) </span>
                        </div>
                    </div>
                </div>

                
            </div>

        </section>

        <!-- products section end -->






        <!-- footer section start  -->
        <section class="footer">
            <div class="box-container">

                <div class="box">
                    <h3>quick links</h3>
                    <a href="Homepage.html"> <i class="ri-arrow-right-line"></i> home </a>
                    <a href="shop.html"> <i class="ri-arrow-right-line"></i> shop </a>
                    <a href="about.html"> <i class="ri-arrow-right-line"></i> about </a>
                    <a href="team.html"> <i class="ri-arrow-right-line"></i> team </a>
                    <a href="blog.html"> <i class="ri-arrow-right-line"></i> blog </a>
                    <a href="contact.html"> <i class="ri-arrow-right-line"></i> contact </a>
                </div>

                <div class="box">
                    <h3>quick links</h3>
                    <a href="Homepage.html"> <i class="ri-arrow-right-line"></i> Home </a>
                    <a href="shop.html"> <i class="ri-arrow-right-line"></i> Shop </a>
                    <a href="about.html"> <i class="ri-arrow-right-line"></i> About </a>
                    <a href="team.html"> <i class="ri-arrow-right-line"></i> Team </a>
                    <a href="blog.html"> <i class="ri-arrow-right-line"></i> Blog </a>
                    <a href="contact.html"> <i class="ri-arrow-right-line"></i> Contact </a>
                </div>

                <div class="box">
                    <h3>extra links</h3>
                    <a href="#"> <i class="ri-arrow-right-line"></i> My Order </a>
                    <a href="#"> <i class="ri-arrow-right-line"></i> My Wishlist </a>
                    <a href="#"> <i class="ri-arrow-right-line"></i> My Account </a>
                    <a href="#"> <i class="ri-arrow-right-line"></i> My Favorite </a>
                    <a href="#"> <i class="ri-arrow-right-line"></i> Terms of user </a>
                </div>

                <div class="box">
                    <h3>extra links</h3>
                    <a href="#"> <i class="ri-facebook-fill"></i> Facebook </a>
                    <a href="#"> <i class="ri-twitter-fill"></i> Twitter </a>
                    <a href="#"> <i class="ri-instagram-fill"></i> Instagram </a>
                    <a href="#"> <i class="ri-linkedin-box-fill"></i> Linkedin </a>
                    <a href="#"> <i class="ri-pinterest-fill"></i> Pinterest </a>
                </div>

            </div>
        </section>

        <section class="credit">
            shopemail@gmail.com|+84 123456789
        </section>
        <!-- footer section end  -->

        <!-- custom js file link  -->
        <script src="js/total.js"></script>

    </body>

</html>