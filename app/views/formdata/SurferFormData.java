package views.formdata;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

/**
 * Stores Surfer information from form.
 * @author Eva Shek
 */
public class SurferFormData {
  /** The mode of which a surfer is manages: is it new or is it being edited. */
  public int mode = 0;
  /** Name of the surfer. */
  public String name = "";
  /** Surfers home town. */
  public String home = "";
  /** Surfer's awards. */
  public String awards = "";
  /** URL for carousel image. */
  public String carouselUrl = "";
  /** URL for bio page image. */
  public String bioUrl = "";
  /** Bio info. */
  public String bio = "";
  /** URL slug.*/
  public String slug = "";
  /** Male, female, or grom. */
  public String type = "";
  
  /**
   * Default no-arg constructor.
   */
  public SurferFormData() {
    
  }
  
  /**
   * Constructs a form data object that holds all the surfer information.
   * @param surfer Surfer info
   */
  public SurferFormData(Surfer surfer) {
    this.mode = surfer.getMode();
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.carouselUrl = surfer.getCarouselUrl();
    this.bioUrl = surfer.getBioUrl();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.type = surfer.getType();
  }
  
  /**
   * Checks that all fields are entered properly.
   * @return List of errors associated with form.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name == "") {
      errors.add(new ValidationError("name", "Surfer name is required."));
    }
    if (home == null || home == "") {
      errors.add(new ValidationError("home", "Surfer hometown is required."));
    }
    if (carouselUrl == null || carouselUrl == "") {
      errors.add(new ValidationError("carouselUrl", "Carousel picture URL is required."));
    }
    if (bioUrl == null || bioUrl == "") {
      errors.add(new ValidationError("bioUrl", "Biography picture URL is required."));
    }
    if (bio == null || bio == "") {
      errors.add(new ValidationError("bio", "Biography paragraph is required."));
    }
    if (slug == null || slug == "") {
      errors.add(new ValidationError("slug", "Slug is required."));
    }
    if (!StringUtils.isAlphanumeric(slug)) {
      errors.add(new ValidationError("slug", "Slug needs to contain only letters and numbers."));
    }
    if (SurferDB.exists(slug) && mode == 0) {
      errors.add(new ValidationError("slug", "Slug already exists."));
    }
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("type", "Surfer type is required."));
    }
    
    // next time this form is brought up, it will be to edit the surfer
    if (mode == 0 && errors.isEmpty()) {
      mode = 1; //EDIT
    }
    return errors.isEmpty() ? null : errors;
  }

}
