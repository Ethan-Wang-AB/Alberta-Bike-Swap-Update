
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous"
    />
    <%--Css link added by Simon--%>
    <link href="../assets/css/login.css" rel="stylesheet" />

    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
    />

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"
    ></script>

    <title>Alberta Bike Swap | Login</title>
</head>
<body>
<div class="container-fluid nav-adm">
    <div class="container">
        <a href="${pageContext.request.contextPath}/locations">
            <img src="../assets/img/admin/logo-01.svg" alt="logo" />
        </a>
        <div class="options-nav">
            <!--ul>
                <li>option</li>
                <li><a href="#@">option</a></li>
                <li>a</li>
              </ul-->
            <a href="/">
                <i class="fas fa-sign-out-alt"></i>
                Logout
            </a>
        </div>
    </div>
</div>

<%--
<jsp:useBean id="login" scope="request" type="java.lang.String" />
--%>
<div class="container">
    <div class="row justify-content-md-center align-items-center">
        <div class="card bg-light col-md-8">
            <h1 class="ms-1 mt-1">Alberta Bike Swap | Login</h1>
            <div class="card-body">
                <p id="message">${message}</p>
                <form action="Login" method="post">
                    <div class="input-group flex-nowrap mb-3">
                        <span class="input-group-text"><i class="bi bi-at"></i></span>
                        <input
                                type="email"
                                name="email"
                                value="<c:out value='${login}'/>"
                                class="form-control"
                                placeholder="Email"
                                aria-label="Login"
                                aria-describedby="addon-wrapping"
                        />
                        <span class="input-group-text"><i class="bi bi-at"></i></span>
                    </div>
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text"><i class="bi bi-key"></i></span>
                        <input
                                type="password"
                                name="password"
                                class="form-control"
                                placeholder="Password"
                                aria-label="Password"
                                aria-describedby="addon-wrapping"
                        />
                        <span class="input-group-text"><i class="bi bi-key"></i></span>
                    </div>
                    <button type="submit" class="btn btn-lg btn-success mt-3">
                        Login
                    </button>
                    <%--
                    <a
                      href="login?action=new_account"
                      class="btn btn-sm btn-primary mt-3 ms-3 float-end"
                    >
                      New Account
                    </a>
                    --%> <%--
              <a href="reset" class="btn btn-sm btn-warning mt-3 float-end">
                Forgot Password?
              </a>
              --%>
                <span style="float: right; margin:10px;padding-top: 16px;"> <a href="ResetPassword">Forgot password</a>     </span>
                 <span style="float: right; margin:10px;padding-top: 16px;" > <a href="registration">Create Account</a>    </span>

                </form>

                <c:if test="${errorMessage != null}">
                    <div
                            class="alert alert-danger alert-dismissible fade show pb-2 pt-2 mt-3"
                            role="alert"
                    >
                        <i class="bi bi-x-circle me-2"></i>
                            ${errorMessage}
                        <button
                                type="button"
                                class="btn-close btn-sm pb-1"
                                data-bs-dismiss="alert"
                                aria-label="Close"
                        ></button>
                    </div>
                </c:if>
                <%--
                <c:if test="${successMessage != null}">
                  --%> <%--
              <div
                class="alert alert-primary alert-dismissible fade show pb-2 pt-2 mt-3"
                role="alert"
              >
                --%> <%--
                <i class="bi bi-check-circle me-2"></i>
                ${successMessage}--%> <%--
                <button
                  type="button"
                  class="btn-close btn-sm pb-1"
                  data-bs-dismiss="alert"
                  aria-label="Close"
                ></button>
                --%> <%--
              </div>
              --%> <%--
            </c:if>
            --%>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../assets/script/animationLogin.js"></script>
</body>
</html>
