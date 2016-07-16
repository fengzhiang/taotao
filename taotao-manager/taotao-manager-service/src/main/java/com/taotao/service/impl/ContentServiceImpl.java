package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public EUDataResult getContentService(long categoryId, int page, int rows) {

		TbContentExample example = new TbContentExample();
		PageHelper.startPage(page, rows);
		
		Criteria criteria = example.createCriteria();
		List<TbContent> list= contentMapper.selectByExample(example);
		EUDataResult result = new EUDataResult();
		result.setRows(list);
		PageInfo<TbContent> info = new PageInfo<TbContent>(list);
		result.setTotal(info.getTotal());
	
		
		return result;
	}
	

}
