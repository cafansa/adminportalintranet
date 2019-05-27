package com.adminportalintranet;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.domain.security.UserRole;
import com.adminportalintranet.service.UserService;
import com.adminportalintranet.utility.SecurityUtility;

@SpringBootApplication
public class AdminportalIntranetApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AdminportalIntranetApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Admin");
		user1.setLastName("SohoApps");
		user1.setUsername("administrador");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("csoporte@m3medios.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		//role1.setRoleId(1);
		role1.setName("ADMINISTRADOR");
		role1.setActivo(true);
		role1.setFechaingreso(new Date());
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}
}
