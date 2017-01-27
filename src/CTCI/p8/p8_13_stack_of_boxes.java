package CTCI.p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class p8_13_stack_of_boxes {
    private static class Box{
        int w, h, l;
        Box(int l, int w, int h){
            this.w = w;
            this.h = h;
            this.l = l;
        }
    }

    //kinda like knapsack
    static int maxStackHeight(Box[] boxes){
        //slight optimization by sorting boxes by a dimension e.g. height
        Arrays.sort(boxes, (a, b)->b.h-a.h);
        return stackUtil(boxes, null, 0, new int[boxes.length]);
    }
    static int stackUtil(Box[] boxes, Box bottom, int index, int[] maxHeight){
        //base case
        if (index == boxes.length){
            return 0;
        }

        //include this box or not
        int withThisBox = 0;
        Box newBottom = boxes[index];
        if (canStack(newBottom, bottom)){
            if (maxHeight[index] == 0){
                maxHeight[index] = newBottom.h + stackUtil(boxes, newBottom, index+1, maxHeight);
            }
            withThisBox = maxHeight[index];
        }

        int withoutThisBox = stackUtil(boxes, bottom, index+1, maxHeight);

        return Math.max(withThisBox, withoutThisBox);
    }

    static boolean canStack(Box box, Box bottom){
        if (bottom == null) return true;
        return bottom.h > box.h && bottom.l > box.l && bottom.w > box.w;
    }

    public static void main(String[] args){
        Box[] boxes = new Box[5];
        boxes[0] = new Box(10, 10, 1);
        boxes[1] = new Box(6, 5, 10);
        boxes[2] = new Box(2, 2, 7);
        boxes[3] = new Box(4, 4, 6);
        boxes[4] = new Box(3, 3, 5);

        System.out.println(maxStackHeight(boxes));//should be 21
    }
}
