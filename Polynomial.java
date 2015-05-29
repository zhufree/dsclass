package dsclass;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial {
		static int n;
		static double x;
		static int a[];
	ArrayList creatpoly(){
		Scanner scan=new Scanner(System.in);
		x=scan.nextDouble();
		n=scan.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=scan.nextInt();
		}
		System.out.print("P(x.)=0");
		for(int i=0;i<n;i++){
			System.out.print("+"+a[i]+"x^"+a[i]);
		}
		ArrayList al=new ArrayList();
		al.add(a);
		al.add(x);
		return al;
	}
	void compute(int a[],double x){
		double sum=0;
		for(int i=0;i<a.length;i++){
			double xs=1;
			for(int j=0;j<a[i];j++){
				xs*=x;
			}
			sum+=a[i]*xs;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Polynomial pl=new Polynomial();
		ArrayList al=pl.creatpoly();
		pl.compute((int[])al.get(0), Double.parseDouble(al.get(1).toString()));
	}
}
