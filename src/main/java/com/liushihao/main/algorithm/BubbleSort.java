package com.liushihao.main.algorithm;

/**
 * @author 11092
 * @Description
 * @create 2024-12-21 12:21
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ n-3
        int n = arr.length;
        for (int end = n - 1; end >= 0; end--) {
            // 0 ~ end
            // 将第一位和第二位的值作比较，如果第一位的值大，那么交换位置
            // 将第二位和第三位的值作比较，如果第一位的值大，那么交换位置
            // ......
            // 0 1  1 2  2 3  3 4  4 5  end-1 end
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second, second - 1);
                }
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
        bubbleSort(arr);
        printArray(arr);
    }
}
