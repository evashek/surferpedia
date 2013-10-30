package controllers;

import java.util.List;
import java.util.Map;
import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.FootstyleTypes;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.BioPage;
import views.html.Index;
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
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Retrieves a surfer by their slug.
   * @param slug surfer ID
   * @return The bio page.
   */
  public static Result getSurfer(String slug) {
    return ok(BioPage.render(SurferDB.getSurfer(slug), SurferDB.getSurfers()));
  }

  /**
   * Display a blank form page to add a new surfer.
   * @return The form page
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Map<String, Boolean> types = SurferTypes.getTypes(data.type);
    List<String> styles = FootstyleTypes.getStyles();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers()));
  }
  
  /**
   * Deletes the surfer specified by the slug.
   * @param slug Surfer ID
   * @return The index page
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return redirect(routes.Application.index());
  }
  
  /**
   * Allows the user to edit a surfer's info page.
   * @param slug Surfer ID
   * @return the edit form.
   */
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Map<String, Boolean> types = SurferTypes.getTypes(data.type);
    List<String> styles = FootstyleTypes.getStyles();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers()));
  }
  
  /**
   * Saves the data from the form and validates the entered values.
   * @return The saved form.
   */
  public static Result postSurfer() {
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).bindFromRequest();
    Map<String, Boolean> types;
    List<String> styles;
    if (surferForm.hasErrors()) {
      System.out.println("Errors exist.");
      types = SurferTypes.getTypes();
      styles = FootstyleTypes.getStyles();
      return badRequest(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers()));
    }
    else {
      SurferFormData data = surferForm.get();
      SurferDB.store(data);
      types = SurferTypes.getTypes(data.type);
      styles = FootstyleTypes.getStyles();
      return ok(ManageSurfer.render(surferForm, types, styles, SurferDB.getSurfers()));
    }
  }
}
