<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>u.enterprise <g:layoutTitle default="Grails"/></title>
  <link rel="stylesheet" href="${ub.resource(dir:'css', file: 'yui-reset-fonts-grids.css')}"/>
  <link rel="stylesheet" href="${ub.styleResource(file: "main.css")}"/>
  <link rel="stylesheet" href="${ub.styleResource(file: "custom.css")}"/>
  <link rel="shortcut icon" type="image/x-icon" href="${ub.styleResource(file: "favicon.ico")}"/>
  <g:layoutHead/>
</head>

<body>
<div id="doc4" class="yui-t4">
  <!-- start BANNER -->
  <div id="hd" role="banner">
    <div class="yui-g">
      <div id="logo" class="yui-u first">
        <a href="${createLinkTo(dir:"")}">
          <img src="${ub.styleResource(file: 'grails_logo.gif')}" alt="Grails" />
        </a>
      </div>
      <div id="headline" class="yui-u">
        u.enterprise
      </div>
    </div>
  </div>

  <div id="bd" role="main">
    <div class="yui-g">
      <div class="yui-u first"></div>
      <div id="status" class="yui-ge">
        <div class="yui-u first">
          your are logged in as <span>hugo@aol.com</span>
        </div>
        <div class="yui-u">
          <g:link controller="security" action="logout">logout</g:link>
        </div>
      </div>
    </div>
    <div id="yui-main">
      <div id="content" class="yui-b">
        <g:layoutBody/>
      </div>
    </div>

    <div id="navigation" role="navigation" class="yui-b">
      <ul>
        <li><a href="${createLinkTo(dir:"")}">Home</a></li>
        <li><g:link controller="entity" action="index">Manage Entities</g:link></li>
        <li><g:link controller="user" action="index">Manage Users</g:link></li>
        <li><a href="#">Link3</a></li>
        <li><a href="#">Link4</a></li>
        <li><a href="#">Link5</a></li>
        <li><a href="#">Link6</a></li>
        <li><a href="#">Link7</a></li>
        <li><g:link controller="user" action="index">About...</g:link></li>
      </ul>
    </div>

  </div>
  <div id="ft" role="contentinfo">
    <p><g:meta name="app.name"/> version <g:meta name="app.version"/>, &copy 2008-2009 by u.enterprise</p>
    <p></p>
  </div>
</div>
</body>

<!--
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${ub.styleResource(file: 'spinner.gif')}" alt="Spinner" />
        </div>
        <div class="logo"><img src="${ub.styleResource(file: 'grails_logo.jpg')}" alt="Grails" /></div>
        <div id="container">
        <g:layoutBody/>
        </div>
    </body>
    -->
</html>