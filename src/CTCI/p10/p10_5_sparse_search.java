package CTCI.p10;

class p10_5_sparse_search {
    static int sparseSearch(String[] strings, String val){
        return binSearch(strings, 0, strings.length-1, val);
    }
    static int binSearch(String[] strings, int lo, int hi, String val){
        if (lo > hi) return -1;//not found
        int mid = (lo+hi)/2;
        if (strings[mid].isEmpty()){
            int left = mid-1;
            int right = mid+1;
            while (true){
                if (left < lo && right > hi) return -1;
                if (left >= lo && !strings[left].isEmpty()){
                    mid = left;
                    break;
                }
                if (right <= hi && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }
            }
        }

        int cmp = strings[mid].compareTo(val);
        if (cmp == 0) return mid;
        else if (cmp < 0){
            return binSearch(strings, mid+1, hi, val);
        }
        else{
            return binSearch(strings, lo, mid-1, val);
        }

    }

    public static void main(String[] args){
        String[] strings = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        System.out.println(sparseSearch(strings, "ball"));//output=4
    }
}
