package com.sojson.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.UPermission;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.demo.BootGridRequestParamsUtil;
import com.sojson.demo.BootGridUtils;
import com.sojson.demo.domain.BootGridPageObject;
import com.sojson.demo.domain.BootGridPaginationRequestObject;
import com.sojson.permission.service.PermissionService;

@Controller
@Scope(value="prototype")
@RequestMapping("/permission")
public class PermissionDemoController  extends BaseController {

	@Autowired
	PermissionService permissionService;
	
	/**
	 * 获取权限列表 获取分页信息
	 * @param findContent	查询内容
	 * @param pageNo		页码
	 * @param modelMap		参数回显
	 * @return
	 */
	@RequestMapping(value="/page")
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	public BootGridPageObject<UPermission> getPermissionPaginationData(String findContent,ModelMap modelMap,HttpServletRequest request, HttpServletResponse response){
		modelMap.put("findContent", findContent);
		
		BootGridPaginationRequestObject parames = BootGridRequestParamsUtil.parseParams(request, this.pageNo, pageSize);
		LoggerUtils.debug(getClass(), parames.toString());
		
		this.setPageNo(parames.getCurrent());
		this.setPageSize(parames.getRowCount());
		Pagination<UPermission> permissions = permissionService.findPage(modelMap,pageNo,pageSize);
		
		BootGridPageObject<UPermission> page = BootGridUtils.prepareBootGridPageObject(pageNo, pageSize, permissions.getList(), permissions.getTotalCount());
		LoggerUtils.debug(getClass(), page.toString());
		return page;
	}
	
	/**
	 * 更新权限列表 记录
	 * @param findContent	查询内容
	 * @param pageNo		页码
	 * @param modelMap		参数回显
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	public void getPermissionPaginationData(@RequestBody(required=true) UPermission obj){
		
		LoggerUtils.debug(getClass(), obj.toString());
		
	}
}
