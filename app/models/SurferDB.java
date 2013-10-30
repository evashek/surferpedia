package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * A database of surfers.
 * @author Eva Shek
 */
public class SurferDB {
  
  private static Map<String, Surfer> surfers = new HashMap<>();

  /**
   * Adds/Updates surfer information from form into database.
   * @param surferForm Surfer form info
   */
  public static void store(SurferFormData surferForm) {
    Surfer surfer = new Surfer(surferForm.mode, surferForm.name, surferForm.home, surferForm.awards,
        surferForm.carouselUrl, surferForm.bioUrl, surferForm.bio, surferForm.slug, surferForm.type, 
        surferForm.footstyle);
    surfers.put(surferForm.slug, surfer);
  }
  
  /**
   * Checks whether the specified slug already exists.
   * @param slug Slug
   * @return True if slug exists, false otherwise.
   */
  public static boolean exists(String slug) {
    if (surfers.containsKey(slug)) {
      return true;
    }
    return false;
  }
  
  /**
   * Retrieves a surfer by their slug.
   * @param slug Surfer ID
   * @return the Surfer
   */
  public static Surfer getSurfer(String slug) {
    return surfers.get(slug);
  }
  
  /**
   * List of all surfers.
   * @return Surfer list
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Removes a surfer from the database.
   * @param slug Surfer ID
   */
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
  }
}
