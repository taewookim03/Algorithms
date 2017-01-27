package CTCI.p8;

class p8_3_magic_index {
    static int magicDistinct(int[] arr, int lo, int hi){
        if (hi < lo) return -1;
        int mid = (lo+hi)/2;
        if (mid == arr[mid]) return mid;
        else if (mid < arr[mid]) return magicDistinct(arr, lo, mid-1);
        else return magicDistinct(arr, mid+1, hi);
    }
    static int magicDuplicate(int[] arr, int lo, int hi){
        if (hi < lo) return -1;
        int mid = (lo+hi)/2;
        if (arr[mid] == mid) return mid;
        int left = magicDuplicate(arr, lo, Math.min(mid-1, arr[mid]));
        if (left != -1) return left;
        else return magicDuplicate(arr, Math.max(mid+1, arr[mid]), hi);
    }

    public static void main(String[] args){
        int[] arr = new int[]{-40, -20, -10, 0, 1, 3, 6, 10, 11};
        System.out.println(magicDistinct(arr, 0, arr.length - 1));

        int[] dupArr = new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magicDuplicate(arr, 0, arr.length - 1));
        System.out.println(magicDuplicate(dupArr, 0, arr.length - 1));
    }
}
