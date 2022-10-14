package personParameters;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {
    GREEN,
    RED,
    BROWN;

    private static  List<Color> colors =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static int size = colors.size();
    private static Random RANDOM = new Random();

    public static Color randomColor(){
        Color color = colors.get(RANDOM.nextInt(size));
        return color;
    }
}
