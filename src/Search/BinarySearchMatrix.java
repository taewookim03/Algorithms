package Search;
/**
 * http://www.algorist.com/algowiki/index.php/Sorting-searching-TADM2E 4-35
 */
class BinarySearchMatrix {
    static void find(int[][] matrix, int val){
        int r = vertical_search(matrix, val, 0, matrix.length-1);
        if (r == -1){
            System.out.println("not found");
            return;
        }
        int c = horizontal_search(matrix[r], val, 0, matrix[r].length-1);
        if (c == -1){
            System.out.println("not found");
            return;
        }
        System.out.println("row " + r + ", col " + c);
    }

    static int horizontal_search(int[] row, int val, int lo, int hi){
        if (hi - lo < 0) return -1;
        int mid = lo + (hi - lo)/2;
        if (row[mid] == val) return mid;
        else if (val < row[mid]){
            return horizontal_search(row, val, lo, mid - 1);
        }
        else return horizontal_search(row, val, mid + 1, hi);
    }

    static int vertical_search(int[][] matrix, int val, int lo, int hi){
        //if val is less than any element in the matrix
        if (val < matrix[lo][0]) return -1;
        //if (hi - lo < 0) return -1;

        int mid = lo + (hi - lo)/2;
        //check mid
        if (matrix[mid][0] <= val && (mid == matrix.length - 1 || matrix[mid+1][0] > val)){
            return mid;
        }
        else if (matrix[mid][0] > val){
            return vertical_search(matrix, val, lo, mid - 1);
        }
        else return vertical_search(matrix, val, mid + 1, hi);
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1, 2, 4},
                {3, 4, 6},
                {6, 7, 8}
        };

        find(matrix, 9);
    }
}
