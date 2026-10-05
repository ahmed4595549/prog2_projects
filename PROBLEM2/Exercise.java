package PROBLEM2;

public class Exercise {
    public int[] swapNumbers(int first, int second) {
        int[] arr;
        first =first +second;
        second =first -second;
        first =first -second;
        arr = new int[2];
        arr[0] = first;
        arr[1] = second;
        return arr;

    }
}
