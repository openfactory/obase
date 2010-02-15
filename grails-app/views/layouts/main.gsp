<%--
    for scaffolded views that have "main" as layout hardcoded will need it
--%>
<!-- page scope apparently does not get passed on applyLayout ... -->
<g:set scope="request" var="navmenu" value="admin"/>
<g:set scope="request" var="grailscss" value="true"/>


<g:applyLayout name="${ub.layoutName()}">
  <g:layoutBody/>
</g:applyLayout>
