package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.service.ContentService;


@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService content;
	
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataResult getContentService(long categoryId, int page, int rows){
		EUDataResult result = content.getContentService(categoryId, page, rows);
		return result;
	}
	

}
