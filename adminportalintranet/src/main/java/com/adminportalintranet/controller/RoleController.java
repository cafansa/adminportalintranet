package com.adminportalintranet.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService RoleService;
	
	@RequestMapping("/newRol")
	public String CrearRol(Model model) {
		Role role = new Role();
		model.addAttribute("role",role);
		return "nuevoRol";
	}
	
	@RequestMapping(value="/guardarRol", method=RequestMethod.POST)
	public String guardarRol(
			HttpServletRequest request,
			@ModelAttribute("role") Role role,
			@ModelAttribute("name") String name,
			Model model
			) throws Exception {
		
		Role role1 = new Role();
		//role.setRoleId(2);
		//role.setName(rolname);

		if(RoleService.findByName(name) != null)
		{
			model.addAttribute("rolExists", true);
			model.addAttribute("role", role1);
			return "nuevoRol";
		}
		else
		{
			role.setActivo(true);
			role.setFechaingreso(new Date());
			RoleService.save(role);
			List<Role> roles = RoleService.findAll();
			model.addAttribute("roleList", roles);	
			//return "roles";
			return "redirect:/role/listarRoles";
		}
	}
	
	@RequestMapping("/listarRoles")
	public String listarRoles(Model model) {
		List<Role> role = RoleService.findAll();
		model.addAttribute("roleList", role);		
		return "roles";
	}
	
	@RequestMapping("/updateRole")
	public String updateRole(@RequestParam("id") Long id, Model model) {
		Role role = RoleService.findOne(id);
		model.addAttribute("role", role);
		
		return "updateRol";
	}
	
	@RequestMapping(value="/updateRole", method=RequestMethod.POST)
	public String updateRolePost(@ModelAttribute("role") Role role, HttpServletRequest request, Model model) {
		//role.setName(rolname);
		RoleService.save(role);
		List<Role> roles = RoleService.findAll();
		model.addAttribute("roleList", roles);	
		//return "roles";
		return "redirect:/role/listarRoles";
	}
	
	@RequestMapping("/desactivarRole")
	public String desactivarRole(@RequestParam("id") Long id, Model model) {
		Role role = RoleService.findOne(id);
		role.setActivo(false);
		RoleService.save(role);
		List<Role> roles = RoleService.findAll();
		model.addAttribute("roleList", roles);		
		//return "roles";
		return "redirect:/role/listarRoles";
	}
	
	@RequestMapping("/activarRole")
	public String activarRole(@RequestParam("id") Long id, Model model) {
		Role role = RoleService.findOne(id);
		role.setActivo(true);
		RoleService.save(role);
		List<Role> roles = RoleService.findAll();
		model.addAttribute("roleList", roles);		
		//return "roles";
		return "redirect:/role/listarRoles";
	}
}
