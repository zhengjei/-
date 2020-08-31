package com.oracle.gdms.entity;

import java.io.Serializable;

public class GoodsTypeEntity implements Serializable{
	private int gtid;
	private String name;
	private String description;
	public int getGtid() {
		return gtid;
	}
	public void setGtid(int gtid) {
		this.gtid = gtid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "GoodsTypeEntity [gtid=" + gtid + ", name=" + name + ", description=" + description + "]";
	}
	public GoodsTypeEntity(int gtid, String name, String description) {
		super();
		this.gtid = gtid;
		this.name = name;
		this.description = description;
	}
	public GoodsTypeEntity() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
}
