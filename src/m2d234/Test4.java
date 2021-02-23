package m2d234;

import java.util.ArrayList;
import java.util.List;

/**
 * ʹ��wait()��notify()����ʵ�֡�������������ģʽ��
 * 
 * wait()��notify()��������ͨ����ķ����������̵߳ķ���
 * 
 * wait()��notify()����������ͬһ�������ϣ����̰߳�ȫ����
 * 
 * wait()�������ڶ����ϵĻ�߳̽���ȴ�״̬�����ͷ��߳�֮ǰռ�е���
 * 
 * notify()�����ѵȴ��е��̣߳������ͷ���
 * @author yyds
 *
 */
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		
		Thread t1=new Thread(new Producer(list));
		
		Thread t2=new Thread(new Consumer(list));
		t1.setName("������");
		t2.setName("������");
		t1.start();
		t2.start();
	}

}

//�����߳�
class Producer implements Runnable{
	private List list;
	public Producer(List list) {
		this.list=list;
	}
	public void run() {
		//һֱ����
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
		//һֱ����
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