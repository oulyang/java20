package m2d233;
/**
 * ʵ��Callable�ӿ���ʵ���߳�
 * �ŵ㣺���Ի�ȡ���̵߳�ִ�н��
 * ȱ�㣺Ч�ʵͣ��ڻ�ȡt�߳�ִ�н��ʱ����ǰ�߳�����
 */
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
public class Test3 {

	public static void main(String[] args) throws Exception, ExecutionException {
		// TODO Auto-generated method stub
		FutureTask ft=new FutureTask(new Callable() {
			public Object call() throws Exception {
				System.out.println("begin");
				Thread.sleep(1000*2);
				System.out.println("end");
				int a=10;
				int b=1;
				return a+b;
			}
		});
		
		Thread t=new Thread(ft);
		t.start();
		Object obj=ft.get();
	}

}
