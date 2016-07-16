package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUtreenode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EUtreenode> getCategoryList(long parentid) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentid);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUtreenode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
	
			EUtreenode node = new EUtreenode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}
	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
		

		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);

		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		contentCategoryMapper.insert(contentCategory);
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
	
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(contentCategory);
	}
	@Override
	public TaotaoResult deleteContentCategoty( long id) {
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		long  parent = contentCategory.getParentId();
		if(contentCategory.getIsParent()){
			contentCategoryMapper.deleteByPrimaryKey(id);
			TbContentCategoryExample example = new TbContentCategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(id);
			contentCategoryMapper.deleteByExample(example);
			TbContentCategoryExample example2 = new TbContentCategoryExample();
			
			Criteria criteria1 = example2.createCriteria();
			criteria1.andParentIdEqualTo(parent);
		if(contentCategoryMapper.selectByExample(example2) == null){
			TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parent);
			parentCat.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		
		}else{
			contentCategoryMapper.deleteByPrimaryKey(id);
			
			
			TbContentCategoryExample example2 = new TbContentCategoryExample();
			Criteria criteria1 = example2.createCriteria();
			criteria1.andParentIdEqualTo(parent);
		if(contentCategoryMapper.selectByExample(example2)==null){
			TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parent);
			parentCat.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
			
		}
		
		return  TaotaoResult.ok();
	}
	@Override
	public TaotaoResult updateContentCategoty(long id, String name) {
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(id);
		parentCat.setName(name);
		contentCategoryMapper.updateByPrimaryKey(parentCat);
		return TaotaoResult.ok();
	}
	

}
