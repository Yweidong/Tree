package com.dong.Tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 杨伟栋
 * @Date: 2020/11/1 12:32
 * @Description: 1371690483@qq.com
 */
public class BinarySearchTree<E> {

    private int size;
    private Node<E> root;//根节点

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    //二叉树前序遍历递归打印
    public void prediguiprint() {
        prediguiprint(root);
    }
    public void prediguiprint(Node<E> node) {
        if(node ==null) {
            return;
        }
        System.out.println(node.element);
        prediguiprint(node.left);
        prediguiprint(node.right);
    }

    //层序遍历二叉树
    /*
     * 思路： 根节点先入队  然后从根节点开始进行入队操作（先进先出原则） 将当前节点的左右子节点入队，（先进入队列的先访问---》其左右子节点继续入队）
     *
     *
     **/
    public void levelpring() {
        if(root ==null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> eNode = queue.poll();
            System.out.println(eNode.element);
            if(eNode.left!=null) {
                queue.offer(eNode.left);
            }
            if(eNode.right!=null) {
                queue.offer(eNode.right);
            }

        }
    }



    public void add(E element) {
        if(root ==null) {
            root = new Node<>(element,null);
            size++;
            return;
        }

        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;//记录位置
        while (node!=null) {
            cmp = compare(element,node.element);//>0在右边   <0左边
            parent = node;
            if(cmp>0) {
                node = node.right;
            }else if(cmp<0) {
                node = node.left;
            }else {
                node.element = element;
                return;
            }

        }
        Node<E> newNode = new Node<>(element,parent);
        if (cmp>0) {
           parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;
    }
    //比较大小  e1==e2  0  e1>e2 return 1  e1<e2  return 2
    public int compare(E e1, E e2) {
        if(comparator!=null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);

    }
    public class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }


    }


}
