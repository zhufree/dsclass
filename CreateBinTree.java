package dsclass;
import java.util.Scanner;
/**
 * 第五次作业：通过人机交互建立一个二叉树并统计结点个数
 * @author Free
 * 2015.6.1
 */
import dsclass.ch05.*;

public class CreateBinTree {
	public BiTreeNode searchNode(BiTreeNode t,Object x){
		if(t!=null){
			if(t.getData().equals(x)){
				return t;
			}else{
				BiTreeNode lresult=searchNode(t.getLchild(),x);
				return lresult!=null?lresult:searchNode(t.getRchild(),x);
			}
		}
		return null;
	}//按值查找某个结点
	public void addtoroot(BiTreeNode root,BiTreeNode now,int l_or_r){
		if(l_or_r==0){
			root.setLchild(now);
		}else if(l_or_r==1){
			root.setRchild(now);
		}else{
			System.out.println("输入数字错误！请输入0或1");
		}
	}//插入单个结点
	public static void main(String[] args) {
		CreateBinTree cbt=new CreateBinTree();
		System.out.println("请输入根结点的值");
		Scanner scan=new Scanner(System.in);
		BiTreeNode root=new BiTreeNode(String.valueOf(scan.nextInt()));
		BiTree test=new BiTree(root);
		scan.nextLine();
		System.out.println("请按以下格式添加叶子节点（输入-1结束）：父节点 子节点 左边（数字0）右边（数字1）");
		String[] input=scan.nextLine().split(" ");
		while(!input[0].equals("-1")){
			BiTreeNode root_to_add=cbt.searchNode(root,input[0]);
			BiTreeNode new_to_add=new BiTreeNode(input[1]);
			cbt.addtoroot(root_to_add, new_to_add, Integer.valueOf(input[2]));
			test.levelTraverse();
			input=scan.nextLine().split(" ");
		}
		System.out.println("共有"+test.countNode(root)+"个结点");
	}
}
