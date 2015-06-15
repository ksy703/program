import java.io.Serializable;

public class Shop{

	String running;
	String water;
	String upclothes;
	String downclothes;
	String cycle;
	String arm;
	String leg;

	
	
	
	public String getrunning() {
		return running;
	}

	public void setrunning(String a) {
		this.running = a;
	}

	public String getwater() {
		return water;
	}

	public void setwater(String a) {
		this.water = a;
	}

	public String getupclothes() {
		return upclothes;
	}

	public void setupclothes(String a) {
		this.upclothes = a;
	}

	public String getdownclothes() {
		return downclothes;
	}

	public void setdownclothes(String a) {
		this.downclothes = a;
	}

	public String getcycle() {
		return cycle;
	}

	public void setcycle(String a) {
		this.cycle = a;
	}

	public String getarm() {
		return arm;
	}

	public void setarm(String a) {
		this.arm = a;
	}

	public String getleg() {
		return leg;
	}

	public void setleg(String a) {
		this.leg = a;
	}
	public String toString() {// 오브젝트의 메소드 toString이므로 오버라이드 가능
		return "런닝머신 : "+getrunning()+" 개" + "\n\n싸이클 : "+getcycle() +" 개"+ "\n\n팔운동기구 : " + getarm()+" 개" + 
				"\n\n다리운동기구 : " + getleg()+" 개" + "\n\n정수기 : " + getwater()+" 개" + "\n\n운동복(상의) : " +getupclothes()+" 벌" +
				"\n\n운동복(하의): " + getdownclothes()+" 벌";
	}

	
}
