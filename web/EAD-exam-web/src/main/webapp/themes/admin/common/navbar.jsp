<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

	<div class="navbar navbar-expand-md navbar-light">
		<div class="navbar-brand" style="padding: 0px; padding-top: 4px">
			<a href="<c:url value='/'/>" class="d-inline-block" style="padding-left: 10%">
				<img src="<c:url value='/themes/login/images/logo_mavin_group.jpg'/>" alt="" style="width:120px; height:40px; margin-bottom: 3px">
			</a>
		</div>
		
		<div class="d-md-none">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-mobile"><i class="icon-tree5"></i></button>
			<button class="navbar-toggler sidebar-mobile-main-toggle" type="button"><i class="icon-paragraph-justify3"></i></button>
		</div>

		<div class="collapse navbar-collapse" id="navbar-mobile">
			<ul class="navbar-nav">
				<li class="nav-item"><a href="#" class="navbar-nav-link sidebar-control sidebar-main-toggle d-none d-md-block"><i class="icon-paragraph-justify3"></i></a></li>


				
			</ul>

			<span class="navbar-text ml-md-3 mr-md-auto"><span class="badge bg-success">Online</span></span>

			<ul class="navbar-nav">
 				<li class="nav-item dropdown">
					<li class="nav-item dropdown">
					<a href="#" class="navbar-nav-link dropdown-toggle caret-0" data-toggle="dropdown" data-popup="tooltip" title="Chưa phát triển">
					   <i class="fa fa-bell" aria-hidden="true"></i>
					   <span class="d-md-none ml-2"></span><span class="badge badge-pill bg-warning-400 ml-auto ml-md-0">9</span>
					</a>

					<%-- <div class="dropdown-menu dropdown-menu-right dropdown-content wmin-md-350">
						<div class="dropdown-content-header"><span class="font-weight-semibold"><fmt:message key="system.notification"/></span><a href="#" class="text-default"><i class="icon-sync"></i></a></div>

						<div class="dropdown-content-body dropdown-scrollable">
							<ul class="media-list">
								<li class="media">
									<div class="mr-3"><a href="#" class="btn bg-transparent border-primary text-primary rounded-round border-2 btn-icon"><i class="icon-git-pull-request"></i></a></div>
									<div class="media-body">Mã vật tư<a href="#"> - 001</a> Cám bao sắp hết hạn<div class="text-muted font-size-sm">Còn 1 ngày</div></div>
								</li>

							</ul>
						</div>
					</div> --%>
					
				</li>
				</li>
				<li class="nav-item dropdown dropdown-user">
					<a href="#" class="navbar-nav-link dropdown-toggle" data-toggle="dropdown"><img src="<c:url value='/themes/admin/global_assets/images/placeholders/placeholder.jpg'/>" class="rounded-circle" alt=""><span>${pageContext.request.remoteUser}</span></a>
					<div class="dropdown-menu dropdown-menu-right">
<%-- 						<a href="#" class="dropdown-item"><i class="icon-user-plus"></i> <fmt:message key="label.profile"/></a> --%>
<!-- 						<a href="#" class="dropdown-item"><i class="icon-coins"></i> My balance</a> -->
						<div class="dropdown-divider"></div>
						<security:authorize access="hasAnyRole('ROLE_ACC_VIEW')">
						<a href="<c:url value='/user/list'/>" class="dropdown-item"><i class="icon-cog5"></i> <fmt:message key="label.management.acc"/></a>
						</security:authorize>
						<a href="${ctx }/user/resetpw" class="dropdown-item"><i class="icon-rotate-ccw2"></i><fmt:message key="password.change"/></a>
						<a href="${ctx }/logout" class="dropdown-item"><i class="icon-switch2"></i><fmt:message key="logout"/></a>
					</div>
				</li>
			</ul>
			
			
			
		</div>
	</div>
	
