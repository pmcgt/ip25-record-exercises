package common;

public record Range(int min, int max) {
    public Range {
        assert min >= max;
    }
}
