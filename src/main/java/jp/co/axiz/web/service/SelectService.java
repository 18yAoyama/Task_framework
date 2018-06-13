package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.User_info;

public interface SelectService {

	public List<User_info> select(Integer id, String name, String tel);

}
