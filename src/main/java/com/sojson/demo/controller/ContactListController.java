package com.sojson.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sojson.demo.domain.Contact;
import com.sojson.demo.domain.PageObject;

@Controller
@RequestMapping(path="/data")
public class ContactListController {

	@RequestMapping(path="/contacts")
	@ResponseBody
	@ResponseStatus(code=HttpStatus.OK)
	public PageObject<Contact> getContactListPage(HttpServletRequest request,HttpServletResponse resposne){
		Contact a = new Contact(19,"123@test.de","2014-05-30T22:15:00");
		Contact b = new Contact(29,"123@test.de","2016-05-30T22:15:01");
		Contact c = new Contact(14,"123@test.de","2017-05-30T22:15:02");
		Contact d = new Contact(43,"123@test.de","2018-05-30T22:15:03");
		Contact e = new Contact(36,"123@test.de","2019-05-30T22:15:04");
		Contact f = new Contact(27,"123@test.de","2014-12-30T22:15:05");
		Contact h = new Contact(78,"123@test.de","2014-23-30T22:15:06");
		
		List<Contact> rows = new ArrayList<Contact>();
		rows.add(a);
		rows.add(b);
		rows.add(c);
		rows.add(d);
		rows.add(e);
		rows.add(f);
		rows.add(h);
		
		PageObject<Contact> res = new PageObject<Contact>();
		res.setCurrent(1);
		res.setRowCount(10);
		res.setRows(rows);
		res.setTotal(1120);
		
		return res;
	}
}
