<%--
  User: mkuhl
  Date: 14.06.2009
  Time: 14:34:12
--%>

<html>
  <head>
    <title>Dashboard for ${entity.name}</title>
    <ub:layout/>
  </head>
  <body>
    <div class="dialog">
      <h1>Dashboard for ${entity.name}</h1>
      <fieldset>
        <legend>Entity Data</legend>
        <table>
          <colgroup>
            <col class="labelcol"/>
            <col class="fieldcol"/>
          </colgroup>
          <tr>
            <td>Entity Name</td>
            <td>${entity.name}</td>
          </tr>
          <tr>
            <td>Type</td>
            <td>${entity.type.name}</td>
          </tr>
          <tr>
            <td>SuperType</td>
            <td>${entity.type.supertype.name}</td>
          </tr>
          <tr>
            <td>created</td>
            <td>${entity.dateCreated}</td>
          </tr>

        </table>
      </fieldset>

      <fieldset>
        <legend>Account Details</legend>
        <table>
          <colgroup>
            <col class="labelcol"/>
            <col class="fieldcol"/>
          </colgroup>
          <tr>
            <td>Email</td>
            <td>${entity.user.email}</td>
          </tr>
          <tr>
            <td>Enabled</td>
            <td>${entity.user.enabled}</td>
          </tr>
          <tr>
            <td>Roles</td>
            <td>ROLE_ADMIN, ROLE_USER</td>
          </tr>

        </table>
      </fieldset>

      <g:if test="${entity.profile}">
        <fieldset>
          <legend>Profile</legend>
          <table>
            <colgroup>
              <col class="labelcol"/>
              <col class="fieldcol"/>
            </colgroup>
            <tr>
              <td>Full Name</td>
              <td>${entity.profile.fullName}</td>
            </tr>
            <tr>
              <td>Tag Line</td>
              <td>${entity.profile.tagline}</td>
            </tr>
            <tr>
              <td>Profile Type</td>
              <td>${entity.type.supertype.profileType}</td>
            </tr>
          </table>
        </fieldset>
      </g:if>

      <fieldset>
        <legend>Tags</legend>
      </fieldset>
    </div>
  </body>
</html>