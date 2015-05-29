package dsclass;
/*对一段文本中的单词进行切分，排序，统计出现次数
 * 并储存在十字链表中*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dsclass.ch04.CrossList;
import dsclass.ch04.SeqString;

public class CountWord {
	ArrayList<SeqString> allwords(SeqString sb){
		char currchar,prechar;
		ArrayList<SeqString> strs=new ArrayList<SeqString>();
		for (int i = 0; i < sb.length(); i++) {
			for(int j=i+1;j<sb.length();j++){
				currchar = sb.charAt(j);   //当前字符
				prechar = sb.charAt(j - 1);  //前一个字符
				if ((((int) (currchar) < 48 && (int) (currchar) !=39
					||(int) (currchar) >57 && (int) (currchar) < 65)
					|| (int) (currchar) > 122 //当前字符不是字母
	                || ((int) (currchar) > 90 && (int) (currchar) < 97))
	                && (((int) (prechar) >= 65 && (int) (prechar) <= 90) //当前字符的前一个字符是字母
	                || ((int) (prechar) >= 97 && (int) (prechar) <= 122)
	                ||(int)(prechar)==39
	               ||((int)(prechar)>=48&&(int)(prechar)<=57))) {
					   SeqString currstr=(SeqString)sb.substring(i, j);
					   //System.out.println(currstr);
					   strs.add(currstr);
					   i=j+1;
				   }
			   }
	       }
		return strs;
	}
	int count(SeqString s,ArrayList<SeqString> strs){
		int count=0;
		for(SeqString s_:strs){
			if (s.compareTo(s_)==0){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		CountWord cw=new CountWord();
		SeqString strings[]=new SeqString[20];
		String text0="Additions:More of the jQuery API:nextUntil?Optimizations-" +
				"The html5lib tree builder doesn't use the standard tree-building API,which " +
				"worries me and has resulted in a number of bugs." +
				"markup_attr_map can be optimized since it's always a map now." +
				"Upon encountering UTF16LE data or some other uncommon serialization " +
				"of Unicode,UnicodeDammit will convert the data to Unicode,then " +
				"encode it at UTF8.This is wasteful because it will just get decoded" +
				"back to Unicode.CDATA-" +
				"The elementtree XMLParser has a strip_cdata argument that,when set to" +
				"False,should allow BeautifulSoup to preserve CDATA sections instead" +
				"of treating them as text.Except it doesn't.This argument is also" +
				"present for HTMLParser,and also does nothing there." +
				"Currently,html5lib converts CDATA sections into comments.Anas-yet-unreleased " +
				"version of html5lib changes the parsers handling of " +
				"CDATA sections to allow CDATA sections in tags like svg and " +
				"math.The HTML5TreeBuilder will need to be updated to create CData " +
				"objects instead of Comment objects in this situation.";
		String text1="Before I knew the details of the sexual activity of Eric Gill I was his fan.Now I’m only a fan of his work.Gill," +
				"the London underground typeface designer,was also a sculptor,stonecutter and printmaker." +
				"He was profoundly religious and his work was highly regarded in his time." +
				"In 1989,biographer Fiona MacCarthy exposed Eric Gill’s diary(a detailed log of his life)" +
				"where he records his sexual activity.He had committed adultery," +
				"incest with his sister and abused his children and the family dog.";
		strings[0]=new SeqString(text0);
		strings[1]=new SeqString(text1);//make 20 new SeqString in array
		CrossList clw=new CrossList(2,200);//create a new crosslist to save
		//clw.setMu(2);//make it 20 later
		for(int i=0;i<2;i++){//for each text
			int j=0;
			SeqString strCur=strings[i];//get the current one
			ArrayList<SeqString> strsCur=cw.allwords(strCur);//cut the text to words and save in arrarylist
			Collections.sort(strsCur,new Comparator<SeqString>(){
				public int compare(SeqString s1,SeqString s2){
					return s1.compareTo(s2);
				}//sort the list
			});
			for(SeqString s:strsCur){//for each word in words list
				clw.Insert(i+1, j+1,cw.count(s, strsCur));
				//mu :num of text,nu:count of word in the text,s:the string of the word;
				//System.out.println("The word "+s+" appeared "+cw.count(s, strsCur)+" times.");
				j++;
			}
		}
		clw.print();
		
	}
}
