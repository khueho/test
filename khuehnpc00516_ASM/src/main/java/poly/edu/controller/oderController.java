package poly.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.service.oderService;

@Controller
public class oderController {
	@Autowired
	oderService oService ;
	
	@RequestMapping("/oder/checkout")
	public String checkout(Model model , HttpServletRequest resq) {
	
		return "oder/checkout";
	}
	
	
	@RequestMapping("/oder/list")
	public String list(Model model , HttpServletRequest resq) {
		String username = resq.getRemoteUser();
		model.addAttribute("oders", oService.findByUsername(username));
		return "oder/list";
		
	}
	@RequestMapping("/oder/detail/{id}")
	public String detail(@PathVariable("id") Long id ,Model model) {
		model.addAttribute("oder", oService.findById(id));
		return "oder/detail";
	}
}
