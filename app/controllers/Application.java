package controllers;

import java.util.List;
import java.util.Map;
import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.FootstyleTypes;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.BioPage;
import views.html.Index;
import views.html.Login;
import views.html.ManageSurfer;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(SurferDB.getSurfers(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
  
  /**
   * Retrieves a surfer by their slug.
   * @param slug surfer ID
   * @return The bio page.
   */
  public static Result getSurfer(String slug) {
    return ok(BioPage.render(SurferDB.getSurfer(slug), SurferDB.getSurfers(), Secured.isLoggedIn(ctx()),
        Secured.getUserInfo(ctx())));
  }

  /**
   * Display a blank form page to add a new surfer.
   * @return The form page
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Map<String, Boolean> types = SurferTypes.getTypes(data.type);
    List<String> styles = FootstyleTypes.getStyles();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers(), Secured.isLoggedIn(ctx()), 
        Secured.getUserInfo(ctx())));
  }
  
  /**
   * Deletes the surfer specified by the slug.
   * @param slug Surfer ID
   * @return The index page
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return redirect(routes.Application.index());
  }
  
  /**
   * Allows the user to edit a surfer's info page.
   * @param slug Surfer ID
   * @return the edit form.
   */
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Map<String, Boolean> types = SurferTypes.getTypes(data.type);
    List<String> styles = FootstyleTypes.getStyles();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers(), Secured.isLoggedIn(ctx()), 
        Secured.getUserInfo(ctx())));
  }
  
  /**
   * Saves the data from the form and validates the entered values.
   * @return The saved form.
   */
  @Security.Authenticated(Secured.class)
  public static Result postSurfer() {
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).bindFromRequest();
    Map<String, Boolean> types;
    List<String> styles;
    if (surferForm.hasErrors()) {
      System.out.println("Errors exist.");
      types = SurferTypes.getTypes();
      styles = FootstyleTypes.getStyles();
      return badRequest(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers(),
          Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
    else {
      SurferFormData data = surferForm.get();
      SurferDB.store(data);
      types = SurferTypes.getTypes(data.type);
      styles = FootstyleTypes.getStyles();
      return ok(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers(),
          Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", SurferDB.getSurfers(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {
    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", SurferDB.getSurfers(), Secured.isLoggedIn(ctx()),
          Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }

  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}
