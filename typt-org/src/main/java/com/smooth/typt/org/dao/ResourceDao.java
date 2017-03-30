package com.smooth.typt.org.dao;

import java.util.List;

import com.smooth.typt.org.entity.Resource;
import org.springframework.data.jpa.repository.Query;

import com.smooth.typt.common.dao.CommonDao;

public interface ResourceDao extends ResourceDaoCustom, CommonDao<Resource,String>{

	@Query("select r from Resource r where r.deleteFlag = 0 and r.parent.id = null ")
	List<Resource> getRootResourceList();
	
	@Query("select r from Resource r where r.deleteFlag = 0 order by r.orderNo")
	List<Resource> getSystemResourceList();
	
}
