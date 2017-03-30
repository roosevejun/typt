package com.smooth.typt.org.dao;

import java.util.List;
import java.util.Map;

import com.smooth.typt.common.entity.PageModel;
import com.smooth.typt.org.dto.RoleQueryDTO;
import com.smooth.typt.org.entity.Role;

public interface RoleCustomDao {
	
	public List<Role> findRoles(Map<String, Object> params);
	
	/**
	 * 根据查询条件查询角色分页信息
	 * @param roleQueryDTO
	 * @return
	 */
	PageModel<Role> queryRolePage(RoleQueryDTO roleQueryDTO);
	
}
