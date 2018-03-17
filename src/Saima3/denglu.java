package Saima3;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class denglu extends JFrame{                             /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//登陆框类
	JTextField tx;                                             //用户名输入框
	JPasswordField JPF;                                        //密码框
	String password2;
	String password;
	JFrame frm;                                                //第一个框体
	ImageClass img;                                            //插入背景图片类
	JPanel JP;                                                 //装载本框体所以控件的面板
	JButton JB1;                                                //登陆按钮
	JButton JB2;                                                 //注册按钮                                      
	music mc;                                                   //背景音乐类
	public void main1(music mc){
		
		frm=new JFrame();                               
		frm.setTitle("Racing Horse登陆界面");                              //程序框标题
		frm.setDefaultCloseOperation(1);      
        frm.setBounds(230,130,815,515);
        frm.setVisible(true);
        frm.setLayout(new BorderLayout());
        
        this.mc=mc;
        
        img=new ImageClass("bin/saima3/底片2.jpg",800,480);  
        img.setBounds(0, 0, 800, 480);
        frm.getContentPane().add(img);
        
        
        JP=new JPanel();                                   
        JP.setLayout(null);
        JP.setOpaque(false);
        JP.setBounds(0, 0, 800,480);
        img.add(JP);
        
        
        tx=new JTextField();                                       
        tx.setBounds(398, 147, 171, 32);
        tx.setVisible(true);
        
        JPF=new JPasswordField();                                  //密码框
       JPF.setEchoChar('*');
        JPF.setBounds(398, 187, 171, 32);
        JPF.setVisible(true);
        
        JB1=new JButton(new ImageIcon("bin/saima3/登陆.jpg"));      
        JB1.setBounds(395,232, 82, 34);
        
        
        JB2=new JButton(new ImageIcon("bin/saima3/注册按钮.jpg"));                           
        JB2.setBounds(485,233, 83, 33);
        
        JP.add(tx);                                                //为面板上添加控件
        JP.add(JPF);
        JP.add(JB1);
        JP.add(JB2);
        
        
        JB1.addActionListener(new JTD(this));// 登陆按钮添加监听类
        JB2.addActionListener(new JTD(this));                             //注册按钮添加监听类
	}

}
