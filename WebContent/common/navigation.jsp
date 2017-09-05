<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<ul class="nav nav-list">
				<security:authorize ifAnyGranted="CONSOLE">
					<li id="parent_1" class="">
						<a href="${ctx }/defaultAction.action" >
							<i class="icon-desktop"></i>
							<span class="menu-text">控制台 </span>
						</a>
						<%-- <ul class="submenu">
							<security:authorize ifAnyGranted="PERSONAL">
								<li id="sub_11" class="">
									<a href="${ctx}/usersAction.action">
										<i class="icon-double-angle-right"></i>
											个人中心
									</a>
								</li>
							</security:authorize>
							<security:authorize ifAnyGranted="NEWS">
								<li id="sub_12" class="">
									<a href="${ctx}/usersAction.action">
										<i class="icon-double-angle-right"></i>
											新闻中心
									</a>
								</li>
							</security:authorize>
							<security:authorize ifAnyGranted="MAILS">
								<li id="sub_13" class="">
									<a href="${ctx}/rolesAction.action">
										<i class="icon-double-angle-right"></i>
										        邮箱中心
									</a>
								</li>
							</security:authorize>
						</ul> --%>
					</li>
				</security:authorize>	
				<security:authorize ifAnyGranted="SYSTEM">
					<li id="parent_2" class="">
						<a href="#" class="dropdown-toggle">
							<i class="icon-cogs"></i>
							<span class="menu-text">系统管理 </span>
							<b class="arrow icon-angle-down"></b>
						</a>

						<ul class="submenu">
							<security:authorize ifAnyGranted="SYSTEM_USER">
								<li id="sub_21" class="">
									<a href="${ctx}/usersAction.action">
										<i class="icon-double-angle-right"></i>
											用户管理
									</a>
								</li>
							</security:authorize>
							<security:authorize ifAnyGranted="SYSTEM_ROLE">
								<li id="sub_22" class="">
									<a href="${ctx}/rolesAction.action">
										<i class="icon-double-angle-right"></i>
										        角色管理
									</a>
								</li>
							</security:authorize>
							<security:authorize ifAnyGranted="SYSTEM_AUTHORITIES">
								<li id="sub_23" class="">
									<a href="${ctx}/authoritiesAction.action">
										<i class="icon-double-angle-right"></i>
										        权限管理
									</a>
								</li>
							</security:authorize>
							<security:authorize ifAnyGranted="SYSTEM_SYSPARAM">
								<li id="sub_24" class="">
									<a href="${ctx}/sysParamTypeAction!retrieveAllSysParamTypes.action">
										<i class="icon-double-angle-right"></i>
										        系统参数
									</a>
								</li>
							</security:authorize>
						</ul>
					</li>
				</security:authorize>
				
				<security:authorize ifAnyGranted="CONSUMER_MANAGE">
						<li id="parent_3" class="">
							<a href="#" class="dropdown-toggle">
								<i class="icon-male"></i>
								<span class="menu-text">客户管理</span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<security:authorize ifAnyGranted="MY_CONSUMER">
									<li id="sub_31" class="">
										<a href="${ctx}/consumerAction!retrieveAllConsumers.action">
											<i class="icon-double-angle-right"></i>
												我的客户
										</a>
									</li>
								</security:authorize>
								<security:authorize ifAnyGranted="MY_CONTACT">
									<li id="sub_32" class="">
										<a href="${ctx}/contactAction!retrieveAllContacts.action">
											<i class="icon-double-angle-right"></i>
												我的联系人
										</a>
									</li>
								</security:authorize>
								<security:authorize ifAnyGranted="MY_BUSINESS">
									<li id="sub_33" class="">
										<a href="${ctx}/businessAction!retrieveAllBusinesss.action">
											<i class="icon-double-angle-right"></i>
												商机线索
										</a>
									</li>
								</security:authorize>
								<security:authorize ifAnyGranted="MY_FOLLOW">
									<li id="sub_34" class="">
										<a href="${ctx}/followAction!retrieveAllFollows.action">
											<i class="icon-double-angle-right"></i>
												我的跟进
										</a>
									</li>
								</security:authorize>
								<security:authorize ifAnyGranted="MY_EVENT">
									<li id="sub_35" class="">
										<a href="${ctx}/evenAction!retrieveAllEvens.action">
											<i class="icon-double-angle-right"></i>
												交往记录
										</a>
									</li>
								</security:authorize>
							</ul>
						</li>
					</security:authorize>
					
					<security:authorize ifAnyGranted="CONTRACT_ORDER">
						<li id="parent_4" class="">
							<a href="#" class="dropdown-toggle">
								<i class="icon-bookmark"></i>
								<span class="menu-text">合同订单</span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<security:authorize ifAnyGranted="CONTRACT">
									<li id="sub_41" class="">
										<a href="${ctx}/contractAction!retrieveAllContracts.action">
											<i class="icon-double-angle-right"></i>
												合同管理
										</a>
									</li>
								</security:authorize>
								<security:authorize ifAnyGranted="ORDER">
									<li id="sub_42" class="">
										<a href="${ctx}/orderAction!retrieveAllOrders.action">
											<i class="icon-double-angle-right"></i>
												订单管理
										</a>
									</li>
								</security:authorize>	

							</ul>
						</li>
					</security:authorize>
					
					<security:authorize ifAnyGranted="FINANCIAL_MANAGE">
							<li id="parent_5" class="">
								<a href="#" class="dropdown-toggle">
									<i class="icon-jpy"></i>
									<span class="menu-text"> 财务管理 </span>
									<b class="arrow icon-angle-down"></b>
								</a>
	
								<ul class="submenu">
									<security:authorize ifAnyGranted="RECEIVING">
										<li id="sub_51" class="">
											<a href="${ctx }/receivingAction!retrieveAllReceivings.action">
												<i class="icon-double-angle-right"></i>
												收款管理	
											</a>
										</li>
									</security:authorize>
									
									<security:authorize ifAnyGranted="INVOICE">
										<li id="sub_52" class="">
											<a href="${ctx }/invoiceAction!retrieveAllInvoices.action">
												<i class="icon-double-angle-right"></i>
												开票管理
											</a>
										</li>
									</security:authorize>
								</ul>
							</li>
						</security:authorize>

					<security:authorize ifAnyGranted="PERSONNEL_MANAGE">
						<li id="parent_6" class="">
							<a href="#" class="dropdown-toggle">
								<i class="icon-group"></i>
								<span class="menu-text">
									人事管理
								</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<security:authorize ifAnyGranted="DEPARTMENT_POSITION">
									<li id="sub_61" class="">
										<a href="${ctx}/departmentAction!retrieveAllDepartments.action">
											<i class="icon-double-angle-right"></i>
											部门岗位管理
										</a>
									</li>
								</security:authorize>
							</ul>
						</li>
					</security:authorize>
					
					<security:authorize ifAnyGranted="PRODUCT">	
						<li id="parent_7" class="">
							<a href="${ctx}/productAction!retrieveAllProducts.action">
								<i class="icon-list-alt"></i>
								<span class="menu-text">产品管理</span>
							</a>
						</li>
						
					</security:authorize>
						
			<security:authorize ifAnyGranted="DATA_RECYCLE">				
					<li id="parent_8" class=""> 
						<a href="#" class="dropdown-toggle">
							<i class="icon-trash"></i>
							<span class="menu-text">数据回收 </span>
	
							<b class="arrow icon-angle-down"></b>
						</a>
	
						<ul class="submenu">
							<!-- <security:authorize ifAnyGranted="PERSONNEL_RECYCLE">
									<li id="sub_81" class="">
										<a href="#" class="dropdown-toggle">
											<i class="icon-double-angle-right"></i>
												人事回收
											<b class="arrow icon-angle-down"></b>
										</a>
										<ul class="submenu">
												<security:authorize ifAnyGranted="DEPARMENT_RECYCLE">
														<li>
														<a href="#" style="text-decoration: none;">
															<i class="icon-trash"></i>
																部门回收
														</a>
													</li>
												</security:authorize>
												<security:authorize ifAnyGranted="POSITION_RECYCLE">
													<li>
														<a href="#" style="text-decoration: none;">
															<i class="icon-trash"></i>
																岗位回收
														</a>
													</li>
												</security:authorize>	
												<security:authorize ifAnyGranted="MEMBER_RECYCLE">
													<li>
														<a href="#" style="text-decoration: none;">
															<i class="icon-trash"></i>
																员工回收
														</a>
													</li>
												</security:authorize>
										  </ul>
								 	 </li>
							 </security:authorize> -->
							  
							 <security:authorize ifAnyGranted="CRM_RECYCLE">	
									  <li id="sub_82" class="">
										<a href="#" class="dropdown-toggle">
											<i class="icon-double-angle-right"></i>
												CRM回收
											<b class="arrow icon-angle-down"></b>
										</a>
										<ul class="submenu">
											 <security:authorize ifAnyGranted="CONSUMER_RECYCLE">	
													<li>
														<a href="${ctx}/consumerAction!retrieveAllTrash.action" style="text-decoration: none;">
															<i class="icon-trash"></i>
																客户回收
														</a>
													</li>
												</security:authorize>
											<security:authorize ifAnyGranted="CONTACT_RECYCLE">	
												<li>
													<a href="${ctx}/contactAction!retrieveAllTrash.action" style="text-decoration: none;">
														<i class="icon-trash"></i>
															联系人回收
													</a>
												</li>
											</security:authorize>
											<security:authorize ifAnyGranted="ORDER_RECYCLE">		
												<li>
													<a href="${ctx}/orderAction!retrieveAllTrash.action" style="text-decoration: none;">
														<i class="icon-trash"></i>
															订单回收
													</a>
												</li>
											</security:authorize>	
											<security:authorize ifAnyGranted="CONTRACT_RECYCLE">	
												<li>
													<a href="${ctx}/contractAction!retrieveAllTrash.action" style="text-decoration: none;">
														<i class="icon-trash"></i>
															合同回收
													</a>
												</li>
											</security:authorize>
											<security:authorize ifAnyGranted="PRODUCT_RECYCLE">		
												<li>
													<a href="${ctx}/productAction!retrieveAllTrash.action" style="text-decoration: none;">
														<i class="icon-trash"></i>
															产品回收
													</a>
												</li>
											</security:authorize>
										  </ul>
									  </li>
								 </security:authorize>
						  </ul>
					  </li>
			</security:authorize>	
				
		</ul><!-- /.nav-list -->