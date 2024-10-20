import java.lang.reflect.Field;
import java.util.HashMap;

public class ObjectConverter {
   public static HashMap<String, BITSStudent> objectToMap(Object object) throws IllegalAccessException {
        HashMap<String, BITSStudent> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), (BITSStudent)field.get(object));
        }
        return map;
    }
}
