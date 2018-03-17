package Saima3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JTD  implements ActionListener {                //对登陆界面的控件进行监听
	String userName=null;           //存储用户名
	char[] password3=null;          //存储从密码框获得的密码
	JFrameFirst jd=null;                 
	denglu dl=null;                      //登陆类
	JTD(denglu dl){                 //JTD类的构造函数重载
		this.dl=dl;
	}
	JTD(JFrameFirst jd){
		this.jd=jd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;                        //进行数据库链接
		java.sql.Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=TEXT1","申四","1234");
			st=con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(dl!=null){
		if(e.getSource()==dl.JB1){                      //单击登陆按钮触发的事件
			userName=dl.tx.getText();                   
			jd=new JFrameFirst(userName);               
			password3=dl.JPF.getPassword();
			dl.password=String.valueOf(password3);
			
			try {
				rs=st.executeQuery("SELECT password FROM userDate where userName='"+userName+"'");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				while(rs.next()){
				try {
					dl.password2=rs.getString("password");
					dl.password2=dl.password2.trim();
					if(dl.password.equals(dl.password2)){           //对密码进行匹配
						dl.mc.stop();
						jd.create();
						dl.frm.dispose();
					}else{
						JFrame frm2=new JFrame();
						frm2.setTitle("您输入的密码不正确");                              //程序框标题
						frm2.setDefaultCloseOperation(1);      
				        frm2.setBounds(515,260,300,250);
				        frm2.setVisible(true);
				        frm2.setLayout(new BorderLayout());
				        
				        ImageClass im=new ImageClass("bin/saima3/密码输入错误.jpg",300,250);
				        im.setBounds(0, 0, 300, 250);
				        frm2.getContentPane().add(im);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}//JB1if
		if(e.getSource()==dl.JB2){                               //单击注册按钮触发的事件
			JFrame frm=new JFrame();                             //注册程序框
			frm.setTitle("Racing Horse注册框");                              
			frm.setDefaultCloseOperation(1);      
	        frm.setBounds(230,130,815,515);
	        frm.setVisible(true);
	        frm.setLayout(new BorderLayout());
			
	        ImageClass img=new ImageClass("bin/saima3/注册.jpg",800,480);   //注册框插入背景
	        img.setBounds(0, 0, 800, 480);
	        img.setLayout(null);
	        frm.getContentPane().add(img,BorderLayout.CENTER);
	        
	        JTextField tx1=new JTextField();                        //用户名输入编辑框
	        tx1.setText("请输入用户名");
	        tx1.setBounds(350, 140, 170, 30);
	        
	        JPasswordField JPF1=new JPasswordField();                //密码输入文本框
	         JPF1.setEchoChar('*');
	         JPF1.setBounds(350, 190, 170, 30);
	         
	         JPasswordField JPF2=new JPasswordField();                //确认密码输入文本框
	         JPF2.setEchoChar('*');
	         JPF2.setBounds(350, 232, 170, 30);
	        
	        JButton JB1=new JButton(new ImageIcon("bin/saima3/提交.jpg"));                         //提交按钮
	        JB1.setBounds(351,284,80, 32);
	        
	        JButton JB2=new JButton(new ImageIcon("bin/saima3/取消.jpg"));                         //取消按钮
	        JB2.setBounds(436, 284, 80, 32);
	        
	        img.add(tx1);                                            //背景面板添加控件
	        img.add(JB1);
	        img.add(JB2);
	        img.add(JPF1);
	        img.add(JPF2);
	        
	        JB1.addActionListener(new JT(JB1,JB2,tx1,JPF1,JPF2,frm));         //提交按钮添加监听类
	        JB2.addActionListener(new JT(JB1,JB2,tx1,JPF1,JPF2,frm));         //取消按钮添加监听类
	        
	        
		}//JB2if
		}
		if(jd!=null){
			if(e.getSource()==jd.JB[9]){                      //注销按钮的监听事件
				try {
					st.executeQuery("delete from userDate where userName='"+jd.userName+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jd.frm.dispose();
				jd.mc.stop();
				new denglu().main1(new music("bin/saima3/登陆.wav"));
			}
		}
		
		//dl的if
		
	}

}
