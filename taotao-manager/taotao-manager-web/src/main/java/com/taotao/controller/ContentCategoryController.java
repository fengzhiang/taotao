package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUtreenode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;


@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUtreenode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<EUtreenode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(long id){
		TaotaoResult result = contentCategoryService.deleteContentCategoty( id);
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult uqdateContentCategory(long id,String name){
		TaotaoResult result = contentCategoryService.updateContentCategoty(id, name);
		return result;
	}

}
