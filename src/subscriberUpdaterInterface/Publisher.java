package subscriberUpdaterInterface;

import java.awt.*;
import java.util.ArrayList;

public interface Publisher {

    ArrayList<Subscriber> subscribers = new ArrayList<>();

    void publish(Object object, SubscriptionType subscriptionType);

}
