//import java.util.ArrayList;
//import java.util.List;
//
//class Item{
//    int w;
//    int v;
//
//    Item(int w, int v){
//        this.w = w;
//        this.v = v;
//    }
//}
//
//
//class Knapsack {
//    static int ksack(int W, List<Item> items){
//        int n = items.size();
//        int[][] value = new int[n+1][W+1];
//
//        for (int i = 0; i <= n; i++){
//            for (int w = 0; w <= W; w++){
//                if (i == 0 || w == 0){
//                    value[i][w] = 0;
//                }
//                else if (items.get(i-1).w > w){
//                    //do not inclue i
//                    value[i][w] = value[i-1][w];
//                }
//                else{
//                    //include i and see max between including i and not including i
//                    int val1 = value[i-1][w-items.get(i-1).w] + items.get(i-1).v;
//                    int val2 = value[i-1][w];
//                    value[i][w] = Math.max(val1, val2);
//                }
//            }
//        }
//        return value[n][W];
//    }
//
//    public static void main(String[] args){
//        List<Item> items = new ArrayList<Item>();
//        items.add(new Item(12, 4));
//        items.add(new Item(2, 2));
//        items.add(new Item(1, 1));
//        items.add(new Item(4, 10));
//        items.add(new Item(1, 2));
//
//        System.out.println(ksack(15, items));
//    }
//}
