package common;

public record Interval(double min, double max) {
    public boolean contains(double num) {
        return num >= min && num <= max;
    }
}
