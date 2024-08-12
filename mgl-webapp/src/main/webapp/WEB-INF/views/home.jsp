<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="mgl" %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Home page</title>
    </head>
    <body>
       <mgl:myNav/>
       <h2>Upload a file for your game</h2>
       <!-- <div class="column">
           <form method="POST" action="uploadCoverArt" enctype="multipart/form-data">
               <input class="row" type="text" name="name" placeholder="Name your file here"></input>
               <input class="row" type="file" name="file"></input>
               <input class="row" type="submit" value="Upload">
           </form>
       </div> -->

    </body>
</html>