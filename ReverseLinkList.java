package dsclass;
import dsclass.ch02.LinkList;
/**
 * 第二次作业：单链表逆置
 * @author:Free
 * 2015.5.29
 */
import dsclass.ch02.Node;
public class ReverseLinkList {
	void reservelist(LinkList ll) throws Exception{
		Node head=ll.getHead();//获取头结点
		Node p=head.getNext();//获取第一个元素
		head.setNext(null);//使头结点和第一个元素之间断开
		while(p!=null){
			Node q=p;
			p=p.getNext();
			q.setNext(head.getNext());
			head.setNext(q);
		}//一次访问每个元素，将每个元素依次插入到头结点和第一个元素之间，这样和原来的链表就是倒序了。
		ll.display();
	}
	public static void main(String[] args) throws Exception {
		LinkList ll=new LinkList(4,true);
		ll.display();
		ReverseLinkList rl=new ReverseLinkList();
		rl.reservelist(ll);
	}
}
