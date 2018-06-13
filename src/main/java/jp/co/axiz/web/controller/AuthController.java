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

import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.LoginService;

@Controller
public class AuthController {

	@Autowired
	LoginService loginService;

	@Autowired
	HttpSession session;

	@RequestMapping("/login")
	public String login (@ModelAttribute("form") Login login, Model model) {
		return "login";
	}


	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginCheck (@Validated @ModelAttribute("form") Login login,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "IDまたはPASSが間違っています");
			return "login";
		}

		//id、passを元にadminテーブルを検索
		Admin admin = loginService.findAdmin(login.getId(), login.getPass());

		//検索チェック
		if (admin == null) {
			model.addAttribute("msg", "IDまたはPASSが間違っています");
			return "login";

		} else {
			//admin_nameをセッションへ保存
			session.setAttribute("Admin_name", admin.getAdmin_name());

			//存在したらメニュー画面へ
			return "menu";
		}
	}


	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout (Model model) {

		session.invalidate();

		return "logout";
	}

}
