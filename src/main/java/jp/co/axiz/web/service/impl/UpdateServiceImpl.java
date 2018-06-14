package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.User_infoDao;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	User_infoDao dao;

	//入力されたidの数字チェック
	@Override
	public boolean isNum (String id) {
	    try {
	        Integer.parseInt(id);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}

	@Override
	public boolean isChange(String name, String tel, String pass, User_info before) {

		//すべて同じならfalse
		if(name.equals(before.getUser_name()) && tel.equals(before.getTelephone()) && pass.equals(before.getPassword())) {
			return false;
		}

		return true;
	}

	@Override
	public void update(String id, String name, String tel, String pass) {
		dao.update(id, name, tel, pass);
	}

}
