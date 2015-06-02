package dsclass;
import dsclass.ch02.SqList;
import java.util.Random;
import java.util.Scanner;
/*
 * 顺序表逆置
 * @author:Free
 * 2015.5.29
 */
public class ReverseSqList {
	int[] createlist() throws Exception{
		Scanner scan=new Scanner(System.in);
		System.out.println("please input the length of the sqlist:");
		int num=scan.nextInt();
		scan.close();
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
	}//根据用户输入的长度随机生成数组和顺序表，并把该数组返回
	void reverselist(int[] l) throws Exception{
		for(int i=0;i<l.length/2;i++){
			int  temp=l[i];
			//System.out.print(l[i]+" ");
			l[i]=l[l.length-1-i];
			l[l.length-1-i]=temp;
		}//从第一个元素开始遍历到数组中间，并和另一头开始的相对位置的元素调换位置，即将数组逆置
		System.out.println();
		SqList sl=new SqList(l.length);
		int i;
		for(i=0;i<l.length;i++){
			sl.insert(i, l[i]);
		}//将逆置后数组元素插入新的顺序表中
		sl.display();
	}
	public static void main(String[] args) throws Exception {
		ReverseSqList rs=new ReverseSqList();
		rs.reverselist(rs.createlist());
	}

}
