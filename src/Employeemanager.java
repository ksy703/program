import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employeemanager extends MemberManagement implements ActionListener {

	form eframe = new form();

	private JTextField counter;
	private JTextField trainer;
	private JTextField trainer2;
	private JTextField trainer3;
	private JTextField cleaner;

	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("나가기");

	public Employeemanager() {
		eframe.setTitle("직원등록");
		eframe.setSize(300, 450);
		eframe.setLocation(500, 300);
		eframe.setDefaultCloseOperation(eframe.EXIT_ON_CLOSE);

		JLabel mp = new JLabel("카운터 :");
		mp.setBounds(27, 16, 100, 30);
		eframe.getContentPane().add(mp);

		JLabel mn = new JLabel("트레이너1 :");
		mn.setBounds(27, 56, 100, 30);
		eframe.getContentPane().add(mn);

		JLabel ma = new JLabel("트레이너2 :");
		ma.setBounds(27, 96, 100, 30);
		eframe.getContentPane().add(ma);

		JLabel mg = new JLabel("트레이너3 :");
		mg.setBounds(27, 136, 100, 30);
		eframe.getContentPane().add(mg);

		JLabel mc = new JLabel("청소담당 :");
		mc.setBounds(27, 176, 100, 30);
		eframe.getContentPane().add(mc);

		counter = new JTextField();
		counter.setColumns(10);
		counter.setBounds(80, 21, 62, 21);
		eframe.getContentPane().add(counter);

		trainer = new JTextField();
		trainer.setColumns(10);
		trainer.setBounds(98, 62, 62, 21);
		eframe.getContentPane().add(trainer);

		trainer2 = new JTextField();
		trainer2.setColumns(10);
		trainer2.setBounds(98, 101, 62, 21);
		eframe.getContentPane().add(trainer2);

		trainer3 = new JTextField();
		trainer3.setColumns(10);
		trainer3.setBounds(98, 140, 62, 21);
		eframe.getContentPane().add(trainer3);

		cleaner = new JTextField();
		cleaner.setColumns(10);
		cleaner.setBounds(94, 180, 62, 21);
		eframe.getContentPane().add(cleaner);

		bt1.setBounds(97, 252, 97, 40);
		eframe.getContentPane().add(bt1);

		bt2.setBounds(97, 332, 97, 40);
		eframe.getContentPane().add(bt2);

		eframe.setVisible(true);

		bt1.addActionListener(this);
		bt2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		boolean StringCheck = true;
		if (e.getSource() == bt1) {
			String memp = counter.getText();
			String memn = trainer.getText();
			String mema = trainer2.getText();
			String memg = trainer3.getText();
			String mempp = cleaner.getText();

			if (memp.equals("")) {
				JOptionPane.showMessageDialog(this, "카운터 직원의 이름을 입력해 주세요",
						"메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memn.equals("")) {
				JOptionPane.showMessageDialog(this, "트레이너1의 이름을 입력해 주세요",
						"메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (mema.equals("")) {
				JOptionPane.showMessageDialog(this, "트레이너2의 이름을 입력해 주세요",
						"메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (memg.equals("")) {
				JOptionPane.showMessageDialog(this, "트레이너3의 이름을 입력해 주세요",
						"메시지", JOptionPane.INFORMATION_MESSAGE);
			} else if (mempp.equals("")) {
				JOptionPane.showMessageDialog(this, "청소담당직원을 입력해 주세요", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				// 등록전 마지막 확인
				int check = JOptionPane.showConfirmDialog(this,
						"입력한 내용이 맞습니까?\n" + "카운터 : " + memp + "\n트레이너1 : "
								+ memn + "\n트레이너2 : " + mema + "\n트레이너3 : "
								+ memg + "\n청소담당 : " + mempp, "메시지",
						JOptionPane.INFORMATION_MESSAGE);
				if (check == 0) {// 입력한 내용이 맞을 때

					Employee s = new Employee();
					s.setcounter(memp);
					s.settrainer(memn);
					s.settrainer2(mema);
					s.settrainer3(memg);
					s.setcleaner(mempp);

					employee_list.add(s);

					FileWriter fw = null;
					// list에 기록남기기
					try {
						fw = new FileWriter("employeelist.txt");
						for (int i = 0; i < employee_list.size(); i++) {
							fw.write(employee_list.get(i).getcounter());
							fw.write(",");
							fw.write(employee_list.get(i).gettrainer());
							fw.write(",");
							fw.write(employee_list.get(i).gettrainer2());
							fw.write(",");
							fw.write(employee_list.get(i).gettrainer3());
							fw.write(",");
							fw.write(employee_list.get(i).getcleaner());

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
				JOptionPane.showMessageDialog(this, "직원 정보가 등록되었습니다.", "메시지",
						JOptionPane.INFORMATION_MESSAGE);

			}
		}

		// 등록을 취소할 때
		else if (e.getSource() == bt2) {
			eframe.dispose();
			super.MmStart();
		}
	}

}
