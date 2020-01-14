package test;

public class BinSortTree {
    private BinSortTree lChild;//左孩子
    private BinSortTree rChild;//右孩子
    private BinSortTree parent;//父结点
    private Integer date;//数据域

    public BinSortTree(BinSortTree lChild,BinSortTree rChild,Integer date){
        super();
        this.lChild=lChild;
        this.rChild=rChild;
        this.date=date;
    }
    public BinSortTree(Integer date){
        this(null,null,date);
    }
    public BinSortTree(){
        super();
    }
    //插入数据                 已有树           要插入的数据
    public boolean insert(BinSortTree tree,Integer item){
        if (item<tree.date){//如果要插入的值比根结点小p
            //左边插入
            if (tree.lChild==null){
                //如果没有左子树，就创建一棵左子树
                //并把值赋给左子树的根结点，初始化
                BinSortTree temp=new BinSortTree(item);
                tree.lChild=temp;
                temp.parent=tree;
                return true;
            }else {
                //如果有左子树，就直接在左子树中进行递归
                insert(tree.lChild,item);
            }
        }else if (item>tree.date){//如果要插入的值比根结点大
            if (tree.rChild==null){//右边插入
                //如果没有右子树就创建一个右子树，并把该值赋给右子树的根结点
                BinSortTree temp=new BinSortTree(item);
                tree.rChild=temp;
                temp.parent=tree;
                return  true;
            }else{
                //如果有右子树，就在右子树中进行递归
                insert(tree.rChild,item);
            }
        }
        return false;
    }
    //中序遍历 对于排序二叉树而言，相当于从小到大输出
    public void inOrder(BinSortTree tree){
        if (tree!=null){
            inOrder(tree.lChild);
            visit(tree.date);
            inOrder(tree.rChild);
        }
    }
    private void visit(Integer date){
        System.out.print(date+" ");
    }

}
