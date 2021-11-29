<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String rootURL = (String)request.getAttribute("rootURL");
%>
<c:set var="rootURL" value="<%=rootURL%>" />
  <!DOCTYPE html>
  <html>

  <head>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <meta name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="${rootURL}/resources/css/style.css">
    <link rel="stylesheet" href="${rootURL}/resources/css/sg.css">
    <link rel="stylesheet" href="${rootURL}/resources/css/sy.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"></script>
  </head>

  <body class="layout_width">
    <header>
      <div class="tit">
        <span class="site"><a href="${rootURL}">Diet<br>Shop</a></span>
        <div class="search">
          <input id="search" type="search" name="search" placeholder="검색"></input>
          <span class="icon"><i class="xi-search"></i></span>
        </div>
        <span class="header_login"><a href="${rootURL}/member/login">로그인</a></span>
      </div>
    </header>
    <nav>
      <div class="category_top" id="category_top">
        <span class="category"><a href="${rootURL}/category">카테고리</a></span>
        <span class="mypage"><a href="${rootURL}/member/mypage">마이페이지</a></span>
        <span class="shoppingbag"><a href="${rootURL}">장바구니</a></span>
      </div>
    </nav>
    <main>
      <div class="search2">
        <input id="search2" type="search" name="search2"
              placeholder="검색"></input></span>
        <span class="icon2"><i class="xi-search"></i></span>
      </div>
      
    
   