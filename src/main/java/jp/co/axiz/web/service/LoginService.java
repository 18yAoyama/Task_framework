package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.Admin;

public interface LoginService {

	//id、passを元にadminテーブルを検索
	public Admin findAdmin(String id, String pass);

}
