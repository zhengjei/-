package com.oracle.gdms.util;

import java.util.ResourceBundle;

public class Factory {
	private static ResourceBundle rb;
	
	static {
		rb = ResourceBundle.getBundle("config/application");
	}
	
	private Factory() {	}
	
	private static Factory fac;

	public static Factory getInstance() {
		// TODO 自动生成的方法存根
		fac = fac == null ? new Factory() : fac;
		return fac;
	}

	public Object getObject(String key) {
		// 读取配置文件，从配置文件中找到key对应的class路径和名称
		String classname = rb.getString(key);
		Object o = null;
		try {
			o = Class.forName(classname).newInstance();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		return o;
	}

}
