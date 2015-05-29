package dsclass;

public class Priority_q {
	public static void main(String[] args) {
		PriorityQueue pm=new PriorityQueue();
		int start_time=0,end_time=0;
		double response=0;
		pm.offer(new PriorityTread(1, 20,3));
		pm.offer(new PriorityTread(2, 30,2));
		pm.offer(new PriorityTread(3, 20,4));
		pm.offer(new PriorityTread(4, 20,3));
		pm.offer(new PriorityTread(5, 40,2));
		pm.offer(new PriorityTread(6, 10,5));
		while(!pm.isEmpty()){
			PriorityTread p=(PriorityTread) pm.poll();
			end_time+=p.getTime();
			response=(double)start_time/p.getTime();
			System.out.println(" "+p.getElem()+"\t"+p.getPriority()+"\t"+p.getTime()+"\t"+start_time+"\t"+end_time+"\t"+response);
			start_time+=p.getTime();
		}
	}
}
