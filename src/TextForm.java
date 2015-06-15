import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TextForm extends MemberManagement implements ActionListener {
	//직접입력창생성
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField code;
	
	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("취소");
	form textframe = new form();
	//체크박스생성
	JRadioButton female;
	JRadioButton male;
	JRadioButton fat1;
	JRadioButton fat2;
	JRadioButton healthy;
	JRadioButton slim;
	JRadioButton exercise;
	JRadioButton exerciseYoga;
	JRadioButton exerciseSwim;
	JRadioButton exerciseYogaSwim;
	
	ButtonGroup genderbg = new ButtonGroup();
	ButtonGroup hclassbg = new ButtonGroup();
	ButtonGroup healthbg = new ButtonGroup();
	//등록창생성
	public TextForm(){
		textframe.setTitle("회원등록");
		textframe.setSize(500, 450);
		textframe.setLocation(500, 300);
		textframe.setDefaultCloseOperation(textframe.EXIT_ON_CLOSE);
	
		JLabel mCode = new JLabel("회원 코드  :");
		mCode.setBounds(27, 16, 90, 30);
		textframe.getContentPane().add(mCode);
		
		JLabel mName = new JLabel("이름 :");
		mName.setBounds(27, 56, 90, 30);
		textframe.getContentPane().add(mName);
		
		JLabel mAge = new JLabel("나이 :");
		mAge.setBounds(27, 96, 90, 30);
		textframe.getContentPane().add(mAge);
		
		JLabel mGender = new JLabel("성별 :");
		mGender.setBounds(27, 136, 90, 30);
		textframe.getContentPane().add(mGender);
		
		JLabel mPhone = new JLabel("전화번호(숫자만입력):");
		mPhone.setBounds(27, 176, 138, 30);
		textframe.getContentPane().add(mPhone);
		
		JLabel mHclass = new JLabel("회원 유형 :");
		mHclass.setBounds(27, 216, 90, 30);
		textframe.getContentPane().add(mHclass);
		
		JLabel mHealth = new JLabel("건강 상태 :");
		mHealth.setBounds(27, 256, 90, 30);
		textframe.getContentPane().add(mHealth);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(70, 62, 62, 21);
		textframe.getContentPane().add(name);
	
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(70, 101, 62, 21);
		textframe.getContentPane().add(age);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(170, 178, 144, 21);
		textframe.getContentPane().add(phone);
		
		

		bt1.setBounds(97, 332, 97, 40);
		textframe.getContentPane().add(bt1);
		
		bt2.setBounds(280, 332, 97, 40);
		textframe.getContentPane().add(bt2);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(100, 20, 62, 21);
		if(member_list.size() != 0){
			code.setText((Integer.parseInt(member_list.get(member_list.size()-1).getcode())+1)+"");
		}else{
			code.setText(1001 + "");
		}
		textframe.getContentPane().add(code);
		
		male = new JRadioButton("남");
		male.setBounds(90, 140, 45, 23);
		
		female = new JRadioButton("여");
		female.setBounds(150, 140, 45, 23);
		fat1 = new JRadioButton("고도비만");
		fat1.setBounds(90, 262, 100, 23);
		fat2 = new JRadioButton("비만");
		fat2.setBounds(190, 262, 60, 23);
		healthy = new JRadioButton("정상체중");
		healthy.setBounds(290, 262, 100, 23);
		slim = new JRadioButton("저체중");
		slim.setBounds(390, 262, 100, 23);
		exercise = new JRadioButton("헬스");
		exercise.setBounds(90, 221, 60, 23);
		exerciseYoga = new JRadioButton("헬스+요가");
		exerciseYoga.setBounds(160, 221, 100, 23);
		exerciseSwim = new JRadioButton("헬스+수영");
		exerciseSwim.setBounds(260, 221, 100, 23);
		exerciseYogaSwim = new JRadioButton("헬스+요가+수영");
		exerciseYogaSwim.setBounds(360, 221, 200, 23);
		
		genderbg.add(male);
		genderbg.add(female);
		hclassbg.add(fat1);
		hclassbg.add(fat2);
		hclassbg.add(healthy);
		hclassbg.add(slim);
		healthbg.add(exercise);
		healthbg.add(exerciseYoga);
		healthbg.add(exerciseSwim);
		healthbg.add(exerciseYogaSwim);
		textframe.getContentPane().add(male);
		textframe.getContentPane().add(female);
		textframe.getContentPane().add(fat1);
		textframe.getContentPane().add(fat2);
		textframe.getContentPane().add(healthy);
		textframe.getContentPane().add(slim);
		textframe.getContentPane().add(exercise);
		textframe.getContentPane().add(exerciseYoga);
		textframe.getContentPane().add(exerciseYogaSwim);
		textframe.getContentPane().add(exerciseSwim);
		
		
		textframe.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String memGender = null;
		String memHclass = null;
		String memHealth = null;
		boolean  StringCheck = true;
		//등록버튼을 선택했을 때
		if(e.getSource() == bt1){
			String memCode = code.getText();
			String memName = name.getText();
			String memAge = age.getText();
			String memPhone = phone.getText();
			if(male.isSelected()){
				memGender = "남자";
			}else if(female.isSelected()){
				memGender = "여자";
			}
			
			if(fat1.isSelected()){
				memHealth = "고도비만";
			}else if(fat2.isSelected()){
				memHealth = "비만";
			}else if(healthy.isSelected()){
				memHealth = "정상";
			}else if(slim.isSelected()){
				memHealth = "저체중";
			}
			
			if(exercise.isSelected()){
				memHclass="헬스";
			}else if(exerciseYoga.isSelected()){
				memHclass="헬스+요가";
			}else if(exerciseSwim.isSelected()){
				memHclass="헬스+수영";
			}else if(exerciseYogaSwim.isSelected()){
				memHclass="헬스+요가+수영";
			}
			
			
			//입력창을 모두 채웠는지 확인
			if(memCode.equals("")){
				JOptionPane.showMessageDialog(this, "회원 코드을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memName.equals("")){
				JOptionPane.showMessageDialog(this, "회원 이름을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memAge.equals("")){
				JOptionPane.showMessageDialog(this, "회원 나이를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memGender.equals("")){
				JOptionPane.showMessageDialog(this, "회원 성별를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memPhone.equals("")){
				JOptionPane.showMessageDialog(this, "회원 전화번호를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memHclass.equals("")){
				JOptionPane.showMessageDialog(this, "회원 전화번호를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memHealth.equals("")){
				JOptionPane.showMessageDialog(this, "회원 전화번호를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else{//동일한 회원코드가 있는지 확인
				for(int i=0; i<member_list.size(); i++){
					if(memCode.equals(member_list.get(i).getcode())){
						JOptionPane.showMessageDialog(this, "동일한 회원코드가 있습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
				}//입력오류확인
				if(!integerOrNot(memCode)){
					JOptionPane.showMessageDialog(this, "회원 코드는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!integerOrNot(memAge)){
					JOptionPane.showMessageDialog(this, "회원 나이는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!integerOrNot(memPhone)){
					JOptionPane.showMessageDialog(this, "전화번호는 문자를 입력할 수 없습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else if(!(memPhone.substring(0,2).equals("01") && (memPhone.length() ==10 || memPhone.length() ==11))){
					JOptionPane.showMessageDialog(this, "잘못된 전화번호를 입력하였습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
				}else{//등록전 마지막 확인
					int check = JOptionPane.showConfirmDialog(this, "입력한 내용이 맞습니까?\n" + 
							"회원 코드 : "+memCode + "\n이름 : "+memName + "\n나이 : " + memAge + 
							"\n성별 : " + memGender + "\n전화번호 : " + memPhone + "\n회원유형 : " +memHclass +
							"\n건강상태: " + memHealth,
							"메시지", JOptionPane.INFORMATION_MESSAGE );
					if(check == 0){//입력한 내용이 맞을 때
						Member m = new Member();
						m.setcode(memCode);
						m.setname(memName);
						m.setage(memAge);
						m.setgender(memGender);
						m.setphone(memPhone);
						m.sethclass(memHclass);
						m.sethealth(memHealth);
						member_list.add(m);
						//메시지나타내기
						JOptionPane.showMessageDialog(this, "회원이 등록되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
						int check2 = JOptionPane.showConfirmDialog(this, "계속 입력하시겠습니까?");
						if(check2 == 0){//계속해서 입력
							code.setText(Integer.parseInt(member_list.get(member_list.size()-1).getcode()) +1 + "");
							name.setText(null);
							age.setText(null);
							genderbg.clearSelection();
							hclassbg.clearSelection();
							healthbg.clearSelection();
							phone.setText(null);
							
						}else if(check2 == 1){//시작화면으로 가기
							textframe.setVisible(false);
							super.MmStart();
						}
					}
				}
			}
		}
		//등록을 취소할 때
		else if(e.getSource() == bt2){
			textframe.dispose();
			super.MmStart();
		}
	}
	
	public boolean integerOrNot(String strData){ // 입력값이 숫자인지 문자인지 판별 
		char[] charData = strData.toCharArray();
		boolean check=true;
		while(check){
			for(int i=0; i<charData.length; i++){		
				if(!Character.isDigit(charData[i])){
						check = !check;
						break;
				}
			}
			break;	
		}return check;
	}
}

