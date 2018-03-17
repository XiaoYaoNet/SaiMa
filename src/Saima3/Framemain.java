package Saima3;

import java.sql.SQLException;

public class Framemain {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		denglu d1=new denglu();
		music mc=new music("bin/saima3/≈‹¬Ì≥°.wav");
		d1.main1(mc);
		//mc.stop();
		mc.loop();
		//DisplayDemo DD=new DisplayDemo();
	}

}
