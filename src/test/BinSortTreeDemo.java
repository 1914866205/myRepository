package test;

public class BinSortTreeDemo {
    public static void main(String[] args) {
        int[]arr={63,90,70,55,67,42,98,83,10,45,58};
        //将第一个数字作为根结点
        BinSortTree tree=new BinSortTree(arr[0]);
        for(int i:arr){
            tree.insert(tree,i);
        }
        tree.inOrder(tree);
    }
}
