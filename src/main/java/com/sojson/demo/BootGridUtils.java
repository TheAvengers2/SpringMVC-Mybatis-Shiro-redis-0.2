package com.sojson.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import com.sojson.common.utils.LoggerUtils;
import com.sojson.common.utils.StringUtils;
import com.sojson.demo.domain.BootGridPageObject;


public class BootGridUtils {
	
	public static final String DEFUALT_CHARSET = "UTF-8";

	/**
	 * Decode url with specify charset.
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String decodeUrl(String param, String charset){
		if (StringUtils.isBlank(charset)) {
			return decodeUrl(param);
		}
		String res = "";
		try {
			res = URLDecoder.decode(param, charset);
		} catch (UnsupportedEncodingException e) {
			LoggerUtils.error(BootGridUtils.class, String.format("Please check if you charset:%s is valid.", charset));
		}
		return res;
	}
	
	/**
	 * decode url with charset UTF-8.
	 * @param param
	 * @return
	 */
	public static String decodeUrl(String param){
		return decodeUrl(param,DEFUALT_CHARSET);
	}
	
	/**
	 * encode url with specify charset.
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String encodeUrl(String param, String charset){
		if (StringUtils.isBlank(charset)) {
			return encodeUrl(param);
		}
		String res = "";
		try {
			res = URLEncoder.encode(param, charset);
		} catch (UnsupportedEncodingException e) {
			LoggerUtils.error(BootGridUtils.class, String.format("Please check if you charset:%s is valid.", charset));
		}
		return res;
	}
	
	/**
	 *  encode url with charset UTF-8.
	 * @param param
	 * @return
	 */
	private static String encodeUrl(String param) {
		return encodeUrl(param,DEFUALT_CHARSET);
	}
	
	public static <T> BootGridPageObject<T> prepareBootGridPageObject(int current,int rowCount,List<T> data, int totalCount){
		BootGridPageObject<T> pageData = new BootGridPageObject<T>();
		pageData.setCurrent(current);
		pageData.setRowCount(rowCount);
		pageData.setRows(data);
		pageData.setTotal(totalCount);
		return pageData;
	}

	public static void main(String[] args) {
		String res = BootGridUtils.decodeUrl("sort%5Bname%5D=desc");
//		String res = BootGridUtils.encodeUrl("sort[name]=desc");
		System.out.println(res);
		System.out.println(res.indexOf("sort["));
		System.out.println(res.indexOf("]"));
		System.out.println(res.substring(5, res.indexOf("]")));
	}
}
