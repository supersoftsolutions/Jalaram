<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<head>
<title>Jalaram</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="AdminResources/css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="AdminResources/css/style.css" rel='stylesheet' type='text/css' />
<link href="AdminResources/css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="AdminResources/css/font.css" type="text/css"/>
<link href="AdminResources/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="AdminResources/js/jquery2.0.3.min.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  <script>
$( ".selector" ).datepicker({
  dayNamesShort: [ "sun", "mon", "tue", "wen", "Thu", "Fri", "Sat" ]
});
</script>
<script type="text/javascript">
       function Search_Gridview(strKey, strGV) {
           var strData = strKey.value.toLowerCase().split(" ");
           var tblData = document.getElementById(strGV);
           var rowData;
           for (var i = 1; i < tblData.rows.length; i++) {
               rowData = tblData.rows[i].innerHTML;
               var styleDisplay = 'none';
               for (var j = 0; j < strData.length; j++) {
                   if (rowData.toLowerCase().indexOf(strData[j]) >= 0)
                       styleDisplay = '';
                   else {
                       styleDisplay = 'none';
                       break;
                   }
               }
               tblData.rows[i].style.display = styleDisplay;
           }
       }
   </script>
</head>
<body>
<section id="container">
<!--header start-->
<jsp:include page="Header.jsp"></jsp:include>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="">
		<div class="table-agile-info">
  <div class="panel panel-default">
    <div class="panel-heading">
   Daily Report
    </div>
    <div class="row w3-res-tb">
     <div class="col-sm-2">
       
        <button class="btn btn-sm btn-default">Generate</button>                
      </div> 
      <div class="col-sm-3">
       
 
          <input type="text" class="input-sm form-control" placeholder="Search" onkeyup="Search_Gridview(this,'id1')">
        <!--  <span class="input-group-btn">
            <button class="btn btn-sm btn-default" type="button">Go!</button>
          </span> -->
           </div> 
      <div class="col-sm-2">
     	 <input  type="text" readonly="true" id=".selector" size="10" maxlength="10" />		
<!--               <input  type="text" id="datepicker" size="10" maxlength="10" />
 -->      
      </div>
          <div class="col-sm-3">
<!--       <input  type="text" readonly="true" size="10" maxlength="10" />		
 -->              <input  type="text"  id="datepicker"  size="10" maxlength="10" />
      
      </div>
      <div class="col-sm-2">
      <div class="input-group">
                <button class="btn btn-sm btn-default">Update</button>                
  </div> 
      </div>
    </div>
    <div class="table-responsive">
      <table class="table table-striped b-t b-light" id="id1">
        <thead>
          <tr>
          <!--   <th style="width:20px;">
              <label class="i-checks m-b-none">
                <input type="checkbox"><i></i>
              </label>
            </th> -->
            <th>ID</th> 
             <th>Name</th>
             <th>idada</th>
             <th>Khaman</th>
             <th>Khandvi</th>
              <th>Nylon</th> 
             <th>Patra</th>
             <th>Samosa</th>
             <th>Sandwich_dhokla</th>
             <th>Sp_patra</th>
             <th>Priority</th>
             
             
           	
            
            <th style="width:30px;"></th>
          </tr>
        </thead>
         <tbody>
                                        <c:forEach items="${list}" var="x">
                                        <tr>
                                    <td>${x.ID}</td>
                                            <td>${x.name}</td>
                                            <td>${x.mobile}</td>
                                            <td>${x.address1}</td>
                                            <td>${x.balance}</td>
                                            
       <td height="30px" width="30px"> <a href="editwholesale.html?id=${x.ID}">Edit/</a> <a href="deletewholesale.html?id=${x.ID}">Delete</a></td>
                       </tr>                      
                            
                                               
                                        </c:forEach> 
                                      </tbody>

      </table>
    </div>
    
  </div>
</div>
</section>
<jsp:include page="Footer.jsp"></jsp:include>
  <!-- / footer -->
</section>

<!--main content end-->
</section>
<script src="AdminResources/js/bootstrap.js"></script>
<script src="AdminResources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="AdminResources/js/scripts.js"></script>
<script src="AdminResources/js/jquery.slimscroll.js"></script>
<script src="AdminResources/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="AdminResources/js/jquery.scrollTo.js"></script>

</body>
</html>
