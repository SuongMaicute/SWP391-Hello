<%-- 
    Document   : Login
    Created on : May 21, 2023, 3:39:10 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Sign in and Sign up Form</title>

        <!-- remix icon cdn link  -->
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.0.0/fonts/remixicon.css" rel="stylesheet">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="./css/login.css" />

    </head>

    <body>
        <main>
            <div class="box">
                <div class="inner-box">
                    <div class="forms-wrap">
                        <!-- Login section starts  -->
                        <form action="DispatcherServlet" autocomplete="off" class="sign-in-form">
                            <div class="logo">
                                <a href="" class="logo"> <i class="ri-store-2-line"></i> Pet.Hello </a>
                            </div>

                            <div class="heading">
                                <h2>Welcome Back</h2>
                                <h6>Not registred yet?</h6>
                                <a href="#" class="toggle">Sign up</a>
                            </div>

                            <div class="actual-form">
                                <div class="input-wrap">
                                    <input
                                        type="text"
                                        minlength="4"
                                        class="input-field"
                                        autocomplete="off"
                                        required
                                        />
                                    <label>Name</label>
                                </div>

                                <div class="input-wrap">
                                    <input
                                        type="password"
                                        minlength="4"
                                        class="input-field"
                                        autocomplete="off"
                                        required
                                        />
                                    <label>Password</label>
                                    <c:set var="valid" value="${requestScope.validAcc}"/>
                                </div>
                                <c:if test="${not empty valid}">
                                    <h4 style="color: red; padding-left: 10px; margin-top: 16px; margin-bottom: 0;">
                                        Incorrect username or password
                                    </h4>
                                </c:if>


                                <input  name="MAIN" type="submit" value="Login" class="sign-btn" />
                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&amp;redirect_uri=http://localhost:8081/swp/LoginGoogleHandler&amp;response_type=code&amp;client_id=1037707091680-1aq2v2s9f844d1qs4dapbn521vdi89pe.apps.googleusercontent.com&amp;approval_prompt=force" class="gg-btn">
                                    <span class="btn-text">Google</span>
                                </a>


                                <p class="text">
                                    Forgotten your password or you login!!
                                    <a href="Checkmail.jsp">Click here</a> to get your Pass
                                </p>
                            </div>
                        </form>






                        <form action="DispatcherServlet" autocomplete="off" class="sign-up-form">
                            <div class="logo">
                                <a href="" class="logo"> <i class="ri-store-2-line"></i> Pet.Hello </a>
                            </div>

                            <div class="heading">
                                <h2>Get Started</h2>
                                <h6>Already have an account?</h6>
                                <a href="#" class="toggle">Sign in</a>
                            </div>

                            <div class="actual-form">
                                <div class="input-wrap">
                                    <input
                                        type="text" name="name"
                                        minlength="4"
                                        class="input-field"
                                        autocomplete="off"
                                        required
                                        />
                                    <label>Name</label>
                                </div>
                                <c:set var="NameErr" value="${requestScope.NameERR}" />
                                <c:if test="${not empty NameErr}">
                                    <h4 style="color: red;">Your name is blank </h4>
                                </c:if>


                                <div class="input-wrap">
                                    <input
                                        type="email" name="email"
                                        class="input-field"
                                        autocomplete="off"
                                        required
                                        />
                                    <label>Gmail</label>
                                </div>
                                <c:set var="EmailERR" value="${requestScope.EmailERR}" />
                                <c:if test="${not empty EmailERR}">
                                    <h4 style="color: red;">Your Gmail is blank </h4>
                                </c:if>

                                <c:set var="DuplicatedERR" value="${requestScope.DuplicatedERR}" />
                                <c:if test="${not empty DuplicatedERR}">
                                    <h4 style="color: red;">Your Gmail is already register in PetHello Platform</h4style=>
                                        </c:if>

                                        <div class="input-wrap">
                                    <input
                                        type="password" name="pass"
                                        minlength="4"
                                        class="input-field"
                                        autocomplete="off"
                                        required
                                        />
                                    <label>Password</label>

                                </div>
                                <c:set var="PassERR" value="${requestScope.PassERR}" />
                                <c:if test="${not empty PassERR}">
                                    <h4 style="color: red;">Your password is blank </h4>
                                </c:if>   



                                <div class="input-wrap">
                                    <input
                                        type="password" name="re_pass"
                                        minlength="4"
                                        class="input-field"
                                        autocomplete="off"
                                        required
                                        />
                                    <label>Confirm Password</label>

                                </div>

                                <c:set var="ConfirmERR" value="${requestScope.ConfirmERR}" />
                                <c:if test="${not empty ConfirmERR}">
                                    <h4 style="color: red;">Your confirm is blank </h4>
                                </c:if>

                                <c:set var="MatchERR" value="${requestScope.MatchERR}" />
                                <c:if test="${not empty MatchERR}">
                                    <h4 style="color: red;">Your password is not match</h4>
                                </c:if>
                                <input name="MAIN" type="submit" value="Register" class="sign-btn" />

                                <p class="text">
                                    By signing up, I agree to the
                                    <a href="#">Terms of Services</a> and
                                    <a href="#">Privacy Policy</a>
                                </p>
                            </div>
                        </form>
                    </div>

                    <div class="carousel">
                        <div class="images-wrapper">
                            <img src="./img/home-img-1.png" />
                        </div>

                        <div class="text-slider">
                            <div class="text-wrap">
                                <div class="text-group">

                                </div>
                            </div>

                            <div class="bullets">
                                <span class="active" data-value="1"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Javascript file -->

        <script src="./js/Login.js"></script>
    </body>
</html>
