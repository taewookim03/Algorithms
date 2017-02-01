import java.util.*;
import java.util.stream.Collectors;

class scratch{
    static int squareIndex(int i, int j){
        return (i/3) * 3 + j/3;
    }

    public static void main(String[] args){

        int i = -1;
        for (i = 0; i < 9; i++){
            if (i == 8) break;
        }
        System.out.println(i);
    }
}
