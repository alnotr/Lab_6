package personParameters;

import java.io.Serializable;

public class Location implements Serializable {
    private Float x; //Поле не может быть null
    private int y;
    private Long z; //Поле не может быть null

    public Location(Float x, int y, Long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Location {" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Float getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }
}
