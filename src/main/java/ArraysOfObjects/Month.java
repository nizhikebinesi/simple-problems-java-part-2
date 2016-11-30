package ArraysOfObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 11/29/16.
 */
public abstract class Month {
    public static final Map<Integer, String> month;/* = new HashMap<>(){{
        put(1, "Январь");
        put(2, "Февраль");
        put(3, "Март");
        put(4, "Апрель");
        put(5, "Май");
        put(6, "Июнь");
        put(7, "Июль");
        put(8, "Август");
        put(9, "Сентябрь");
        put(10, "Октябрь");
        put(11, "Ноябрь");
        put(12, "Декабрь");
    }};*/

    static {
        month = new HashMap<>();
        month.put(1, "Январь");
        month.put(2, "Февраль");
        month.put(3, "Март");
        month.put(4, "Апрель");
        month.put(5, "Май");
        month.put(6, "Июнь");
        month.put(7, "Июль");
        month.put(8, "Август");
        month.put(9, "Сентябрь");
        month.put(10, "Октябрь");
        month.put(11, "Ноябрь");
        month.put(12, "Декабрь");
    }
}
