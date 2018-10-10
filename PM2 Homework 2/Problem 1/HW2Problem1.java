import java.util.Arrays;

public class HW2Problem1 {
    public static void main (String[] args) {
        int[] a = {12, 9001, 5};
        Problem1Sort(a,3);
    }
    static void Problem1Sort(int[] a, int arraySize){
        int temp = 0;
        String strArray[] = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            strArray[i] = String.valueOf(a[i]);
        }
        int elementLength = strArray[0].length();
        for (int j = 1; j < strArray.length; j++){
            if (strArray[j].length() > elementLength){
                elementLength = strArray[j].length();
            }
        }
        int k = 10;
        while (k <= Math.pow(10,elementLength)) {
            for (int i = 0; i < arraySize; i++) {
                for (int j = i + 1; j < arraySize; j++) {
                    int x = a[i] % k;
                    int y = a[j] % k;
                    if (x > y) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        System.out.println(Arrays.toString(a));
                    }
                }
            }
            k = k * 10;
        }
    }
}
