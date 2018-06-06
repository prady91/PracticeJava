import java.util.HashMap;

/**
 * Created by pradyumna on 5/27/18.
 */
public class TinyUrlCodec {

    HashMap<String, String> encodedUrlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encodedUrl = String.valueOf(longUrl.hashCode());
        while (encodedUrlMap.containsKey(encodedUrl)) {
            encodedUrl = String.valueOf(longUrl.hashCode())+ Math.random();
        }
        encodedUrlMap.put(encodedUrl, longUrl);
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return encodedUrlMap.get(shortUrl);
    }

}
