package utils;
public class Metrics {
    public long comparisons;
    public int maxDepth;
    private long startTime;
    public Metrics() {
        comparisons = 0;
        maxDepth = 0;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public long getTime() {

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;
    }

    public void updateDepth(int depth) {

        if(depth > maxDepth) {
            maxDepth = depth;
        }

    }

    public void reset() {

        comparisons = 0;
        maxDepth = 0;

    }

}