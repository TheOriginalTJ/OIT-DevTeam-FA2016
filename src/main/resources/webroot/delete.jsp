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
<table id="table1" class="table table-striped">
                <thead>
                						
                <tr>
                    <th>Course #:</th>
                    <th>Section #:</th>
                    <th>Course Name:</th>
                    <th>Instructor ID:</th>
                    <th>Meeting Days:</th>
                    <th>Start Time:</th>
                    <th>End Time:</th>
                </tr>
                </thead>

                <tbody>

                <%
                	GUI_Dev.Resource res = new GUI_Dev.Resource();
 					List<OIT_Dev.Class> filtered = res.filtered.getFilteredList();
 					
                    for(int i=0; i<filtered.size(); i++){
                %>

                <tr id="<%=i%>">
                    <td><%=filtered.get(i).getClassnum()%>
                    </td>
                    <td><%=filtered.get(i).getSectionnum()%>
                    </td>
                    <td><%=filtered.get(i).getCourseName()%>
                    </td>
                    <td><%= filtered.get(i).getInstructorID()%>
                    </td>
                    <td><%= filtered.get(i).getMeetingDays()%>
                    </td>
                    <td><%= filtered.get(i).getStartTime()%>
                    </td>
                    <td><%= filtered.get(i).getEndTime()%>
                    </td>
                    <td><a onclick="edit(<%=i%>);">Edit</a></td>
                </tr>
                <% }
                %>
                </tbody>
            </table>
            
            <script>
            	function edit(id){
            		window.alert(id)
            	}
            </script>

</body>
</html>