<html>
    <head>
        <title>USTD:  <g:layoutTitle default="Default Title" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'ubase.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />

        <!-- dynamic styles go here right now - consider using a template for this -->
        <style type="text/css">
          body {
            background-image:url("${resource(dir:'images/ue/common', file:'ue-network.gif')}") ;
          }
        </style>

        <g:layoutHead />
    </head>
    <body>
      <div id="container">
      <g:layoutBody/>
      </div>
    </body>
</html>