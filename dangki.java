package DangKi;

public class dangki {
private String name;
private String email;
private String hashPassword;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getHashPassword() {
	return hashPassword;
}
public void setHashPassword(String hashPassword) {
	this.hashPassword = hashPassword;
}

public dangki(String name, String email, String hashPassword) {
	this.name = name;
	this.email = email;
	this.hashPassword = hashPassword;
}
public dangki() {
}


}
