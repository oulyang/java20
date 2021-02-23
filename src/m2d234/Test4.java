package m2d234;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用wait()和notify()方法实现“生产者消费者模式”
 * 
 * wait()和notify()方法是普通对象的方法，不是线程的方法
 * 
 * wait()和notify()方法作用在同一个对象上，有线程安全问题
 * 
 * wait()：让正在对象上的活动线程进入等待状态，并释放线程之前占有的锁
 * 
 * notify()：唤醒等待中的线程，不会释放锁
 * @author yyds
 *
 */
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		
		Thread t1=new Thread(new Producer(list));
		
		Thread t2=new Thread(new Consumer(list));
		t1.setName("生产者");
		t2.setName("消费者");
		t1.start();
		t2.start();
	}

}

//生产线程
class Producer implements Runnable{
	private List list;
	public Producer(List list) {
		this.list=list;
	}
	public void run() {
		//一直生产
		while(true) {
			synchronized(list) {
				if(list.size()>0) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Object o=new Object();
				list.add(o);
				System.out.println(Thread.currentThread().getName()+" "+o);
				list.notify();
			}

		}
	}
}

class Consumer implements Runnable{
	private List list;
	public Consumer(List list) {
		this.list=list;
	}
	public void run() {
		//一直消费
		while(true) {
			while(true) {
				synchronized(list) {
					if(list.size()==0) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					Object o=list.get(0);
					System.out.println(Thread.currentThread().getName()+" "+o);
					list.notify();
				}
			}
		}
	}
}