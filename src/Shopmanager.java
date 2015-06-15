import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Shopmanager extends MemberManagement implements ActionListener {

	form shopframe = new form();

	private JTextField running;
	private JTextField water;
	private JTextField upclothes;
	private JTextField downclothes;
	private JTextField cycle;
	private JTextField arm;
	private JTextField leg;

	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("나가기");

	public Shopmanager() {
		shopframe.setTitle("헬스장관리");
		shopframe.setSize(500, 450);
		shopframe.setLocation(500, 300);
		

		JLabel mRunning = new JLabel("런닝 머신 수 :");
		mRunning.setBounds(27, 16, 100, 30);
		shopframe.getContentPane().add(mRunning);

		JLabel mCycle = new JLabel("사이클 수 :");
		mCycle.setBounds(27, 56, 100, 30);
		shopframe.getContentPane().add(mCycle);

		JLabel mArm = new JLabel("팔운동기구 수 :");
		mArm.setBounds(27, 96, 100, 30);
		shopframe.getContentPane().add(mArm);

		JLabel mLeg = new JLabel("다리운동기구 수 :");
		mLeg.setBounds(27, 136, 100, 30);
		shopframe.getContentPane().add(mLeg);

		JLabel mWater = new JLabel("정수기 수 :");
		mWater.setBounds(27, 176, 100, 30);
		shopframe.getContentPane().add(mWater);

		JLabel mUpclothes = new JLabel("운동복(상의) 수 :");
		mUpclothes.setBounds(27, 216, 100, 30);
		shopframe.getContentPane().add(mUpclothes);

		JLabel mDownclothes = new JLabel("운동복(하의) 수 :");
		mDownclothes.setBounds(27, 256, 100, 30);
		shopframe.getContentPane().add(mDownclothes);

		running = new JTextField();
		running.setColumns(10);
		running.setBounds(120, 21, 62, 21);
		shopframe.getContentPane().add(running);

		cycle = new JTextField();
		cycle.setColumns(10);
		cycle.setBounds(100, 62, 62, 21);
		shopframe.getContentPane().add(cycle);

		arm = new JTextField();
		arm.setColumns(10);
		arm.setBounds(125, 101, 62, 21);
		shopframe.getContentPane().add(arm);

		leg = new JTextField();
		leg.setColumns(10);
		leg.setBounds(138, 140, 62, 21);
		shopframe.getContentPane().add(leg);

		water = new JTextField();
		water.setColumns(10);
		water.setBounds(100, 180, 62, 21);
		shopframe.getContentPane().add(water);

		upclothes = new JTextField();
		upclothes.setColumns(10);
		upclothes.setBounds(138, 221, 62, 21);
		shopframe.getContentPane().add(upclothes);

		downclothes = new JTextField();
		downclothes.setColumns(10);
		downclothes.setBounds(138, 261, 62, 21);
		shopframe.getContentPane().add(downclothes);

		bt1.setBounds(97, 332, 97, 40);
		shopframe.getContentPane().add(bt1);

		bt2.setBounds(280, 332, 97, 40);
		shopframe.getContentPane().add(bt2);

		shopframe.setVisible(true);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean StringCheck = true;
		if (e.getSource() == bt1) {
			String memrunning = running.getText();
			String memwater = water.getText();
			String memupclothes = upclothes.getText();
			String memdownclothes = downclothes.getText();
			String memcycle = cycle.getText();
			String memarm = arm.getText();
			String memleg = leg.getText();

			// 입력창을 모두 채웠는지 확인
			if (memrunning.equals("")) {
				JOptionPane.showMessageDialog(this, "런닝머신 수를 입력해 주세요", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (memcycle.equals("")) {
				JOptionPane.showMessageDialog(this, "싸이클 수를 입력해 주세요", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (memarm.equals("")) {
				JOptionPane.showMessageDialog(this, "팔운동기구 수를 입력해 주세요", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (memleg.equals("")) {
				JOptionPane.showMessageDialog(this, "다리운동기구 수를 입력해 주세요", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (memwater.equals("")) {
				JOptionPane.showMessageDialog(this, "정수기 수를 입력해 주세요", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (memupclothes.equals("")) {
				JOptionPane.showMessageDialog(this, "운동복(상의) 수를 입력해 주세요",
						"메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memdownclothes.equals("")) {
				JOptionPane.showMessageDialog(this, "운동복(하의) 수를 입력해 주세요",
						"메시지", JOptionPane.INFORMATION_MESSAGE);
			}

			else {// 동일한 회원코드가 있는지 확인
					// 입력오류확인
				if (!integerOrNot(memcycle)) {
					JOptionPane.showMessageDialog(this,
							"싸이클 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!integerOrNot(memarm)) {
					JOptionPane.showMessageDialog(this,
							"팔운동기구 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!integerOrNot(memleg)) {
					JOptionPane.showMessageDialog(this,
							"다리운동기구 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!integerOrNot(memrunning)) {
					JOptionPane.showMessageDialog(this,
							"런닝머신 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!integerOrNot(memwater)) {
					JOptionPane.showMessageDialog(this,
							"정수기 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!integerOrNot(memupclothes)) {
					JOptionPane.showMessageDialog(this,
							"운동복(상의) 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!integerOrNot(memdownclothes)) {
					JOptionPane.showMessageDialog(this,
							"운동복(하의) 수는 문자를 입력할 수 없습니다.", "메시지",
							JOptionPane.INFORMATION_MESSAGE);
				} else {// 등록전 마지막 확인
					int check = JOptionPane.showConfirmDialog(this,
							"입력한 내용이 맞습니까?\n" + "런닝머신 : " + memrunning + " 개"
									+ "\n싸이클 : " + memcycle + " 개"
									+ "\n팔운동기구 : " + memarm + " 개"
									+ "\n다리운동기구 : " + memleg + " 개"
									+ "\n정수기 : " + memwater + " 개"
									+ "\n운동복(상의) : " + memupclothes + " 벌"
									+ "\n운동복(하의): " + memdownclothes + " 벌",
							"메시지", JOptionPane.INFORMATION_MESSAGE);
					if (check == 0) {// 입력한 내용이 맞을 때
						Shop s = new Shop();
						s.setrunning(memrunning);
						s.setcycle(memcycle);
						s.setarm(memarm);
						s.setleg(memleg);
						s.setwater(memwater);
						s.setupclothes(memupclothes);
						s.setdownclothes(memdownclothes);
						shop_list.add(s);
						
						FileWriter fw = null;
						// list에 기록남기기
						try {
							fw = new FileWriter("showlist.txt");
							for (int i = 0; i < shop_list.size(); i++) {
								fw.write(memrunning);
								fw.write(",");
								fw.write(memcycle);
								fw.write(",");
								fw.write(memarm);
								fw.write(",");
								fw.write(memleg);
								fw.write(",");
								fw.write(memwater);
								fw.write(",");
								fw.write(memupclothes);
								fw.write(",");
								fw.write(memdownclothes);
								fw.write("\r\n");
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							try {
								fw.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
					// 메시지나타내기
					JOptionPane.showMessageDialog(this, "헬스장 정보가 등록되었습니다.",
							"메시지", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		}

		// 등록을 취소할 때
		else if (e.getSource() == bt2) {
			shopframe.dispose();
			super.MmStart();
		}

	}

	public boolean integerOrNot(String strData) { // 입력값이 숫자인지 문자인지 판별
		char[] charData = strData.toCharArray();
		boolean check = true;
		while (check) {
			for (int i = 0; i < charData.length; i++) {
				if (!Character.isDigit(charData[i])) {
					check = !check;
					break;
				}
			}
			break;
		}
		return check;

	}

}
