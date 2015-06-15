import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Shopshowing extends MemberManagement implements ActionListener {
	form shopshow = new form();

	JTextArea textArea = new JTextArea();

	JButton bt2 = new JButton("나가기");

	Shopshowing() {
		shopshow.setTitle("헬스장현황");
		shopshow.setSize(500, 300);
		shopshow.setLocation(500, 300);
		shopshow.setDefaultCloseOperation(shopshow.EXIT_ON_CLOSE);

		shopshow.setVisible(true);
		shopshow.getContentPane().add(textArea);
		shopshow.setVisible(true);

		textArea.setEditable(false);
		textArea.setBounds(12, 9, 331, 240);
		shopshow.getContentPane().add(textArea);

		bt2.setBounds(366, 102, 97, 40);
		shopshow.getContentPane().add(bt2);

		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;

		try {
			shop_list.clear();
			fi = new FileInputStream("showlist.txt");
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			String str = null;
			while ((str = bfr.readLine()) != null) {
				Shop s = new Shop();
				st = new StringTokenizer(str, ",");
				s.setrunning(st.nextToken());
				s.setcycle(st.nextToken());
				s.setarm(st.nextToken());
				s.setleg(st.nextToken());
				s.setwater(st.nextToken());
				s.setupclothes(st.nextToken());
				s.setdownclothes(st.nextToken());
				shop_list.add(s);
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

		textArea.setText("***헬스장 현황 정보***\n\n" + shop_list.get(0).toString());

		bt2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bt2) {
			shopshow.dispose();
			super.MmStart();
		}
	}

}
