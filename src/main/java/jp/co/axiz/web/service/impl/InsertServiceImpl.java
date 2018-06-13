package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.User_infoDao;
import jp.co.axiz.web.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

	@Autowired
	User_infoDao userDao;

	@Override
	public void insert(String name, String tel, String pass) {
		userDao.insert(name, tel, pass);
	}

}
