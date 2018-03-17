package Saima3;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageLoad extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MediaTracker mt=new MediaTracker(this);
	ImageDate hdate[]=new ImageDate[5];                //����������ͼƬ������
	ImageProcess hprocess[]=new ImageProcess[5];       //�ƶ�ͼƬ��5���߳̽ӿ�����
	Thread thread[]=new Thread[5];                     //�ƶ�ͼƬ��5���߳�����
	double[] count2=new double[4];                    //��¼��ƥ�ܵ�ʱ�������
	double tmoney;                                    //Ͷע�Ľ�Ǯ
	double money;                                    //�˻����
	String userName;                                 //��½���û���
	JFrame JF;                                       //�������ص�������
	int sum;                                         //����û�ѡ�����ƥ
	music mc;
	ImageLoad(double tmoney,double money,String userName,JFrame JF,int sum){
		synchronized(this){
			this.tmoney=tmoney;
			this.money=money;
			this.userName=userName;
			this.JF=JF;
			this.sum=sum;
			mc=new music("bin/saima3/����.wav");
			mc.loop();
			Image IMG=Toolkit.getDefaultToolkit().getImage("bin/saima3/�ܵ�.jpg");
		    hdate[0]=new ImageDate(0,0,IMG);
		    hprocess[0]=new ImageProcess(hdate[0],0);
		    thread[0]=new Thread(hprocess[0]);
		    thread[0].start();
		    for(int i=1;i<5;i++){
			    Image img=Toolkit.getDefaultToolkit().getImage("bin/saima3/0000"+(i+1)+".gif");
			    hdate[i]=new ImageDate(0,(i-1)*70+250,img);
			
			    hprocess[i]=new ImageProcess(hdate[i],this,i,money,tmoney,userName,JF,sum,mc);
			    thread[i]=new Thread(hprocess[i]);
			    thread[i].start();
		    }
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<hdate.length;i++)
		{
			mt.addImage(hdate[i].getImage(), 1);
			try {
				mt.waitForAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(hdate[i].getImage(), hdate[i].getX(), hdate[i].getY(), this);
		}
	}

}
