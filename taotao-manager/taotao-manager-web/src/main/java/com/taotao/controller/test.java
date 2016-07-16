package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.pojo.TbItem;
import com.taotao.service.Itemservice;
import com.taotao.service.impl.ItemserviceImpl;

public class test {
	
	
	private static Itemservice itemService = new ItemserviceImpl();
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TbItem tbItem = itemService.getItemByid(536563);
		System.out.println(tbItem);

	}

}
