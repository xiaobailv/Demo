package com.liushihao.main.algorithm;

/**
 * @author 11092
 * @Description
 * @create 2024-12-21 11:20
 */
public class SelectionSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~ n-1
        int n = arr.length;
          for (int i = 0; i < n; i++) {
            // i ~ n-1
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = arr[minValueIndex] < arr[j] ? minValueIndex : j;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void printArray(int[] arr){
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
        int[] arr = {1, 4, 6, 32, 6, 732, 8, 7, 8};
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
}
