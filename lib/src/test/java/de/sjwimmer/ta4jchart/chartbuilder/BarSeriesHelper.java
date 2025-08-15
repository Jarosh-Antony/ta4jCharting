package de.sjwimmer.ta4jchart.chartbuilder;

import org.ta4j.core.Bar;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DoubleNum;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BarSeriesHelper {

    /**
     * Creates a series of mock bars with given close prices
     *
     * @param closes the expected close prices of the bars
     * @return a series of mock bars with given close prices
     */
    public static List<Bar> createBars(final double... closes) {
        final List<Bar> bars = new ArrayList<>(closes.length);
        for (int i = 0; i < closes.length; i++) {
            // TODO: Amount
            bars.add(new BaseBar(Duration.ofDays(1), Instant.now().minus((closes.length - i), ChronoUnit.DAYS), DoubleNum.valueOf(closes[i]), DoubleNum.valueOf(closes[i] + (double) i), DoubleNum.valueOf(Math.max(0, closes[i] - i)), DoubleNum.valueOf(closes[i]), DoubleNum.valueOf(closes[i] * (double) i), DoubleNum.valueOf(closes[i] * (double) i), 1));
        }
        return bars;
    }

    /**
     * Creates a series of mock bars
     *
     * @return a series of mock bars with given close prices
     */
    public static List<Bar> createBars() {
        return createBars(32, 26, 28, 20, 21, 23, 24, 23, 26);
    }
}
