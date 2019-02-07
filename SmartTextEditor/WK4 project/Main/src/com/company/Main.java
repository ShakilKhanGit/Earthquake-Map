import java.util.Arrays;

public class Main
{

    public static void main (String[]args)
    {
        int[] arr = { 7, 1, 5, 2, 4, 9 };

        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            int j;

            for(j=i+1; j<arr.length; j++){
                if(arr[j] < arr[i]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            System.out.println ("Now: " + Arrays.toString (arr));
        }

        System.out.println ("Final: " + Arrays.toString (arr));
    }

    private static void swap(int[] arr, int i, int minIndex){
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }


}
