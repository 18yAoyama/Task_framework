package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.User_infoDao;
import jp.co.axiz.web.entity.User_info;

@Repository
public class User_indoDaoImpl implements User_infoDao {

	@Autowired
    private JdbcTemplate jT;

	@Override
	public List<User_info> select(Integer id, String name, String tel) {
		String SQL_SELECT_INFO = "SELECT user_id, user_name, telephone FROM user_info";

		boolean exId =  id != null;
		boolean exName = !(name.equals(""));
		boolean exTel = !(tel.equals(""));
		boolean flg = (exId || exName || exTel);

		//入力された条件に合わせてSQL文の作成
		if (flg) {
			SQL_SELECT_INFO += " WHERE";

			if (exId) {
				SQL_SELECT_INFO += " user_id = ?";
			} else {
				SQL_SELECT_INFO += "'1' = ?";
			}
			if (exName) {
				SQL_SELECT_INFO += " AND user_name = ?";
			} else {
				SQL_SELECT_INFO += " AND user_name LIKE ?";
			}
			if (exTel) {
				SQL_SELECT_INFO += " AND telephone = ?";
			} else {
				SQL_SELECT_INFO += " AND telephone LIKE ?";
			}
		}

		SQL_SELECT_INFO += " ORDER BY user_id";

		//検索条件に合わせてSQLの実行
		if (flg) {
			if (exId && exName && exTel) {
				//id○name○tel○
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), id, name, tel);

			} else if (!exId && exName && exTel) {
				//id×name○tel○
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), 1, name, tel);

			} else if (exId && !exName && exTel) {
				//id○name×tel○
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), id, "%%", tel);

			} else if (exId && exName && !exTel) {
				//id○name○tel×
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), id, name, "%%");

			} else if (exId && !exName && !exTel) {
				//id○name×tel×
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), id, "%%", "%%");

			} else if (!exId && exName && !exTel) {
				//id×name○tel×
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), 1, name, "%%");

			} else if (!exId && !exName && exTel) {
				//id×name×tel○
				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class), 1, "%%", tel);

			}
		} else {
			//検索条件がない場合
			return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<User_info>(User_info.class));
		}

		return null;
	}

	//登録
	@Override
	public void insert(String name, String tel, String pass) {
		jT.update("INSERT INTO user_info (user_name, telephone, password) VALUES (?, ?, ?);", name , tel, pass);
	}

	@Override
	public Integer idInsert() {
		// TODO 自動生成されたメソッド・スタブ
		return jT.queryForObject("SELECT MAX(user_id) FROM user_info", Integer.class);
	}

}
