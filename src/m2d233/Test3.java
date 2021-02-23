package m2d233;
/**
 * 实现Callable接口来实现线程
 * 优点：可以获取到线程的执行结果
 * 缺点：效率低，在获取t线程执行结果时，当前线程受阻
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
