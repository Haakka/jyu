package com.modules.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.hash.Sha256Hash; 

/**
 * 使用SHA256算法生成相应的散列数据
 * @author Stephen
 * 
 */
public class Sha256 {

	/**
	 * 对数据进行sha256hash加密
	 * @param source
	 * @param salt
	 * @param hashIterations
	 * @return
	 */
	public static String getSha256Hash(Object source, Object salt, int hashIterations){
		return new Sha256Hash(source, salt, hashIterations).toString();
	}
	
	
	
	/**
	 * 对sha256hash加密数据校检是否一致
	 * @param source
	 * @param salt
	 * @param hashIterations
	 * @return
	 */
	public static Boolean checkSha256Hash(Object source, Object salt, int hashIterations,String oldEncrypt){
		String encrypt = getSha256Hash(source, salt, hashIterations);
		if(StringUtil.isNotBlank(oldEncrypt) && StringUtil.isNotBlank(encrypt) && oldEncrypt.equals(encrypt)){
			return true;
		}
		return false;
	}
	
	   /** 
	   * 传入文本内容，返回 SHA-256 串 
	   *  
	   * @param strText 
	   * @return 
	   */  
	  public static String SHA256(final String strText)  
	  {  
	    return SHA(strText, "SHA-256");  
	  }  
	  
	  
	  /** 
	   * 传入文本内容，返回 SHA-512 串 
	   *  
	   * @param strText 
	   * @return 
	   */  
	  public static String SHA512(final String strText)  
	  {  
	    return SHA(strText, "SHA-512");  
	  }  
	  
	  /** 
	   * 字符串 SHA 加密 
	   *  
	   * @param strSourceText 
	   * @return 
	   */  
	  private static String SHA(final String strText, final String strType)  
	  {  
	    // 返回值  
	    String strResult = null;  
	  
	    // 是否是有效字符串  
	    if (strText != null && strText.length() > 0)  
	    {  
	      try  
	      {  
	        // SHA 加密开始  
	        // 创建加密对象 并傳入加密類型  
	        MessageDigest messageDigest = MessageDigest.getInstance(strType);  
	        // 传入要加密的字符串  
	        messageDigest.update(strText.getBytes());  
	        // 得到 byte 類型结果  
	        byte byteBuffer[] = messageDigest.digest();  
	  
	        // 將 byte 轉換爲 string  
	        StringBuffer strHexString = new StringBuffer();  
	        // 遍歷 byte buffer  
	        for (int i = 0; i < byteBuffer.length; i++)  
	        {  
	          String hex = Integer.toHexString(0xff & byteBuffer[i]);  
	          if (hex.length() == 1)  
	          {  
	            strHexString.append('0');  
	          }  
	          strHexString.append(hex);  
	        }  
	        // 得到返回結果  
	        strResult = strHexString.toString();  
	      }  
	      catch (NoSuchAlgorithmException e)  
	      {  
	        e.printStackTrace();  
	      }  
	    }  
	  
	    return strResult;  
	  }  
	 
}
