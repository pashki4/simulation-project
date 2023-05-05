package ua.com.vyshniakovpo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Coordinates(int x, int y) {


    public <T extends Coordinates> List<T> getNeighbors() {
        List<T> result = new ArrayList<>();
        result.add((T) new Coordinates(x + 1, y));
        result.add((T) new Coordinates(x - 1, y));
        result.add((T) new Coordinates(x, y + 1));
        result.add((T) new Coordinates(x, y - 1));
        return result;
    }

    public static Double getLengthBetween(Coordinates from, Coordinates to) {
        return Math.sqrt((from.x - to.x) * (from.x - to.x) + (from.y - to.y) * (from.y - to.y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
