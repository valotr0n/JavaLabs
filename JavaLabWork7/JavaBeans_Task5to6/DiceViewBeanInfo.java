package JavaBeans_Task5to6;

import java.beans.*;

public class DiceViewBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor value =
                    new PropertyDescriptor("value", DiceView.class);
            return new PropertyDescriptor[]{value};
        } catch (IntrospectionException e) {
            return null;
        }
    }
}
