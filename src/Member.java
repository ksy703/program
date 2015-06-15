

public class Member {

	
	String code;//회원코드
	String name;
	String age;
	String gender ;
	String phone;
	String hclass;//헬스, 헬스+요가, 헬스+수영, 헬스+요가+수영
	String health; //고도비만, 비만, 정상, 저체중
	

	

	public String getcode() {
		return code;
	}

	public void setcode(String a) {
		this.code = a;
	}

	public String getname() {
		return name;
	}

	public void setname(String a) {
		this.name = a;
	}

	public String getage() {
		return this.age;
	}

	public void setage(String a) {
		this.age = a;
	}

	public String getphone() {
		return phone;
	}
	public void setphone(String a) {
		this.phone = a;
	}
	public String gethclass() {
		return hclass;
	}
	public void sethclass(String a) {
		this.hclass = a;
	}

	public String gethealth() {
		return health;
	}

	public void sethealth(String a) {
		this.health = a;
	}
	public String getgender(){
		return gender;
	}
	public void setgender(String a){
		this.gender = a;
	}

	

}
