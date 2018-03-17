package Saima3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImageClass extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;                                       //插取背景图片路径
    int width,height;                               //图片高度大小
    private Image img;                              
    MediaTracker mt=new MediaTracker(this);
    ImageClass(String s,int width,int height){
    	this.s=s;
    	this.width=width;
    	this.height=height;
    	setOpaque(false);
    	setLayout(null);
    }
    public void paintComponent(Graphics g){
        img=Toolkit.getDefaultToolkit().getImage(s);
		mt.addImage(img, 1);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	g.drawImage(img, 0,0,width,height,Color.white,null);
    	super.paintComponent(g);
    }  
}
