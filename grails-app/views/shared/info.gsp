<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
      <title>openfactory / ubase Info</title>
      <g:javascript library="jquery"/>

      <style type="text/css">
        body {
          background-image:none;
        }
        #content {
          padding:10px;
          border: 6px solid gray;
          text-align:center;
          width:40%;
          margin:auto;
          -moz-border-radius:10pt;
          /*text-align:center;*/
          /*margin-left:auto;*/
          /*margin-right:auto;*/
          /*margin-top:3em;*/
          /*margin-bottom:3em;*/
          /*padding:3em;*/
          /*width:40%;*/
          background-color:darkorange;
          opacity:0.0;
          /*color:darkslategray;*/
          /*bord*/
          font-size:120%;
          font-weight:bold;

        }
        #content h2 {
          color:red;
        }
      </style>


    </head>

    <body>
        <div id="content">
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
    <a style="opacity:0.0" href="http://www.uenterprise.de">www.uenterprise.de</a>
    <div class="info_linkbox">
      <g:link url="/shared/info">INFO</g:link>
      <g:link view="/shared/info">TEST</g:link>
      <g:link view="/shared/info">FEST</g:link>
    </div>

   </div>


    <jq:jquery>
      $("#content").animate({opacity: "1.0"}, "slow", function() {
        $("a").animate({opacity: "1.0"}, "slow")  ;
      })

      <!--$("a").fadeIn("slow")-->
    </jq:jquery>

   </body>
</html>