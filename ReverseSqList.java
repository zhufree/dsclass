package dsclass;
import dsclass.ch02.SqList;
import java.util.Random;
import java.util.Scanner;

public class ReverseSqList {
	int[] createlist() throws Exception{
		Scanner scan=new Scanner(System.in);
		System.out.println("please input the length of the sqlist:");
		int num=scan.nextInt();
		int lst[]=new int[num];
		SqList sl=new SqList(num);
		Random random = new Random(num);
		int i;
		for(i=0;i<num;i++){
			sl.insert(i, random.nextInt(100));
			lst[i]=random.nextInt(100);
			System.out.print(lst[i]+" ");
		}
		//sl.display();
		return lst;
	}
	void reverselist(int[] l) throws Exception{
		for(int i=0;i<l.length/2;i++){
			int  temp=l[i];
			//System.out.print(l[i]+" ");
			l[i]=l[l.length-1-i];
			l[l.length-1-i]=temp;
		}
		System.out.println();
		SqList sl=new SqList(l.length);
		int i;
		for(i=0;i<l.length;i++){
			sl.insert(i, l[i]);
		}
		sl.display();
	}
	public static void main(String[] args) throws Exception {
		ReverseSqList rs=new ReverseSqList();
		rs.reverselist(rs.createlist());
	}

}
