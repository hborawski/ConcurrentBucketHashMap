
public class TestConcurrentBucket {
	public static void main(String[] args){
		final ConcurrentBucketHashMap<String, Integer> map = new ConcurrentBucketHashMap<String, Integer>(3);
		Thread[] threads = new Thread[3];
		for(int i = 0; i < 3; i ++){
			SimpleThread t = new SimpleThread("Thread "+i, map);
			threads[i]=t;
		}
		for(Thread run : threads){
			run.start();
		}
	}
	
	private static class SimpleThread extends Thread{
		private ConcurrentBucketHashMap<String, Integer> map;
		public SimpleThread(String name, ConcurrentBucketHashMap<String, Integer> map){
			super(name);
			this.map = map;
		}
		public void run(){
			for(int i = 0; i < 10; i ++){
				map.put(this.getName()+i, i);
			}
			System.out.println(this.getName() + " " +map.size());
		}
	}
}
