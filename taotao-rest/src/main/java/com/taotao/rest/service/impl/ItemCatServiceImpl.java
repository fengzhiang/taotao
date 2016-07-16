package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
@Service
public class ItemCatServiceImpl  implements ItemCatService{
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		
		catResult.setData(getCatList(0));
		return  catResult;
	}

	
	private List<?> getCatList(long prantid){
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(prantid);
		List< TbItemCat> list =itemCatMapper.selectByExample(example);
		List result = new ArrayList<>();
		int count= 0;
		for(TbItemCat cat :list){
			if(cat.getIsParent()){
				CatNode node= new CatNode();
				if(prantid ==0){
					node.setName("<a href='/products/"+cat.getId()+".html'>"+cat.getName()+"</a>");
				}else{
					node.setName(cat.getName());
				}
				node.setUrl("/products/"+cat.getId()+".html");
				node.setItem(getCatList(cat.getId()));
				result.add(node);
				count ++;
				//第一层只取14条记录
				if (prantid == 0 && count >=14) {
					break;
				}
				
			}else{
				result.add("/products/"+cat.getId()+".html|" + cat.getName());
			}	
			
		}
		return result;
		
		
		
		
		
		
	}
	
}
