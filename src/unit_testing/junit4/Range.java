package unit_testing.junit4;

public class Range {
    private final long lowerBound;
    private final long upperBound;

    public Range(long lowerBound, long upperBound) throws IllegalArgumentException {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("Lower bound is higher then upper bound!");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isInRange(long number) {
        return number >= lowerBound && number <= upperBound;
    }
}
