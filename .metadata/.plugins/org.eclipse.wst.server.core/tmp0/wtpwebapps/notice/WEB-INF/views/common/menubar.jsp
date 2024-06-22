<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/common.css">
</head>
<body>
<div class="header">
   <div class="menu-area">
      <div class="nav-area">
         <ul>
            <li><a href="">home</a></li>
            <li><a href="">내려요</a></li>
            <li><a href="">분실물</a></li>
            <li><a href="${ pageContext.servletContext.contextPath }/community/list">커뮤니티</a></li>
            <li><a href="">공지사항</a></li>
            <c:choose>
               <c:when test="${ empty sessionScope.loginMember }">
                  <li><a href="${ pageContext.servletContext.contextPath }/user/login">로그인</a></li>
               </c:when>
               <c:when test="${ sessionScope.loginMember.role eq 'ROLE_USER' }">
                  <li><a href="">마이페이지</a></li>
                  <li><a href="${ pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
               </c:when>
               <c:when test="${ sessionScope.loginMember.role eq 'ROLE_ADMIN' }">
                  <li><a href="">신고내역</a></li>
                  <li><a href="${ pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
               </c:when>
            </c:choose>
         </ul>
      </div>
   </div>
</div>
</body>
</html>
