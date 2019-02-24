package com.tianxiaobo.chapter1;

/**
 * MaxTree
 *
 * @author Tian ZhongBo
 * @date 2019-02-24 17:12:56
 */
public class MaxTree {

    public static Node constructMaxTree(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr is illegal");
        }

        Node root = null;
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodes[i] = node;

            if (i == 0) {
                root = node;
                continue;
            }

            if (arr[i] < arr[i - 1]) {
                nodes[i - 1].right = node;
            } else {
                if (root.value < arr[i]) {
                    node.left = root;
                    root = node;
                } else {
                    for (int j = i - 2; j > 0; j--) {
                        if (arr[i] < arr[j]) {
                            node.left = nodes[j].right;
                            nodes[j].right = node;
                            break;
                        }
                    }
                }
            }
        }

        return root;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
