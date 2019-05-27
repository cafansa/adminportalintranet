package com.adminportalintranet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.service.UserService;
import com.adminportalintranet.service.impl.UserSecurityService;

@Controller
//@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(Model model) {
		User user = new User();
		
		model.addAttribute("user",user);
		return "index";
		//return "redirect: /login";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		
		//LEER LOS DATOS DEL USUARIO EN SESION
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		User usuarioLogged = userService.findByUsername(currentUserName);
		final String nombreUsuario = usuarioLogged.getFirstName();
		final String apellidoUsuario = usuarioLogged.getLastName();
		System.out.println("######################bUsuario en sesion "+currentUserName+" y se llama: "+nombreUsuario+" "+apellidoUsuario);
		
		return "admin";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginin(
			HttpServletRequest request,
			@ModelAttribute("user") User user,
			@ModelAttribute("username") String username,
			@ModelAttribute("password") String password,
			Model model
			) {
		System.out.println("prueba=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("username=>"+user.getUsername());
		System.out.println("username2=>"+username);
		User user2 = userService.findByUsername(user.getUsername());
		
		UserDetails userDetails = userSecurityService.loadUserByUsername(user.getUsername());

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		model.addAttribute("user", user2);
		model.addAttribute("username", user.getUsername());
		
		model.addAttribute("errorClass", true);	
		//redirectAttributes.addAttribute("username", username);
		return "admin";
	}
}
