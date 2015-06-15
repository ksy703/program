
public class Employee {
	
	String counter;
	String trainer;
	String trainer2;
	String trainer3;
	String cleaner;
	
	public String getcounter(){
		return counter;
	}
	public void setcounter(String a){
		this.counter =a;
	}
	public String gettrainer() {
		return trainer;
	}

	public void settrainer(String a) {
		this.trainer = a;
	}

	public String gettrainer2() {
		return trainer2;
	}

	public void settrainer2(String a) {
		this.trainer2 = a;
	}

	public String gettrainer3() {
		return trainer3;
	}
	public void settrainer3(String a) {
		this.trainer3 = a;
	}
	public String getcleaner(){
		return cleaner;
	}
	public void setcleaner(String a){
		this.cleaner = a;
	}
	public String toString() {// 오브젝트의 메소드 toString이므로 오버라이드 가능
		return "\n***직원 현황***"+"\n\n<카운터 담당> 이름 : "+getcounter() + "\n\n<트레이너1> 이름 : " + gettrainer()+ 
				"\n\n<트레이너2> 이름 : " + gettrainer2()+ "\n\n<트레이너3> 이름 : " + gettrainer3() +"\n\n<청소담당> 이름 : "+getcleaner();
	}

}
