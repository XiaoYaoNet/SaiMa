package Saima3;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameSecond extends Thread {
	double money;
	double tmoney;
	String userName;
	JFrame JF;
	Connection con=null;
	java.sql.Statement st=null;
	int sum;                                   //用户选马的标记变量
	double count2[]=new double[4];
	FrameSecond(double money,double tmoney,String userName,JFrame JF,int sum,double count2[]){
		this.money=money;
		this.tmoney=tmoney;
		this.userName=userName;
		this.JF=JF;
		this.sum=sum;
		this.count2=count2;
	}
	public void run(){
		int a=0;
		for(int i=0;i<3;i++){
			if(count2[i]>count2[i+1])
				a=i+1;
		}
		if(a==sum){
			money+=(tmoney*0.2);
		}else{
			money-=(tmoney*0.2);
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=TEXT1","申四","1234");
			st=con.createStatement();
			st.executeQuery("UPDATE userDate SET MONEY1="+money+"where userName='"+userName+"'");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JFrameFirst cpt=new JFrameFirst(userName);
		cpt.create();
		JF.dispose();
		if(a==sum){
			JFrame frm2=new JFrame();
			frm2.setDefaultCloseOperation(1);      
	        frm2.setBounds(515,260,200,159);
	        frm2.setVisible(true);
	        frm2.setLayout(new BorderLayout());
	        
	        JButton jb=new JButton(new ImageIcon("bin/saima3/获得胜利.gif"));
	        jb.setBounds(0, 0, 300, 250);
	        frm2.getContentPane().add(jb);
		}
		else{
			JFrame frm2=new JFrame();
			frm2.setDefaultCloseOperation(1);      
	        frm2.setBounds(515,260,200,159);
	        frm2.setVisible(true);
	        frm2.setLayout(new BorderLayout());
	        
	        JButton jb=new JButton(new ImageIcon("bin/saima3/输了.jpg"));
	        jb.setBounds(0, 0, 300, 250);
	        frm2.getContentPane().add(jb);
	        
	        
		}
	}

}
