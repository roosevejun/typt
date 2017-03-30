package com.smooth.typt.org.dao;


import java.util.List;
import java.util.Map;

import com.smooth.typt.common.entity.PageModel;
import com.smooth.typt.org.dto.UserQueryDTO;
import com.smooth.typt.org.entity.User;

public interface SystemUserDao {
	
	public List<User> findUsers(Map<String, Object> params);
	
	/**
	 * 根据用户信息查询分页信息
	 * @param userQueryDTO
	 * @return
	 */
	PageModel<User> queryUserPage(UserQueryDTO userQueryDTO);
	
}
