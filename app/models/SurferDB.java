package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

public class SurferDB {
  
  private static Map<String, Surfer> surfers = new HashMap<>();

  /**
   * Adds/Updates surfer information from form into database.
   * @param surferForm Surfer form info
   */
  public static void store(SurferFormData surferForm) {
    Surfer surfer = new Surfer(surferForm.name, surferForm.home, surferForm.awards, surferForm.carouselUrl,
          surferForm.bioUrl, surferForm.bio, surferForm.slug, surferForm.type);
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
  
  public static Surfer getSurfer(String slug) {
    return surfers.get(slug);
  }
  
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }

  public static List<Surfer> getMales() {
    List<Surfer> surferList = getSurfers();
    ArrayList<Surfer> males = new ArrayList<>();
    for (Surfer surfer : surferList) {
      if (surfer.getType().equals("Male")) {
        males.add(surfer);
      }
    }
    return males;
  }
  
  public static List<Surfer> getFemales() {
    List<Surfer> surferList = getSurfers();
    ArrayList<Surfer> females = new ArrayList<>();
    for (Surfer surfer : surferList) {
      if (surfer.getType().equals("Female")) {
        females.add(surfer);
      }
    }
    return females;
  }
  
  public static List<Surfer> getGroms() {
    List<Surfer> surferList = getSurfers();
    ArrayList<Surfer> groms = new ArrayList<>();
    for (Surfer surfer : surferList) {
      if (surfer.getType().equals("Grom")) {
        groms.add(surfer);
      }
    }
    return groms;
  }
  
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
  }
}
