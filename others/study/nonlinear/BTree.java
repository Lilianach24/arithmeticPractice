package nonlinear;

/**
 * 二叉树的基本运算及其实现
 */

import java.util.Stack;

/**
 * 二叉树的链式存储结构的节点类:
 */
class BTNode<E>{
    //存放数据元素
    E data;
    //指向左孩子的结点
    BTNode lchild;
    //指向右孩子的结点
    BTNode rchild;
    public BTNode(){
        lchild=rchild=null;
    }
    public BTNode(E d){
        data=d;
        lchild=rchild=null;
    }
}
public class BTree {
    //根节点
    BTNode<Character> b;
    //二叉树的括号表示串
    String bstr;
    //构造方法
    public BTree(){
        b=null;
    }

    //二叉树的基本运算算法
    /**
     * 创建二叉树
     * 例如对于括号表示串: A(B(D(,G)),C(E,F)) 建立二叉树的链式存储结构
     */
    public void createBTree(String str){
        //建立一个栈
        Stack<BTNode> st=new Stack<BTNode>();
        BTNode<Character> p=null;
        boolean flag=true;
        char ch;
        int i=0;
        //循环扫描str中的每一个字符
        while(i<str.length()){
            ch=str.charAt(i);
            switch(ch){
                case '(':
                    //刚刚新建的结点有孩子,将其进栈
                    st.push(p);
                    flag=true;
                    break;
                case ')':
                    //栈顶结点的子树处理完,出栈
                    st.pop();
                    break;
                case ',':
                    //开始处理栈顶结点的右孩子
                    flag=false;
                    break;
                default:
                    //用ch值新建一个结点
                    p=new BTNode<Character>(ch);
                    //若尚未建立根节点,p作为根节点
                    if(b==null){
                        b=p;
                    }
                    //已建立二叉树的根节点
                    else {
                        //新节点p作为栈顶结点的左孩子
                        if(flag){
                            if(!st.empty()){
                                st.peek().rchild=p;
                            }
                        }
                        //新结点p作为栈顶结点的右孩子
                        else{
                            if(!st.empty()){
                                st.peek().rchild=p;
                            }
                        }
                    }
                    break;
            }
            i++;
        }
    }

    /**
     * 返回二叉链的括号表示串
     */
    private void toString1(BTNode<Character> t){
        if(t!=null){
            //输出根节点值
            bstr+=t.data;
            if(t.lchild!=null||t.rchild!=null){
                //有孩子结点时输出"("
                bstr+="(";
                //递归输出左子树
                toString1(t.lchild);
                //有右孩子时输出","
                if(t.rchild!=null){
                    bstr+=",";
                }
                //递归输出右子树
                toString1(t.rchild);
                //输出")"
                bstr+=")";
            }
        }
    }
    @Override
    public String toString(){
        bstr="";
        toString1(b);
        return bstr;
    }

    /**
     * 查找值为x的结点
     * @return
     */
    private BTNode<Character> findNode1(BTNode<Character> t, char x){
        BTNode<Character> p;
        //t为空时返回null
        if(t==null){
            return null;
        }
        //t所指结点值为x时返回t
        else if(t.data==x){
            return t;
        }
        else {
            //在左子树中查找
            p=findNode1(t.lchild,x);
            //在左子树中找到p,返回p
            if(p!=null){
                return p;
            }
            //返回在右子树中的查找结果
            else {
                return findNode1(t.rchild,x);
            }
        }
    }
    public BTNode<Character> findNode(char x){
        return findNode1(b,x);
    }

    /**
     * 求高度
     * 空树的高度为0,非空树的高度为左右子树中较大的高度加1
     */
    private int height1(BTNode<Character> t){
        int lchildh,rchildh;
        if(t==null){
            //空树的高度为0
            return 0;
        }
        else {
            //求左子树的高度
            lchildh=height1(t.lchild);
            //求右子树的高度
            rchildh=height1(t.rchild);
            return Math.max(lchildh,rchildh)+1;
        }
    }
    public int height(){
        return height1(b);
    }

    //二叉树的先序, 中序,后序遍历递归算法
    /**
     * 先序遍历二叉树的过程:
     *      1. 访问根节点
     *      2. 先序遍历左子树
     *      3. 先序遍历右子树
     * 先序遍历算法
     */
    private void preOrder1(BTNode<Character> t){
        if(t!=null){
            //先访问根节点
            System.out.print(t.data+" ");
            //先序遍历左子树
            preOrder1(t.lchild);
            //先序遍历右子树
            preOrder1(t.rchild);
        }
    }
    public void preOrder(BTree bt){
        preOrder1(bt.b);
    }
    /**
     * 中序遍历二叉树的过程:
     *      1. 中序遍历左子树
     *      2. 访问根节点
     *      3. 中序遍历右子树
     * 中序遍历的算法
     */
    private void inOrder1(BTNode<Character> t){
        if(t!=null){
            //中序遍历左子树
            inOrder1(t.lchild);
            //访问根节点
            System.out.print(t.data+" ");
            //中序遍历右子树
            inOrder1(t.rchild);
        }
    }
    public void inOrder(BTree bt){
        inOrder1(bt.b);
    }
    /**
     * 后序遍历二叉树的过程:
     *      1. 后序遍历左子树
     *      2. 后序遍历右子树
     *      3. 访问根节点
     * 后续遍历的算法
     */
    private void postOrder1(BTNode<Character> t){
        if(t!=null){
            postOrder1(t.lchild);
            postOrder1(t.rchild);
            System.out.print(t.data+" ");
        }
    }
}
