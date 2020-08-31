package com.oracle.gdms.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.GoodsType;
import com.oracle.gdms.entity.GoodsTypeEntity;
import com.oracle.gdms.entity.ResponseEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;

@Path("/hongyan")
public class HongYan {
	@Path("/sing")
	@GET
	public String sing() {
		System.out.println("AAAA");
		return "aaaa";
	}
	
	@Path("/sing/ci")
	@GET
	public String sing(@QueryParam("name")String name) {
		System.out.println(name);
		return "CI";
	}
	@Path("/push/one")
	@POST
	public String push(@FormParam("name")String name, @FormParam("sex")String sex) {
		System.out.println(name);
		return "form";
	}
	@Path("/push/json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String pushJson(String jsonparam) {
		
		System.out.println(jsonparam);
		JSONObject j = JSONObject.parseObject(jsonparam);
		String name = j.getString("name");
		String sex = j.getString("sex");
		String age = j.getString("age");
		System.out.println(name);
		System.out.println(sex);
		System.out.println(age);
		
		return "json";
	}
	
	@Path("/goods/update/type")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<GoodsEntity> queryGoodsType(GoodsType type) {
		GoodsService service = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
		List<GoodsEntity> list = service.queryGoodsType(type.getGtid());
		System.out.println(list.size());
		return list;
	}
	
	@Path("/goods//type")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateGoodsType(String jsonparam) {
		JSONObject j = JSONObject.parseObject(jsonparam);
		String goodsid = j.getString("goodsid");
		String gtid = j.getString("gtid");
		System.out.println(goodsid);
		System.out.println(gtid);
		return j.toJSONString();
	}
	
	@Path("/goods/push/one")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity pushGoodsOne(String jsonparam) {
		ResponseEntity r = new ResponseEntity();
		try {
			
			JSONObject j = JSONObject.parseObject(jsonparam);
			String gs = j.getString("goods");
			GoodsModel goods = JSONObject.parseObject(gs, GoodsModel.class);
			System.out.println("成功了");
			System.out.println("商品信息"+ goods.toString());
			r.setCode(0);
			r.setMessage("推送成功");
		} catch (Exception e) {
			// TODO: handle exception
			r.setCode(1184);
			r.setMessage("推送失败" + jsonparam);
		}
		return r;
	}
	

}
