package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteController {

	@RequestMapping("/delete")
	public String index (Model model) {

		return "";
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteP (Model model) {

		return "";
	}


	@RequestMapping(value="/deleteConfirm" , method=RequestMethod.POST)
	public String deleteConfirm (Model model) {

		return "";
	}

}
