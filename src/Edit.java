
import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Edit extends MemberManagement implements ActionListener{
	form editframe = new form();
	JButton eName = new JButton("이름");
	JButton eAge = new JButton("나이");
	JButton eGender = new JButton("성별");
	JButton ePhone = new JButton("전화번호");
	JButton eHclass = new JButton("회원유형");
	JButton eHealth = new JButton("건강상태");
	JButton eConfirm = new JButton("확인");
	JButton eCancel = new JButton("취소");
	
	private JTextField tName;
	private JTextField tAge;
	private JTextField tGender;
	private JTextField tPhone;
	private JTextField tHclass;
	private JTextField tHealth;
	int index ;
	String name=null, age=null, selectGender=null, phone=null,hclass=null, health =null;
	public Edit(int index) {
		editframe.getContentPane().setEnabled(false);
		editframe.setTitle("수정");
		editframe.setSize(409, 295);
		editframe.setLocation(550, 350);
		editframe.setDefaultCloseOperation(editframe.EXIT_ON_CLOSE);
		
		this.index = index - 1;
		
		JLabel lblNewLabel = new JLabel("수정할 사항을 선택한후 수정해주세요.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 10, 200, 23);
		editframe.getContentPane().add(lblNewLabel);
		
		eName.setBounds(275, 33, 105, 25);
		editframe.getContentPane().add(eName);
		
		eAge.setBounds(275, 63, 105, 25);
		editframe.getContentPane().add(eAge);
		
		eGender.setBounds(275, 93, 105, 25);
		editframe.getContentPane().add(eGender);
		
		ePhone.setBounds(275, 123, 105, 25);
		editframe.getContentPane().add(ePhone);
		
		eHclass.setBounds(275, 153, 105, 25);
		editframe.getContentPane().add(eHclass);
		
		eHealth.setBounds(275, 183, 105, 25);
		editframe.getContentPane().add(eHealth);
		
		eConfirm.setBounds(61, 222, 105, 25);
		editframe.getContentPane().add(eConfirm);
		
		eCancel.setBounds(218, 222, 105, 25);
		editframe.getContentPane().add(eCancel);
		
		JLabel name = new JLabel("이름 : ");
		name.setBounds(12, 43, 57, 15);
		editframe.getContentPane().add(name);
		
		JLabel age = new JLabel("나이 : ");
		age.setBounds(12, 73, 57, 15);
		editframe.getContentPane().add(age);
		
		JLabel gender = new JLabel("성별 : ");
		gender.setBounds(12, 103, 57, 15);
		editframe.getContentPane().add(gender);
		
		JLabel phone = new JLabel("전화번호 : ");
		phone.setBounds(12, 133, 83, 15);
		editframe.getContentPane().add(phone);
		
		JLabel hclass = new JLabel("회원유형 : ");
		hclass.setBounds(12, 163, 83, 15);
		editframe.getContentPane().add(hclass);
		
		JLabel health = new JLabel("건강상태 : ");
		health.setBounds(12, 193, 83, 15);
		editframe.getContentPane().add(health);
		
		tName = new JTextField();
		tName.setEditable(false);
		tName.setBounds(50, 40, 208, 21);
		//tName.s
		editframe.getContentPane().add(tName);
		tName.setColumns(10);
		
		tAge = new JTextField();
		tAge.setEditable(false);
		tAge.setColumns(10);
		tAge.setBounds(50, 70, 208, 21);
		editframe.getContentPane().add(tAge);
		
		tGender = new JTextField();
		tGender.setEditable(false);
		tGender.setColumns(10);
		tGender.setBounds(50, 100, 208, 21);
		editframe.getContentPane().add(tGender);
		
		tPhone = new JTextField();
		tPhone.setEditable(false);
		tPhone.setColumns(10);
		tPhone.setBounds(73, 130, 185, 21);
		editframe.getContentPane().add(tPhone);
		
		tHclass = new JTextField();
		tHclass.setEditable(false);
		tHclass.setColumns(10);
		tHclass.setBounds(73, 160, 185, 21);
		editframe.getContentPane().add(tHclass);
		
		tHealth = new JTextField();
		tHealth.setEditable(false);
		tHealth.setColumns(10);
		tHealth.setBounds(73, 190, 185, 21);
		editframe.getContentPane().add(tHealth);
		
		tName.setText(member_list.get(this.index).getname());
		tAge.setText(member_list.get(this.index).getage());
		tGender.setText(member_list.get(this.index).getgender());
		tPhone.setText(member_list.get(this.index).getphone());
		tHclass.setText(member_list.get(this.index).gethclass());
		tHealth.setText(member_list.get(this.index).gethealth());
	
		editframe.setVisible(true);
		eName.addActionListener(this);
		eAge.addActionListener(this);
		eGender.addActionListener(this);
		ePhone.addActionListener(this);
		eHclass.addActionListener(this);
		eHealth.addActionListener(this);
		eConfirm.addActionListener(this);
		eCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int check;
		if(e.getSource() == eName){
			check = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?\n" + 
					"회원 이름 : " + tName.getText() ,"메시지", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				name = JOptionPane.showInputDialog("수정할 이름을 입력하세요", member_list.get(this.index).getname());
				tName.setText(name);
				if(name == null){
					tName.setText(member_list.get(this.index).getname());
				}
			}
		}else if(e.getSource() == eAge){
			check = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?\n" + 
					"회원 나이 : " + tAge.getText() ,"메시지", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				age = JOptionPane.showInputDialog("수정할 나이를 입력하세요", member_list.get(this.index).getage());
				tAge.setText(age);
				if(age == null){
					tAge.setText(member_list.get(this.index).getage());
				}
			}
		}else if(e.getSource() == eGender){
			check = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?\n" + 
					"회원 성별 : " + tGender.getText() ,"메시지", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				String[] str = {"남자", "여자"};
				selectGender = (String)JOptionPane.showInputDialog(this, "수정할 성별을 입력하세요\n" , "메시지",
						JOptionPane.INFORMATION_MESSAGE,	null, str, str[0]);
				tGender.setText(selectGender);
				if(selectGender == null){
					tGender.setText(member_list.get(this.index).getgender());
				}
			}
		}else if(e.getSource() == ePhone){
			check = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?\n" + 
					"전화번호 : " + tPhone.getText() ,"메시지", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				phone = JOptionPane.showInputDialog("수정할 전화번호를 입력하세요", member_list.get(this.index).getphone());
				tPhone.setText(phone);
				if(phone == null){
					tPhone.setText(member_list.get(this.index).getphone());
				}
			}
		}else if(e.getSource() == eHclass){
			check = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?\n" + 
					"회원유형 : " + tHclass.getText() ,"메시지", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				String[] str2={"헬스","헬스+요가","헬스+수영","헬스+요가+수영"};
				hclass = (String)JOptionPane.showInputDialog(this,"수정할 회원유형을 입력하세요\n","메시지", JOptionPane.INFORMATION_MESSAGE,	null, str2, str2[0]);
				tHclass.setText(hclass);
				if(hclass == null){
					tHclass.setText(member_list.get(this.index).gethclass());
				}
			}
		}else if(e.getSource() == eHealth){
			check = JOptionPane.showConfirmDialog(this, "수정하시겠습니까?\n" + 
					"건강상태 : " + tHealth.getText() ,"메시지", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				String[] str3={"고도비만","비만","정상","저체중"}; 
				health = (String)JOptionPane.showInputDialog(this,"수정할 건강상태를 입력하세요\n","메시지", JOptionPane.INFORMATION_MESSAGE,	null, str3, str3[0]);
				tHealth.setText(health);
				if(health == null){
					tHealth.setText(member_list.get(this.index).gethealth());
				}
			}
		}
		if(e.getSource() == eConfirm){
			if( name != null){
				member_list.get(this.index).setname(this.name);
			}
			if(age != null){
				member_list.get(this.index).setage(this.age);
			}
			if(selectGender != null){
				member_list.get(this.index).setgender(this.selectGender);
			}
			if(phone != null){
				member_list.get(this.index).setphone(this.phone);
			}
			if(hclass != null){
				member_list.get(this.index).sethclass(this.hclass);
			}
			if(health != null){
				member_list.get(this.index).sethealth(this.health);
			}
			editframe.dispose();
			Manager m = new Manager();
		}else if(e.getSource() == eCancel){
			editframe.dispose();
			Manager m = new Manager();
		}
		//list.get(this.index).setName(name);
	}
}
