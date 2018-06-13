package jp.co.axiz.web.entity;

import javax.validation.constraints.NotBlank;

public class Login {

	@NotBlank
	private String id;

	@NotBlank
	private String pass;

	@Override
	public String toString() {
		return "Login [id=" + id + ", pass=" + pass + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
