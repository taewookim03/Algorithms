package CTCI.p16moderate;

class p16_1_number_swapper {
    static void swapNoVar(int[] arr, int i, int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    public static void main(String[] args){
        int[] arr = new int[]{3, 8};
        swapNoVar(arr, 0, 1);

        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
