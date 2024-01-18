package holdings.indsys.iLabel.demo.test;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {31, 41, 59, 26, 41, 58};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
