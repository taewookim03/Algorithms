package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class encode_and_decode_tinyurl {
    public class Codec {
        Map<String,String> encodeMap = new HashMap<>();
        Map<String,String> decodeMap = new HashMap<>();
        Random random = new Random();
        final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        final int URL_LEN = 6;
        final String HOST = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (encodeMap.containsKey(longUrl)) return HOST + encodeMap.get(longUrl);

            String tinyUrl;
            do{
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < URL_LEN; i++){
                    sb.append(chars.charAt(random.nextInt(chars.length())));
                }
                tinyUrl = sb.toString();
            } while (decodeMap.containsKey(tinyUrl));

            encodeMap.put(longUrl, tinyUrl);
            decodeMap.put(tinyUrl, longUrl);
            return HOST + tinyUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return decodeMap.get(shortUrl.replace(HOST, ""));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
