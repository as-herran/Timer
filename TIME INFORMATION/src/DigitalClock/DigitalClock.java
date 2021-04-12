/**
 * This is an application to display the hour, date, week of the year and day of the year.
 * 
 */

/**
 * @author alexs
 */
package DigitalClock;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Class to set up a new clock-application
@SuppressWarnings("serial")
public class DigitalClock extends JFrame{
	
	JFrame frame;
	JLabel image;
	JLabel clock;
	JLabel date_txt;
	JLabel date;
	JLabel weekOfTheYear_txt;
	JLabel weekOfTheYear;
	JLabel dayOfTheYear_txt;
	JLabel dayOfTheYear;
	
	ImageIcon img;
	
	ClockThread ct;
	
	SimpleDateFormat formater = new SimpleDateFormat("dd/MM");
	String now;
	
	
	public DigitalClock() {
		
		// Creating/configuring the frame
		frame = new JFrame("NEW APP");
		frame.setLayout(null);
		frame.setSize(557, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLocation(100, 100);
		
		// Setting the icon of the application
		img = new ImageIcon("reloj2.jpg");
		frame.setIconImage(img.getImage());
		
		// Creating the label which contains the image
		image = new JLabel();
		image.setIcon(img);
		image.setBounds(75, 25, 407, 300);
		frame.add(image);
		
		// Creating the label which contains the clock
		clock = new JLabel();
		clock.setBounds(90, 340, 450, 80);
		clock.setForeground(Color.WHITE);
		clock.setFont(new Font("Arial", Font.PLAIN, 96));
		frame.add(clock);
		
		// Creating the label text for date
		date_txt = new JLabel("Fecha");
		date_txt.setFont(new Font("Arial", Font.PLAIN, 24));
		date_txt.setForeground(Color.WHITE);
		date_txt.setBounds(90, 420, 100, 20);
		frame.add(date_txt);
		
		// Creating the label with the date
		now = formater.format(new Date());
		date = new JLabel(now);
		date.setFont(new Font("Arial", Font.PLAIN, 48));
		date.setForeground(Color.WHITE);
		date.setBounds(65, 440, 130, 50);
		frame.add(date);
		
		// Creating the label text for week
		weekOfTheYear_txt = new JLabel("Semana");
		weekOfTheYear_txt.setFont(new Font("Arial", Font.PLAIN, 24));
		weekOfTheYear_txt.setForeground(Color.WHITE);
		weekOfTheYear_txt.setBounds(255, 420, 100, 20);
		frame.add(weekOfTheYear_txt);		
		
		// Creating the label with the week of the year
		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(new Date());
		weekOfTheYear= new JLabel(Integer.toString(dateCalendar.get(Calendar.WEEK_OF_YEAR)));
		weekOfTheYear.setFont(new Font("Arial", Font.PLAIN, 48));
		weekOfTheYear.setForeground(Color.WHITE);
		weekOfTheYear.setBounds(275, 440, 100, 50);
		frame.add(weekOfTheYear);
		
		// Creating the label text for day
		dayOfTheYear_txt = new JLabel("Día");
		dayOfTheYear_txt.setFont(new Font("Arial", Font.PLAIN, 24));
		dayOfTheYear_txt.setForeground(Color.WHITE);
		dayOfTheYear_txt.setBounds(415, 420, 100, 20);
		frame.add(dayOfTheYear_txt);	
		
		
		// Creating the label with the day of the year
		dayOfTheYear = new JLabel(Integer.toString(dateCalendar.get(Calendar.DAY_OF_YEAR)));
		dayOfTheYear.setFont(new Font("Arial", Font.PLAIN, 48));
		dayOfTheYear.setForeground(Color.WHITE);
		dayOfTheYear.setBounds(395, 440, 100, 50);
		frame.add(dayOfTheYear);
		
		
		
		// Creating the object clock
		ct = new ClockThread(this);
		// Making visible the frame
		frame.setVisible(true);
		
		
	
	}
	
	
	public static void main(String[] args) {
		new DigitalClock();
	}

}
