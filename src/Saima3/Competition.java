package Saima3;


import javax.swing.JFrame;

public class Competition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageLoad IL;
	double tmoney;
	double money;
	String userName;
	int sum;
	Competition(double money,double tmoney,String userName,int sum){
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Racing Horse»¸¬Ì≥°");
		this.tmoney=tmoney;
		this.money=money;
		this.userName=userName;
		this.sum=sum;
		IL=new ImageLoad(tmoney,money,userName,this,sum);
		this.add(IL);
		this.setSize(2000,1000);
		this.setVisible(true);
	}
}
