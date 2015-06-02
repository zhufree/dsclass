package dsclass;
import dsclass.ch02.*;
/**
 * 第七次作业：用插入或选择排序法对单链表排序
 * */
public class SortExercise {
	public static void main(String[] args) throws Exception {
		LinkList ll=new LinkList(3,true);
		ll.display();
		Node pre=ll.getHead();
		Node end=ll.getHead().getNext();
		Node cur=end.getNext();
		System.out.println(String.valueOf(pre.getData())+String.valueOf(end.getData())+String.valueOf(cur.getData()));
		if(end!=null){
			Node p=pre.getNext();
			while(p!=end){
				if(Integer.parseInt(cur.getData().toString())<Integer.parseInt(p.getData().toString())){
					pre.setNext(cur);
					cur.setNext(p);
				}else{
					end=cur;
					cur=cur.getNext();
				}
			}
			System.out.println(String.valueOf(pre.getData())+String.valueOf(end.getData())+String.valueOf(cur.getData()));
			ll.display();
		}
		ll.display();
	}
}
