<%--
  Created by IntelliJ IDEA.
  User: mkuhl
  Date: 11.07.2009
  Time: 11:48:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Asset Upload complete</title>
    <ub:layout/>
  </head>
  <body>
    <p>
      <g:if test="${asset}">
        your asset of type '${asset.type}' has been uploaded successfully !
      </g:if>
      <g:else>
        your asset could not be uploaded
      </g:else>
    </p>
  </body>
</html>