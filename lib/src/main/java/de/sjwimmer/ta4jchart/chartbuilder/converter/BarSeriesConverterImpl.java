package de.sjwimmer.ta4jchart.chartbuilder.converter;

import org.jfree.data.xy.DefaultHighLowDataset;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;

import java.util.Date;

public class BarSeriesConverterImpl implements BarSeriesConverter {

    @Override
    public DefaultHighLowDataset convert(BarSeries barSeries) {
        return convert(barSeries, barSeries.getName());
    }

    @Override
    public DefaultHighLowDataset convert(BarSeries barSeries, String name) {
        if (barSeries.getBarCount() < 1) {
            throw new IllegalArgumentException("Bar series needs at least two bars");
        }

        final int nbBars = barSeries.getBarCount();

        final Date[] dates = new Date[nbBars];
        final double[] opens = new double[nbBars];
        final double[] highs = new double[nbBars];
        final double[] lows = new double[nbBars];
        final double[] closes = new double[nbBars];
        final double[] volumes = new double[nbBars];

        int i = 0;
        for (Bar bar : barSeries.getBarData()) {
            dates[i] = Date.from(bar.getEndTime());
            opens[i] = bar.getOpenPrice().doubleValue();
            highs[i] = bar.getHighPrice().doubleValue();
            lows[i] = bar.getLowPrice().doubleValue();
            closes[i] = bar.getClosePrice().doubleValue();
            volumes[i] = bar.getVolume().doubleValue();
            i++;
        }
        return new DefaultHighLowDataset(name, dates, highs, lows, opens, closes, volumes);
    }
}
