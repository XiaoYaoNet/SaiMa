package Saima3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JT extends Thread implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
       
	JFrameFirst jf=null;
	
	String record;                        //插入数据库的数据进行记录
	JTextField tx1; 
	JPasswordField JPF1;
	JPasswordField JPF2;
	char password[]=null;
	JFrame frm;
	JButton JB4;                          //注册按钮
	JButton JB1;                          //取消按钮
	double tmoney=0;                       //投注的金钱
	
    JT(JFrameFirst jf){
    	this.jf=jf;
    }
    JT(JButton JB1,JButton JB2,JTextField tx1,JPasswordField JPF1,JPasswordField JPF2,JFrame frm){
    	JB4=JB1;
    	this.tx1=tx1;
    	this.JPF1=JPF1;
    	this.JPF2=JPF2;
    	this.frm=frm;
    	this.JB1=JB2;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jf!=null){
		if(e.getSource()==jf.JB[0]){                   //第一匹马按钮的监听事件
			jf.JB[5].setLocation(317, 61);
			jf.JB[6].setLocation(1000, 1000);
			jf.JB[7].setLocation(1000, 1000);
			jf.JB[8].setLocation(1000, 1000);
			
	        jf.num=1;
		}
		if(e.getSource()==jf.JB[1]){                    //第二匹马按钮的监听事件
			jf.JB[5].setLocation(1000, 1000);
			jf.JB[6].setLocation(317, 61);
			jf.JB[7].setLocation(1000, 1000);
			jf.JB[8].setLocation(1000, 1000);

	        jf.num=2;
		}
		if(e.getSource()==jf.JB[2]){                    //第三匹马按钮的监听事件
			jf.JB[5].setLocation(1000, 1000);
			jf.JB[6].setLocation(1000, 1000);
			jf.JB[7].setLocation(317, 61);
			jf.JB[8].setLocation(1000, 1000);
			
			jf.num=3;
		}
		if(e.getSource()==jf.JB[3]){                      //第四匹马按钮的监听事件
			jf.JB[5].setLocation(1000, 1000);
			jf.JB[6].setLocation(1000, 1000);
			jf.JB[7].setLocation(1000, 1000);
			jf.JB[8].setLocation(317, 61);   
			
			jf.num=4;
			
		}
		if(e.getSource()==jf.JB[4]){                       //开始按钮的监听事件
			jf.mc.stop();
			record=jf.tx2.getText();
			tmoney=Double.valueOf(record);
			if(tmoney<jf.money){
				jf.frm.dispose();
				new Competition(jf.money,tmoney,jf.userName,jf.num);
			}
			else{
				JFrame frm2=new JFrame();
				frm2.setTitle("您的资金不足");                              //程序框标题
				frm2.setDefaultCloseOperation(1);      
		        frm2.setBounds(800,560,300,250);
		        frm2.setVisible(true);
		        frm2.setLayout(new BorderLayout());
			}
		}
		}
		
		if(e.getSource()==JB4){                            //注册按钮监听
			Connection con=null;                  
			java.sql.Statement st=null;
			
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
			record=tx1.getText();
	    	record+="','";
	    	password=JPF1.getPassword();
	    	record+=String.valueOf(password);
	    	String t1=String.valueOf(JPF1.getPassword());
	    	String t2=String.valueOf(JPF2.getPassword());
	    	if(t1.equals(t2)){
			try {
				frm.dispose();
				st.executeQuery("INSERT INTO userDate VALUES('"+record+"',1000);");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	    	}else{
	    		JFrame frm2=new JFrame();
				frm2.setTitle("您输入的密码不匹配");                              //程序框标题
				frm2.setDefaultCloseOperation(1);      
		        frm2.setBounds(477,260,300,250);
		        frm2.setVisible(true);
		        frm2.setLayout(new BorderLayout());
		        
		        ImageClass im=new ImageClass("bin/saima3/密码输入不同.jpg",300,250);
		        im.setBounds(0, 0, 300, 250);
		        frm2.getContentPane().add(im);
	    	}
		}
		if(e.getSource()==JB1){
			frm.dispose();
		}
	}
}

