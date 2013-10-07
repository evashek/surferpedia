package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.zeke;
import views.html.nikki;
import views.html.kyuss;
import views.html.cjhobgood;
import views.html.kekai;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }

  
  /**
   * Returns Zeke's profile page.
   * @return Ezekiel Lau's profile.
   */
  public static Result zeke() {
    return ok(zeke.render("Welcome to Ezekiel Lau."));
    
  }
  
  /**
   * Returns Nikki's profile page.
   * @return Nikki Van Djik's profile.
   */
  public static Result nikki() {
    return ok(nikki.render("Welcome to Nikki Van Djik."));
    
  }
  
  /**
   * Returns Kyuss' profile page.
   * @return Kyuss King's profile.
   */
  public static Result kyuss() {
    return ok(kyuss.render("Welcome to Kyuss King."));
    
  }
  
  /**
   * Returns CjHobgood' profile page.
   * @return CJ Hobgood's profile.
   */
  public static Result cjhobgood() {
    return ok(cjhobgood.render("Welcome to Kyuss King."));
    
  }
  
  /**
   * Returns Rabbit Kekai profile page.
   * @return CJ Hobgood's profile.
   */
  public static Result kekai() {
    return ok(kekai.render("Welcome to Rabbit Kekai."));
    
  }
}
