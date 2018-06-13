package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.User_infoDao;
import jp.co.axiz.web.entity.User_info;
import jp.co.axiz.web.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

	@Autowired
	User_infoDao userDao;

	//id、名前、telを元にuser_infoテーブルを検索
	@Override
	public List<User_info> select(Integer id, String name, String tel) {

		return userDao.select(id, name, tel);
	}

	@Override
	public int idInsert() {

		return userDao.idInsert();
	}

}
