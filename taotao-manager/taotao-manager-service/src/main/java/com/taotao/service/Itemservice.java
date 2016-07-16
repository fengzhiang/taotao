package com.taotao.service;

import com.taotao.common.pojo.EUDataResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface Itemservice {
   public 	TbItem  getItemByid(long id); 
   
   public  EUDataResult getItemlist(int page ,int rows);
   
   public  TaotaoResult createItem(TbItem item , String desc , String itemParam)throws Exception;
    
   public TaotaoResult deleteItem(long id);
    
   
   
   

}
