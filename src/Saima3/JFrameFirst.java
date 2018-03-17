package Saima3;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class JFrameFirst extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton JB[]=new JButton[10];    //  按钮数组
	JTextField tx2;
	String userName;                //对用户名进行传递
	int num=1;                     //对用户所选的马进行标记
	JFrame frm;
	ImageClass jpm;                //插入背景图片
	JPanel text;                   //此框体下的主面板
	JPanel jpb;                     //显示马匹图片的按钮
	Connection con=null;                  
	java.sql.Statement st=null;
	ResultSet rs=null;
	double money=0;                        //用户当前金钱
	music mc;
	JFrameFirst(String userName){                              //JFrameFirst类构造函数重载
		mc=new music("bin/saima3/跑马场.wav");
		this.userName=userName;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=TEXT1","申四","1234");
			st=con.createStatement();
			rs=st.executeQuery("SELECT money1 FROM userDate where userName='"+userName+"'");
			if(rs.next()){
				money=rs.getInt("money1");
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public void create(){
		frm=new JFrame();                                      //进行选马阶段的框体构建
		frm.setTitle("Racing Horse");                              
		frm.setDefaultCloseOperation(1);      
        frm.setBounds(230,130,815,515);
        frm.setVisible(true);
        frm.setLayout(null);
        mc.loop();
        
        jpm=new ImageClass("bin/saima3/投注.jpg",800,480);
        jpm.setBounds(0, 0, 800, 480);
        jpm.setLayout(null);
        
        text=new JPanel();
        text.setBounds(0, 0, 800, 480);
        text.setLayout(null);
        
        JLabel jb=new JLabel();
        jb.setText(String.valueOf(money));
        jb.setBounds(696, 35, 140, 30);
        jb.setBackground(Color.WHITE);
        jb.setFont(new Font("",Font.BOLD,25));
        
        JB[0]=new JButton(new ImageIcon("bin/saima3/0002.jpg"));
        JB[1]=new JButton(new ImageIcon("bin/saima3/0003.jpg"));
        JB[2]=new JButton(new ImageIcon("bin/saima3/0004.jpg"));
        JB[3]=new JButton(new ImageIcon("bin/saima3/0005.jpg"));
        JB[4]=new JButton(new ImageIcon("bin/saima3/开始按钮.jpg"));
        JB[5]=new JButton(new ImageIcon("bin/saima3/00002.gif"));
        JB[6]=new JButton(new ImageIcon("bin/saima3/00003.gif"));
        JB[7]=new JButton(new ImageIcon("bin/saima3/00004.gif"));
        JB[8]=new JButton(new ImageIcon("bin/saima3/00005.gif"));
        JB[9]=new JButton(new ImageIcon("bin/saima3/注销.jpg"));
        JB[0].setBounds(128, 254, 120, 54);
        JB[1].setBounds(275, 254, 120, 54);
        JB[2].setBounds(423, 254, 120, 54);
        JB[3].setBounds(571, 254, 120, 54);
        JB[4].setBounds(300, 397, 217, 52);
        JB[5].setBounds(317, 61, 185, 162);
        JB[6].setBounds(1000, 1000, 185, 162);
        JB[7].setBounds(1000, 1000, 185, 162);
        JB[8].setBounds(1000, 1000, 185, 162);
        JB[9].setBounds(0,0, 120, 54);

        jpm.add(JB[0]);
        jpm.add(JB[1]);
        jpm.add(JB[2]);
        jpm.add(JB[3]);
        jpm.add(JB[4]);
        jpm.add(JB[5]);
        jpm.add(JB[6]);
        jpm.add(JB[7]);
        jpm.add(JB[8]);
        jpm.add(JB[9]);
        jpm.add(jb);
        frm.getContentPane().add(jpm);
        
        tx2=new JTextField();
        tx2.setBounds(432,346, 90, 34);
        jpm.add(tx2);
        frm.validate();
                                                                                                                
        
        for(int i=0;i<5;i++){
        	JB[i].addActionListener(new JT(this));
        }
        JB[9].addActionListener(new JTD(this));
	}
}
