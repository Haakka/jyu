package com.modules.commons;

public class CommonStatus {
	
	// pc校验码常量
	public static final String CUSTOM_PC_CODE_CONSTANT = "pcCode";

	// +飞猫总站域名
	public static final String COMMON_DOMAIN = "jfeimao";
	
	
	// 客户端类型
	public static final String MSG_CLIENTS_SYSTEM = "SYSTEM";
	public static final String MSG_CLIENTS_USER = "USER";
	public static final String MSG_CLIENTS_PC = "PC";
	public static final String MSG_CLIENTS_WECHAT = "WECHAT";
	public static final String MSG_CLIENTS_IOS = "IOS";
	public static final String MSG_CLIENTS_ANDROID = "ANDROID";
	
	public static final String CLIENT_TYPE_PC_MAMNGER="0";//PC后台
	public static final String CLIENT_TYPE_WECHAT="1";//微信端
	public static final String CLIENT_TYPE_PC_FRONT="2";//PC前端
	public static final String CLIENT_TYPE_APP="3";//APP端
	
	
	/**通用STATUS状态*/
	public static final String STATUS_ZERO = "0";
	public static final String STATUS_ONE = "1";
	public static final String STATUS_TWO = "2";
	public static final String STATUS_THREE = "3";
	
	/**
	 * 软删除状态
	 */
	public static final String HAS_DELETE_STATUS="0"; //已删除
	public static final String NOT_DELETE_STATUS="1"; //未删除
	
	/**通用FLAG判断状态*/
	public static final String FLAG_MINUS_TWO = "-2";
	public static final String FLAG_MINUS_ONE = "-1";
	public static final String FLAG_ZERO = "0";
	public static final String FLAG_ONE = "1";
	public static final String FLAG_TWO = "2";
	public static final String FLAG_THREE = "3";
	public static final String FLAG_FOUR = "4";
	public static final String FLAG_FIVE = "5";
	
	

	/**订单状态*/
	public static final String ORDER_TYPE_ZERO = "0"; // 未处理
	public static final String ORDER_TYPE_ONE = "1"; // 已派单
	public static final String ORDER_TYPE_TWO = "2"; // 处理中
	public static final String ORDER_TYPE_THREE = "3";// 已完结
	public static final String ORDER_TYPE_FOUR = "4"; // 处理中
	
	/**产品进度状态*/
	public static final String PRODUCT_FINISH = "0";  //已完成
	public static final String PRODUCT_DEVELOPING = "1"; //开发中
	public static final String PRODUCT_FOLLOWING = "2"; //跟进中
	public static final String PRODUCT_NOTSTART = "3"; //未开始
	
	/**项目状态*/
	public static final String PROJECT_BASE_STATUS_STOP = "0";  //准备启动
	public static final String PROJECT_BASE_STATUS_USING = "1"; //处理中
	public static final String PROJECT_BASE_CHECKING = "2"; //验收中
	public static final String PROJECT_BASE_PAUSEING = "3"; //暂停中
	public static final String PROJECT_BASE_FINISH = "4"; //已完成
	public static final String PROJECT_BASE_BAD = "5"; //坏账
	
	/**性别*///用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	public static final String SEX_UNKNOW = "0"; //未知
	public static final String SEX_BOY = "1"; //男性boy
	public static final String SEX_GIRL = "2"; //女性girl
	/**渠道商类型*/
	public static final String CHANNEL_TYPE_CENTER = "0"; //本部
	public static final String CHANNEL_TYPE_PERSON = "1"; //个人
	public static final String CHANNEL_TYPE_OUTSIDE = "2"; //外部机构
	public static final String CHANNEL_TYPE_ASSOCIATED_COMPANY = "3"; //关联公司
	/**渠道经理状态*/
	public static final String CHANNELDIRECTOR_STATUS_NOT = "0"; //未培训
	public static final String CHANNELDIRECTOR_STATUS_USEING = "1"; //培训中
	public static final String CHANNELDIRECTOR_STATUS_OVER = "2"; //已培训
	public static final String CHANNELDIRECTOR_STATUS_SUCCESS = "3"; //已录取
	
	/**订单处理状态*/
	public static final String ORDER_STATUS_NOT_PROCESSED = "0"; //未处理
	public static final String ORDER_STATUS_SEND = "1"; //已派单
	public static final String ORDER_STATUS_PROCESSING = "2"; //处理中
	public static final String ORDER_STATUS_PROCESSED = "3"; //已完结
	public static final String ORDER_STATUS_NOT_USER = "4"; //废单
	public static final String ORDER_STATUS_HANG = "5"; //挂单-->新增状态，介于处理中和已完结之间
	
	/**订单成交状态*/
	public static final String ORDER_STATUS_NOT_DEAL = "0"; //未成交
	public static final String ORDER_STATUS_DEAL = "1"; //已成交
	public static final String ORDER_STATUS_NOT_OVER = "2"; //未完结
	public static final String ORDER_STATUS_OVER = "3"; //已完结
	public static final String ORDER_STATUS_VERIFY = "5"; //废单审核/申请废单
	
	/**项目类别分类*/
	public static final String  PROJECT_TYPE_SORT_ONE= "0"; //解决方案
	public static final String  PROJECT_TYPE_SORT_TWO= "1"; //产品
	
	/**审核意见*/
	public static final String  ORDER_AGREE= "0"; //审核通过
	public static final String  ORDER_NOT_AGREE= "1"; //审核不通过
	
	/**学历*/
	public static final String  MIDDLESCHOOL= "0"; //初中
	public static final String  HIGHSCHOOL= "1"; //高中
	public static final String  JUNIOR_COLLEGE= "2"; //专科
	public static final String  UNDERGRADUATE= "3"; //本科
	public static final String  MASTER= "4"; //硕士
	public static final String  DOCTOR= "5"; //博士
	
	/**水平*/
	public static final String  LOW= "0"; //低
	public static final String  MIDDLE= "1"; //中
	public static final String  HIGH= "2"; //高
	
	/**订单信息类型*/
	public static final String  MESSAGE_BILL= "0"; //客户提单
	public static final String  MESSAGE_SEND= "1"; //订单派单
	public static final String  MESSAGE_ACCEPT= "2"; //经理接单
	public static final String  MESSAGE_REMIND= "3"; //到期提醒
	public static final String  MESSAGE_SYSTEM= "4"; //系统消息
	
	/**项目级别/订单跟进级别*/
	public static final String  PROJECT_IMPORTANT= "0"; //重要
	public static final String  PROJECT_MEDIUM= "1"; //中等
	public static final String  PROJECT_ORDINARY= "2"; //普通
	
	/**困难等级*/
	public static final String  PROJECT_DIFFICULT_VERYHARD= "0"; //非常困难
	public static final String  PROJECT_DIFFICULT_HARD= "1"; //困难
	public static final String  PROJECT_DIFFICULT_NORMAL= "2"; //正常
	public static final String  PROJECT_DIFFICULT_EASY= "3"; //简单
	
	/**项目情况*/
	public static final String  PROJECT_SITUATION_NORMAL= "0"; //正常
	public static final String  PROJECT_SITUATION_PAUSE= "1"; //暂停
	public static final String  PROJECT_SITUATION_EMERGENCY= "2"; //紧急
	public static final String  PROJECT_SITUATION_NUEMERGENCY= "3"; //不急
	
	/**工作年限*/
	public static final String  WORKING_YEARS_NO= "0"; //无经验
	public static final String  WORKING_YEARS_ONE= "1"; //一年~三年
	public static final String  WORKING_YEARS_THR= "2"; //三年~七年
	public static final String  WORKING_YEARS_SEVEN= "3"; //七年以上
	
	/**合同类型*/
	public static final String  CONTRACT_TYPE_COLLECT= "0"; //已收款
	public static final String  CONTRACT_TYPE_PENDING= "1"; //未收款
	public static final String  CONTRACT_TYPE_BILL= "2"; //已开票
	public static final String  CONTRACT_TYPE_NOT_BILL= "3"; //未开票
	
	/**客户价值*/
	public static final String  CUSTOMER_SIGNED= "0"; //已签约客户
	public static final String  CUSTOMER_POTENTIAL= "1"; //潜在客户
	
	/**订单跟进中的成交率*/
	public static final String  ORDERDETAIL_DEALRATE_0= "0"; 
	public static final String  ORDERDETAIL_DEALRATE_1= "1"; 
	public static final String  ORDERDETAIL_DEALRATE_2= "2"; 
	public static final String  ORDERDETAIL_DEALRATE_3= "3"; 
	public static final String  ORDERDETAIL_DEALRATE_4= "4"; 
	public static final String  ORDERDETAIL_DEALRATE_5= "5"; 
	public static final String  ORDERDETAIL_DEALRATE_6= "6"; 
	public static final String  ORDERDETAIL_DEALRATE_7= "7";
	public static final String  ORDERDETAIL_DEALRATE_8= "8";
	public static final String  ORDERDETAIL_DEALRATE_9= "9";
	public static final String  ORDERDETAIL_DEALRATE_10= "10";
}
