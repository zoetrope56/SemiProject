package member.model;

import java.util.Date;

public class Member {
	private String userId;
	private String name;
	private String password;
	private String email;
	private String tel;
	private Date birth;
	public Member(String userId, String name, String password, String email, String tel, Date date) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.birth = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
}