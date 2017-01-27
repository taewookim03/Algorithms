//import java.util.*;
//
///**
// * better solution in case of M words (O(nlogm)):
// * http://stackoverflow.com/questions/2954626/algorithm-to-find-the-smallest-snippet-from-searching-a-document
// */
//
//class SmallestSnippet3words {
////    static int minIndex(int[] arr){
////        int min_i = 0;
////        int min_elt = arr[0];
////        for (int i = 1; i < arr.length; i++){
////            if (arr[i] < min_elt) {
////                min_elt = arr[i];
////                min_i = i;
////            }
////        }
////        return min_i;
////    }
////    static int min(int[] arr){
////        int m = arr[0];
////        for (int i = 1; i < arr.length; i++){
////            if (arr[i] < m) m = arr[i];
////        }
////        return m;
////    }
////    static int max(int[] arr){
////        int m = arr[0];
////        for (int i = 1; i < arr.length; i++){
////            if (arr[i] > m) m = arr[i];
////        }
////        return m;
////    }
////
////    static void minSnippet3Words(int[] a, int[] b, int[] c){
////        int i = 0, j = 0, k = 0;
////        int[] triplet = new int[3];
////        int snippet_start = 0;
////        int snippet_end = Integer.MAX_VALUE;
////        int span;
////        int min_distance = Integer.MAX_VALUE;
////
////        while (i < a.length && j < b.length && k < c.length){
////            triplet[0] = a[i];
////            triplet[1] = b[j];
////            triplet[2] = c[k];
////            span = max(triplet) - min(triplet);
////            if (span < min_distance) {
////                min_distance = span;
////                snippet_start = min(triplet);
////                snippet_end = max(triplet);
////            }
////            int min_i = minIndex(triplet);
////            switch(min_i){
////                case 0:
////                    i++; break;
////                case 1:
////                    j++; break;
////                case 2:
////                    k++; break;
////            }
////        }
////        System.out.println(snippet_start + " - " + snippet_end);
////    }
//
//
//
//    static void minSnippetkWords(List< List <Integer> > lists){
//        for (List<Integer> list : lists){
//            if (list.isEmpty()) return;
//        }
//
//        //min heap sorted by first element of the list
//        Queue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>((a,b) -> a.get(0) - b.get(0));
//
//        int snippet_end = 0;
//        for (List<Integer> list : lists) {
//            if (list.get(0) > snippet_end) snippet_end = list.get(0);
//            minHeap.add(list);
//        }
//        int snippet_start = minHeap.peek().get(0);
//        int min_snippet = snippet_end - snippet_start;
//        int min_snippet_start = snippet_start;
//        int min_snippet_end = snippet_end;
//
//        while (minHeap.size() == lists.size()){
//            List<Integer> front = minHeap.remove();
//            front.remove(0);
//
//            if (!front.isEmpty()) {
//                minHeap.add(front);
//                if (front.get(0) > snippet_end) snippet_end = front.get(0);
//                snippet_start = minHeap.peek().get(0);
//
//                if (snippet_end - snippet_start < min_snippet) {
//                    min_snippet = snippet_end - snippet_start;
//                    min_snippet_start = snippet_start;
//                    min_snippet_end = snippet_end;
//                }
//            }
//        }
//        System.out.println(min_snippet_start + " - " + min_snippet_end);
//    }
//
//    public static void main(String[] args){
//        int[] a = new int[]{1, 9, 27};//indices of word a
//        int[] b = new int[]{6, 10, 19};
//        int[] c = new int[]{8, 12, 14};
//        //minSnippet3Words(a, b, c);
//
//        //pq version
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        List<Integer> aList = new ArrayList<Integer>();
//        for (int i : a) aList.add(i);
//        List<Integer> bList = new ArrayList<Integer>();
//        for (int i : b) bList.add(i);
//        List<Integer> cList = new ArrayList<Integer>();
//        for (int i : c) cList.add(i);
//        lists.add(aList);
//        lists.add(bList);
//        lists.add(cList);
//        minSnippetkWords(lists);
//    }
//}
