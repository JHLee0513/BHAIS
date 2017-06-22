/*
 * You may distribute, remix, tweak, and build upon this work, even commercially
 * as long as it makes the world a better place.
 */


import org.jfree.data.xy.XYDataItem;

/**
 *
 * @author BrianLee
 */
public class LabelXYDataItem extends XYDataItem {
    
    private final String label;
   
    public LabelXYDataItem(double x, double y, String lab) {
        super(x, y);
        label = lab;
    }
    
    public String getLabel() {
        return label;
    }
    
}
