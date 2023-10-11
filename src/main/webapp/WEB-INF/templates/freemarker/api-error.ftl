<html>
    <head>
        <title>
        </title>
        <style>
        .exception-container {
        margin: 0 auto;
        font-weight: 400;
        color: black;
        background-color: #03aafc;
        border: 1px solid #fc036f;
        width: fit-content;
        text-align: center;
        }
        
        .link {
        color: black;
        transition: 0.5s;
        }
        
        .link:hover {
        color: white;
        opacity: 1;
        text-shadow: 2px 2px 4px #000000;
        }
        
        body {
  background-color: rgba(0,0,0,0.65);
        }
        </style>
    </head>
    <body>
        <div class="exception-container">
            <h1>${error}</h1>
            <br/>
            <p>${code}</p>
            <p>url: ${url}</p>
            <br />
            <p>${message}</p>
            
            <p><a class="link" href="mailto:${email}">${email}</a></p>
        </div>
    </body>
</html>