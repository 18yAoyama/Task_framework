package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.User_info;

public interface UpdateService {

	//入力されたidの数字確認
	public boolean isNum (String id);

	//入力された情報の変更確認
	public boolean isChange(String name, String tel, String pass, User_info before);

	public void update(String id, String name, String tel, String pass);

}
