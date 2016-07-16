package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUtreenode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
@Service
public class ItemCatServiceImpl  implements ItemCatService{
	@Autowired
	private TbItemCatMapper itemCat;

	@Override
	public List<EUtreenode> getitemCatlist(long parid) {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteaia=example.createCriteria();
		criteaia.andParentIdEqualTo(parid);
		List<TbItemCat> list = itemCat.selectByExample(example);
		List<EUtreenode> resultList = new  ArrayList<EUtreenode>();
		for(TbItemCat cat :list){
			EUtreenode node = new EUtreenode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			resultList.add(node);
			
		}
	
		
		
		return resultList;
	}
	
	

}
