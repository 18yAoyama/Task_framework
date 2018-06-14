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

import jp.co.axiz.web.entity.Delete;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.service.DeleteService;
import jp.co.axiz.web.service.SelectService;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class DeleteController {

	@Autowired
	SelectService selectService;

	@Autowired
	UpdateService updateService;

	@Autowired
	DeleteService deleteService;

	@RequestMapping("/delete")
	public String delete (@ModelAttribute("form") Delete delete, Model model) {
		//delete.jsp表示
		return "delete";
	}

	@RequestMapping(value="/deleteConfirm", method=RequestMethod.POST)
	public String deleteP (@Validated @ModelAttribute("form") Delete delete,
			BindingResult bindingResult, Model model) {
		//delete.jspのpost送信後

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "必須項目を入力してください");
			return "delete";
		}

		//入力idの数字確認
		if(!updateService.isNum(delete.getId())) {
			//数字でなければupdate.jspに戻す
			model.addAttribute("msg", "入力されたデータは存在しません");
			return "delete";
		}

		//入力されたidを元にデータベース検索
		List<User_info> list = selectService.select(Integer.parseInt(delete.getId()), "", "");

		//idが存在するか確認
		if(list.size() == 0) {
			model.addAttribute("msg", "入力されたデータは存在しません");
			return "delete";
		}

		//deleteにuser_info
		model.addAttribute("delete", list.get(0));

		return "deleteConfirm";
	}


	@RequestMapping(value="/delete" , method=RequestMethod.POST)
	public String deleteConfirm (@ModelAttribute("form") Delete delete, Model model) {

		//delete処理
		deleteService.delete(Integer.parseInt(delete.getId()));

		return "deleteResult";
	}

}
