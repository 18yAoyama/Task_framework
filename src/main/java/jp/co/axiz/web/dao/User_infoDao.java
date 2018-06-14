package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.User_info;

public interface User_infoDao {

	//id、名前、telを元に検索
	public List<User_info> select(Integer id, String name, String tel);

	//名前、tel、passを元に登録
	public void insert(String name, String tel, String pass);

	public Integer idInsert();

	public void update(String id, String name, String tel, String pass);

	public void delete(Integer id);

}
