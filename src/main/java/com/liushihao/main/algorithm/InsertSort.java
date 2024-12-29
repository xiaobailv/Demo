package com.liushihao.main.algorithm;

/**
 * @author 11092
 * @Description
 * @create 2024-12-21 13:48
 */
public class InsertSort {

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 第零位 完成
        // 第一位的左侧如果有值并且和它左侧的位置比较大小直到左侧没有值，如果左侧的值比它大，则左移一位；
        // 第二位的左侧如果有值并且和它左侧的位置比较大小直到左侧没有值，如果左侧的值比它大，则左移一位；
        // 0 ~ 0 完成
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ 3
        // 0 ~ n-1
        int n = arr.length;
        for (int end = 1; end <= n - 1; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 第零位 完成
        // 第一位的左侧如果有值并且和它左侧的位置比较大小直到左侧没有值，如果左侧的值比它大，则左移一位；
        // 第二位的左侧如果有值并且和它左侧的位置比较大小直到左侧没有值，如果左侧的值比它大，则左移一位；
        // 0 ~ 0 完成
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ 3
        // 0 ~ n-1
        int n = arr.length;
        for (int end = 1; end <= n - 1; end++) {
            // pre 新数的前一个位置
            // 如果pre的位置有值，并且pre位置的值比当前位置的值大则交换位置
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 32, 6, 732, 7, 8};
        printArray(arr);
        insertSort2(arr);
        printArray(arr);
    }
}
