import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 45, -32, -99, -8, 100, 34, 32, 0};

        System.out.println("Values in array: ");
        System.out.println(Arrays.toString(arr));

        System.out.println("Sorted array: ");
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void compareVals(int[] arr, int x, int y) {
        for (int i = x; i < y; i++) {
            if (arr[i] > arr[i + 1]) {
                swappingVals(arr, i, i + 1);
            }
        }
    }
    //Function "swappingVals": switching values of the arrays, used in "mergeVals" function and "compareVals" function
    public static void swappingVals(int[] arr, int i, int j) {
        int temp = 0;
        //Variable 'temp' holds value of array 'arr' of value at index 'i'
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //Function "mergeVals":
    public static void mergeVals(int[] arr, int x, int y, int z) {
        int i = x;
        while (i <= z) {
            if (arr[i] > arr[z + 1]) {
                swappingVals(arr, i, z + 1);
                compareVals(arr, z + 1, y);
            }
            i++;
        }
    }

    public static void mergeSort(int[] arr, int x, int y) {

        //Sorting one item
        if (x == y) {
            return;
        }
        //Sorting two items
        if (y - x == 1) {
            if (arr[x] > arr[y]) {
                swappingVals(arr, x, y);
            }
            return;
        }
        //Recursive procedure
        int mid = (x + y) / 2;

        mergeSort(arr, x, mid);
        mergeSort(arr, mid + 1, y);
        mergeVals(arr, x, y, mid);
    }
}
