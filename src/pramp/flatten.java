package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taewoo Kim on 2/19/2017.
 */
class flatten {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("key1", "1");

        Map map1 = new HashMap();
        map1.put("a", "2");
        map1.put("b", "3");
        Map map2 = new HashMap();
        map2.put("d", "3");
        map2.put("e", "1");
        map1.put("c", map2);

        map.put("key2", map1);

        Map res = flatten(map);
        for (Object k : res.keySet()){
            System.out.println(k + " " + res.get(k));
        }
    }

    static Map flatten(Map map){
        Map result = new HashMap<>();

        for (Object key : map.keySet()){
            if (map.get(key) instanceof Map){
                Map keyMap = (Map)map.get(key);
                Map subResult = flatten(keyMap);

                for (Object subKey : subResult.keySet()){
                    result.put(key + "." + subKey, subResult.get(subKey));
                }
            }
            else{
                result.put(key, map.get(key));
            }
        }
        return result;
    }
}

