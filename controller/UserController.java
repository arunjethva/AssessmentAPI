package com.controller;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName("index");
		return model;
	}

	@RequestMapping("/reg")
	public ModelAndView Registration(@ModelAttribute("user") User u) {
		userService.addOrUpdateUser(u);
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName("index");

		return model;
	}

	@RequestMapping("/display")
	public ModelAndView display() {
		ModelAndView model = new ModelAndView();
		model.addObject("data", userService.viewAllUser());
		model.setViewName("display");

		return model;

	}

	@RequestMapping("/delete")
	public RedirectView deleteUser(@RequestParam("did") int id) {
		userService.deleteUser(id);
		return new RedirectView("display");
	}

	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam("eid") int id) {

		ModelAndView model = new ModelAndView();
		model.addObject("user", userService.getById(id));
		model.setViewName("index");
		return model;
	}

}
