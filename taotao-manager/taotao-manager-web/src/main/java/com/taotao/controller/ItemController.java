package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.Itemservice;



@Controller
public class ItemController {

	@Autowired
	private Itemservice itemservice;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemservice.getItemByid(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataResult getItemList(Integer page,Integer rows) {
		EUDataResult result = itemservice.getItemlist(page, rows);
		return result;
	}
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(TbItem item, String desc , String itemParams) throws Exception {
		TaotaoResult result = itemservice.createItem(item,desc,itemParams);
		return result;
	}
	
	@RequestMapping(value="/rest/item/delete")
	@ResponseBody
	public TaotaoResult deleteItem(Long ids) {
		TaotaoResult result = itemservice.deleteItem(ids);
		return result;
	}
	
	
}
