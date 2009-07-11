<%--
  Created by IntelliJ IDEA.
  User: mkuhl
  Date: 11.07.2009
  Time: 11:35:47
  default upload form. will be almost always be overwritten by applications to transparently pass in metadata (in hidden fields)
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>upload asset</title>
    <ub:layout/>
  </head>
  <body>
    <g:uploadForm action="put">
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
            <tr>
              <td>Type</td>
              <td><g:select name="type" from="['profile', 'album', 'pub']"/></td>
            </tr>
          </table>
        </fieldset>
        <g:submitButton name="submit" value="Upload"/>
      </div>
    </g:uploadForm>

  </body>
</html>