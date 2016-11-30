<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Classroom Allocation</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Classroom Allocation</a>
        </div>
   </div>
</nav>

<a href="index.jsp" class="btn btn-default" role="button">Return to home page</a>


<%@ page import="java.util.List" %>

 <script>
  function edit(href) {
           window.alert(href);
        }
 </script>

<table id="table1" class="table table-striped">
                <thead>
                						
                <tr>
                    <th>Building:</th>
                    <th>Room Number:</th>
                </tr>
                </thead>

                <tbody>

                <%
                	GUI_Dev.Resource res = new GUI_Dev.Resource();
 					List<OIT_Dev.Classroom> filteredRoom = res.filteredRoom.getFilteredList();
 					
                    for(int i=0; i<filteredRoom.size(); i++){
                %>

                <tr id="<%=i%>">
                    <td><%=filteredRoom.get(i).getBuilding()%>
                    </td>
                    <td><%=filteredRoom.get(i).getRoomnum()%>
                    </td>
                    <td><a onclick="edit(<%=i%>);">Edit</a></td>
                </tr>
                <% }
                %>
                </tbody>
            </table>
            
           

</body>
</html>