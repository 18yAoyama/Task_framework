package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Select;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.service.SelectService;

@Controller
public class SelectController {

	@Autowired
	SelectService selectService;

	@RequestMapping("/select")
	public String select (@ModelAttribute("form") Select select, Model model) {
		return "select";
	}

	@RequestMapping(value="/insertToSelect", method=RequestMethod.POST)
	public String selectS (@ModelAttribute("form") Select select, Model model) {
		//insertしたidを表示
		model.addAttribute("id", selectService.idInsert());

		return "select";
	}

	@RequestMapping("/list")
	public String list (@Validated @ModelAttribute("form") Select select,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "入力されたデータはありませんでした");
			return "select";
		}

		//検索結果取得
		List<User_info> list = selectService.select(select.getId(), select.getName(), select.getTel());

		if (list == null || list.size() == 0) {
			model.addAttribute("msg", "入力されたデータはありませんでした");
			return "select";

		} else {
			model.addAttribute("user_info", list);
			return "selectResult";

		}
	}

}
