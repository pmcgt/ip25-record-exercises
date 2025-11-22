import common.DoubleStats;
import common.Interval;

void main() {
    double[] array = {3.2,1.2,4.3, 2.9};
    IO.println(DoubleStats.count(array, new Interval(2.0,4.0)));
}
