package com.productapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/addform")
	public String showAddForm() {
		return "addProductForm";
	}
	
	@RequestMapping("/deleteform")
	public String deleteForm() {
		return "deleteProductForm";
	}
	
	@RequestMapping("/updateform")
	public String updateForm() {
		return "updateProductForm";
	}
}
