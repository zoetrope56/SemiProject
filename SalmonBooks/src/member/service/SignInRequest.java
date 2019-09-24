package member.service;

import java.util.Date;
import java.util.Map;

public class SignInRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	private String email;
	private String tel;
	private Date birth;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean validate(Map<String, Boolean> errors) {
		return password != null && password.equals(confirmPassword); 
	}
	public void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
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
	@Override
	public String toString() {
		return "SignInRequest [id=" + id + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", email=" + email + ", tel=" + tel + ", birth=" + birth + "]";
	}
}
