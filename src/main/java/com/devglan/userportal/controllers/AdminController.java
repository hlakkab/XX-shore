package com.devglan.userportal.controllers;

import com.devglan.userportal.models.Admin;
import com.devglan.userportal.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

@EnableAspectJAutoProxy(proxyTargetClass = false)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/admin"})

public class AdminController {
	
    @Autowired
    private AdminService adminService;
        
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Admin findByMemailAndMpassword(@RequestBody Admin loginAdmin)
	{
		return adminService.findByMemailAndMpassword(loginAdmin.getmemail(),loginAdmin.getmpassword());
	}
     
}