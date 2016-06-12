package com.freebird.web.dao.jpa;

import com.freebird.web.domain.User;

public interface UserDao {

	User findByUserName(String username);

}