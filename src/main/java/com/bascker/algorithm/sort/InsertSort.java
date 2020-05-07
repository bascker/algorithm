package com.bascker.algorithm.sort;

/**
 * 直接插入排序：适合数列基本有序的场景
 * @author bascker
 * @since v1.0
 */
public class InsertSort implements Sort {

    public void sort(final int[] arr) {
        int tmp;
        int j;

        for (int i = 1; i < arr.length; i ++) {
            // 待排元素
            tmp = arr[i];

            // 扫描待排序元素前的元素，若大于待排元素，则后移一位
            j = i - 1;
            while (j >= 1 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j --;
            }

            // 将待排元素插入对于位置
            arr[j + 1] = tmp;
        }
    }

    public void timeComplexity() {
        System.out.println("// ------------------ //");
        System.out.println("best:     O(m)");                  // 数组基本有序场景
        System.out.println("average:  O(m^2)");
        System.out.println("worst:    O(n^2)");                // 数组逆序场景
        System.out.println("// ------------------ //");
    }

    public void spaceComplexity() {
        System.out.println("// ------------------ //");
        System.out.println("O(1)");
        System.out.println("// ------------------ //");
    }

}
