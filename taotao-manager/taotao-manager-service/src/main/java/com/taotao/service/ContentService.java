package com.taotao.service;

import com.taotao.common.pojo.EUDataResult;

public interface ContentService {
	EUDataResult getContentService(long categoryId ,int page ,int rows);

}
