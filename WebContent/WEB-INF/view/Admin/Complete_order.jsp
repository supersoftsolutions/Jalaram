<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
   
   <c:if test="${!empty list1}">
<script>
 
	alert("User is not Registered Successfully. Click Quick Registration Button");

</script>
</c:if>
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
    Complete Order(Regular order)
    </div>
    <div class="row w3-res-tb">
   <!--  <div class="col-sm-5 m-b-xs">
        <select class="input-sm form-control w-sm inline v-middle">
          <option value="0">Bulk action</option>
          <option value="1">Delete selected</option>
          <option value="2">Bulk edit</option>
          <option value="3">Export</option>
        </select>
        <button class="btn btn-sm btn-default">Apply</button>                
      </div> 
      <div class="col-sm-4">
      </div> -->
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" class="input-sm form-control" placeholder="Search" onkeyup="Search_Gridview(this,'id1')">
        <!--   <span class="input-group-btn">
            <button class="btn btn-sm btn-default" type="button">Go!</button>
          </span> -->
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
             <th>Address</th>
             <th>Date</th>
               <th>Product</th>
             <th>Kg</th>
             <th>Rate</th>
             <th>Total</th>
                <th>Status</th>
               <th>Transport Name</th>
             <th>Transport Charge</th>
             <th>Transport Type</th>
             <th>Labour Charge</th>
             
           	
            
            <th style="width:30px;"></th>
          </tr>
        </thead>
         <tbody>
                                        <c:forEach items="${list}" var="x">
                                         <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
                                        <tr>
                                            
                                            
                                     <td>${x.regular_orderid}</td>
                                     <td>${x.caterers_name}</td>   
                                     <td>${x.address}</td>                                
                                     <td>${x.date}</td>
                                     <td>${x.product}</td>
                                     <td>${x.kg}</td>   
                                     <td>${x.rate}</td>                                
                                     <td>${x.total}</td>
                                     <td>${x.status}</td>
                                     <td>${x.transport_name}</td>
                                       <td>${x.transport_charge}</td>                                
                                     <td>${x.transport_type}</td>
                                     <td>${x.labour_charge}</td>
                                            
    <td height="30px" width="30px">  <a href="Add_charge.html?id=${x.regular_orderid}">Complete/</a>  <a href="cancel_regular_order.html?id=${x.regular_orderid}">Cancel</a></td> 
                                             
      <!--    <td>       -->
          <%--  <button class="btn btn-primary" type="submit" onclick="showPopupWindow(); setAttributes(${question.id}, 0>Save</button> --%> 
<%--            <button onclick="showPopupWindow(); setAttributes(${x.ID}, 0)">Reply</button>
 --%>       <!--   </td>                                  -->
                                            
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
