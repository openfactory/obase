<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
      <title>u.enterprise / EP Home</title>
		  <meta name="layout" content="public" />
      <g:javascript library="jquery"/>

    <style type="text/css">
      body {
        background-image:url("../../web-app/images/ue/ue-network.gif") ;
      }
      #content {
        text-align:center;
        margin-left:auto;
        margin-right:auto;
        margin-top:3em;
        margin-bottom:3em;
        padding:3em;
        width:40%;
        background-color:darkorange;
        opacity:0.0;
        color:darkslategray;
        font-family:sans-serif;
        font-size:120%;
        font-weight:bold;

      }
      #content h1 {
        color:red;
      }
    </style>
    </head>

    <body>
        <div id="content">
        <h1>u.enterprise / EP </h1>
        <br>
        <p>

          <g:meta name="app.desc"/> <g:meta name="app.version"/>
          running on Grails <g:meta name="app.grails.version"/> (${GrailsUtil.environment})<br />
          with Java ${System.properties."java.vm.version"}<br />
          character encoding is ${System.properties."file.encoding"}<br /><br/>
          Copyright (C) 2008,2009 by
          u.enterprise business solutions GmbH<br>
          RIZ, Leobersdorfer Strasse 42/1-09<br>
          A-2560 Berndorf/St.Veit, Österreich<br>
          E: info@uenterprise.de</br>
		</p>
    <br>
    <a style="display:none" href="www.uenterprise.de">www.uenterprise.de</a>

   </div>

    <jq:jquery>
      $("a").fadeIn("slow")
      $("#content").animate({opacity: "0.8"}, "slow");
    </jq:jquery>

   </body>
</html>