package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.AdminDao;
import jp.co.axiz.web.entity.Admin;
import jp.co.axiz.web.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	AdminDao adminDao;

	@Override
	public Admin findAdmin(String id, String pass) {
		return adminDao.findAdmin(id, pass);
	}

}
