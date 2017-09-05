<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
	
	<!-- basic scripts -->

	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${ctx}/js/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="${ctx}/js/assets/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/assets/js/date-time/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	<script src="${ctx}/js/assets/js/date-time/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->
	<%-- <script src="${ctx}/js/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctx}/js/assets/js/jquery.dataTables.bootstrap.js"></script> --%>

	<!-- ace scripts -->

	<script src="${ctx}/js/assets/js/ace-elements.min.js"></script>
	<script src="${ctx}/js/assets/js/ace.min.js"></script>
	
	<script src="${ctx}/js/common/SYFileHelper.js"></script>
	<%-- <script src="${ctx}/js/assets/js/bootbox.js"></script> --%>
	<script type="text/javascript">
		jQuery(function($) {
			//设置弹窗的语言
			bootbox.setLocale("zh_CN");
		});
		
	</script>
	
	<script type="text/javascript">
		function preview(file) {
			 var prevDiv = document.getElementById('prewatch');
			 if (file.files && file.files[0]) {
			 var reader = new FileReader();
			 reader.onload = function(evt){
			 prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="120px" height="100px" onclick="openPic(\'head\')" style="cursor: pointer;" />';
			 $('#head').attr('src',evt.target.result);
			}  
			 reader.readAsDataURL(file.files[0]);
			} else  {
			 prevDiv.innerHTML = '<img src="${uploadImgPath}/user_img.png" width="120px" height="100px"  style="cursor: pointer;"/>'; 
			 		}
		 }
		 function openPic(id) {
				var wd = $('#' + id).width();
				var hi = $('#' + id).height();
				if (wd >= 900) {
					wd = 900;
				}
				if (hi >= 520) {
					hi = 520;
				}
				layer.open({
				    type: 1,
				    title: false,
				    closeBtn: true,
				    area: [wd + 'px', hi + 'px'],
				    skin: 'layui-layer-nobg', //没有背景色
				    shadeClose: true,
				    content: $('#' + id)
				});
		}
	</script>
	