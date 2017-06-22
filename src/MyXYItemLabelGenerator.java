
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrianLee
 */
public class MyXYItemLabelGenerator extends StandardXYItemLabelGenerator {
    @Override
    public String generateLabel(XYDataset dataset, int series, int item){
        XYSeriesCollection ds = (XYSeriesCollection)dataset;
        XYSeries theSeries = ds.getSeries(series);
        LabelXYDataItem theItem = (LabelXYDataItem)theSeries.getDataItem(item);
        return theItem.getLabel();
    }
}
