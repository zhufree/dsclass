package dsclass;
import dsclass.ch04.OLNode;
import dsclass.ch04.SeqString;

public class WordNode extends OLNode {
	int col,row;
	SeqString w;
	WordNode getRight;
	WordNode getDown;
	 public SeqString getW() {
	        return w;
	    }

	    public void setW(SeqString w) {
	        this.w = w;
	    }
	    public WordNode getRight() {
	        return getRight;
	    }

	    public void setRight(WordNode right) {
	        this.getRight = right;
	    }
	    public WordNode getDown() {
	        return getDown;
	    }

	    public void setDown(WordNode down) {
	        this.getDown = down;
	    }
	    public WordNode(){
	    	this(0,0,new SeqString(""));
	    }

		public WordNode(int row, int col,SeqString w) {  //有参构造方法
        this.row = row;
        this.col = col;
        this.w = w;
        getRight = null;
        getDown = null;
    }
}
