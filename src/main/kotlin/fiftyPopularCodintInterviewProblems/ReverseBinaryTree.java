package fiftyPopularCodintInterviewProblems;

public class ReverseBinaryTree {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public void reverseTree(Tree root){
        if (root == null)
            return;
        Tree leftTree = root.left;
        root.left = root.right;
        root.right = leftTree;
        reverseTree(root.left);
        reverseTree(root.right);
    }
}
