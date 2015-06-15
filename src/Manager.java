
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Manager extends MemberManagement  implements ActionListener, ItemListener {
	form managerframe = new form();
	JButton add = new JButton("회원 추가");
	JButton edit = new JButton("회원 수정");
	JButton delete = new JButton("회원 삭제");
	JButton cancel = new JButton("취소");
	JComboBox cb = new JComboBox();
	private JLabel select = new JLabel("회원 선택");
	private final JTextArea memInfo = new JTextArea();
	
	public Manager(){
		managerframe.setTitle("회원관리");
		managerframe.setSize(331, 285);
		managerframe.setLocation(550, 350);
		managerframe.setDefaultCloseOperation(managerframe.EXIT_ON_CLOSE);
	
		cb.setBounds(12, 39, 183, 21);
		cb.addItem("회원을 선택하세요");
		for(int i=0; i<member_list.size(); i++){
			cb.addItem(member_list.get(i).getcode() + ". " + member_list.get(i).getname());
		}
		managerframe.getContentPane().add(cb);
		
		edit.setBounds(207, 40, 97, 32);
		managerframe.getContentPane().add(edit);
		
		delete.setBounds(207, 82, 97, 32);
		managerframe.getContentPane().add(delete);
		
		cancel.setBounds(207, 166, 97, 32);
		managerframe.getContentPane().add(cancel);
		
		select.setBounds(12, 14, 57, 15);
		managerframe.getContentPane().add(select);
		
		memInfo.setEditable(false);
		memInfo.setBounds(12, 80, 183, 152);
		managerframe.getContentPane().add(memInfo);
		
		add.setBounds(207, 124, 97, 32);
		managerframe.getContentPane().add(add);
		
		add.addActionListener(this);
		edit.addActionListener(this);
		delete.addActionListener(this);
		cancel.addActionListener(this);
		cb.addItemListener(this);

		
		managerframe.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie){
		if(cb.getSelectedIndex()!=0){
			int select = cb.getSelectedIndex()-1;
			memInfo.setText("회원 코드 : "+member_list.get(select).getcode() + "\n회원 이름 : "+ member_list.get(select).getname() 
				+ "\n회원 나이 : " + member_list.get(select).getage()  + "\n회원 성별 : " + member_list.get(select).getgender()  + "\n회원 전화번호 : " 
				+ member_list.get(select).getphone()  + "\n회원 유형 : " +member_list.get(select).gethclass()  +	"\n건강 상태 : " +member_list.get(select).gethealth());
		}else{
			memInfo.setText(null);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == edit){
			int select = cb.getSelectedIndex();
			Edit ed = new Edit(select);
			managerframe.dispose();
		}else if(e.getSource() == delete){
			int select = cb.getSelectedIndex()-1;
			member_list.remove(select);
			cb.removeItemAt(select+1);
		}else if(e.getSource() == add){
			managerframe.dispose();
			TextForm tf = new TextForm();
		}else if(e.getSource() == cancel){
			managerframe.dispose();
			super.MmStart();
		}
	}
}
