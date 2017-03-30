package com.smooth.typt.org.dao;


import org.springframework.data.jpa.repository.Query;

import com.smooth.typt.common.dao.CommonDao;
import com.smooth.typt.org.entity.Role;

public interface RoleDao extends RoleCustomDao,CommonDao<Role,String>{

	@Query("from Role r where r.roleName = ?1 ")
	public Role findByRoleName(String roleName);
	
}
