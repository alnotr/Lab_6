package Commands;

import personParameters.Color;
import personParameters.Person;
import work.Manager;
import work.Respond;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Remove_all_by_eye_color extends AbstractCommand{
    public Remove_all_by_eye_color(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        int count = 0;
        Color color = Color.valueOf(String.valueOf(argument));
        List<String> toRemove = new ArrayList<>();
        for(Map.Entry<String,Person> entry : Manager.entrySet()) {
            Person p = entry.getValue();
            String key = entry.getKey();
            Enum EyeColor = p.getColor();
            if(color.equals(EyeColor)){
                toRemove.add(key);
            }
        }
        for(int i = 0; i<toRemove.size(); i++){
            Manager.removeByKey(toRemove.get(i));
            count += 1;
        }
        return new Respond("Было удалено следующее количество элементов : " + count);
    }
}
