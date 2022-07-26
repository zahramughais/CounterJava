package com.zahra.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			session.setAttribute("count", (Integer) session.getAttribute("count") +1);
		}
		return"index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session,Model model) {
		model.addAttribute("countM", (Integer) session.getAttribute("count"));
		return"counter.jsp";
	}
	@RequestMapping("/thirdpage")
	public String thirdpage(HttpSession session,Model model) {
		model.addAttribute("countM", (Integer) session.getAttribute("count") * 2);
		return"thirdpage.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {		
		session.setAttribute("count", 0);
		return "redirect:/";
	}
}
