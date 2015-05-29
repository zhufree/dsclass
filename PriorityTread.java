package dsclass;

public class PriorityTread extends PriorityQData{
	private int time;
	public PriorityTread(Object elem, int priority, int time) {
		super(elem,priority);
		this.time=time;
	}
	public int getTime(){
		return time;
	}
	public void setTime(int time){
		this.time=time;
	}
	
}
