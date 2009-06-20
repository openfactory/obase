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
    <h1>Dashboard for ${entity.name}</h1>
    <fieldset>
      <legend>Entity Data</legend>
      <table>
        <tr>
          <td>Entity Name (Nick)</td>
          <td>${entity.name}</td>
        </tr>
        <tr>
          <td>Entity Type</td>
          <td>${entity.type.name}</td>
        </tr>
        <tr>
          <td>Entity SuperType</td>
          <td>${entity.type.supertype.name}</td>
        </tr>
        <tr>
          <td>created at</td>
          <td>${entity.dateCreated}</td>
        </tr>

      </table>
    </fieldset>

    <g:if test="${entity.profile}">
      <fieldset>
        <legend>Profile</legend>
        <table>
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
      <ent
    </fieldset>
  </body>
</html>