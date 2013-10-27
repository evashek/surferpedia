package controllers;

import java.util.Map;
import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
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
  
  public static Result getSurfer(String slug) {
    return ok(BioPage.render(SurferDB.getSurfer(slug), SurferDB.getSurfers()));
  }

  public static Result newSurfer() {
    Map<String, Boolean> types = SurferTypes.getTypes();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class);
    return ok(ManageSurfer.render(surferForm, types, SurferDB.getSurfers()));
  }
  
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return redirect(routes.Application.index());
  }
  
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Map<String, Boolean> types = SurferTypes.getTypes(data.type);
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render(surferForm, types, SurferDB.getSurfers()));
  }
  
  public static Result postSurfer() {
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).bindFromRequest();
    Map<String, Boolean> types;
    if (surferForm.hasErrors()) {
      System.out.println("Errors exist.");
      types = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render(surferForm, types, SurferDB.getSurfers()));
    }
    else {
      SurferFormData data = surferForm.get();
      SurferDB.store(data);
      types = SurferTypes.getTypes(data.type);
      return ok(ManageSurfer.render(surferForm, types, SurferDB.getSurfers()));
    }
  }
}
