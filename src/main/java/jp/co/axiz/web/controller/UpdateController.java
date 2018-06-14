package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Update;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.service.SelectService;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {

	@Autowired
	HttpSession session;

	@Autowired
	UpdateService updateService;

	@Autowired
	SelectService selectService;

	@RequestMapping("/update")
	public String update (@ModelAttribute("form") Update update, Model model) {
		return "update";
	}


	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateP (@Validated @ModelAttribute("form") Update id,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "必須項目を入力してください");
			return "update";
		}

		//入力idの数字確認
		if(!updateService.isNum(id.getId())) {
			//数字でなければupdate.jspに戻す
			model.addAttribute("msg", "入力されたデータは存在しません");
			return "update";
		}


		//idを元に検索
		List<User_info> list = selectService.select(Integer.parseInt(id.getId()), "", "");

		//idのデータが存在するか確認
		if(list.size() == 0) {
			model.addAttribute("msg", "入力されたデータは存在しません");
			return "update";
		}

		//データをUser_info型でsessionに保存
		session.setAttribute("User_info", list.get(0));

		return "updateInput";
	}


	@RequestMapping(value="/updateInput", method=RequestMethod.POST)
	public String updateInputP (@ModelAttribute("form") Update update, Model model) {

		//情報が変更されているか確認
		if(!updateService.isChange(update.getName(), update.getTel(), update.getPass(), (User_info)session.getAttribute("User_info"))) {
			model.addAttribute("msg", "１項目以上変更してください");
			return "updateInput";
		}

		//変更情報をaddAttribute
		session.setAttribute("update", update);

		return "updateConfirm";
	}

	@RequestMapping(value="/updateInput")
	public String Update(@ModelAttribute("form") Update update, Model model) {

		//戻るボタンを押したとき、updateInput.jspに戻る
		return "updateInput";
	}

	@RequestMapping(value="/updateConfirm", method=RequestMethod.POST)
	public String updateConfirmP (@ModelAttribute("form") Update update, String rePass, Model model) {

		Update updateInfo = (Update)session.getAttribute("update");

		//パスワード確認
		if(!updateInfo.getPass().equals(update.getPass())) {
			model.addAttribute("msg", "前画面で入力したパスワードと一致しません");
			return "updateConfirm";
		}

		//update処理
		updateService.update(updateInfo.getId(), updateInfo.getName(), updateInfo.getTel(), updateInfo.getPass());

		//updateしたidを格納
		model.addAttribute("id", updateInfo.getId());

		return "updateResult";
	}

}
