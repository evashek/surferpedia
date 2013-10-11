package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Ezekiel;
import views.html.Nikki;
import views.html.Kyuss;
import views.html.CJ;
import views.html.Kekai;
import views.html.Kelly;
import views.html.Sunny;
import views.html.Bethany;
import views.html.Jake;
import views.html.Souza;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(""));
  }

  
  /**
   * Returns Zeke's profile page.
   * @return Ezekiel Lau's profile.
   */
  public static Result zeke() {
    return ok(Ezekiel.render(""));
    
  }
  
  /**
   * Returns Nikki's profile page.
   * @return Nikki Van Djik's profile.
   */
  public static Result nikki() {
    return ok(Nikki.render(""));
    
  }
  
  /**
   * Returns Kyuss' profile page.
   * @return Kyuss King's profile.
   */
  public static Result kyuss() {
    return ok(Kyuss.render(""));
    
  }
  
  /**
   * Returns CJ Hobgood's profile page.
   * @return CJ Hobgood's profile.
   */
  public static Result cj() {
    return ok(CJ.render(""));
    
  }
  
  /**
   * Returns Rabbit Kekai's profile page.
   * @return Rabbit Kekai's profile.
   */
  public static Result kekai() {
    return ok(Kekai.render(""));
    
  }
  
  /**
   * Returns Kelly Slater's profile page.
   * @return Kelly Slater's profile.
   */
  public static Result kelly() {
    return ok(Kelly.render(""));

  }

  /**
   * Returns Bethany Hamilton's profile page.
   * @return Bethany Hamilton's profile.
   */
  public static Result bethany() {
    return ok(Bethany.render(""));

  }

  /**
   * Returns Jake Marshall's profile page.
   * @return Jake Marshall's profile.
   */
  public static Result jake() {
    return ok(Jake.render(""));

  }

  /**
   * Returns Sunny Garcia's profile page.
   * @return Sunny Garcia's profile.
   */
  public static Result sunny() {
    return ok(Sunny.render(""));

  }
  
  /**
   * Returns Adriano de Souza's profile page.
   * @return Adriano de Souza's profile.
   */
  public static Result souza() {
    return ok(Souza.render(""));

  }
}
