package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.AdminDao;
import jp.co.axiz.web.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public Admin findAdmin(String id, String pass) {
		List<Admin> list = jdbcTemplate.query("SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?", new BeanPropertyRowMapper<Admin>(Admin.class), id, pass);

		if(list.size() == 0) {
			return null;
		}

		return (Admin) list.get(0);
	}

}
