package common;

public class DoubleStats {
    static double min(double[] array) {
        double min = array[0];
        int i = 1;
        while (i < array.length) {
            if (array[i] < min) {
                min = array[i];
            }
            i++;
        }
        return min;
    }

    static double max(double[] array) {
        double max = array[0];
        int i = 1;
        while (i < array.length) {
            if (array[i] > max) {
                max = array[i];
            }
            i++;
        }
        return max;
    }

    static double sum(double[] array) {
        double count = 0.0;
        int i = 0;
        while (i < array.length) {
            count += array[i];
            i++;
        }
        return count;
    }

    static double average(double[] array) {
        return sum(array) / array.length;
    }

    public static  Interval valueRange(double[] array) {
        return new Interval(min(array),max(array));
    }

    public static int count(double[] array, Interval interval){
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] >= interval.min() && array[i] <= interval.max()) {
                count++;
            }
        }
        return count;
    }

    public static double[] filter(double[] array, Interval interval) {
        int totalElements = count(array, interval);
        double[] values = new double[totalElements];

        for(int i = 0, idx = 0; i < array.length; i++) {
            if(array[i] >= interval.min() && array[i] <= interval.max()) {
                values[idx] = array[i];
                idx++;
            }
        }
        return values;
    }
}
