package DigitalClock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread extends Thread{
	
	DigitalClock dc;
	String time;
	SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");
	
	public ClockThread(DigitalClock dc) {
		this.dc = dc;
		start();
	
		
	}
	
	public void run() {
		while (true) {
			time =  dtFormat.format(new Date());
			dc.clock.setText(time);
			
		}
	}

}
