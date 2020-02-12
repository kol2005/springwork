<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
nav {
	background-color: blue;
	padding: 0;
	border: none;
}

nav a {
	display: inline-block;
	width: auto;
	text-decoration: none;
	padding: 0.8rem;
	margin: 0;
	color: white;
	position: relative;
}

nav a:hover {
	background-color: #ccc;
	color: black;
	position: relative;
	display: none;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

ul li {
	flex: 0 1 auto; /* float left */
	border: none;
}

li a, .dropbtn {
	display: block;
	text-align: left;
	padding: 14px 16px;
	text-decoration: none;
}

li.dropdown {
	display: block;
}

.dropdown-content{
display: none;
position: absolute;
background-color: blue;
min-width: 160px;
box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
z-index: 3;
}

.dropdown:hover .dropdown-content{
display: block;
}

.dropdown-content a{
border-top: 1px solid white;
background-color: green;
color: yellow;
}

.dropdown-content a:hover{
border-bottom: 1px solid white;
background-color: #ccc;
color: black;
}

</style>

<nav>
	<ul>
		<c:if test="${not empty MENUS}">
			<c:forEach var="MENU" items="${MENUS}">
				<c:choose>
					<c:when test="${empty MENU.drop_menus}">
						<li><a href="${MENU.menu_href}">${MENU.menu_title}</a></li>
					</c:when>
					<c:otherwise>
						<li class="dropdown">
							<a class="dropbtn" href="javascript:void(0)">${MENU.menu_title}</a>
							<div class="dropdown-content">
								<c:forEach var="DROP" items="${MENU.drop_menus}">
								<a href="${rootPath}/${DROP.menu_href}">${DROP.menu_title}</a>
								</c:forEach>
							</div>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
	</ul>
</nav>