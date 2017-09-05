package com.modules.commons;

public class CommonReturn {
	
	public static final String MESSCAT = "讯猫软件有限公司";

	// 常量
	public static final String CONSTANT_STRING_GET = "get";
	public static final String CONSTANT_STRING_SET = "set";
	public static final String CONSTANT_STRING_CODE = "code";
	public static final String CONSTANT_STRING_MSG = "msg";
	public static final String CONSTANT_STRING_RESULT = "result";
	
	public static final String LOCAL_HOST="127.0.0.1";
	public static final String SERVER_HOST="192.168.0.110";
	
	// sign key
	public static final String SIGN_KEY = "jyu2017";
	
	//sha hash 加密遍历数
	public static final int HASH_ITERATIONS = 2017;
	
	public static final int PAGE_SIZE = 10;
	

	//公用返回码
	public static final int ERROR_CODE_ACTION_ERROR_100 = 100;				//系统繁忙，请稍候再试
	public static final int ERROR_CODE_INPUT_ERROR_101 = 101;				//输入参数错误
	public static final int ERROR_CODE_OUTPUT_ERROR_102 = 102;				//输出参数错误
	public static final int ERROR_CODE_INPUT_ERROR_103 = 103;				//输入参数存在空值
	public static final int ERROR_CODE_INPUT_ERROR_104 = 104;				//输入参数格式不对
	public static final int ERROR_CODE_STATUS_ERROR_105 = 105;				//停启用状态错误
	public static final int ERROR_CODE_IS_DEL_ERROR_106 = 106;				//删除状态错误
	public static final int ERROR_CODE_AUDITING_ERROR_107 = 107;			//审核状态错误
	public static final int ERROR_CODE_ORDER_BY_108=108;					//排序信息为空
	public static final int ERROR_CODE_NO_ICON_109=109;						//缩略图不能为空
	public static final int ERROR_CODE_NO_IMAGE_110=110;					//图片不能为空
	public static final int ERROR_CODE_NAME_111=111;						//名称已存在
	public static final int ERROR_CODE_NO_NAME_112=112;						//名称不能为空
	public static final int ERROR_CODE_NO_MONEY_113=113;					//金额不能为空
	public static final int ERROR_CODE_ERROR_MONEY_114=114;					//金额格式错误
	public static final int ERROR_CODE_LINKMAN_115=115;						//联系人不能为空
	public static final int ERROR_CODE_NO_MOBILE_116=116;					//联系电话不能为空
	public static final int ERROR_CODE_NO_ADDRESS_117=117;					//联系地址不能为空
	public static final int ERROR_CODE_NO_EMAIL_118=118;					//邮箱不能为空
	public static final int ERROR_CODE_NO_START_TIME_119=119;				//开始时间不能为空
	public static final int ERROR_CODE_NO_END_TIME_120=120;					//结束时间不能为空
	public static final int ERROR_CODE_ERROR_TIME_121=121;					//时间格式错误
	public static final int ERROR_CODE_EQ_TIME_122=122;						//开始时间不能大于结束时间
	
	public static final int SUCCESS_CODE_200 = 200;							//操作成功
	public static final int ERROR_CODE_CHECK_FORMAT_201 = 201;				//内部校验，审核错误,通用数据格式错误返回
	public static final int ERROR_CODE_CHECK_VALUE_202 = 202;				//内部校验，审核错误,通用数据值错误返回，如输入的密码不正确（一般是跟数据库有交接的[可返回前台的提示]）
	public static final int ERROR_CODE_CHECK_UNEXIST_203 = 203;				//内部校验，审核错误,如下单的时候用户名不存在，对象不存在
	public static final int ERROR_CODE_CHECK_EXIST_204 = 204;				//内部校验，审核错误,如添加账号的时候用户名已存在，对象存在
	public static final int ERROR_CODE_NO_ENOUGH_205 = 205;					//数量不足
	
	
	public static final int ERROR_CODE_FAIL_400 = 400;						//调用失败
	public static final int ERROR_CODE_RESULT_EMPTY_405 = 405;				//返回数据为空
	public static final int ERROR_CODE_EXCEPTION_500 = 500;					//操作异常
	public static final int ERROR_CODE_ONLINE_EXCEPTION_501 = 501;			//网络异常
	public static final int ERROR_CODE_SESSIONKEY_ERROR_505 = 505;			//SessionKey错误
	public static final int ERROR_CODE_TOKEN_ERROR_506 = 506;				//Token错误
	public static final int ERROR_CODE_SUBMIT_600 = 600;					//提交中...
	public static final int ERROR_CODE_SUBMITING_601 = 601;					//正在提交，请勿重复提交
	public static final int ERROR_CODE_ACTION_ING_602 = 602;				//正在操作，无需重复
	public static final int ERROR_CODE_ILLEGAL_700 = 700;					//非法操作
	
	
	/**
	 * 提示信息
	 */
	public final static String MSG_SUCCESS = "操作成功";
	public final static String MSG_FAIL = "操作失败";
	public final static String MSG_PARAM_MISS = "请输入完整的数据";
	public final static String MSG_FULL = "验证码获取已达上限";
	public final static String MSG_EXCEPTION = "操作异常";
	public final static String MSG_EXCEPTION_POPUP = "系统错误，请稍后再试";
	public final static String MSG_BUSH_POPUP="系统繁忙，请稍候再试";
	public final static String MSG_ONLINE_POPUP="网络异常";
	
	public final static String MSG_SESSIONKEY_POPUP="SessionKey错误";
	public final static String MSG_TOKEN_POPUP="Token错误";
	
	public final static String MSG_SUBMIT_POPUP="提交中...";
	public final static String MSG_SUNMIT_ING_POPUP="正在提交，请勿重复提交";
	public final static String MSG_ACTION_ING_POPUP="正在提交，请勿重复提交";
	public final static String MSG_ILLEGAL_POPUP="非法操作";
	
	public final static String MSG_STATUS_POPUP="停启用状态错误";
	public final static String MSG_IS_DEL_POPUP="删除状态错误";
	public final static String MSG_AUDITING_POPUP="审核状态错误";
	public static final String MSG_NO_ORDER_BY="排序信息为空";
	
	public static final String MSG_NO_ICON="缩略图不能为空";	
	public static final String MSG_NO_IMAGE="图片不能为空";
	
	public static final String MSG_NAME="名称已存在";
	public static final String MSG_NO_NAME="名称不能为空";
	
	public static final String MSG_NO_COMMENT="简介不能为空";

	public static final String MSG_NO_MONEY="金额不能为空";
	public static final String MSG_ERROR_MONEY="金额格式错误";
	
	public static final String MSG_LINKMAN="联系人不能为空";
	public static final String MSG_NO_MOBILE="联系电话不能为空";
	public static final String MSG_NO_ADDRESS="联系地址不能为空";
	public static final String MSG_NO_EMAIL="邮箱不能为空";
	
	public static final String MSG_NO_START_TIME="开始时间不能为空";
	public static final String MSG_NO_END_TIME="结束时间不能为空";
	public static final String MSG_ERROR_TIME="时间格式错误";
	public static final String MSG_EQ_TIME="开始时间不能大于结束时间";
	
	// 通用返回信息提示
	public static final String MSG_LOGIN_NO = "请先登录";
	public static final String MSG_LOGIN_SUCCESS = "登录成功";
	public static final String MSG_LOGIN_FAIL = "登录失败";
	public static final String MSG_REGISTER_SUCCESS = "注册成功";
	public static final String MSG_REGISTER_FAIL = "注册失败";
	
	public static final String MSG_EXECUTE_SUCCESS = "执行成功";
	public static final String MSG_FIND_SUCCESS = "查询成功";
	public static final String MSG_FIND_FAIL = "查询失败";
	public static final String MSG_ADD_SUCCESS = "添加成功";
	public static final String MSG_ADD_FAIL = "添加失败";
	public static final String MSG_UPDATE_SUCCESS = "修改成功";
	public static final String MSG_UPDATE_FAIL = "修改失败";
	public static final String MSG_DELETE_SUCCESS = "删除成功";
	public static final String MSG_DELETE_FAIL = "删除失败";
	public static final String MSG_DATA_EXCEPT = "数据异常";
	public static final String MSG_PARAMETER_EMPTY = "参数错误";
	public static final String MSG_INPUT_NOEMPTY = "输入不能为空";
	public static final String MSG_INPUT_FORMAT_ERROR = "输入格式不正确";
	public static final String MSG_BATCH_ERROR = "批量处理出现错误";
	public static final String MSG_RESULT_EMPTY = "数据为空";
	public static final String MSG_DATA_MISSING = "参数缺失";
	public static final String MSG_CUS_ERROR = "请先回收客户信息";
	
	public static final String MSG_OBJ_EXIST_ERROR = "对象已存在";
	public static final String MSG_OBJ_NOEXIST_ERROR = "对象不存在";
	

	// 数据库表
	public static final String MSG_NO_TABLE = "数据库表不存在";
	public static final String MSG_TABLE_NAME_EMPTY = "表名为空";
	public static final String MSG_TABLE_NAME_PLES = "请输入表名";
	public static final String MSG_SELECT_PAGER_ERROR = "当前页没有需要查询的数据!";
	
	public static final String MSG_USER_EXIST_ERROR = "用户已存在";
	public static final String MSG_USER_NOEXIST_ERROR = "用户不存在";
	public static final String MSG_LOGINNAME_EXIST_ERROR = "此用户名已存在";
	public static final String MSG_LOGINNAME_NOEXIST_ERROR = "此用户名不存在";
	public static final String MSG_LOGINNAME_FORMAT_ERROR = "用户名必须由6-20位的字母和数字组成";
	public static final String MSG_LOGINNAME_FIRST_ERROR = "用户名首位必须是字母";

	// 密码
	public static final String MSG_PASSWORD_ERROR = "密码错误";
	public static final String MSG_PASSWORD_FORMAT_ERROR = "密码必须由6-20位的字母，数字组成";
	public static final String MSG_PASSWORD_EXIST_SPECIAL_ERROR = "密码中不能存在特殊字符";
	public static final String MSG_LOGINNAME_PASSWORD_NULL_ERROR = "账号或密码不能为空";

	// 修改密码
	public static final String MSG_PASSWORD_UPDATE_SUCCESS = "修改密码成功";
	public static final String MSG_PASSWORD_UPDATE_FAIL = "修改密码失败";
	public static final String MSG_PASSWORD_UPDATE_OLD_ERROR = "旧密码输入错误";
	public static final String MSG_PASSWORD_UPDATE_SAMEPASSW_ERROR = "您设置的新密码和旧密码相同";
	

	
	/***************************************************** 会员系统（格式：100xxx）*****************************************************************/
	public static final int MB_CODE_MEMBER_10001=10001;									//用户已存在
	public static final int MB_CODE_MEMBER_NO_10002=10002;								//用户不存在
	public static final int MB_CODE_MEMBER_ACCOUNT_10003=10003;							//账号已存在
	public static final int MB_CODE_MEMBER_NO_ACCOUNT_10004=10004;						//账号不存在
	public static final int MB_CODE_MEMBER_EMPTY_ACCOUNT_10005=10005;					//账号为空
	public static final int MB_CODE_MEMBER_NO_PWD_10006=10006;							//密码不能为空
	public static final int MB_CODE_MEMBER_ERROR_PWD_10007=10007;						//密码错误
	public static final int MB_CODE_MEMBER_NO_OLD_PWD_10008=10008;						//原密码不能为空
	public static final int MB_CODE_MEMBER_NO_NEW_PWD_10009=10009;						//新密码不能为空
	public static final int MB_CODE_MEMBER_ERROR_OLD_TO_NEW_PWD_10010=10010;			//密码不一致
	public static final int MB_CODE_MEMBER_NO_EMAIL_10011=10011;						//邮箱
	public static final int MB_CODE_MEMBER_NO_MOBILE_10012=10012;						//手机不能为空
	
	public static final String MB_MSG_MEMBER="用户已存在";
	public static final String MB_MSG_MEMBER_NO="用户不存在";
	public static final String MB_MSG_MEMBER_ACCOUNT="账号已存在";
	public static final String MB_MSG_MEMBER_NO_ACCOUNT="账号不存在";
	public static final String MB_MSG_MEMBER_EMPTY_ACCOUNT="账号为空";
	public static final String MB_MSG_MEMBER_NO_PWD="密码不能为空";
	public static final String MB_MSG_MEMBER_ERROR_PWD="密码错误";
	public static final String MB_MSG_MEMBER_ERROR_MYPWD="原密码错误";
	public static final String MB_MSG_MEMBER_NO_OLD_PWD="原密码不能为空";
	public static final String MB_MSG_MEMBER_NO_NEW_PWD="新密码不能为空";
	public static final String MB_MSG_MEMBER_ERROR_OLD_TO_NEW_PWD="密码不一致";
	public static final String MB_MSG_MEMBER_NO_EMAIL="邮箱";
	public static final String MB_MSG_MEMBER_NO_MOBILE="手机不能为空";
	
	
	
	/***************************************************** 订单系统（格式：200xxx）*****************************************************************/
	public static final int MB_CODE_ORDER_20001=20001;									//订单已存在
	public static final int MB_CODE_ORDER_NO_20002=20002;								//订单不存在
	public static final int MB_CODE_ID_MISS_20003=20003;								//请求数据id为空
	public static final int MB_CODE_TOKEN_MISS_20004=20004;								//请求数据token为空
	public static final int MB_CODE_CHANNELDIRECTOR_MISS_20005=20005;					//渠道经理申请数据为空
	public static final int MB_CODE_PAGESIZE_PAGENO_MISS_20006=20006;					//请求数据pageSize或者pageNo为空
	public static final int MB_CODE_PAGESIZE_PAGENO_ERROR_20007=20007;					//请求数据pageSize或者pageNo错误
	public static final int MB_CODE_ORDER_MISS_20008=20008;								//订单申请存在数据缺失
	public static final int MB_CODE_ORDER_TYPE_MISS_20009=20009;						//订单类型数据缺失或者无效
	public static final int MB_CODE_ORDER_SAVE_ERROR_20010=20010;						//订单信息保存失败
	public static final int MB_CODE_CHANNELDIRECTOR_EXIST_20011=20011;					//渠道经理已申请
	
	public static final String MB_MSG_ORDER="订单已存在";
	public static final String MB_MSG_ORDER_NO="订单不存在";
	public static final String MB_CODE_ID_MISS="请求数据id为空";
	public static final String MB_CODE_TOKEN_MISS="请求数据token为空";
	public static final String MB_CODE_CHANNELDIRECTOR_MISS="渠道经理申请数据为空";
	public static final String MB_CODE_PAGESIZE_PAGENO_MISS="请求数据pageSize或者pageNo为空";
	public static final String MB_CODE_PAGESIZE_PAGENO_ERROR="请求数据pageSize或者pageNo错误";
	public static final String MB_CODE_ORDER_MISS="订单申请存在数据缺失";
	public static final String MB_CODE_ORDER_TYPE_MISS="订单类型数据缺失或者无效";
	public static final String MB_CODE_ORDER_SAVE_ERROR="订单信息保存失败";
	public static final String MB_CODE_CHANNELDIRECTOR_EXIST="您已经申请，谢谢！";
	
	/***************************************************** 消息财务（格式：300xxx）*****************************************************************/
	//暂时不整合
	
	/***************************************************** 供应商系统（格式：400xxx）*****************************************************************/
	
	//流程类型
	public static final int SP_CODE_PROCE_TYPE_40001=40001;								//流程类型已存在
	public static final int SP_CODE_PROCE_TYPE_NO_40002=40002;							//流程类型不存在
	public static final int SP_CODE_PROCE_MANDATORY_40005=40005;						//必选信息为空
	public static final int SP_CODE_PROCE_ERROR_MANDATORY_40006=40006;					//必选信息错误
	//msg
	public static final String SP_MSG_PROCE_TYPE="流程类型存在";
	public static final String SP_MSG_PROCE_TYPE_NO="流程类型不存在";
	public static final String SP_MSG_PROCE_MANDATORY="必选信息为空";
	public static final String SP_MSG_PROCE_ERROR_MANDATORY="必选信息错误";
	
	
	
	//产品分类
	public static final int SP_CODE_PRODUCT_TYPE_40101=40101;							//产品分类已存在
	public static final int SP_CODE_PRODUCT_TYPE_NO_40102=40102;						//产品分类不存在
	//msg
	public static final String SP_MSG_PRODUCT_TYPE="产品分类已存在";
	public static final String SP_MSG_PRODUCT_TYPE_NO="产品分类不存在";
	
	
	
	//产品信息
	public static final int SP_CODE_PRODUCT_40201=40201;								//产品已存在
	public static final int SP_CODE_PRODUCT_NO_40202=40202;								//产品不存在
	public static final int SP_CODE_PRODUCT_NO_INDUSTRY_40203=40203;					//行业类别不能为空
	public static final int SP_CODE_PRODUCT_NO_KEYWORDS_40204=40204;					//产品标签不能为空
	public static final int SP_CODE_PRODUCT_NO_DURATION_40204=40204;					//产品周期不能为空
	public static final int SP_CODE_PRODUCT_NO_MONEY_40205=40205;						//产品报价不能为空
	public static final int SP_CODE_PRODUCT_NO_CUSTOMER_40206=40206;					//实施客户不能为空
	public static final int SP_CODE_PRODUCT_NO_REFUSED_REMARK_40207=40207;				//拒绝理由不能为空
	public static final int SP_CODE_PRODUCT_NO_PRODUCT_URL_40208=40208;					//演示地址不能为空
	public static final int SP_CODE_PRODUCT_NO_HAS_PRODUCT_URL_40209=40209;				//演示状态不能为空
	public static final int SP_CODE_PRODUCT_ERROR_HAS_PRODUCT_URL_40210=40210;			//演示状态错误
	//msg
	public static final String SP_MSG_PRODUCT="产品已存在";
	public static final String SP_MSG_PRODUCT_NO="产品不存在";	
	public static final String SP_MSG_PRODUCT_NO_INDUSTRY="行业类别不能为空";
	public static final String SP_MSG_PRODUCT_NO_KEYWORDS="产品标签不能为空";
	public static final String SP_MSG_PRODUCT_NO_DURATION="产品周期不能为空";
	public static final String SP_MSG_PRODUCT_NO_MONEY="产品报价不能为空";
	public static final String SP_MSG_PRODUCT_NO_CUSTOMER="实施客户不能为空";
	public static final String SP_MSG_PRODUCT_NO_REFUSED_REMARK="拒绝理由不能为空";
	public static final String SP_MSG_PRODUCT_NO_PRODUCT_URL="演示地址不能为空";
	public static final String SP_MSG_PRODUCT_NO_HAS_PRODUCT_URL="演示状态不能为空";
	public static final String SP_MSG_PRODUCT_ERROR_HAS_PRODUCT_URL="演示状态错误";
	
	
	
	//产品分类
	public static final int SP_CODE_PROJECT_ATTCH_40301=40301;							//项目附件已存在
	public static final int SP_CODE_PROJECT_ATTCH_NO_40302=40302;						//项目附件不存在
	public static final int SP_CODE_PROJECT_ATTCH_NO_TITLE_40303=40303;					//项目附件标题不能为空
	public static final int SP_CODE_PROJECT_ATTCH_NO_SAVE_PATH_40304=40304;				//项目附件路径不能为空
	//msg
	public static final String SP_MSG_PROJECT_ATTCH="项目附件已存在";
	public static final String SP_MSG_PROJECT_ATTCH_NO="项目附件不存在";
	public static final String SP_MSG_PROJECT_ATTCH_NO_TITLE="项目附件标题不能为空";	
	public static final String SP_MSG_PROJECT_ATTCH_NO_SAVE_PATH="项目附件路径不能为空";	
	
	
	//项目信息
	public static final int SP_CODE_PROJECT_40401=40401;								//项目已存在
	public static final int SP_CODE_PROJECT_NO_40402=40402;								//项目不存在
	public static final int SP_CODE_PROJECT_NO_LEADER_40403=40403;						//项目负责人不存在
	public static final int SP_CODE_PROJECT_PROJECT_NUM_40404=40404;					//项目编号已存在
	public static final int SP_CODE_PROJECT_NO_PROJECT_NUM_40405=40405;					//项目编号不能为空
	public static final int SP_CODE_PROJECT_NO_DIFFICULTY_LEVEL_40406=40406;			//难度等级不能为空
	public static final int SP_CODE_PROJECT_ERROR_DIFFICULTY_LEVEL_40407=40407;			//难度等级错误
	public static final int SP_CODE_PROJECT_NO_IMPORTANT_40408=40408;					//重要程度不能为空
	public static final int SP_CODE_PROJECT_ERROR_IMPORTANT_40409=40409;				//重要程度错误
	public static final int SP_CODE_PROJECT_NO_AMOUNT_40410=40410;						//项目金额不能为空
	public static final int SP_CODE_PROJECT_NO_INPUT_AMOUNT_40411=40411;				//已付金额不能为空
	public static final int SP_CODE_PROJECT_NO_START_TIME_40412=40412;					//项目启动时间不能为空
	public static final int SP_CODE_PROJECT_NO_END_TIME_40413=40413;					//项目结束时间不能为空
	public static final int SP_CODE_PROJECT_NO_SCHEDULE_40414=40414;					//项目进度不能为空
	public static final int SP_CODE_PROJECT_ERROR_SCHEDULE_40415=40415;					//项目进度错误
	public static final int SP_CODE_PROJECT_NO_PROJECT_PLAN_40416=40417;				//项目方案不能为空
	public static final int SP_CODE_PROJECT_NO_EMERGENCY_40418=40418;					//项目紧急情况不能为空
	public static final int SP_CODE_PROJECT_ERROR_EMERGENCY_40419=40419;				//项目紧急情况错误
	public static final int SP_CODE_PROJECT_NO_VER_REPOSITORY_40420=40420;				//版本库类型不能为空
	public static final int SP_CODE_PROJECT_ERROR_VER_REPOSITORY_40421=40421;			//版本库类型不能为空
	public static final int SP_CODE_PROJECT_NO_VER_URL_40422=40422;						//版本库地址不能为空
	public static final int SP_CODE_PROJECT_NO_PLAN_FINISH_TIME_40423=40423;			//计划完成时间不能为空
	public static final int SP_CODE_PROJECT_NO_ALLOT_STATUS_40424=40424;				//分配状态
	public static final int SP_CODE_PROJECT_ERROR_ALLOT_STATUS_40425=40425;				//分配状态错误
	public static final int SP_CODE_PROJECT_NO_CUSTOMER_NAME_40426=40426;				//客户名称不能为空
	public static final int SP_CODE_PROJECT_NO_CUSTOMER_MANAGER_NAME_40427=40427;		//业务负责人名称不能为空
	public static final int SP_CODE_PROJECT_NO_NAME_40428=40428;						//项目名称
	public static final int SP_CODE_PROJECT_NO_STATUS_40429=40429;						//项目状态不能为空
	public static final int SP_CODE_PROJECT_ERROR_STATUS_40430=40430;					//项目状态错误
	//msg
	public static final String SP_MSG_PROJECT="项目已存在";
	public static final String SP_MSG_PROJECT_NO="项目不存在";
	public static final String SP_MSG_PROJECT_NO_LEADER="项目负责人不存在";
	public static final String SP_MSG_PROJECT_PROJECT_NUM="项目编号已存在";
	public static final String SP_MSG_PROJECT_NO_PROJECT_NUM="项目编号不能为空";
	public static final String SP_MSG_PROJECT_NO_DIFFICULTY_LEVEL="难度等级不能为空";
	public static final String SP_MSG_PROJECT_ERROR_DIFFICULTY_LEVEL="难度等级错误";
	public static final String SP_MSG_PROJECT_NO_IMPORTANT="重要程度不能为空";
	public static final String SP_MSG_PROJECT_ERROR_IMPORTANT="重要程度错误";
	public static final String SP_MSG_PROJECT_NO_AMOUNT="项目金额不能为空";
	public static final String SP_MSG_PROJECT_NO_INPUT_AMOUNT="已付金额不能为空";
	public static final String SP_MSG_PROJECT_NO_START_TIME="项目启动时间不能为空";
	public static final String SP_MSG_PROJECT_NO_END_TIME="项目结束时间不能为空";
	public static final String SP_MSG_PROJECT_NO_SCHEDULE="项目进度不能为空";
	public static final String SP_MSG_PROJECT_ERROR_SCHEDULE="项目进度错误";
	public static final String SP_MSG_PROJECT_NO_PROJECT_PLAN="项目方案不能为空";
	public static final String SP_MSG_PROJECT_NO_EMERGENCY="项目紧急情况不能为空";	
	public static final String SP_MSG_PROJECT_ERROR_EMERGENCY="项目紧急情况错误";
	public static final String SP_MSG_PROJECT_NO_VER_REPOSITORY="版本库类型不能为空";
	public static final String SP_MSG_PROJECT_ERROR_VER_REPOSITORY="版本库类型不能为空";
	public static final String SP_MSG_PROJECT_NO_VER_URL="版本库地址不能为空";	
	public static final String SP_MSG_PROJECT_NO_PLAN_FINISH_TIME="计划完成时间不能为空";
	public static final String SP_MSG_PROJECT_NO_ALLOT_STATUS="分配状态";	
	public static final String SP_MSG_PROJECT_ERROR_ALLOT_STATUS="分配状态错误";
	public static final String SP_MSG_PROJECT_NO_CUSTOMER_NAME="客户名称不能为空";
	public static final String SP_MSG_PROJECT_NO_CUSTOMER_MANAGER_NAME="业务负责人名称不能为空";
	public static final String SP_MSG_PROJECT_NO_NAME="项目名称";
	public static final String SP_MSG_PROJECT_NO_STATUS="项目状态不能为空";
	public static final String SP_MSG_PROJECT_ERROR_STATUS="项目状态错误";
	
	
	//供应商信息
	public static final int SP_CODE_SUPPLIER_40501=40501;								//供应商已存在
	public static final int SP_CODE_SUPPLIER_NO_40502=40502;							//供应商不存在
	public static final int SP_CODE_SUPPLIER_NO_NAME_40503=40503;						//供应商名称不能为空
	public static final int SP_CODE_SUPPLIER_NO_LEGAL_40504=40504;						//法人代表不能为空
	public static final int SP_CODE_SUPPLIER_NO_REGISTERED_CAPITAL_40505=40505;			//注册资金不能为空
	public static final int SP_CODE_SUPPLIER_BUSINESS_LICENSE_NO_40506=40506;			//营业执照号码已存在
	public static final int SP_CODE_SUPPLIER_NO_BUSINESS_LICENSE_NO_40507=40507;		//营业执照号码不能为空
	public static final int SP_CODE_SUPPLIER_NO_BUSINESS_LICENSE_IMG_40508=40508;		//营业执照副本图片不能为空
	public static final int SP_CODE_SUPPLIER_NO_BUSINESS_START_DATE_40509=40509;		//营业执照开始时间不能为空
	public static final int SP_CODE_SUPPLIER_NO_BUSINESS_END_DATE_40510=40510;			//营业执照结束时间不能为空
	public static final int SP_CODE_SUPPLIER_NO_BUSINESS_MAIN_40511=40511;				//主营业务不能为空
	public static final int SP_CODE_SUPPLIER_NO_LOGO_40512=40512;						//LOGO不能为空
	public static final int SP_CODE_SUPPLIER_NO_IS_LISTED_40513=40513;					//是否上市不能为空
	public static final int SP_CODE_SUPPLIER_NO_INVOICE_TYPE_40514=40514;				//发票类型不能为空
	public static final int SP_CODE_SUPPLIER_ERROR_INVOICE_TYPE_40515=40515;			//发票类型错误
	public static final int SP_CODE_SUPPLIER_NO_ENTERPRISE_NATURE_40516=40516;			//企业性质
	public static final int SP_CODE_SUPPLIER_ERROR_ENTERPRISE_NATURE_40517=40517;		//企业性质错误
	public static final int SP_CODE_SUPPLIER_NO_BANK_NAME_40518=40518;					//开户银行名称不能为空
	public static final int SP_CODE_SUPPLIER_NO_BANK_USER_NAME_40519=40519;				//开户人不能为空
	public static final int SP_CODE_SUPPLIER_NO_BANK_CARD_NO_40520=40520;				//开户账号不能为空
	public static final int SP_CODE_SUPPLIER_ERROR_BANK_CARD_NO_40521=40521;			//开户账号错误
	public static final int SP_CODE_SUPPLIER_NO_BANK_BRANCH_NAME_40522=40522;			//开户支行不能为空
	//msg
	public static final String SP_MSG_SUPPLIER="供应商已存在";
	public static final String SP_MSG_SUPPLIER_NO="供应商不存在";
	public static final String SP_MSG_SUPPLIER_NO_NAME="供应商名称不能为空";
	public static final String SP_MSG_SUPPLIER_NO_LEGAL="法人代表不能为空";
	public static final String SP_MSG_SUPPLIER_NO_REGISTERED_CAPITAL="注册资金不能为空";
	public static final String SP_MSG_SUPPLIER_BUSINESS_LICENSE_NO="营业执照号码已存在";
	public static final String SP_MSG_SUPPLIER_NO_BUSINESS_LICENSE_NO="营业执照号码不能为空";
	public static final String SP_MSG_SUPPLIER_NO_BUSINESS_LICENSE_IMG="营业执照副本图片不能为空";
	public static final String SP_MSG_SUPPLIER_NO_BUSINESS_START_DATE="营业执照开始时间不能为空";	
	public static final String SP_MSG_SUPPLIER_NO_BUSINESS_END_DATE="营业执照结束时间不能为空";
	public static final String SP_MSG_SUPPLIER_NO_BUSINESS_MAIN="主营业务不能为空";
	public static final String SP_MSG_SUPPLIER_NO_LOGO="LOGO不能为空";
	public static final String SP_MSG_SUPPLIER_NO_IS_LISTED="是否上市不能为空";
	public static final String SP_MSG_SUPPLIER_NO_INVOICE_TYPE="发票类型不能为空";
	public static final String SP_MSG_SUPPLIER_ERROR_INVOICE_TYPE="发票类型错误";
	public static final String SP_MSG_SUPPLIER_NO_ENTERPRISE_NATURE="企业性质";
	public static final String SP_MSG_SUPPLIER_ERROR_ENTERPRISE_NATURE="企业性质错误";
	public static final String SP_MSG_SUPPLIER_NO_BANK_NAME="开户银行名称不能为空";
	public static final String SP_MSG_SUPPLIER_NO_BANK_USER_NAME="开户人不能为空";
	public static final String SP_MSG_SUPPLIER_NO_BANK_CARD_NO="开户账号不能为空";
	public static final String SP_MSG_SUPPLIER_ERROR_BANK_CARD_NO="开户账号错误";
	public static final String SP_MSG_SUPPLIER_NO_BANK_BRANCH_NAME="开户支行不能为空";
	
	
	//供应商等级
	public static final int SP_CODE_SUPPLIER_LEVEL_40601=40601;							//供应商等级已存在
	public static final int SP_CODE_SUPPLIER_LEVEL_NO_40602=40602;						//供应商等级不存在
	//msg
	public static final String SP_MSG_SUPPLIER_LEVEL="供应商等级已存在";
	public static final String SP_MSG_SUPPLIER_LEVEL_NO="供应商等级不存在";
	
	
	//供应商资质
	public static final int SP_CODE_SUPPLIER_QUALI_40701=40701;							//供应商资质已存在
	public static final int SP_CODE_SUPPLIER_QUALI_NO_40702=40702;						//供应商资质不存在
	public static final int SP_CODE_SUPPLIER_QUALI_NO_ISSUING_40702=40702;				//资质颁发机构不能为空
	//msg
	public static final String SP_MSG_SUPPLIER_QUALI="供应商资质已存在";
	public static final String SP_MSG_SUPPLIER_QUALI_NO="供应商资质不存在";
	public static final String SP_MSG_SUPPLIER_QUALI_NO_ISSUING="资质颁发机构不能为空";
	
	
	//供应商类型
	public static final int SP_CODE_SUPPLIER_TYPR_40801=40801;							//供应商类型已存在
	public static final int SP_CODE_SUPPLIER_TYPR_NO_40802=40802;						//供应商类型不存在
	//msg
	public static final String SP_MSG_SUPPLIER_TYPR="供应商类型已存在";
	public static final String SP_MSG_SUPPLIER_TYPR_NO="供应商类型不存在";
	
	
	//项目流程
	public static final int SP_CODE_PROCEDURE_40901=40901;								//项目流程已存在
	public static final int SP_CODE_PROCEDURE_NO_40902=40902;							//项目流程不存在
	//msg
	public static final String SP_MSG_PROCEDURE="项目流程已存在";
	public static final String SP_MSG_PROCEDURE_NO="项目流程不存在";
	
	
	//项目流程备注
	public static final int SP_CODE_PROJECT_REMARK_41001=41001;							//项目流程备注已存在
	public static final int SP_CODE_PROJECT_REMARK_NO_41002=41002;						//项目流程备注不存在
	public static final int SP_CODE_PROJECT_REMARK_NO_RECORD_41003=41003;				//记录着不存在
	public static final int SP_CODE_PROJECT_REMARK_NO_PARTICIPATE_41004=41004;			//参与者不存在
	public static final int SP_CODE_PROJECT_REMARK_NO_AUDI_41005=41005;					//流程进度还未审核
	public static final int SP_CODE_PROJECT_REMARK_AUDI_41006=41006;					//流程进度已经审核过了
	public static final int SP_CODE_PROJECT_REMARK_ERROR_AUDI_41007=41007;				//流程进度已经审核过了
	//msg
	public static final String SP_MSG_PROJECT_REMARK="项目流程备注已存在";
	public static final String SP_MSG_PROJECT_REMARK_NO="项目流程备注不存在";	
	public static final String SP_MSG_PROJECT_REMARK_NO_RECORD="记录着不存在";
	public static final String SP_MSG_PROJECT_REMARK_NO_PARTICIPATE="参与者不存在";
	public static final String SP_MSG_PROJECT_REMARK_NO_AUDI="流程进度还未审核";
	public static final String SP_MSG_PROJECT_REMARK_AUDI="流程进度已经审核过了";
	public static final String SP_MSG_PROJECT_REMARK_ERROR_AUDI="审核状态错误";
	
	
	//团队成员信息
	public static final int SP_CODE_WORKER_NO_EDUCATION_41101=41101;					//学历不能为空
	public static final int SP_CODE_WORKER_NO_POSITION_41102=41102;						//职位不能为空
	public static final int SP_CODE_WORKER_NO_SCHOOL_41103=41103;						//毕业院校不能为空
	public static final int SP_CODE_WORKER_NO_EXPERIENCE_41104=41104;					//项目经验不能为空
	public static final int SP_CODE_WORKER_NO_SKILL_41105=41105;						//技术技能不能为空
	public static final int SP_CODE_WORKER_NO_WORK_YEAR_41106=41106;					//工作年限不能为空
	public static final int SP_CODE_WORKER_ERROR_WORK_YEAR_41107=41107;					//工作年限错误
	public static final int SP_CODE_WORKER_IS_HEAD_41108=41108;							//该供应商已经存在负责人
	public static final int SP_CODE_WORKER_NO_IS_HEAD_41109=41109;						//是否是负责人不能为空
	public static final int SP_CODE_WORKER_ERROR_IS_HEAD_41110=41110;					//是否是负责人状态错误
	//msg
	public static final String SP_MSG_WORKER_NO_EDUCATION="学历不能为空";
	public static final String SP_MSG_WORKER_NO_POSITION="职位不能为空";
	public static final String SP_MSG_WORKER_NO_SCHOOL="毕业院校不能为空";
	public static final String SP_MSG_WORKER_NO_EXPERIENCE="项目经验不能为空";
	public static final String SP_MSG_WORKER_NO_SKILL="技术技能不能为空";
	public static final String SP_MSG_WORKER_NO_WORK_YEAR="工作年限不能为空";
	public static final String SP_MSG_WORKER_ERROR_WORK_YEAR="工作年限错误";
	public static final String SP_MSG_WORKER_IS_HEAD="该供应商已经存在负责人";
	public static final String SP_MSG_WORKER_NO_IS_HEAD="是否是负责人不能为空";
	public static final String SP_MSG_WORKER_ERROR_IS_HEAD="是否是负责人状态错误";
	
	
	//项目反馈信息
	public static final int SP_CODE_PROJECT_MANAGER_41201=41201;						//项目反馈信息已存在
	public static final int SP_CODE_PROJECT_MANAGER_NO_41202=41202;						//项目反馈信息不能为空
	public static final int SP_CODE_PROJECT_MANAGER_NO_TITLE_41203=41203;				//标题不能为空
	//msg
	public static final String SP_MSG_PROJECT_MANAGER="项目反馈信息已存在";
	public static final String SP_MSG_PROJECT_MANAGER_NO="项目反馈信息不能为空";
	public static final String SP_MSG_PROJECT_MANAGER_NO_TITLE="标题不能为空";
		
	
	//项目成员信息
	public static final int SP_CODE_PROJECT_WORKER_41301=41301;							//项目成员已存在
	public static final int SP_CODE_PROJECT_WORKER_NO_41302=41302;						//项目成员不能为空
	//msg
	public static final String SP_MSG_PROJECT_WORKER="项目成员已存在";
	public static final String SP_MSG_PROJECT_WORKER_NO="项目成员不能为空";
	
	
	//供应商客户信息
	public static final int SP_CODE_SUPPLIER_CUSTOMER_41401=41401;						//供应商客户已存在
	public static final int SP_CODE_SUPPLIER_CUSTOMER_NO_41402=41402;					//供应商客户不能为空
	//msg
	public static final String SP_MSG_SUPPLIER_CUSTOMER="供应商客户已存在";
	public static final String SP_MSG_SUPPLIER_CUSTOMER_NO="供应商客户不能为空";
	
	
	//供应商联系人信息
	public static final int SP_CODE_SUPPLIER_LINKMAN_41501=41101;						//供应商联系人已存在
	public static final int SP_CODE_SUPPLIER_LINKMAN_NO_41502=41502;					//供应商联系人不能为空
	//msg
	public static final String SP_MSG_SUPPLIER_LINKMAN="供应商联系人已存在";
	public static final String SP_MSG_SUPPLIER_LINKMAN_NO="供应商联系人不能为空";
	
	
	//供应商资质信息
	public static final int SP_CODE_SUPPLIER_QUA_41601=41601;							//供应商资质信息已存在
	public static final int SP_CODE_SUPPLIER_QUA_NO_41602=41602;						//供应商资质信息不能为空
	public static final int SP_CODE_SUPPLIER_QUA_NO_ISSUING_41603=41603;				//机构不能为空
	//msg
	public static final String SP_MSG_SUPPLIER_QUA="供应商资质信息已存在";
	public static final String SP_MSG_SUPPLIER_QUA_NO="供应商资质信息不能为空";
	public static final String SP_MSG_SUPPLIER_QUA_NO_ISSUING="机构不能为空";
	
	
	/*****************************************************渠道财务系统（格式：500xxx）*****************************************************************/
	//暂时不整合
	
	/*****************************************************积分系统系统（格式：600xxx）*****************************************************************/
	public static final int INT_CODE_INTER_60001=60001;								//积分用户存在
	public static final int INT_CODE_NO_INTER_60002=60002;							//积分用户不存在
	public static final int INT_CODE_GOODS_60003=60003;								//商品已存在
	public static final int INT_CODE_NO_GOODS_60004=60004;							//商品不存在
	public static final int INT_CODE_ATTR_60005=60005;								//商品属性已存在
	public static final int INT_CODE_NO_ATTR_60006=60006;							//商品属性不存在
	public static final int INT_CODE_TYPE_60007=60007;								//商品类型已存在
	public static final int INT_CODE_NO_TYPE_60008=60008;							//商品类型不存在
	public static final int INT_CODE_ADDRESS_60009=60009;							//收货地址存在
	public static final int INT_CODE_NO_ADDRESS_60010=60010;						//收货地址不存在
	public static final int INT_CODE_RECORD_60011=60011;							//兑换记录存在
	public static final int INT_CODE_NO_RECORD_60012=60012;							//兑换记录不存在
	public static final int INT_CODE_ORDER_60013=60013;								//兑换订单存在
	public static final int INT_CODE_NO_ORDER_60014=60014;							//兑换订单不存在
	public static final int INT_CODE_PROVIDE_60015=60015;							//发放记录存在
	public static final int INT_CODE_NO_PROVIDE_60016=60016;						//发放记录不存在
	
	public static final int INT_CODE_EXCAHNGE_SUCCESS_61000=61000;					//兑换成功
	public static final int INT_CODE_EXCAHNGE_FAIL_61001=61001;						//兑换失败
	public static final int INT_CODE_EXCAHNGE_ING_61002=61002;						//兑换中
	public static final int INT_CODE_PAY_SUCCESS_61003=61003;						//支付成功
	public static final int INT_CODE_PAY_FAIL_61004=61004;							//支付失败
	public static final int INT_CODE_PAY_ING_61005=61005;							//支付中
	public static final int INT_CODE_INPUT_NUM_61006=61006;							//请输入兑换数量
	public static final int INT_CODE_INPUT_NUM_ERROR_61007=61007;					//兑换数量不正确
	public static final int INT_CODE_STOCK_ENOUGH_61008=61008;						//库存充足，请放心兑换
	public static final int INT_CODE_STOCK_NO_ENOUGH_61009=61009;					//库存不足
	public static final int INT_CODE_POINTS_NO_ENOUGH_61010=61010;					//积分不足
	public static final int INT_CODE_BALACE_NO_ENOUGH_61011=61011;					//余额不足
	public static final int INT_CODE_SELECT_EXCAHNGE_WAY_61012=61012;				//请选择兑换方式
	public static final int INT_CODE_EXCAHNGE_WAY_61013=61013;						//兑换方式有误
	public static final int INT_CODE_SELECT_EXCAHNGE_PAY_WAY_61014=61014;			//请选择支付方式
	public static final int INT_CODE_NO_DEAL_ORDER_61015=61015;						//订单待处理
	public static final int INT_CODE_DEAL_ORDER_ING_61016=61016;					//订单处理中
	public static final int INT_CODE_DEAL_ORDER_SUCCESS_61017=61017;				//订单处理成功
	
	
	//MSG
	public static final String INT_MSG_INTER="积分用户存在";
	public static final String INT_MSG_NO_INTER="积分用户不存在";
	public static final String INT_MSG_GOODS="商品已存在";	
	public static final String INT_MSG_NO_GOODS="商品不存在";
	public static final String INT_MSG_ATTR="商品属性已存在";
	public static final String INT_MSG_NO_ATTR="商品属性不存在";
	public static final String INT_MSG_TYPE="商品类型已存在";
	public static final String INT_MSG_NO_TYPE="商品类型不存在";
	public static final String INT_MSG_ADDRESS="收货地址存在";
	public static final String INT_MSG_NO_ADDRESS="收货地址不存在";
	public static final String INT_MSG_RECORD="兑换记录存在";
	public static final String INT_MSG_NO_RECORD="兑换记录不存在";
	public static final String INT_MSG_ORDER="兑换订单存在";
	public static final String INT_MSG_NO_ORDER="兑换订单不存在";
	public static final String INT_MSG_PROVIDE="发放记录存在";
	public static final String INT_MSG_NO_PROVIDE="发放记录不存在";
	
	public static final String INT_MSG_EXCAHNGE_SUCCESS="兑换成功";
	public static final String INT_MSG_EXCAHNGE_FAIL="兑换失败";
	public static final String INT_MSG_EXCAHNGE_ING="兑换中";
	public static final String INT_MSG_PAY_SUCCESS="支付成功";
	public static final String INT_MSG_PAY_FAIL="支付失败";
	public static final String INT_MSG_PAY_ING="支付中";
	public static final String INT_MSG_INPUT_NUM="请输入兑换数量";
	public static final String INT_MSG_INPUT_NUM_ERROR="兑换数量不正确";
	public static final String INT_MSG_STOCK_ENOUGH="库存充足，请放心兑换";	
	public static final String INT_MSG_STOCK_NO_ENOUGH="库存不足";	
	public static final String INT_MSG_POINTS_NO_ENOUGH="积分不足";
	public static final String INT_MSG_BALACE_NO_ENOUGH="余额不足";	
	public static final String INT_MSG_SELECT_EXCAHNGE_WAY="请选择兑换方式";
	public static final String INT_MSG_EXCAHNGE_WAY="兑换方式有误";
	public static final String INT_MSG_SELECT_EXCAHNGE_PAY_WAY="请选择支付方式";
	public static final String INT_MSG_NO_DEAL_ORDER="订单待处理";
	public static final String INT_MSG_DEAL_ORDER_ING="订单处理中";
	public static final String INT_MSG_DEAL_ORDER_SUCCESS="订单处理成功";
	
	
	
	/*****************************************************日志（格式：700xxx）*****************************************************************/
	//暂时不整合
	

	

	//字体验证
	public static final String FONT_COLOR="#173177";
	
	//顶部颜色
	public static final String TOP_COLOR="#CCCCCC";
	
	
	/** RedisKey前缀*/
	public static final String PREFIX_COLUMN="column";
	
	public static final String PREFIX_AD="ad";
	
	public static final String PREFIX_USER="user";
	
	public static final String PREFIX_ADMIN="admin";
	
	public static final String PREFIX_ORDER="order";
	
	public static final String PREFIX_PROJIECT="project";
	
	public static final String PREFIX_ORDER_TYPE="order_type";
	
	
	/**手机验证码的session*/
	public static final String CHECK_CODE_MOBILE = "checkCodeMobile";   
	
	
	/**
	 * 异常和提示页面跳转
	 */
	public static final String TRIPS = "finance/trips";
	
	public static final String EXCEPTION = "finance/exception";

}
