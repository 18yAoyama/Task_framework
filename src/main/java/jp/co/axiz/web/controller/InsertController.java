package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Insert;
import jp.co.axiz.web.service.InsertService;
import jp.co.axiz.web.service.SelectService;

@Controller
public class InsertController {

	@Autowired
	HttpSession session;

	@Autowired
	InsertService insertService;

	@Autowired
	SelectService selectService;

	@RequestMapping("/insert")
	public String insert (@ModelAttribute("form") Insert insert, Model model) {
		return "insert";
	}


	@RequestMapping(value="/insertConfirm", method=RequestMethod.POST)
	public String insertP (@Validated @ModelAttribute("form") Insert insert,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "insert";
		}

		session.setAttribute("insert", insert);
		return "insertConfirm";
	}


	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertConfirmP (@ModelAttribute("form") Insert re, Model model) {

		Insert insert = (Insert) session.getAttribute("insert");
		String pass = insert.getPass();
		String rePass = re.getPass();

		if (!rePass.equals(pass)) {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません");
			return "insertConfirm";
		}

		//DB処理
		insertService.insert(insert.getName(), insert.getTel(), insert.getPass());

		//insertしたidを格納
		model.addAttribute("id", selectService.idInsert());

		return "insertResult";
	}

}
