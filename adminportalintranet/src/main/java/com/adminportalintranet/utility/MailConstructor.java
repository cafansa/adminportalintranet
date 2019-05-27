package com.adminportalintranet.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.adminportalintranet.domain.User;

@Component
public class MailConstructor {
	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, User user, String password, String username
			) { 
		
		String url =  contextPath + "/user/validarUser?token="+token;
		//String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is:\n"+password;
		String message = "\nDe click en el link para verificar el email y cambiar la contraseña. \nSu usuario es:"+username+". Su password temporal es:"+password;
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setTo(user.getEmail());
		email.setSubject("Nuevo usuario intranet");
		email.setText(url+message);
		email.setFrom(env.getProperty("support.email"));
		
		return email;
	}
}
