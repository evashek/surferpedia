package views.formdata;

import java.util.Arrays;
import java.util.List;

/**
 * Inidicates which footstyle surfer uses.
 * @author Eva Shek
 */
public class FootstyleTypes {

  /**
   * Returns list of footstyles.
   * @return Footstyle list
   */
  public static List<String> getStyles() {
    String[] styleArray = {"Regular", "Goofy"};
    return Arrays.asList(styleArray);
  }
  
}
