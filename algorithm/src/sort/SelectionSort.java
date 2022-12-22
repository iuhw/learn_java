package sort;

import java.util.Arrays;

/**
 * 选择排序，思路：将数组切分为排序区和未排序区，元素中的每个元素从未排序区找最小值，时间复杂度O(n^2),空间复杂度O(n)
 */
public class SelectionSort implements IArraySort {

    /**
     * 选择排序
     */
    public int[] sort(int[] array) {
        // 快速结束
        if (array == null || array.length <= 1) {
            return array;
        }
        // 拷贝数组 目的是引用类型防止程序执行过程中数据被其它线程修改导致的数据不一致
        int[] copy = Arrays.copyOf(array, array.length);
        // 需要进行 n * (n -1) 轮判断
        for (int i = 0; i < copy.length - 1; i++) {
            // 最小值下标
            int min = i;
            // 在非排序区进行比较选择
            for (int j = i + 1; j < copy.length; j++) {
                // 如果发现了更小的值 则记录下标位置
                if (copy[min] > copy[j]) {
                    min = j;
                }
            }
            // 数据调换
            if (min != i) {
                int temp = copy[i];
                copy[i] = copy[min];
                copy[min] = temp;
            }
        }
        return copy;
    }

    /**
     * 选择排序
     */
    public int sortK(int[] array, int k) {
        // 快速结束
        if (array == null || array.length <= 1 || k < 1 || k > array.length) {
            return Integer.MIN_VALUE;
        }
        // 拷贝数组 目的是引用类型防止程序执行过程中数据被其它线程修改导致的数据不一致
        int[] copy = Arrays.copyOf(array, array.length);
        // 需要进行 n * (n -1) 轮判断
        for (int i = 0; i < copy.length - 1; i++) {
            // 最小值下标
            int min = i;
            // 在非排序区进行比较选择
            for (int j = i + 1; j < copy.length; j++) {
                // 如果发现了更小的值 则记录下标位置
                if (copy[min] > copy[j]) {
                    min = j;
                }
            }
            // 数据调换
            if (min != i) {
                int temp = copy[i];
                copy[i] = copy[min];
                copy[min] = temp;
            }
            if (i == k - 1) {
                return copy[i];
            }
        }
        return Integer.MIN_VALUE;
    }
}
