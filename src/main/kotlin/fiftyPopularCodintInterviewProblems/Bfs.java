package fiftyPopularCodintInterviewProblems;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public void bfs(){
        Tree tree = new Tree(1,
                new Tree(2, new Tree(4), new Tree(5)),
                new Tree(3, new Tree(6), new Tree(7)));
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while (queue.size() > 0) {
            Tree queueTree = queue.peek();
            System.out.println(queueTree.data);
            if (queueTree.left != null)
                queue.add(queueTree.left);
            if (queueTree.right != null)
                queue.add(queueTree.right);
            queue.remove();
        }
    }


}
