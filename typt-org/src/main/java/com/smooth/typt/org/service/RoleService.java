package com.smooth.typt.org.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smooth.typt.common.entity.PageModel;
import com.smooth.typt.common.service.CommonService;
import com.smooth.typt.org.dao.RoleDao;
import com.smooth.typt.org.dto.RoleQueryDTO;
import com.smooth.typt.org.entity.Role;

@Service
public class RoleService extends CommonService<Role,String>{

	@Autowired
	private RoleDao roleDao;

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		super.setCommonDao(roleDao);
	}
	
	public List<Role> findRoles(Map<String, Object> params) {
		return roleDao.findRoles(params);
	}
	
	public void updateDeleteFlag(String[] ids, Integer deleteFlag){
		if(ids != null){
			for(String id : ids){
				Role role = this.find(id);
				role.setDeleteFlag(deleteFlag);
				this.update(role);
			}
		}
	}
	
	public Role findByRoleName(String roleName) {
		return roleDao.findByRoleName(roleName);
	}
	
	/**
	 * 根据查询条件查询角色分页信息
	 * @param roleQueryDTO
	 * @return
	 */
	public PageModel<Role> queryRolePage(RoleQueryDTO roleQueryDTO){
		return this.roleDao.queryRolePage(roleQueryDTO);
	}
}
