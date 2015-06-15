import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Search extends MemberManagement implements ActionListener {
	form Frame = new form();
	JButton sCode = new JButton("회원 코드");
	JButton sName = new JButton("회원 이름");
	JButton sPhone = new JButton("전화 번호");
	JButton sAll = new JButton("전체 회원");
	JButton sCancel = new JButton("나가기");
	JTextArea textArea = new JTextArea();

	public Search() {
		Frame.setTitle("회원검색");
		Frame.setSize(477, 293);
		Frame.setLocation(550, 350);
		Frame.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("검색");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(354, 3, 43, 32);
		Frame.getContentPane().add(lblNewLabel);

		sCode.setBounds(354, 40, 95, 32);
		Frame.getContentPane().add(sCode);

		sName.setBounds(354, 82, 95, 32);
		Frame.getContentPane().add(sName);

		sPhone.setBounds(354, 124, 95, 32);
		Frame.getContentPane().add(sPhone);

		sAll.setBounds(354, 166, 95, 32);
		Frame.getContentPane().add(sAll);

		sCancel.setBounds(354, 208, 95, 32);
		Frame.getContentPane().add(sCancel);

		textArea.setEditable(false);
		textArea.setBounds(12, 9, 331, 234);
		Frame.getContentPane().add(textArea);

		JList list_1 = new JList();
		list_1.setBounds(242, 48, 1, 1);
		Frame.getContentPane().add(list_1);

		Frame.setVisible(true);

		sCode.addActionListener(this);
		sName.addActionListener(this);
		sPhone.addActionListener(this);
		sAll.addActionListener(this);
		sCancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		int dataCnt = 1;
		String[] nameCollection = null;
		String nameCode = null;
		if (e.getSource() == sCode) {
			String code = JOptionPane.showInputDialog("검색할 코드을 입력하세요");
			if (code == null) {
				return;
			}
			if (member_list.size() != 0) {
				for (int i = 0; i < member_list.size(); i++) {
					if (code.equals(member_list.get(i).getcode())) {
						textArea.setText("회원 코드 : "
								+ member_list.get(i).getcode() + "\n\n회원 이름 : "
								+ member_list.get(i).getname() + "\n\n회원 나이 : "
								+ member_list.get(i).getage() + "\n\n회원 성별 : "
								+ member_list.get(i).getgender()
								+ "\n\n회원 전화번호 : "
								+ member_list.get(i).getphone()
								+ "\n\n회원 유형 : "
								+ member_list.get(i).gethclass()
								+ "\n\n건강 상태: "
								+ member_list.get(i).gethealth());
						break;
					}
					dataCnt++;
				}
				if (dataCnt == member_list.size() + 1) {
					JOptionPane.showMessageDialog(this, "일치하는 회원이 없습니다.",
							"메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원이 없습니다.", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sName) {
			int cnt = 0;
			String name = JOptionPane.showInputDialog("검색할 이름을 입력하세요");
			if (name == null) {
				return;
			}
			if (member_list.size() != 0) {
				for (int i = 0; i < member_list.size(); i++) {
					if (name.equals(member_list.get(i).getname())) {
						cnt++;
					}
				}
				if (cnt > 1) {
					nameCollection = new String[cnt];
					int namecnt = 0;
					for (int i = 0; i < member_list.size(); i++) {
						if (name.equals(member_list.get(i).getname())) {
							nameCollection[namecnt] = member_list.get(i)
									.getcode()
									+ ". "
									+ member_list.get(i).getname()
									+ " "
									+ member_list.get(i).getphone();
							namecnt++;
						}
					}
					nameCode = (String) JOptionPane.showInputDialog(this,
							"같은 이름이 존재합니다.\n", "메시지",
							JOptionPane.INFORMATION_MESSAGE, null,
							nameCollection, nameCollection[0]);
					
					if (nameCode == null) {
						return;
					}
					nameCode = nameCode.substring(0, 4);
					for (int i = 0; i < member_list.size(); i++) {
						if ((nameCode.equals(member_list.get(i).getcode()))) {
							textArea.setText("회원 코드 : "
									+ member_list.get(i).getcode()
									+ "\n\n회원 이름 : "
									+ member_list.get(i).getname()
									+ "\n\n회원 나이 : "
									+ member_list.get(i).getage()
									+ "\n\n회원 성별 : "
									+ member_list.get(i).getgender()
									+ "\n\n회원 전화번호 : "
									+ member_list.get(i).getphone()
									+ "\n\n회원 유형 : "
									+ member_list.get(i).gethclass()
									+ "\n\n건강 상태 : "
									+ member_list.get(i).gethealth());
							
							
						}
					}
				} else {
					for (int i = 0; i < member_list.size(); i++) {
						if (name.equals(member_list.get(i).getname())) {
							textArea.setText("회원 코드 : "
									+ member_list.get(i).getcode()
									+ "\n\n회원 이름 : "
									+ member_list.get(i).getname()
									+ "\n\n회원 나이 : "
									+ member_list.get(i).getage()
									+ "\n\n회원 성별 : "
									+ member_list.get(i).getgender()
									+ "\n\n회원 전화번호 : "
									+ member_list.get(i).getphone()
									+ "\n\n회원 유형 : "
									+ member_list.get(i).gethclass()
									+ "\n\n건강 상태 : "
									+ member_list.get(i).gethealth());
							break;
						}
						dataCnt++;
					}
					if (dataCnt == member_list.size() + 1) {
						JOptionPane.showMessageDialog(this, "일치하는 회원이 없습니다.",
								"메시지", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원이 없습니다.", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sPhone) {
			String phone = JOptionPane.showInputDialog("검색할 전화번호를 입력하세요");
			if (phone == null) {
				return;
			}
			if (member_list.size() != 0) {
				for (int i = 0; i < member_list.size(); i++) {
					if (phone.equals(member_list.get(i).getphone())) {
						textArea.setText("회원 코드 : "
								+ member_list.get(i).getcode() + "\n\n회원 이름 : "
								+ member_list.get(i).getname() + "\n\n회원 나이 : "
								+ member_list.get(i).getage() + "\n\n회원 성별 : "
								+ member_list.get(i).getgender()
								+ "\n\n회원 전화번호 : "
								+ member_list.get(i).getphone()
								+ "\n\n회원 유형 : "
								+ member_list.get(i).gethclass()
								+ "\n\n건강 상태 : "
								+ member_list.get(i).gethealth());
						break;
					}
					dataCnt++;
				}
				if (dataCnt == member_list.size() + 1) {
					JOptionPane.showMessageDialog(this, "일치하는 회원이 없습니다.",
							"메시지", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원이 없습니다.", "메시지",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sAll) {
			AllSearch al = new AllSearch();
		} else if (e.getSource() == sCancel) {
			Frame.dispose();
			super.MmStart();
		}
	}

	public class AllSearch extends MemberManagement {
		form allsearch = new form();
		private JTable table_1;

		public AllSearch() {
			allsearch.setTitle("전체회원");
			allsearch.setSize(700, 448);
			allsearch.setLocation(350, 250);
			allsearch.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			allsearch.getContentPane().setLayout(null);

			JTable table = null;
			String[] column = { "코드", "이름", "나이", "성별", "전화번호", "회원유형", "건강상태" };
			Object[][] ob = new Object[member_list.size()][7];
			for (int i = 0; i < member_list.size(); i++) {
				ob[i][0] = member_list.get(i).getcode();
				ob[i][1] = member_list.get(i).getname();
				ob[i][2] = member_list.get(i).getage();
				ob[i][3] = member_list.get(i).getgender();
				ob[i][4] = member_list.get(i).getphone();
				ob[i][5] = member_list.get(i).gethclass();
				ob[i][6] = member_list.get(i).gethealth();
			}

			table = new JTable(ob, column);
			table.getColumn("코드").setPreferredWidth(50);
			table.getColumn("이름").setPreferredWidth(50);
			table.getColumn("나이").setPreferredWidth(50);
			table.getColumn("성별").setPreferredWidth(50);
			table.getColumn("전화번호").setPreferredWidth(100);
			table.getColumn("회원유형").setPreferredWidth(100);
			table.getColumn("건강상태").setPreferredWidth(260);
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for (int i = 0; i < tcm.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}

			table.setSize(660, 387);

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setSize(660, 387);
			scrollPane.setLocation(12, 10);
			scrollPane.setPreferredSize(new Dimension(369, 203));
			allsearch.getContentPane().add(scrollPane);

			allsearch.setVisible(true);
		}
	}

}
