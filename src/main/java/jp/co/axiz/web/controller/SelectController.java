package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectController {

	@RequestMapping("/select")
	public String select (Model model) {

		return "";
	}

	@RequestMapping("/list")
	public String list (Model model) {

		return "";
	}

}
