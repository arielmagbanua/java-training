import java.util.HashMap;
import java.util.Map;

public class WillysBoolean {
    private boolean value;

    private WillysBoolean(boolean value) {
        this.value = value;
    }

    private static Map<WillysBoolean, WillysBoolean> cache = new HashMap<WillysBoolean, WillysBoolean>();

    public static WillysBoolean valueOf(boolean value) {
        WillysBoolean tmp = new WillysBoolean(value);

        if (cache.containsKey(tmp)) {
            return cache.get(tmp);
        } else {
            cache.put(tmp, tmp);
            return tmp;
        }
    }

    public static void main(String[] args) {
        WillysBoolean.valueOf(true);
        WillysBoolean.valueOf(false);

        boolean test1 = WillysBoolean.valueOf(true).value;
        boolean test2 = WillysBoolean.valueOf(false).value;
        System.out.println("Awts");
    }
}
