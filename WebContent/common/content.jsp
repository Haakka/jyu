<%@ include file="/js/widgets/calendar/calendar.jsp"%>
<script src="${ctx}/js/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/js/validate/jquery.metadata.js" type="text/javascript"></script>
<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>
<script src="${ctx}/js/effects/tootip.js" type="text/javascript"></script>
<script src="${ctx}/js/SYFileHelper.js" type="text/javascript"></script>
<script src="${ctx}/js/jsAddress.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/Selector.js"></script>
<script type='text/javascript' src='${ctx}/js/jquery.boxy.js'></script>
<script src="${ctx}/js/jquery.ui/ui/ui.datepicker.js"></script>
<link rel="stylesheet" href="${ctx}/js/jquery.ui/themes/default/ui.all.css"/>
<script src="${ctx}/js/jquery.cookie.js" type="text/javascript"></script>
<link href="${ctx}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet" />
<link rel='stylesheet' href='${ctx}/css/boxy.css' type='text/css' />

<%-- ueditor start --%>
<script type="text/javascript">
	//项目名称
	var contextPath = '${ctx}';
</script>
<script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.all.min.js"> </script>
<%--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败--%>
<%--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文--%>
<script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
<%--实例化编辑器 --%>
<%--建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例 --%>
$(document).ready(function(){
	if($("#editor").length > 0){
		var ue = UE.getEditor('editor');
	}
});
</script>
<%-- ueditor end --%>