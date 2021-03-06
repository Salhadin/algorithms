/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Arrays;

/**
 *
 * @author 986036
 */
public class TreeConstruction {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7}, post = {4, 5, 2, 6, 7, 3, 1}, in = {4, 2, 5, 1, 6, 3, 7};
        //TreeNode tree = treeFromPreAndPost(pre, post);
        TreeNode tree = treeFromInAndPost(in, post);
        //TreeNode tree = treeFromPreAndIn(pre, in);
        System.out.print("In-order: [ ");
        inOrderTraverse(tree);
        System.out.print(" ]\n");

        System.out.print("Pre-order: [ ");
        preOrderTraverse(tree);
        System.out.print(" ]\n");

        System.out.print("Post-order: [ ");
        postOrderTraverse(tree);
        System.out.print(" ]\n");
    }

    public static TreeNode treeFromPreAndPost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) {
            return root;
        }
        int L = 0;
        for (int i = 0; i < N; i++) {
            if (pre[1] == post[i]) {
                L = i + 1;
                break;
            }
        }
        root.left = treeFromPreAndPost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L - 1));
        root.right = treeFromPreAndPost(Arrays.copyOfRange(pre, L + 1, N), Arrays.copyOfRange(post, L, N - 1));
        return root;
    }

    public static TreeNode treeFromInAndPost(int[] in, int[] post) {
        int N = in.length;
        if (N == 0) {
            return null;
        }
        int L = 0;
        int mid = N / 2;
        
        TreeNode root = new TreeNode(in[mid]);
        if (N == 1) {
            return root;
        }
        
        L = mid + 1;
        
        root.left = treeFromInAndPost(Arrays.copyOfRange(in, 0, L-1), Arrays.copyOfRange(post, 0, L-1));
        root.right = treeFromInAndPost(Arrays.copyOfRange(in, L, N), Arrays.copyOfRange(post, L-1, N-1));
        return root;
    }

    public static TreeNode treeFromPreAndIn(int[] pre, int[] in) {

        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) {
            return root;
        }
        int L = 0;
        int mid = N / 2;
        L = mid + 1;

        root.left = treeFromPreAndIn(Arrays.copyOfRange(pre, 1, L), Arrays.copyOfRange(in, 0, L - 1));
        root.right = treeFromPreAndIn(Arrays.copyOfRange(pre, L, N), Arrays.copyOfRange(in, L, N));
        return root;
    }

    private static void inOrderTraverse(TreeNode node) {

        if (node != null) {
            inOrderTraverse(node.left);
            System.out.print(node.val + " ");
            inOrderTraverse(node.right);
        }

    }

    private static void postOrderTraverse(TreeNode node) {

        if (node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.val + " ");
        }

    }

    private static void preOrderTraverse(TreeNode node) {

        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }

    }
}
