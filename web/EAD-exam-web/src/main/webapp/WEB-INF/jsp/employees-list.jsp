<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../themes/common/taglibs.jsp"%>

<head>
    <title>Danh sách nhân viên trong công ty</title>
    <meta name="menu" content="employeeMenu"/>
    <script src="<c:url value='../../themes/admin/global_assets/js/plugins/forms/validation/validate.min.js'/>"></script>
    <link href="<c:url value='../../themes/admin/assets/css/custom_style.css'/>" rel="stylesheet" type="text/css">
</head>

<div class="content">

        <div class="card">
<%--            <div class="card-header header-elements-inline">--%>
<%--                <div class="header-elements">--%>
<%--                    <div class="list-icons">--%>
<%--                            <a href="<c:url value='/employee/form'/>" class="btn btn-sm btn-primary" title="<fmt:message key="button.add"/>"><i class="icon-plus22"></i><fmt:message key="button.add"/></a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="card-header header-elements-inline">
                    <div class="header-elements">
                        <div class="list-icons ">
                            <a href="<c:url value='/employee/form'/>" class="btn btn-sm btn-primary" title="<fmt:message key="button.add"/>"><i class="icon-plus22"></i><fmt:message key="button.add"/></a>
                        </div>
                    </div>
            </div>
            <div class="card-body">Danh sách nhân viên</div>
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr class="table-success">
                        <th>id</th>
                        <th>name</th>
                        <th>salary</th>
                        <th class="text-center" style="width:120px;"><i class="icon-menu-open2"></i></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty employees}">
                        <tr><td colspan="3" class="text-center text-none-data"><fmt:message key="not.data"/></td></tr>
                    </c:if>
                    <c:forEach var="e" items="${employees}" >
                         <tr>
                            <td>${e.id}</td>
                            <td>${e.name}</td>
                            <td>${e.salary}</td>
                             <td class=" text-center">
                                 <div class="list-icons">
                                     <div class="dropdown">
                                         <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7 mr-3 icon-2x"></i></a>
                                         <div class="dropdown-menu dropdown-menu-right">
                                             <a href="employee/form?id=${e.id}" class="dropdown-item"><i class="icon-pencil7" style="color:blue"> Sửa</i></a>
                                             <a href="employee/delete/${e.id}" class="dropdown-item"><i class="icon-trash" style="color:blue"> Xóa</i></a>
                                         </div>
                                     </div>
                                 </div>
                             </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
<%--<script src="<c:url value='/themes/admin/assets/js/barn_list.js'/>"></script>--%>

