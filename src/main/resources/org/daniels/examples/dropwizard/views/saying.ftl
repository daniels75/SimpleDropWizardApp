<#-- @ftlvariable name="" type="org.daniels.examples.dropwizard.views.SayingView" -->
<html>
    <body>
        <!-- calls getSaying().getContent() and sanitizes it -->
        <h1>Hello, ${saying.content?html}!</h1>
    </body>
</html>