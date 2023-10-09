<#list model["exceptionContent"] as content>
<html>
    <head>
        <title>
        </title>
        <style>
        .exception-container {
        margin: 0 auto;
        font-size: 400;
        color: black;
        background-color: light-blue;
        border: 1px solid light-grey;
        }
        </style>
    </head>
    <body>
        <div class="exception-container">
            Test
            ${content}
        </div>
    </body>
</html>
</#list>