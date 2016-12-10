package com.sojson.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.sojson.common.utils.LoggerUtils;
import com.sojson.demo.domain.BootGridPaginationRequestObject;

public class BootGridRequestParamsUtil {

	/**
	 * Parse request parameters from HTTP GET request url, and convert to a @{link BootGridPaginationRequestObject} object.
	 * @param <T> Custom input parameter object.
	 * @param request HttpServletRequest
	 * @param defaultRowCount Specify a default page size for exception handler.
	 * @param defaultCurrent Specify a default current page number for exception handler.
	 * @return
	 */
	public static <T> BootGridPaginationRequestObject<T> parseParams(final HttpServletRequest request, int defaultRowCount,int defaultCurrent){
		int current = defaultRowCount;
		int rowCount = defaultCurrent;
		String searchPhrase = "";
		String sortColumn = "";
		String sortCondition = "";
		BootGridPaginationRequestObject<T> page = new BootGridPaginationRequestObject<T>();
		//set default value
		page.setCurrent(current);
		page.setRowCount(rowCount);
		
		Map<String,String> paramMap = request.getParameterMap();
		Set<String> keyset = paramMap.keySet();
		Iterator<String> it = keyset.iterator();
		try{
			while (it.hasNext()) {
				String key = it.next();
				String tempKey = BootGridUtils.decodeUrl(key);
				LoggerUtils.debug(BootGridRequestParamsUtil.class, "request key: " + key + " , value: " + request.getParameter(key));
				if (tempKey.startsWith("sort[") && tempKey.length()>5) {
					sortColumn = tempKey.substring(5, tempKey.indexOf("]"));
					sortCondition = request.getParameter(key).toString();
					//break;
				}
			}
			rowCount = Integer.parseInt(request.getParameter("rowCount"));
			current = Integer.parseInt(request.getParameter("current"));
			searchPhrase = request.getParameter("searchPhrase");
			page.setCurrent(current);
			page.setRowCount(rowCount);
			page.setSearchPhrase(searchPhrase);
			page.setSortColumn(sortColumn);
			page.setSortCondition(sortCondition);
		}catch(Exception e){
			LoggerUtils.error(BootGridRequestParamsUtil.class,"Failed to parse rowCount and current page number from reqeust paramter, will use default value.",e);
		}finally{
			return page;
		}
	}
}
