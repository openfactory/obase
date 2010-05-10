<%--
  Created by IntelliJ IDEA.
  User: mkuhl
  Date: 02.05.2010
  Time: 19:53:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Log in to System</title></head>
  <body>
  <g:if test="${flash.message}">
    <div id="message">${flash.message}</div>
  </g:if>

  <g:form controller="security" action="do_login" method="post">
    <fieldset>
      <legend>Login Form</legend>
      <table>
      <colgroup>
        <col class="labelcol"/>
        <col class="fieldcol"/>
      </colgroup>
      <tr>
        <td>UserId</td>
        <td><g:textField name="userid" value="$userid"/></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><g:textField name="password" value="$password"></g:textField></td>
      </tr>
    </table>
    <g:submitButton name="login" value="Login"/>
  </fieldset>
  </g:form>


  </body>
</html>