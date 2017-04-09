import java.util.*;
import java.util.stream.Collectors;

class scratch {



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");

        System.out.println(list.stream().collect(Collectors.joining(", ")));
    }
}
