package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class securityController {
	// đăng Nhập 

	@RequestMapping("/security/login/form")
	public String loginForm (Model model) {
model.addAttribute("message" ,"Vui long dang nhap !!");
		
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginsuccess (Model model) {
		
	
		model.addAttribute("message" ,"Dang nhap thanh cong !");
		
		return "security/login";
		}
	
	@RequestMapping("/security/login/error")
	public String loginerror (Model model) {
		
	
		model.addAttribute("message" ,"Dang Nhap that bai !");
		
		return "security/login";
		}
	
	@RequestMapping("/security/logoff/success")
	public String logoff (Model model) {
		
	
		model.addAttribute("message" ,"Dang xuat thanh cong!");
		
		return "security/login";
		}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried (Model model) {
		
	
		model.addAttribute("message" ,"Khong co quyen truy xuat!");
		
		return "security/login";
		}
	
	
	//dăng ký
	
	@RequestMapping("/security/registration/form")
	public String registrationForm (Model model) {
model.addAttribute("message" ,"Vui long Nhập thông tin !!");
		
		return "security/registration";
	}
	
	@RequestMapping("/security/registration/success")
	public String registrationsuccess (Model model) {
		
	
		model.addAttribute("message" ,"Đăng Ký thanh cong !");
		
		return "security/registration";
		}
	
	@RequestMapping("/security/registration/error")
	public String registrationerror (Model model) {
		
	
		model.addAttribute("message" ,"Đăng Ký that bai !");
		
		return "security/registration";
		}
	
	
	
	
	
	
	
}
