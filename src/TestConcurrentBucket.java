
public class TestConcurrentBucket {
	public static void main(String[] args){
		final ConcurrentBucketHashMap map = new ConcurrentBucketHashMap(3);
		for(int i = 0; i < 2; i ++){
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
			r.run();
		}
	}
}
