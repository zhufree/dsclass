package dsclass;

import dsclass.ch04.CrossList;
import dsclass.ch04.OLNode;
import dsclass.ch04.SeqString;

public class CrossListWord extends CrossList {
    private WordNode[] rhead, chead;
    public CrossListWord(int m, int n) {  //构造方法，初始化
        mu = m;
        nu = n;
        rhead = new WordNode[m];     //初始化行指针数组
        chead = new WordNode[n];     //初始化列指针数组
        tu = 0;
        for (int i = 0; i < m; i++) {
            rhead[i] = new WordNode();
        }
        for (int i = 0; i < n; i++) {
            chead[i] = new WordNode();
        }
    }
	public void insert(int row,int col,SeqString s){
		WordNode rtemp = rhead[row - 1];
        WordNode ctemp = chead[col - 1];
        WordNode oldtemp = null;
        WordNode current = new WordNode(row, col, s);
        if (rtemp.getRight == null) {

            rtemp.getRight = current;

        } else {
            while (rtemp.getRight != null) {
                oldtemp = rtemp;
                rtemp = rtemp.getRight;
                if (rtemp.col > col) {
                    current.getRight = oldtemp.getRight;
                    oldtemp.getRight = current;

                    break;
                } else //但前位置存在 操作可以写覆盖 也可以相加
                if (rtemp.col == col) {
                    System.out.println("本位置存在1");
                    return;
                } else if (rtemp.getRight == null) {
                    rtemp.getRight = current;

                    break;
                }

            }
        }
        if (ctemp.getDown == null) {
            ctemp.getDown = current;
            tu++;
        } else {
            while (ctemp.getDown != null) {
                oldtemp = ctemp;
                ctemp = ctemp.getDown;
                if (ctemp.row > row) {
                    current.getDown = oldtemp.getDown;
                    oldtemp.getDown = current;
                    break;
                } else //但前位置存在 操作可以写覆盖 也可以相加
                if (ctemp.row == row) {
                    System.out.println("本位置存在2");
                    return;
                } else if (ctemp.getDown == null) {
                    ctemp.getDown = current;
                }
                tu++;
                return;
            }
        }
	}
    public void print() {

        if (tu == 0) {
            System.out.println("该矩阵为0矩阵");
            return;
        }
        for (int i = 0; i < mu; i++) {
            WordNode rtemp = rhead[i];
            rtemp = rtemp.getRight;

            for (int j = 0; j < nu; j++) {
                if (rtemp != null && rtemp.row == i + 1 && rtemp.col == j + 1) {
                    System.out.print(rtemp.w);

                    rtemp = rtemp.getRight;
                } else {
                    System.out.print("0");
                }
                if (j != nu - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
