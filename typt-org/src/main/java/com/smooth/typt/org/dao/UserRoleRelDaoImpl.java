package com.smooth.typt.org.dao;

import java.util.List;

import com.smooth.typt.org.entity.User;
import org.apache.commons.lang3.StringUtils;

import com.smooth.typt.common.dao.CustomBaseSqlDaoImpl;
import com.smooth.typt.org.entity.User;

public class UserRoleRelDaoImpl extends CustomBaseSqlDaoImpl implements UserRoleRelCustomDao{

	/**
	 * 根据角色ID和用户名查找用户
	 * @param roleId
	 * @param name
	 * @return
	 */
	public List<User> findUserListByRoleCondition(String roleId, String name){
		String hql="select urr.user from UserRoleRel urr where 1=1 ";
		if(roleId != null){
			hql+=" and urr.role.id = "+roleId;
		}
		if(StringUtils.isNotBlank(name)){
			hql+=" and urr.user.realName like '%"+name+"%' ";
		}
		return this.queryForList(hql);
	}
}
