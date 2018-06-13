package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsertController {

	@RequestMapping("/insert")
	public String insert (Model model) {

		return "";
	}


	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertP (Model model) {

		return "";
	}


	@RequestMapping(value="/insertConfirm", method=RequestMethod.POST)
	public String insertConfirmP (Model model) {

		return "";
	}

}
