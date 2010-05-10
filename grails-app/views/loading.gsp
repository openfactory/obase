<%--
  Created by IntelliJ IDEA.
  User: mkuhl
  Date: 03.05.2010
  Time: 15:36:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
    <div id="loadingWarning" style="
      text-align: center;
      background-color: #fff;
      border: 5px solid #c6c6c6;
      padding: 10px;
      position: absolute;
      /*display: none;*/
      top: 37%;
      left: 35%;
      z-index: 1000;
      width: 11em;
      color: #868686;
      font-family: tahoma, verdana, arial, sans-serif;
      font-size: 20px;"
    >
      <g:form controller="security" action="do_login" method="post" style="margin:0px;">
          <table>
          <colgroup>
            <col class="labelcol"/>
            <col class="fieldcol"/>
          </colgroup>
          <tr>
            <td>UserId</td>
            <td><g:textField name="userid" value="hugo"/></td>
          </tr>
          <tr>
            <td>Password</td>
            <td><g:textField name="password" value="xxx"></g:textField></td>
          </tr>
          <tr></tr>  
        </table>
        <g:submitButton name="login" value="Login"/>
      </g:form>
    </div>
  

  </body>
</html>