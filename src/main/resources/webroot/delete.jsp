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
            
            var editId;
            
            	function edit(id){
            		window.alert(id)
            		document.getElementById('single').style.display = 'block';
            		document.getElementById('table1').style.display = 'none';  
            		
            	}
            </script>
            
            
            
            
            
         <div id="single">
        <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/single">
            <div class="row">
                <h1></h1>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                       <label for="course_number">Course Number</label>
                        <input type="text" id="course_number" name="course_number" class="form-control" placeholder="Ex: COSC120"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_section">Course Section</label>
                        <input type="text" id="course_section" name="course_section" class="form-control" placeholder="Ex: 01"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_name">Course Name</label>
                        <input type="text" id="course_name" name="course_name" class="form-control" placeholder="Ex: Computer Science 1"
                               required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                        <label for="instructor">Instructor ID</label>
                        <input type="text" id="instructor" name="instructor" class="form-control" placeholder="Ex: 123456" required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_days">Course Meeting Days</label>
                        <input type="text" id="course_days" name="course_days" class="form-control" placeholder="Ex: -M-W-F-"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="number_of_slots">Number of Available Slots</label>
                        <input type="text" id="number_of_slots" name="number_of_slots" class="form-control"
                               placeholder="Ex: 32" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                    <label for="start_time">Start Time</label>
                        <input type="text" id="start_time" name="start_time" class="form-control" placeholder="Ex: 920"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="end_time">End Time</label>
                        <input type="text" id="end_time" name="end_time" class="form-control" placeholder="Ex: 1030"
                               required>
                    </div>
                </div>
            </div>
            <div class="row">
                <center><h3>Required Features</h3></center>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-5">
                    <div class="form-group form-group-sm">
                        <div class="col-md-5">
                            <select class="form-control" id="chairs" name="chairs">
                                <option>Individual Seating</option>
                                <option>Group Seating</option>
                            </select>
                        </div>
                        <label class="control-label" for="chairs">Seating Type</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="whiteboard" value="">White Board</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="chalkBoard" value="">Chalk Board</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="computerLaptop" value="">Built-in Computer/Laptop</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="soundSystem" value="">Built-in Sound System</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="cd" value="">CD Player</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="dvd" value="">DVD Player</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="dataVideoProjector" value="">Data/Video Projector</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="hearingAssisted" value="">Hearing Assisted System</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="visualOptimizer" value="">Visual Optimizer</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="laptopConnectivity" value="">Laptop Connectivity</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="networkConnection" value="">Network Connections</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="overhearProjector" value="">Overhead Projector</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="podium" value="">Podium</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="projectorScreen" value="">Projector Screen</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="tvMonitors" value="">TV/Monitors</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="piano" value="">Piano</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <h1></h1>
                </div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-5">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
            
    <script>
    window.onload = function(){
   		document.getElementById('single').style.display = 'none';  
    }
    </script>    

</body>
</html>