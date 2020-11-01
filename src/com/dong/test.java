package com.dong;

import com.dong.Tree.BinarySearchTree;
import com.dong.model.User;

import java.util.Comparator;

/**
 * @Auther: 杨伟栋
 * @Date: 2020/8/9 17:45
 * @Description: 1371690483@qq.com
 */
public class test {
    public static void main(String[] args) {
        BinarySearchTree<Object> objectBinarySearchTree = new BinarySearchTree(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        objectBinarySearchTree.add(new User(12,"123"));
        objectBinarySearchTree.add(new User(13,"1243"));
        objectBinarySearchTree.add(new User(11,"1243"));
        objectBinarySearchTree.add(new User(15,"1243"));
        objectBinarySearchTree.add(new User(10,"1243"));
        objectBinarySearchTree.add(new User(18,"1243"));
        objectBinarySearchTree.levelpring();

    }
}
