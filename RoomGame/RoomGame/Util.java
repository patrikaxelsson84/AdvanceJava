import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static int random(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    }
}
