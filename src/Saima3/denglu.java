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
//��½����
	JTextField tx;                                             //�û��������
	JPasswordField JPF;                                        //�����
	String password2;
	String password;
	JFrame frm;                                                //��һ������
	ImageClass img;                                            //���뱳��ͼƬ��
	JPanel JP;                                                 //װ�ر��������Կؼ������
	JButton JB1;                                                //��½��ť
	JButton JB2;                                                 //ע�ᰴť                                      
	music mc;                                                   //����������
	public void main1(music mc){
		
		frm=new JFrame();                               
		frm.setTitle("Racing Horse��½����");                              //��������
		frm.setDefaultCloseOperation(1);      
        frm.setBounds(230,130,815,515);
        frm.setVisible(true);
        frm.setLayout(new BorderLayout());
        
        this.mc=mc;
        
        img=new ImageClass("bin/saima3/��Ƭ2.jpg",800,480);  
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
        
        JPF=new JPasswordField();                                  //�����
       JPF.setEchoChar('*');
        JPF.setBounds(398, 187, 171, 32);
        JPF.setVisible(true);
        
        JB1=new JButton(new ImageIcon("bin/saima3/��½.jpg"));      
        JB1.setBounds(395,232, 82, 34);
        
        
        JB2=new JButton(new ImageIcon("bin/saima3/ע�ᰴť.jpg"));                           
        JB2.setBounds(485,233, 83, 33);
        
        JP.add(tx);                                                //Ϊ�������ӿؼ�
        JP.add(JPF);
        JP.add(JB1);
        JP.add(JB2);
        
        
        JB1.addActionListener(new JTD(this));// ��½��ť��Ӽ�����
        JB2.addActionListener(new JTD(this));                             //ע�ᰴť��Ӽ�����
	}

}
