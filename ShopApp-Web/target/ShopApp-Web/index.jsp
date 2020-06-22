<%@page import="com.ssc.shop.listener.ShopListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@ page import="com.ssc.shop.listener.ShopListener"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script>
    var lastActiveTime = new Date().getTime();
    $(document).ready(function() {
        $('body').bind('click mousemove keypress scroll resize', function() {
           lastActiveTime = new Date().getTime();
           });
           setInterval(checkIdleTime, 30000); // 30 sec
    });

     function checkIdleTime(){
     var diff = new Date().getTime() - lastActiveTime;
           if( diff > 180000){//3 min of inactivity
            window.location.href ="/ShopApp-Web/logout?message=onTimeOut"
           }else{
               $.ajax({url: '/ShopApp-Web/refreshSession', error: function(data, status, xhr){
                    alert("cannot refresh session on server: "+xhr);
                    window.location.reload();}
                  });
           }
    }
  </script>
</head>
<body>
	<center>		
		<h2>
			<b>Welcome ${user.firstName} ${user.lastName} <br />(${user.emailId})
			</b>
		</h2>
		<br>
		<br> <a href="/ShopApp-Web/logout">Logout</a>
		</div>
		<br><br>
		<h3>Active Sessions : <%= ShopListener.getActiveSessions() %></h3>
		<br>
		<br>		
		<h2>All Users</h2>
		<br>
		<table style="width: 50%;" border="1" cellspacing="0" cellpadding="8">
			<thead>
				<tr style="font-weight: bold;">
					<td>User ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="per" items="${result}">
					<tr>
						<td><c:out value="${per.userId}" /></td>
						<td><c:out value="${per.firstName}" /></td>
						<td><c:out value="${per.lastName}" /></td>
						<td><c:out value="${per.emailId}" /></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</center>
</body>
</html>
