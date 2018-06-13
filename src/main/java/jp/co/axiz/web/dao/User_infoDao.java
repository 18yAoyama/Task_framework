package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.User_info;

public interface User_infoDao {

	//id、名前、telを元に検索
	public List<User_info> select(Integer id, String name, String tel);

}
