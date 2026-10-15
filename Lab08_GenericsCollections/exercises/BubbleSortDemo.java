import java.util.Arrays;

public class BubbleSortDemo {

    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {42, 7, 19, 3, 25};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] words = {"pear", "apple", "zebra", "mango"};
        bubbleSort(words);
        System.out.println(Arrays.toString(words));

        // int[] raw = {5, 2, 9};
        // bubbleSort(raw);   // compile error: int[] is not a T[] for any reference type T
    }
}
