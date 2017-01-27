package Sorting;

/**
 * Created by Gayming on 12/4/2016.
 */
public class InsertionSort {
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++){
            int j = i;
            while (j > 0 && array[j-1] > array[j]){
                //swap elements
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
                --j;
            }
        }
    }
}
