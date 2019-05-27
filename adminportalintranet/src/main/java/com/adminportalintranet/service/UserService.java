package com.adminportalintranet.service;

import java.util.List;
import java.util.Set;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.domain.security.PasswordResetToken;
import com.adminportalintranet.domain.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);

	User findByEmail(String email);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	List<User> findAll();
	
	User save(User user);
	
	User findOne(Long id);
}
