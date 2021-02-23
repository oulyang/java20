package m2d232;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;





public class Test2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Timer t=new Timer();
		//Timer t=new Timer(true);守护线程
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ft=sdf.parse("2021-02-23 14:55:30");
		//t.schedule(定时任务, 第一次执行时间，间隔时间);
		t.schedule(new LogTimerTask() , ft,1000*5);
	}

}

class LogTimerTask extends TimerTask{
	public void run() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strTime=sdf.format(new Date());
		System.out.println(strTime);
	}
}