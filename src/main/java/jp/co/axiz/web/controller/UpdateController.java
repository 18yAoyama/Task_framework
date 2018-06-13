package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdateController {

	@RequestMapping("/update")
	public String update (Model model) {

		return "";
	}


	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateP (Model model) {

		return "";
	}


	@RequestMapping(value="/updateInput", method=RequestMethod.POST)
	public String updateInputP (Model model) {

		return "";
	}

	@RequestMapping(value="/updateConfirm", method=RequestMethod.POST)
	public String updateConfirmP (Model model) {

		return "";
	}

}
