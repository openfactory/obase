<%--
  Created by IntelliJ IDEA.
  User: mkuhl
  Date: 12.07.2009
  Time: 12:03:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>upload profile picture</title>
  <ub:layout/>
</head>

<body>
  <g:uploadForm action="putprf" params="[entity:params.entity]">
    <div class="dialog">
      <fieldset>
        <legend>Asset Upload</legend>
        <table>
          <colgroup>
            <col class="labelcol"/>
            <col class="fieldcol"/>
          </colgroup>
          <tr>
            <td>File</td>
            <td><input type="file" name="asset"></td>
          </tr>
        </table>
      </fieldset>
      <g:submitButton name="submit" value="Upload"/>
    </div>
  </g:uploadForm>

</body>
</html>