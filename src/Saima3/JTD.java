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

public class JTD  implements ActionListener {                //�Ե�½����Ŀؼ����м���
	String userName=null;           //�洢�û���
	char[] password3=null;          //�洢��������õ�����
	JFrameFirst jd=null;                 
	denglu dl=null;                      //��½��
	JTD(denglu dl){                 //JTD��Ĺ��캯������
		this.dl=dl;
	}
	JTD(JFrameFirst jd){
		this.jd=jd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;                        //�������ݿ�����
		java.sql.Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=TEXT1","����","1234");
			st=con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(dl!=null){
		if(e.getSource()==dl.JB1){                      //������½��ť�������¼�
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
					if(dl.password.equals(dl.password2)){           //���������ƥ��
						dl.mc.stop();
						jd.create();
						dl.frm.dispose();
					}else{
						JFrame frm2=new JFrame();
						frm2.setTitle("����������벻��ȷ");                              //��������
						frm2.setDefaultCloseOperation(1);      
				        frm2.setBounds(515,260,300,250);
				        frm2.setVisible(true);
				        frm2.setLayout(new BorderLayout());
				        
				        ImageClass im=new ImageClass("bin/saima3/�����������.jpg",300,250);
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
		if(e.getSource()==dl.JB2){                               //����ע�ᰴť�������¼�
			JFrame frm=new JFrame();                             //ע������
			frm.setTitle("Racing Horseע���");                              
			frm.setDefaultCloseOperation(1);      
	        frm.setBounds(230,130,815,515);
	        frm.setVisible(true);
	        frm.setLayout(new BorderLayout());
			
	        ImageClass img=new ImageClass("bin/saima3/ע��.jpg",800,480);   //ע�����뱳��
	        img.setBounds(0, 0, 800, 480);
	        img.setLayout(null);
	        frm.getContentPane().add(img,BorderLayout.CENTER);
	        
	        JTextField tx1=new JTextField();                        //�û�������༭��
	        tx1.setText("�������û���");
	        tx1.setBounds(350, 140, 170, 30);
	        
	        JPasswordField JPF1=new JPasswordField();                //���������ı���
	         JPF1.setEchoChar('*');
	         JPF1.setBounds(350, 190, 170, 30);
	         
	         JPasswordField JPF2=new JPasswordField();                //ȷ�����������ı���
	         JPF2.setEchoChar('*');
	         JPF2.setBounds(350, 232, 170, 30);
	        
	        JButton JB1=new JButton(new ImageIcon("bin/saima3/�ύ.jpg"));                         //�ύ��ť
	        JB1.setBounds(351,284,80, 32);
	        
	        JButton JB2=new JButton(new ImageIcon("bin/saima3/ȡ��.jpg"));                         //ȡ����ť
	        JB2.setBounds(436, 284, 80, 32);
	        
	        img.add(tx1);                                            //���������ӿؼ�
	        img.add(JB1);
	        img.add(JB2);
	        img.add(JPF1);
	        img.add(JPF2);
	        
	        JB1.addActionListener(new JT(JB1,JB2,tx1,JPF1,JPF2,frm));         //�ύ��ť��Ӽ�����
	        JB2.addActionListener(new JT(JB1,JB2,tx1,JPF1,JPF2,frm));         //ȡ����ť��Ӽ�����
	        
	        
		}//JB2if
		}
		if(jd!=null){
			if(e.getSource()==jd.JB[9]){                      //ע����ť�ļ����¼�
				try {
					st.executeQuery("delete from userDate where userName='"+jd.userName+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jd.frm.dispose();
				jd.mc.stop();
				new denglu().main1(new music("bin/saima3/��½.wav"));
			}
		}
		
		//dl��if
		
	}

}
