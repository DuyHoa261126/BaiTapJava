package ex7;



public class Customer {
private String name;
private boolean member =false;
private String memberType;
public Customer(String name) {
	this.name=name;
	
}
public String getName() {
	return name;
}
public boolean isMember() {
	return this.member;
}
public void setMember(boolean member) {
	this.member=member;
}
public String getMemberType() {
	
	return memberType;
}
public void setMemberType(String memberType) {
	
	this.memberType = memberType;
}
@Override
public String toString() {
	//Khách hàng: [Tên: <name>, Thành viên: <true/false>, Loại thành viên: <type>]

	return "Customer [name=" + name + ", member=" + member + ", memberType=" + memberType + "]";
}

}
