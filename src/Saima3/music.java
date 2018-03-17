package Saima3;

import java.applet.Applet;
import java.applet.AudioClip;

public class music {
	AudioClip clip = null;
	@SuppressWarnings("deprecation")
	public music(String s) {
	    try {
	      setAudioClip(Applet.newAudioClip( (new java.io.File(s)).toURL()));
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
	    loop();
	}
	 public AudioClip getAudioClip() {
		  return this.clip;
		}

		public void setAudioClip(AudioClip clip) {
		  this.clip = clip;
		}
		void loop() {
		  if (getAudioClip() != null) {
		    getAudioClip().loop();
		  }
		}

		void stop() {
		   if (getAudioClip() != null) {
		    getAudioClip().stop();
		  }
		}
}
