<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ include file="/common/head-import.jsp"%>
	
		<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>

							<li>
								<a href="#">控制台</a>
							</li>
							<li class="active">邮箱中心</li>
						</ul><!-- .breadcrumb -->

					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								邮箱
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								
									 <div class="span2" style="width: 248px;"> 
										   <ul class="inbox-nav margin-bottom-10" style="text-decoration: none;">
										        <li class="compose-btn" style="text-decoration: none;"> <a href="javascript:;" data-title="Compose" class="btn green"> <i class="icon-edit"></i> 写邮件 </a> </li>
										        <li class="draft" style="text-decoration: none;"><a class="btn" href="javascript:;" data-title="收件箱">收件箱</a><b></b></li> 
										        <li class="sent" style="text-decoration: none;"><a class="btn" href="javascript:;" data-title="已发送">已发送</a><b></b></li>
										  </ul> 
		     						 </div>
								
								

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					
					<%@ include file="/common/copyright.jsp"%>
				</div><!-- /.main-content -->
			<%@ include file="/common/bottom-import.jsp"%>
			
			
	</body>
</html>
				
	