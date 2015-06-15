import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.prism.Image;

public class MemberManagement extends form{
	
	static ArrayList<Member> member_list = new ArrayList<Member>();
	form mainframe = new form();//판제작
	JFileChooser fileopen = new JFileChooser();
	FileNameExtensionFilter fnef;//파일명
	Image pic;
	
	
	static ArrayList<Shop> shop_list = new ArrayList<Shop>();
	static ArrayList<Employee> employee_list = new ArrayList<Employee>();
	
	public MemberManagement(){
		JLabel me = new JLabel("직원 관리 :");
		me.setBounds(17, 5, 100, 30);
		mainframe.getContentPane().add(me);
		
		JLabel mh = new JLabel("헬스장 현황 관리 :");
		mh.setBounds(17, 96, 150, 30);
		mainframe.getContentPane().add(mh);
		
		JLabel mem = new JLabel("헬스장 회원 관리 :");
		mem.setBounds(17, 196, 150, 30);
		mainframe.getContentPane().add(mem);
		
		JMenuBar menuBar = new JMenuBar();
		mainframe.setJMenuBar(menuBar);//상단메뉴바생성
		menuBar.setBackground(Color.LIGHT_GRAY);
		
		JMenu menu = new JMenu("파일");//파일탭생성
		menuBar.add(menu);
		
		JMenuItem menu1 = new JMenuItem("파일생성");//새로운 파일 생성
		menu.add(menu1);
		
		JMenuItem menu2 = new JMenuItem("불러오기");//저장한 파일 불러오기
		menu.add(menu2);
		
		JMenuItem menu3 = new JMenuItem("저장하기");//저장하기
		menu.add(menu3);
		
		fnef = new FileNameExtensionFilter("텍스트파일(.txt)", "txt");//파일명 지정
		
		//파일생성탭 이벤트설정
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//새리스트만들기
				member_list.clear();
			}
		});
		//불러오기탭 이벤트설정
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  fileopen.setCurrentDirectory(new File("./src/"));
				  fileopen.addChoosableFileFilter(fnef);
				  int file = fileopen.showOpenDialog(null);
				  if (file != fileopen.APPROVE_OPTION) {
				    return;
				 }
				 String filePath = fileopen.getSelectedFile().getPath(); //파일위치
				 if(filePath != null){
					fileLoad(filePath); //파일 불러오기
				 }
			}
		});
		//저장하기탭 이벤트설정
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 fileopen.setCurrentDirectory(new File("./src/"));//파일생성
				 fileopen.setFileSelectionMode(fileopen.FILES_AND_DIRECTORIES);  
				 fileopen.addChoosableFileFilter(fnef);
				 int file = fileopen.showSaveDialog(null);//save보여주기
				 if (file == fileopen.APPROVE_OPTION) {
				  String type = fnef.getDescription().substring(6, 10);
				  //저장할곳지정
				  String savepathname = fileopen.getSelectedFile().getAbsolutePath()+type;
				  fileSave(savepathname);
				 }else{
					 return;
				 }
			}
		});
		JLabel lblNewLabel = new JLabel(new ImageIcon("./src/member.jpg"));
		lblNewLabel.setBounds(22, 10, 431, 213);
		mainframe.getContentPane().add(lblNewLabel);
	}
	//파일 불러오는 메소드
	public void fileLoad(String path){
		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;
		
		try{
				member_list.clear();
				fi = new FileInputStream(path);
				isr = new InputStreamReader(fi);
				bfr = new BufferedReader(isr);
				String str = null;
				while((str = bfr.readLine())!= null){
					Member m = new Member();
					st = new StringTokenizer(str,",");
					m.setcode(st.nextToken());
					m.setname(st.nextToken());
					m.setage(st.nextToken());
					m.setgender(st.nextToken());
					m.setphone(st.nextToken());
					m.sethclass(st.nextToken());
					m.sethealth(st.nextToken());
					member_list.add(m);
				}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				fi.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	//파일저장메소드
	public void fileSave(String path){
		 FileWriter fw = null;
		 //list에 기록남기기
		 try{
		   fw = new FileWriter(path);
		   for(int i=0; i<member_list.size(); i++){
			   fw.write(member_list.get(i).getcode());
			   fw.write(",");
			   fw.write(member_list.get(i).getname());
			   fw.write(",");
			   fw.write(member_list.get(i).getage());
			   fw.write(",");
			   fw.write(member_list.get(i).getgender());
			   fw.write(",");
			   fw.write(member_list.get(i).getphone());
			   fw.write(",");
			   fw.write(member_list.get(i).gethclass());
			   fw.write(",");
			   fw.write(member_list.get(i).gethealth());
			   fw.write("\r\n");
		   }       
	    }catch (Exception e) {
	    	e.printStackTrace();
	   }finally{
			try{
				fw.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public void MmStart(){
		mainframe.setTitle("헬스장 관리 프로그램");
		mainframe.setSize(500, 360);
		mainframe.setLocation(500, 300);
		mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
		mainframe.setVisible(true);
		
		JButton bt6 = new JButton("직원등록");
		bt6.setBackground(Color.GREEN);
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				Employeemanager em = new Employeemanager();
			}
		});
		bt6.setBounds(81, 32, 133, 49);
		mainframe.getContentPane().add(bt6);
		
		JButton bt7 = new JButton("직원확인");
		bt7.setBackground(Color.GREEN);
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				Employeeshowing es = new Employeeshowing();
			}
		});
		bt7.setBounds(260, 32, 133, 49);
		mainframe.getContentPane().add(bt7);
		
		JButton bt1 = new JButton("회원등록");
		bt1.setBackground(Color.YELLOW);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				TextForm tf = new TextForm();
			}
		});
		bt1.setBounds(22, 232, 133, 49);
		mainframe.getContentPane().add(bt1);
		
		JButton bt4 = new JButton("헬스장 현황등록");
		bt4.setBackground(Color.CYAN);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				Shopmanager sm = new Shopmanager();
			}
		});
		bt4.setBounds(81, 132, 133, 49);
		mainframe.getContentPane().add(bt4);
		
		JButton bt5 = new JButton("헬스장 현황확인");
		bt5.setBackground(Color.CYAN);
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				Shopshowing ss = new Shopshowing();
			}
		});
		bt5.setBounds(260, 132, 133, 49);
		mainframe.getContentPane().add(bt5);
		
		JButton bt2 = new JButton("회원관리");
		bt2.setBackground(Color.YELLOW);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				Manager mg = new Manager();
			}
		});
		bt2.setBounds(174, 232, 133, 49);
		mainframe.getContentPane().add(bt2);
		
		JButton bt3 = new JButton("회원검색");
		bt3.setBackground(Color.YELLOW);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				Search ms = new Search();
			}
		});
		bt3.setBounds(324, 232, 133, 49);
		mainframe.getContentPane().add(bt3);
		
	}
	
}