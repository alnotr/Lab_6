package Commands;

import work.*;
import personParameters.*;

import java.util.Map;

public class Count_greater_than_weight extends AbstractCommand {

    public Count_greater_than_weight(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        int count = 0;
        double newWeight = (Double) argument;
        for(Map.Entry<String, Person> entry : Manager.entrySet()) {
            Person p = entry.getValue();
            double weight = Double.valueOf(p.getWeight());
            if(newWeight < weight){
                count += 1;
            }
        }
        return new Respond("Количество элементов, вес которых больше заданного : " + count);
    }
}
