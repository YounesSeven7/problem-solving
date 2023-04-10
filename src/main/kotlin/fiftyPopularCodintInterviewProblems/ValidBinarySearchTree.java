package fiftyPopularCodintInterviewProblems;

import java.util.Arrays;

public class ValidBinarySearchTree {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public boolean isBst(){
        Tree root = new Tree(16, new Tree(8), new Tree(22));
        return r(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean r(Tree root, int min, int max) {
        if (root == null)
            return true;
        return root.data > min && root.data < max && r(root.left, min, root.data) && r(root.right, root.data, max);
    }
}
