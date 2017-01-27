package Arrays;

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class PairSum {
    static Pair findSumPair(int[] arr, int sum){
        int i = 0;
        int j = arr.length - 1;

        while (i < j){
            int s = arr[i] + arr[j];
            if (s == sum) return new Pair(arr[i], arr[j]);
            else if (s < sum) i++;
            else j--;
        }
        return null;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1, 3, 5, 7, 10, 11};
        Pair p = findSumPair(arr, 17);
        if (p != null) System.out.println(p.first + " " + p.second);
        else System.out.println("not found");
    }
}
