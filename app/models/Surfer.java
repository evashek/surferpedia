package models;

/**
 * Constructs a Surfer object that stores information from a form.
 * @author Eva Shek
 */
public class Surfer {
  private String name;
  private String home;
  private String awards;
  private String carouselUrl;
  private String bioUrl;
  private String bio;
  private String slug;
  private String type;
  
  /**
   * Constructs a Surfer object with the specified values.
   * @param name Surfer name
   * @param home Hometown
   * @param awards Awards won
   * @param carouselUrl URL of carousel picture
   * @param bioUrl URL of bio picture
   * @param bio Bio information
   * @param slug URL
   * @param type male/female/grom
   */
  public Surfer(String name, String home, String awards, String carouselUrl, String bioUrl, String bio,
      String slug, String type) {
    this.setName(name);
    this.setHome(home);
    this.setAwards(awards);
    this.setCarouselUrl(carouselUrl);
    this.setBioUrl(bioUrl);
    this.setBio(bio);
    this.setSlug(slug);
    this.setType(type);
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the home
   */
  public String getHome() {
    return home;
  }

  /**
   * @param home the home to set
   */
  public void setHome(String home) {
    this.home = home;
  }

  /**
   * @return the carouselUrl
   */
  public String getCarouselUrl() {
    return carouselUrl;
  }

  /**
   * @param carouselUrl the carouselUrl to set
   */
  public void setCarouselUrl(String carouselUrl) {
    this.carouselUrl = carouselUrl;
  }

  /**
   * @return the awards
   */
  public String getAwards() {
    return awards;
  }

  /**
   * @param awards the awards to set
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }

  /**
   * @return the bioUrl
   */
  public String getBioUrl() {
    return bioUrl;
  }

  /**
   * @param bioUrl the bioUrl to set
   */
  public void setBioUrl(String bioUrl) {
    this.bioUrl = bioUrl;
  }

  /**
   * @return the bio
   */
  public String getBio() {
    return bio;
  }

  /**
   * @param bio the bio to set
   */
  public void setBio(String bio) {
    this.bio = bio;
  }

  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @param slug the slug to set
   */
  public void setSlug(String slug) {
    this.slug = slug;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }
  
  
}
