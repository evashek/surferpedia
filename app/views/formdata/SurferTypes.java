package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows user to choose between three different types of surfers.
 * @author Eva Shek
 */
public class SurferTypes {
  private static String[] types = {"Male", "Female", "Grom"};
  
  
  /**
   * Returns a map of surfer types.
   * @return Map of types (with all types set to false)
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> mapTypes = new HashMap<>();
    for (String type : types) {
      mapTypes.put(type, false);
    }
    return mapTypes;
  }
  
  /**
   * Returns a map of surfer types.
   * @param type Surfer type
   * @return Map of types with specified type set to true.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> mapTypes = SurferTypes.getTypes();
    if (isType(type)) {
      mapTypes.put(type, true);
    }
    return mapTypes;
  }
  
  /**
   * Verifies that type is valid.
   * @param type Surfer type
   * @return True if valid, false otherwise.
   */
  public static boolean isType(String type) {
    return SurferTypes.getTypes().containsKey(type);
  }
}
