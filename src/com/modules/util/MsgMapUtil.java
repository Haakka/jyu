package com.modules.util;

import java.util.HashMap;
import java.util.Map;

import com.modules.commons.CommonReturn;

public class MsgMapUtil {

	public static Map<String, Object> buildResultMap(int code,String msg,Object result){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(CommonReturn.CONSTANT_STRING_CODE, code);
		resultMap.put(CommonReturn.CONSTANT_STRING_MSG, msg);
		resultMap.put(CommonReturn.CONSTANT_STRING_RESULT, result);
		return resultMap;
		
	}
}
