package jp.co.axiz.web.entity;

import javax.validation.constraints.NotBlank;

public class Insert {

	private String id;

	@NotBlank
	private String name;

	@NotBlank
	private String tel;

	@NotBlank
	private String pass;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
