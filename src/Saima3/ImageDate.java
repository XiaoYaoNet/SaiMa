package Saima3;

import java.awt.Image;


public class ImageDate {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Í¼Æ¬×ø±ê
	private int x;
	private int y;
	//²ÎÈüÍ¼Æ¬
	private Image img=null;
	
	ImageDate(int x,int y,Image img){      
		this.x=x;
		this.y=y;
		this.img=img;
	}
	
	public void race(){               
		this.x+=5;
	}
	public void race2(){
		this.x-=5;
		if(x<-2500){
			x=0;
		}
	}
	public Image getImage(){
		return img;
	}
	public void setImage(Image img){
		this.img=img;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
