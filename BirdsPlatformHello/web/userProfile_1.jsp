<%-- 
    Document   : userProfile
    Created on : May 26, 2023, 5:18:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Profile</title>

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="./asset/css/userProfile.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet" />

    </head>

    <body>

        <c:set var="User" value="${sessionScope.USERDTOBYUSERNAME}" /> 
        <c:set var="servlet" value="${requestScope.SERVLET}" />
        <c:if test="${empty servlet}">
            <c:redirect url="GetDataForUserProfile">
                <c:param name="DTO" value="${User}"></c:param>
            </c:redirect>
        </c:if>

        <c:set var="checkExist" value="${requestScope.ACCOUNT_EXIST_IN_DB}" />
        <c:if test="${empty checkExist}">
            <c:set var="UserGG" value="${sessionScope.GOOGLE_ACC}" />
        </c:if>

        <div id="mainPage" class="container bootstrap snippets bootdey">
            <div class="row">
                <div class="profile-nav col-md-3">
                    <div class="panel">
                        <div class="user-heading round">
                            <a href="#">


                                <c:if test="${not empty User}">
                                    <img src="${User.avatar}" alt="User">
                                </c:if>

                                <c:if test="${not empty UserGG}">
                                    <img src="${UserGG.picture}" alt="Google
                                         ">
                                </c:if>

                            </a>
                            <c:if test="${ not empty User}">
                                <h1>${User.username}</h1>
                                <p>${User.email}</p>
                            </c:if>

                            <c:if test="${ empty User}">
                                <h1>${UserGG.name}</h1>
                                <p>${UserGG.email}</p>
                            </c:if>                   

                        </div>

                        <ul class="nav  navbar">
                            <li><a href="#"> <i class="fa-solid fa-house"></i> Home page</a></li>
                            <li class="active"><a href="#"> <i class="fa fa-user"></i> My Profile</a></li>
                            <li><a href="#"> <i class="fa-solid fa-cart-shopping"></i> My Cart <span
                                        class="label label-warning pull-right r-activity">10</span></a></li>
                            <li>

                                <a href="#"> <i class="fa-solid fa-square-check"></i> My Orders</a>
                            </li>
                            <li>
                                <button   onclick="sendMailRegister()">
                                            <i id="ChangePass"  class="fa-solid fa-right-from-bracket"></i> Change
                                               Password
                                </button>
                                <form action="DispatcherServlet">
                                    <input name="MAIN" id="content" type="submit" name="reset" value="Please check your Gmail" >
                                </form>
                            </li>
                            <li><a href="#"> <i class="fa-solid fa-right-from-bracket"></i> Log out</a></li>
                        </ul>
                    </div>
                </div>
                <div class="profile-info col-md-9">

                    <form action="SearchServlet" class="search">
                        <input class="input1" type="text" name="searchValue" placeholder="Whats in your mind today" />
                        <div class="icon">

                            <i class=" fa-solid fa-magnifying-glass"></i>
                        </div>
                    </form>

                    <div class="panel">
                        <div class="bio-graph-heading">
                            My Profile
                            <br>
                            Manage profile information to secure the account.
                        </div>


                        <div class="row">
                            <div class="col-md-6">
                                <div class="panel">
                                    <div class="panel-body">
                                        <div class="bio-chart">
                                            <i style="color: #e38fb1 ;" class="fa-sharp fa-solid fa-dove"></i>
                                        </div>
                                        <div class="bio-desk">
                                            <form action="updateProfileController">
                                                <h4 class="red">Name</h4>
                                                <c:if test="${ not empty User.username}">
                                                    <p> <input name="Name" class="input1" type="text" placeholder="${User.username}" 
                                                               value="${User.username}"/> </p>
                                                    <p> <input name="MAIN" class="submit" type="submit" name="Change"
                                                               value="Update" /></p>

                                                </c:if>

                                                <c:if test="${ empty User.username}">
                                                    <p> <input name="Name" class="input1" type="text" placeholder="Your nick name" /> </p>
                                                    <p> <input name ="MAIN" class="submit" type="submit" name="Change"
                                                               value="Update" /></p>
                                                    </c:if> 

                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel">
                                    <div class="panel-body">
                                        <div class="bio-chart">
                                            <i style="color: #99e0e6;" class="fa-sharp fa-solid fa-dove"></i>
                                        </div>
                                        <div class="bio-desk">
                                            <form action="updateProfileController">
                                                <h4 class="red">Gmail</h4>

                                                
                                                    <p> <input name="Gmail" class="input1" type="text"
                                                               placeholder="${sessionScope.GMAIL}" value="${sessionScope.GMAIL}" /> </p>
                                                    <p> <input name="MAIN" class="submit" type="submit" name="Change"
                                                               value="Change" /></p>

                                                
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel">
                                    <div class="panel-body">
                                        <div class="bio-chart">
                                            <i style="color: #9eb459;" class="fa-sharp fa-solid fa-dove"></i>
                                        </div>
                                        <div class="bio-desk">
                                            <form action="updateProfileController">
                                                <h4 class="red">Phone Number</h4>
                                                <c:if test="${not empty requestScope.PHONE}">
                                                    <p> <input name="PhoneNumber" class="input1" type="text" placeholder="${requestScope.PHONE}"
                                                               value="${requestScope.PHONE}"/> </p>
                                                    </c:if>
                                                    <c:if test="${ empty requestScope.PHONE}">
                                                    <p> <input name="PhoneNumber" class="input1" type="text" placeholder="Your Phone Number " /> </p>
                                                    </c:if>
                                                <p> <input name="MAIN" class="submit" type="submit" name="Change"
                                                           value="Change your Phone Number" /></p>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel">
                                    <div class="panel-body">
                                        <div class="bio-chart">
                                            <i style="color: #caa3da;" class="fa-sharp fa-solid fa-dove"></i>

                                        </div>
                                        <div class="bio-desk">
                                            <h4 class="purple">Point</h4>
                                            <p>${requestScope.POINT} </p>                                     
                                            <p><a href="#">What is Hello Point? </a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="deleteAcc">
                                <h4 id="DeleteBT">
                                    DeleteAccount
                                </h4>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="deleteAccDiv" id="del">
            <div class="box">
                <h3>Delete Account?</h3>
                <p>Are you sure you want to delete </p>

                <div class="warn_info">
                    <h4><i class="fa fa-warning"></i> Warning</h4>
                    <p>By deleting Pet Hello Account you can't undo this action.</p>
                </div>

                <div class="clearfix">
                    <div class="1stButton">

                        <a class="btn1" id="cancelDele" href="">Cancel</a>
                    </div>
                    <div class="2ndButton">
                        <form class="real" action="deleteAccountController">
                            <input type="submit" id="confirmDelete" name="delete" value="Delete Account">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script language="javascript">

            document.getElementById("DeleteBT").onclick = function () {
                document.getElementById("del").style.display = 'Block';
                document.getElementById("mainPage").style.opacity = 0.5;
            };

            document.getElementById("cancelDele").onclick = function () {
                document.getElementById("del").style.display = 'none';

            };
            document.getElementById("ChangePass").onclick = function () {
                document.getElementById("content").style.display = 'Block';
            };

            document.getElementById("content").onclick = function () {
                document.getElementById("content").style.display = 'none';
            };

        </script>

    </body>

</html>
