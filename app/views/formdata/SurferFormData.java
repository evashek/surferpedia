package views.formdata;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

public class SurferFormData {
  public String name = "";
  public String home = "";
  public String awards = "";
  public String carouselUrl = "";
  public String bioUrl = "";
  public String bio = "";
  public String slug = "";
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
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("type", "Surfer type is required."));
    }
    if (SurferDB.exists(slug)) {
      errors.add(new ValidationError("slug", "Slug already exists."));
    }
    return errors.isEmpty() ? null : errors;
  }

}
