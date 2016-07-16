package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.EUtreenode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	
	List<EUtreenode> getCategoryList(long parentid);
	
	TaotaoResult insertContentCategory(long parentId, String name);
	
	TaotaoResult deleteContentCategoty(long id);
	
	TaotaoResult updateContentCategoty(long id,String  name);
	
	

}
