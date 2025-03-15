<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ApprovisionnementDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Articles_Approvisionnement" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!doctype html>
<!-- 
* Bootstrap Simple Admin Template
* Version: 2.1
* Author: Alexis Luna
* Website: https://github.com/alexis-luna/bootstrap-simple-admin-template
-->
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Supply Product </title>
    <link href="assets/vendor/fontawesome/css/fontawesome.min.css" rel="stylesheet">
    <link href="assets/vendor/fontawesome/css/solid.min.css" rel="stylesheet">
    <link href="assets/vendor/fontawesome/css/brands.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/datatables/datatables.min.css" rel="stylesheet">
    <link href="assets/css/master.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
<jsp:include page="navbar.jsp" />
            <div class="content">
                <div class="container">
                    <div class="page-title">
                        <h3> Supply Product
                           
                        </h3>
                      <button type="button" class="btn btn-danger"><a href="test.jsp" class="" onclick=""id="generate-pdf-button">generate-pdf-button<i class="fas fa-file"></i></a></button>
                      <button type="button" class="btn btn-success"><a href="addApprovisionnement.xhtml" class="" onclick=""id="generate-pdf-button">Add new Product<i class="fas fa-plus"></i></a></button>
                    </div>
                    <div class="box box-primary">
                        <div class="box-body">
                            <table width="100%" class="table table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Product code</th>
                                        <th>Expected delivery date</th>
                                        <th>quantity</th>
                                     
                                        <th></th>
                                    </tr>
                                </thead>
                                <%
                       ApprovisionnementDAO userDao = new ApprovisionnementDAO();
		            List<Articles_Approvisionnement> userList = userDao.getAll();
		            for (Articles_Approvisionnement user : userList) {
		        		%>
                                <tbody>
                                    <tr>
                                        <td><%= user.getCodeArt() %></td>
                                    
                                        <td><%= user.getDatePrevueLivraison() %></td>
                                        <td><%= user.getQteCommandé() %></td>
                                
                                        <td class="text-end">
                                            <a href="updateApprovisionnement.xhtml" class="btn btn-outline-info btn-rounded" onclick=""id="generate-pdf-button"><i class="fas fa-pen"></i></a>
                                        <a href="DeleteApprovisionnement.xhtml" class="btn btn-outline-danger btn-rounded" onclick=""><i class="fas fa-trash"></i></a>
                                        </td>
                                    </tr>
                                     <% } %>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/datatables/datatables.min.js"></script>
    <script src="assets/js/initiate-datatables.js"></script>
    <script src="assets/js/script.js"></script>
</body>

</html>