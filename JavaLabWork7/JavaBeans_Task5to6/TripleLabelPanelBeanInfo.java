package JavaBeans_Task5to6;

import java.beans.*;

public class TripleLabelPanelBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor p1 =
                    new PropertyDescriptor("label1Text", TripleLabelPanel.class);
            PropertyDescriptor p2 =
                    new PropertyDescriptor("label2Text", TripleLabelPanel.class);
            PropertyDescriptor p3 =
                    new PropertyDescriptor("label3Text", TripleLabelPanel.class);

            return new PropertyDescriptor[]{p1, p2, p3};
        } catch (IntrospectionException e) {
            return null;
        }
    }
}
