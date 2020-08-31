package com.oracle.gdms.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.Model;
import com.oracle.gdms.entity.ResponseEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.service.impl.GoodsServiceImpl;
import com.oracle.gdms.util.Factory;

@Path("/goods")
public class GoodsRest {

	
	@Path("/push")
	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public ResponseEntity pushGoods(Model goods) {
		
//		System.out.println("商品信息：" + goods.getGoods().getName() + goods.getGoods().getGtid());
		
		GoodsService service = new GoodsServiceImpl();
		int count = service.add(goods.getGoods());
		
		ResponseEntity resp = new ResponseEntity();
		resp.setCode(0);
		resp.setMessage("推送成功");
		
		return resp;
	}
	
	@Path("update/type")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateGoodsType(String jsonparam) {
		JSONObject j = JSONObject.parseObject(jsonparam);
		String goodsid = j.getString("goodsid");
		String gtid = j.getString("gtid");
		GoodsEntity goods= new GoodsEntity();
		goods.setGoodsid(Integer.parseInt(goodsid));
		goods.setGtid(Integer.parseInt(gtid));
		GoodsService service = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
		int count = service.updateGoodsType(goods);
		
		return j.toJSONString();
	}
}



