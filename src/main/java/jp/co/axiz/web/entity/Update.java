package jp.co.axiz.web.entity;

import javax.validation.constraints.NotBlank;

//updateに必要な情報
public class Update {

	@NotBlank
	public String id;

	public String name;
	public String tel;
	public String pass;

	public String rePass;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getRePass() {
		return rePass;
	}
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

}
