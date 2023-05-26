
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Admin Dashboard</title>

        <!-- Montserrat Font -->
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="grid-container">

            <!-- Header -->
            <header class="header">
                <div class="menu-icon" onclick="openSidebar()">
                    <span class="material-icons-outlined">menu</span>
                </div>
                <form>
                    <div class="header-left">
                        <div id="date"></div>
                    </div>
                </form>
                <div class="header-right">
                    <div class="profile-user" onclick="menuToggle();">
                        <img src="images/download.jpg" alt="">
                    </div> 
                    <div class="account-menu">
                        <ul class="navbar-list">
                            <li>
                                <span class="material-icons-outlined">account_circle</span>
                                <a href="">My profile</a>
                            </li>
                            <li>
                                <span class="material-symbols-outlined">
                                    settings
                                </span>
                                <a href="">Setting</a>
                            </li>
                            <li>
                                <span class="material-symbols-outlined">
                                    logout
                                </span>
                                <a href="">Log out</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </header>
            <!-- End Header -->

            <!-- Sidebar -->
            <aside id="sidebar">
                <div class="sidebar-title">
                    <span class="material-icons-outlined" onclick="closeSidebar()">close</span>
                </div>

                <ul class="sidebar-list">
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">dashboard</span> Dashboard
                        </a>
                    </li>
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">inventory_2</span> Products
                        </a>
                    </li>
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">category</span> Categories
                        </a>
                    </li>
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">groups</span> Authentication
                        </a>
                    </li>
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">fact_check</span> Inventory
                        </a>
                    </li>
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">poll</span> Reports
                        </a>
                    </li>
                    <li class="sidebar-list-item">
                        <a href="#" target="_blank">
                            <span class="material-icons-outlined">settings</span> Settings
                        </a>
                    </li>
                </ul>
            </aside>
            <!-- End Sidebar -->

            <!-- Main -->
            <main class="main-container">
                <div class="main-title">
                    <h2>DASHBOARD</h2>
                </div>
                <div class="insights">
                    <c:set var="dataList" value="${requestScope.DATA}"/>
                    <c:set var="count" value="${0}"/>
                    <c:if test="${not empty dataList}">

                        <!-- begin of the table Account -->
                        <div class="account"> 
                            <div>
                                <span class="material-symbols-outlined">
                                    person
                                </span>
                                <div class="middle">
                                    <div class="left">
                                        <h3>Totals Orders</h3>
                                        <c:forEach var="data" items="${dataList}">
                                            <c:if test="${count eq 0}">
                                                <h1>${data}</h1>
                                                <c:set var="count" value="${1}"/>
                                            </c:if>
                                        </c:forEach>
                                    </div>          
                                    <div class="progress">
                                        <svg>
                                        <circle cx='38' cy='38' r='36'></circle>
                                        </svg>
                                        <div class="number">
                                            <p>81%</p>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <small class="text-muted">Last month</small>
                        </div>
                        <!-- end of table Account -->

                        <!-- begin of table Orders -->
                        <div class="orders"> 
                            <div>
                                <span class="material-symbols-outlined">
                                    density_small
                                </span>
                                <div class="middle">
                                    <div class="left">
                                        <h3>Totals Orders</h3>
                                        <c:set var="count" value="${0}"/>
                                        <c:forEach var="data" items="${dataList}">
                                            <c:if test="${count eq 1}">
                                                <h1>${data}</h1>               
                                            </c:if>
                                            <c:set var="count" value="${1}"/>
                                        </c:forEach>
                                    </div>
                                    <div class="progress">
                                        <svg>
                                        <circle cx='38' cy='38' r='36'></circle>
                                        </svg>
                                        <div class="number">
                                            <p>81%</p>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <small class="text-muted">Last month</small>
                        </div>
                        <!-- end of table Orders -->

                        <!-- begin of table Income -->
                        <div class="income"> 
                            <div>
                                <span class="material-symbols-outlined">
                                    stacked_line_chart
                                </span>
                                <div class="middle">
                                    <div class="left">
                                        <h3>Total Income</h3>
                                        <h1>200</h1>
                                    </div>
                                    <div class="progress">
                                        <svg>
                                        <circle cx='38' cy='38' r='36'></circle>
                                        </svg>
                                        <div class="number">
                                            <p>81%</p>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <small class="text-muted">Last month</small>
                        </div>
                        <!-- end of table Income -->
                    </c:if>
                    <c:if test="${empty dataList}">
                        <h1>Empty</h1>
                        <c:redirect url="DashboardController"> </c:redirect>
                    </c:if>
                </div>

                <div class="charts">

                    <div class="charts-card">
                        <h2 class="chart-title">Top 5 Products</h2>
                        <div id="bar-chart"></div>
                    </div>

                    <div class="charts-card">
                        <h2 class="chart-title">Purchase and Sales Orders</h2>
                        <div id="area-chart"></div>
                    </div>

                </div>
            </main>
            <!-- End Main -->
${requestScope.TOPQUANTITY}
        </div>

        <!-- Scripts -->
        <!-- ApexCharts -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.5/apexcharts.min.js"></script>
        <!-- Custom JS -->
        <script>
                        // SIDEBAR TOGGLE

                        var sidebarOpen = false;
                        var sidebar = document.getElementById("sidebar");
                        function openSidebar() {
                        if (!sidebarOpen) {
                        sidebar.classList.add("sidebar-responsive");
                        sidebarOpen = true;
                        }
                        }

                        function closeSidebar() {
                        if (sidebarOpen) {
                        sidebar.classList.remove("sidebar-responsive");
                        sidebarOpen = false;
                        }
                        }



// ---------- CHARTS ----------

// BAR CHART
                        var barChartOptions = {
                        series: [{
                        data: 
                        <c:set var="orderList" value="${requestScope.TOPQUANTITY}"/>      
                        <c:if test="${not empty quantityList}">
                            <c:forEach var="order" items="${orderList}">
                                ${order.quantity}
                        }],
                                chart: {
                                type: 'bar',
                                        height: 350,
                                        toolbar: {
                                        show: false
                                        },
                                },
                                colors: [
                                        "#246dec",
                                        "#cc3c43",
                                        "#367952",
                                        "#f5b74f",
                                        "#4f35a1"
                                ],
                                plotOptions: {
                                bar: {
                                distributed: true,
                                        borderRadius: 4,
                                        horizontal: false,
                                        columnWidth: '40%',
                                }
                                },
                                dataLabels: {
                                enabled: false
                                },
                                legend: {
                                show: false
                                },
                                xaxis: {
                                categories: ["Laptop", "Phone", "Monitor", "Headphones", "Camera"],
                                },
                                yaxis: {
                                title: {
                                text: "Count"
                                }
                                }
                                 </c:forEach>
                        </c:if>                
                         <c:if test="${empty orderList}">
                        <h1>Empty</h1>
                        <c:redirect url="DashboardController"> </c:redirect>
                    </c:if>
                        };
                        var barChart = new ApexCharts(document.querySelector("#bar-chart"), barChartOptions);
                        barChart.render();
// AREA CHART
                        var areaChartOptions = {
                        series: [{
                        name: 'Purchase Orders',
                                data: [31, 40, 28, 51, 42, 109, 100]
                        }, {
                        name: 'Sales Orders',
                                data: [11, 32, 45, 32, 34, 52, 41]
                        }],
                                chart: {
                                height: 350,
                                        type: 'area',
                                        toolbar: {
                                        show: false,
                                        },
                                },
                                colors: ["#4f35a1", "#246dec"],
                                dataLabels: {
                                enabled: false,
                                },
                                stroke: {
                                curve: 'smooth'
                                },
                                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"],
                                markers: {
                                size: 0
                                },
                                yaxis: [
                                {
                                title: {
                                text: 'Purchase Orders',
                                },
                                },
                                {
                                opposite: true,
                                        title: {
                                        text: 'Sales Orders',
                                        },
                                },
                                ],
                                tooltip: {
                                shared: true,
                                        intersect: false,
                                }
                        };
                        var areaChart = new ApexCharts(document.querySelector("#area-chart"), areaChartOptions);
                        areaChart.render();
        </script>
    </body>
</html>