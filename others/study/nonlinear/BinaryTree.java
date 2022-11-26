package nonlinear.tree;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    //记录根节点
    private Node root;
    //记录树中元素的个数
    private int N;

    private class Node{
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子节点
        public Node right;
        public Node(Key key,Value value,Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }

    }
    /**
     * 获取数组中元素的个数
     */
    public int size(){
        return N;
    }
    /**
     * 向树中添加元素key-value
     */
    public void put(Key key,Value value){
        root=put(root,key,value);
    }
    //向指定的x中添加key-value,并返回添加元素后新的树
    private Node put(Node x,Key key,Value value){
        //如果x子树为空
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果x子树不为空,比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键,则继续找x结点的右子树
            x.right=put(x.right,key,value);
        }
        //如果key小于x结点的键,则继续找x结点的左子树
        else if(cmp<0){
            x.left=put(x.left,key,value);
        }
        //如果key等于x结点的键,则替换x结点的value值
        else {
            x.value=value;
        }
        return x;
    }
    /**
     * 查询树中指定key对应的value值
     */
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        //x为空
        if(x==null){
            return null;
        }
        //如果x子树不为空,比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键,则继续找x结点的右子树
            return get(x.right,key);
        }
        //如果key小于x结点的键,则继续找x结点的左子树
        else if(cmp<0){
            return get(x.left,key);
        }
        //如果key等于x结点的键,则找到了键为key的值只需返回x结点的值即可
        else {
            return x.value;
        }
    }
    /**
     * 删除树中key对应的value
     */
    public void delete(Key key){
        delete(root,key);
    }
    private Node delete(Node x,Key key){
        //x树为null
        if(x==null){
            return null;
        }
        //x树不为null
        //如果x子树不为空,比较x结点的键和key的大小
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键,则继续找x结点的右子树
            x.right=delete(x.right,key);
        }
        //如果key小于x结点的键,则继续找x结点的左子树
        else if(cmp<0){
            x.left=delete(x.left,key);
        }
        //如果key等于x结点的键,则完成删除操作
        else {
            //让元素个数减一
            N--;
            //找到右子树中最小节点
            if(x.right==null){
                return x.left;
            }
            if(x.left==null){
                return x.right;
            }
            Node minNode=x.right;
            while (minNode.left!=null){
                minNode=minNode.right;
            }
            //删除右子树中最小的结点
            Node n=x.right;
            while (n.left!=null){
                if(n.left.left==null){
                    n.left=null;
                }else {
                    //变换n结点即可
                    n=n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right=x.right;
            //让x结点的父节点指向minNode
            x=minNode;

        }
        return x;
    }
}
