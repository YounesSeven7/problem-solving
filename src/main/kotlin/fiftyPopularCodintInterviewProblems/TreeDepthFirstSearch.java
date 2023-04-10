package fiftyPopularCodintInterviewProblems;

public class TreeDepthFirstSearch {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public void dfsPreorder(Tree root){
        if (root == null)
            return;
        System.out.println(root.data);
        dfsPreorder(root.left);
        dfsPreorder(root.right);
    }

    public void dfsInorder(Tree root){
        if (root == null)
            return;
        dfsInorder(root.left);
        System.out.println(root.data);
        dfsInorder(root.right);
    }

    public void dfsPostorder(Tree root){
        if (root == null)
            return;
        dfsPostorder(root.left);
        dfsPreorder(root.right);
        System.out.println(root.data);
    }
}
