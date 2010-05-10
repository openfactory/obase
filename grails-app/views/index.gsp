<%--
  Created by IntelliJ IDEA.
  User: mkuhl
  Date: 24.05.2009
  Time: 13:28:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>ubase default plugin page</title>
</head>

  <body>
    <div id="sec.status">
      <p>Is Logged in: <ob:entityName/> </p>
      <p>Is Admin: <ob:isAdmin>yes</ob:isAdmin></p>
      %{--<p>Logged In as: factor at: 1.1.2.2010 14:42:00</p>--}%
      <p>Roles: admin, pet, user</p>
    </div>
    
    <div id="sec.actions">
      <ul>
        <li><g:link controller="security" action="login">log in</g:link></li>
        <li><g:link controller="security" action="logout">log out</g:link></li>
        <li>update status</li>
      </ul>
    </div>
  </body>

</html>
