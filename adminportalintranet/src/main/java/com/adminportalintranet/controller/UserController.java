package com.adminportalintranet.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.domain.security.PasswordResetToken;
import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.domain.security.UserRole;
import com.adminportalintranet.service.RoleService;
import com.adminportalintranet.service.UserRoleService;
import com.adminportalintranet.service.UserService;
import com.adminportalintranet.service.impl.UserSecurityService;
import com.adminportalintranet.utility.MailConstructor;
import com.adminportalintranet.utility.SecurityUtility;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userroleService;
	
	@RequestMapping("/listarusuarios")
	public String listarUsuarios(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("userList", users);		
		return "usuarios";
	}
	
	@RequestMapping("/crearusuario")
	public String CreateUser(Model model) {
		User user = new User();
		List<Role> roles = roleService.findAll();
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		return "registeruser";
	}
	
	@RequestMapping(value="/guardarUsuario", method=RequestMethod.POST)
	public String guardarUsuario(
			HttpServletRequest request,
			@ModelAttribute("user") User user,
			@ModelAttribute("username") String username,
			@ModelAttribute("email") String email,
			@ModelAttribute("role") String role,
			@ModelAttribute("password") String password,
			Model model
			) throws Exception {
		
		User user1 = new User();
		long roleId = Long.parseLong(role);
		
		List<Role> roles = roleService.findAll();
		
		Role roleescogido = roleService.findOne(roleId);
		if(userService.findByUsername(username) != null)
		{
			model.addAttribute("usuarioExiste", true);
			model.addAttribute("user", user1);
			model.addAttribute("roles", roles);
			return "registeruser";
		}
		
		if(userService.findByEmail(email) != null)
		{
			model.addAttribute("emailExiste", true);
			model.addAttribute("user", user1);
			model.addAttribute("roles", roles);
			return "registeruser";
		}
		
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, roleescogido));
		userService.createUser(user, userRoles);
		
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		
		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		SimpleMailMessage emailtosend = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password, username);
		
		mailSender.send(emailtosend);
		
		model.addAttribute("emailSent", "true");
		
		List<User> users = userService.findAll();
		model.addAttribute("userList", users);		
		return "redirect:/user/listarusuarios";
	}
	
	/*@RequestMapping("/newUser")
	public String EnterAdmin(Locale locale, @RequestParam("token") String token, Model model) {
		PasswordResetToken passToken = userService.getPasswordResetToken(token);

		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}

		User user = passToken.getUser();
		String username = user.getUsername();

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("user", user);

		model.addAttribute("classActiveEdit", true);
		return "myProfile";
	}*/
	
	@RequestMapping("/validarUser")
	public String validarUser(Locale locale, @RequestParam("token") String token, Model model) {
		PasswordResetToken passToken = userService.getPasswordResetToken(token);

		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}

		User user = passToken.getUser();
		String username = user.getUsername();

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("user", user);

		model.addAttribute("classActiveEdit", true);
		return "cambiarpassword";
	}
	
	@RequestMapping(value="/actualizarpassword", method=RequestMethod.POST)
	public String actualizarpass(HttpServletRequest request,
			@ModelAttribute("password") String password,
			@ModelAttribute("id") String id,
			Model model
			) throws Exception {
		
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		User user1=userService.findOne(Long.valueOf(id));
		
		user1.setPassword(encryptedPassword);
		userService.save(user1);
		
		model.addAttribute("user", user1);
		return "admin";
	}
	
	@RequestMapping("/updateUsuario")
	public String actualizarusuario(@RequestParam("id") Long id, Model model) throws NoSuchFieldException, SecurityException {
		User user = userService.findOne(id);
		List<Role> roles = roleService.findAll();
		
		//String rolename=user.getUserRoles().stream().findFirst().get().getRole().getName();
		Long roleId=user.getUserRoles().stream().findFirst().get().getRole().getRoleId();
		Role role=roleService.findOne(roleId);
		
		UserRole userrole = userroleService.findByRoleAndUser(role, user);
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		model.addAttribute("userrole",userrole);
		
		return "updateUsuario";
	}
	
	@RequestMapping(value="/updateUsuario", method=RequestMethod.POST)
	public String actualizarusuariopost(
				HttpServletRequest request,
				@ModelAttribute("user") User user,
				@ModelAttribute("firstName") String firstName,
				@ModelAttribute("lastName") String lastName,
				@ModelAttribute("username") String username,
				@ModelAttribute("email") String email,
				@ModelAttribute("role") String role,
				@ModelAttribute("password") String password,
				@ModelAttribute("userrole") String userrole,
				Model model
			) {
		long roleId = Long.parseLong(role);
		Role roleescogido = roleService.findOne(roleId);
		
		long userroleid = Long.parseLong(userrole);
		
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		userService.save(user);
		
		UserRole userRole = userroleService.findOne(userroleid);
		userRole.setRole(roleescogido);
		userroleService.save(userRole);
	
		//String token = UUID.randomUUID().toString();
		//userService.createPasswordResetTokenForUser(user, token);
		
		//String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		//SimpleMailMessage emailtosend = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password, username);
		
		//mailSender.send(emailtosend);
		
		//model.addAttribute("emailSent", "true");
		List<User> users = userService.findAll();
		model.addAttribute("userList", users);		
		return "redirect:/user/listarusuarios";
	}
	
	@RequestMapping("/desactivarUsuario")
	public String desactivarUser(@RequestParam("id") Long id, Model model) {
		User user = userService.findOne(id);
		user.setEnabled(false);
		userService.save(user);
		List<User> users = userService.findAll();
		model.addAttribute("userList", users);		
		return "redirect:/user/listarusuarios";
	}
	
	@RequestMapping("/activarUsuario")
	public String activarUser(@RequestParam("id") Long id, Model model) {
		User user = userService.findOne(id);
		user.setEnabled(true);
		userService.save(user);
		List<User> users = userService.findAll();
		model.addAttribute("userList", users);		
		return "redirect:/user/listarusuarios";
	}
}
