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
			</ul>
		</div><!-- .breadcrumb -->

		<div class="page-content">
			<div>
				<h3 class="row-fluid header smaller  blue" style="line-height: 39px;">
					<span class="span7">控制台</span><!-- /span -->

				</h3>
			</div><!-- /.page-header -->
			<div class="row">
					<!-- PAGE CONTENT BEGINS -->
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="width: 22%;height: 100px;margin-left: 20px;background-color: #26C281;">
                                <div>
                                    <div class="visual">
                                        <i class="fa fa-comments"></i>
                                    </div>
                                    <div class="details">
                                        <div style="text-align: center;margin-top: 10px;">
                                            <span  style="color:#FFF;font-size: 34px;">
                                            	${todayNewConsumer }                                         
                                            </span>
                                        </div>
                                        <div style="text-align: center;color:#FFF;"> 今日新增客户数 </div>
                                    </div>
                                </div>
                        </div>
                         <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="width: 22%;height: 100px;margin-left: 20px;background-color: #2ab4c0;">
                                <div>
                                    <div class="details">
                                        <div class="number" style="text-align: center;margin-top: 10px;">
                                            <span style="color:#FFF;font-size: 34px;">
                                          		 ${yesNewConsumer }
                                            </span> </div>
                                        <div class="desc" style="text-align: center;color:#FFF;"> 昨日新增客户数 </div>
                                    </div>

                                </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="width: 22%;height: 100px;margin-left: 20px;background-color: #578ebe;">
                                <div>
                                    <div class="details">
                                        <div class="number" style="text-align: center;margin-top: 10px;">
                                            <span style="color:#FFF;font-size: 34px;">
                                           	 	${todayNewFollow }
                                            </span>
                                        </div>
                                        <div class="desc" style="text-align: center;color:#FFF;"> 今日新增跟踪记录 </div>
                                    </div>

                                </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="width: 22%;height: 100px;margin-left: 20px;background-color: #9B59B6;">
                                <div>
                                    <div class="details">
                                        <div class="number" style="text-align: center;margin-top: 10px;">
                                            <span style="color:#FFF;font-size: 34px;">
                                           	 ${totalBusiness }
                                            </span> </div>
                                        <div class="desc" style="text-align: center;color:#FFF;"> 线索销售额总计 </div>
                                    </div>

                                </div>
                        </div>
						
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
		
		
		<%@ include file="/common/copyright.jsp"%>
	</div><!-- /.main-content -->
	

	<%@ include file="/common/bottom-import.jsp"%>
	
	<script src="${ctx}/js/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			setCurrent();
		});
		
		function setCurrent(){
			$("#parent_1").addClass("active open");
			$("#sub_11").addClass("active");
		}
	</script>
	
	</body>
</html>


