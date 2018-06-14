package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.User_infoDao;
import jp.co.axiz.web.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {

	@Autowired
	User_infoDao dao;

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
