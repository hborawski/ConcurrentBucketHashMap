
public class TestConcurrentBucket {
	public static void main(String[] args){
		final ConcurrentBucketHashMap<Integer, Integer> map = new ConcurrentBucketHashMap<Integer, Integer>(3);
		Runnable[] threads = new Runnable[5];
		for(int i = 0; i < 5; i ++){
			Runnable r = new Runnable(){
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0; i < 10; i++){
						map.put(i,i);
					}
					System.out.println(map.size());
				}
				
			};
			threads[i] = r;
		}
		
		for(Runnable r : threads){
			r.run();
		}
	}
}
