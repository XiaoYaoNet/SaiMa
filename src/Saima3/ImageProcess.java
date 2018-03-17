package Saima3;

import java.util.Calendar;

import javax.swing.JFrame;
public class ImageProcess implements Runnable {
	private ImageDate hdate;         //本类中实例化的图片类
	public double time2;             //子线程运行的时间
	public ImageLoad ld;            
	int j;                           //对子程序进行标记的变量
	double money,tmoney;
	String userName;
	JFrame JF;
	int sum;                          //用户选马的标记变量
	music mc;
	ImageProcess(ImageDate hdate,ImageLoad ld,int j,double money,double tmoney,String userName,JFrame JF,int sum,music mc){
		this.hdate=hdate;
		this.ld=ld;
		this.j=j;
		this.money=money;
		this.tmoney=tmoney;
		this.userName=userName;
		this.JF=JF;
		this.sum=sum;
		this.mc=mc;
	}
	ImageProcess(ImageDate hdate,int j){
		this.j=j;
		this.hdate=hdate;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		double x=cal.get(Calendar.SECOND);
		if(j<1){
			for(int i=0;i<250;i++)
			{
				this.hdate.race2();
				try {
					Thread.sleep((int)(Math.random()*200));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			for(int i=0;i<230;i++)
			{
				this.hdate.race();
				
				try {
					Thread.sleep((int)(Math.random()*200));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Calendar cal2=Calendar.getInstance();
			double y=cal2.get(Calendar.SECOND);
			time2=y-x;
			ld.count2[j-1]=time2;
			if(ld.count2[0]!=0&&ld.count2[1]!=0&&ld.count2[2]!=0&&ld.count2[3]!=0&&hdate.getX()==1150){
				mc.stop();
				FrameSecond fs=new FrameSecond(money,tmoney,userName,JF,sum,ld.count2); 
				fs.start();
			}
		}
	}

}
