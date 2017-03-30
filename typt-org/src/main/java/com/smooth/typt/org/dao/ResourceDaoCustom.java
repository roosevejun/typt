package com.smooth.typt.org.dao;

import com.smooth.typt.org.entity.Resource;

import java.util.List;
import java.util.Map;




public interface ResourceDaoCustom {

	public List<Resource> findMenuResource(Map<String, Object> params);
	
}
