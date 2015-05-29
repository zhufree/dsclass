package dsclass;

import java.util.Scanner;

import dsclass.ch03.LinkStack;

public class ReverWords {
	public boolean Stringisrever(String s){
		int len=s.length();
		LinkStack ls1=new LinkStack();
		if(len%2==0){
				for(int i=0;i<len/2;i++){
					ls1.push(s.substring(i,i+1));
				}
				ls1.display();
				for(int i=len/2;i<len;i++){
					String top=ls1.pop().toString();
					String sub=s.substring(i,i+1);
					if(top.equals(sub)){
						continue;
					}else{
						return false;
					}
				}
		}else{
			for(int i=0;i<len/2;i++){
				ls1.push(s.substring(i,i+1));
			}
			ls1.display();
			for(int i=len/2+1;i<len;i++){
				String top=ls1.pop().toString();
				String sub=s.substring(i,i+1);
				if(top.equals(sub)){
					continue;
				}else{
					return false;
				}
			}
		}
		//ls1.display();
		return true;
	}
	public boolean Inputisrever(){
		LinkStack ls1=new LinkStack();
		LinkStack ls2=new LinkStack();
		LinkStack ls3=new LinkStack();
		Scanner scan=new Scanner(System.in);
		while(true){
			if(!scan.hasNextInt()){
				String in=scan.next();
				ls1.push(in);
				ls2.push(in);
			}else{
				break;
			}
		}
		int len=ls1.length();
		for(int i=0;i<len;i++){
			ls3.push(ls1.pop());
		}
		for(int i=0;i<len;i++){
			if(ls2.pop().equals(ls3.pop())){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		ReverWords rw=new ReverWords();
		//System.out.println(rw.Stringisrever("abghba"));
		System.out.println(rw.Inputisrever());
	}
}
