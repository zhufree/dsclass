package dsclass;
/**
 * 第一次作业：找出一个数组中最大的数
 * @author:Free
 * 2015.5.29
 */
import java.util.Random;

public class ArrayNum {
	double num[]=new double[100];
	void createnum(){
		Random random = new Random(num.length);
		int i;
		for(i=0;i<num.length;i++){
			num[i]=random.nextDouble()*100;
		}
	}//创建数组
	void printnum(){
		System.out.print("(");
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+",");
		}
		System.out.print(")");
	}//输出数组
	void  compare(){
		double max=0;
		int loc=0;
		for(int i=0;i<num.length;i++){
			if(num[i]>max){
				max=num[i];
				loc=i;
				}
			}
		System.out.print("The max number is "+max+",and it's location is  "+loc);
	}//比较找出最大的数
	public static void main(String[] args) {
		ArrayNum an=new ArrayNum();
		an.createnum();
	    //an.printnum();
		an.compare();
	}
}
