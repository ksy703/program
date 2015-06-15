import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Employeeshowing extends MemberManagement implements ActionListener {
	form show = new form();
	JTextArea textArea = new JTextArea();

	JButton bt2 = new JButton("나가기");

	Employeeshowing() {
		show.setTitle("직원현황");
		show.setSize(500, 300);
		show.setLocation(500, 300);
		show.setDefaultCloseOperation(show.EXIT_ON_CLOSE);

		show.setVisible(true);
		show.getContentPane().add(textArea);
		show.setVisible(true);

		textArea.setEditable(false);
		textArea.setBounds(12, 9, 331, 240);
		show.getContentPane().add(textArea);

		bt2.setBounds(368, 102, 97, 40);
		show.getContentPane().add(bt2);

		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;

		try {
			
			fi = new FileInputStream("employeelist.txt");
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			String str = null;
			while ((str = bfr.readLine()) != null) {
				Employee s = new Employee();
				st = new StringTokenizer(str, ",");
				s.setcounter(st.nextToken());
				s.settrainer(st.nextToken());
				s.settrainer2(st.nextToken());
				s.settrainer3(st.nextToken());
				s.setcleaner(st.nextToken());

				employee_list.add(s);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < employee_list.size(); i++) {
			String a = employee_list.get(i).toString();
			textArea.setText(a);

		}

		bt2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bt2) {
			show.dispose();
			super.MmStart();
		}
	}
}
