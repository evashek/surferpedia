import models.Surfer;
import models.SurferDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;


/**
 * Create a global object that can initialize surfers in the Surferpedia application.
 * @author Eva Shek
 */
public class Global extends GlobalSettings {
  
  public static final int NUM_OF_FIRST_SURFERS = 3;
  
  /**
   * Executes startup code with sample surfers.
   * @param app the Application
   */
  public void onStart(Application app) {
    SurferFormData[] firstSurfers = {
        new SurferFormData(new Surfer("Ezekiel Lau", "Honolulu, Hawaii",
        "ASP 4-Star HIC Pro Champion", "http://farm5.staticflickr.com/4073/4766299193_64be477cc8_z.jpg",
        "http://www.surfersvillage.com/img/news/57150.jpg", "Ezekiel Lau (better known as Zeke) is coming of age as " +
        		"a surfer and competitor right in front of our eyes with some impressive and creative surfing. Zeke is " +
        		"known for having a unique blend of style, speed, and power. Ezekiel sets himself apart as a private " +
        		"school student at Kamehameha Schools (an Institution for students of Hawaiian Ancestry) while pursuing " +
        		"a competitive surfing career in which he claimed 4 National Titles. Surfing is his passion and he " +
        		"hopes you will develop a passion for watching him as he comes up in rank as the next generation of " +
        		"surfing’s’ finest.", "ezekiellau", "Male")),
        new SurferFormData(new Surfer("Nikki Van Djik", "Phillip Island, VIC, Australia", "ASP 6-Star Pantin " +
        		"Classic Galicia Pro Champion", "http://surfersinsuits.com.au/wp-content/uploads/2013/02/Screen-" +
        		"shot-2013-02-13-at-11.10.54-AM.jpg", "http://farm6.staticflickr.com/5100/5584076462_a2fc01a97b_z.jpg",
        		"Nikki's Dad taught her to surf on the beaches of Phillip Island, where she has grown (is still " +
        		"growing) up. At the tender age of 10 Nikki was talent spotted by Rip Curl and in 2007 was the youngest " +
        		"ever State Junior Champion, taking out the Quiksilver State Championships at just 12 years of age. At " +
        		"14, Nikki won the local trials for a wildcard to compete in the main event of the Rip Curl Women’s Pro " +
        		"in 2009. After surfing her way to 9th place she was knocked out by team mate Steph Gilmore. Now 15, " +
        		"Nikki has been concentrating on the Pro Junior Series and is aiming for the World Tour one day.",
        		"nikkivandjik", "Female")),
        new SurferFormData(new Surfer("Kyuss King", "Byron Bay, Australia", "2011 U12 NSW State Titles Champion",
            "http://kyussking.com/au/wp-content/uploads/2011/12/banner44.jpg", "http://emerysurfboards.com/austral" +
            "ia/wp-content/uploads/2011/05/Kyuss-Bali-May-June-2010-sml.jpg", "At the age of 4 Kyuss featured on " +
            		"the front cover of the local newspaper surfing across a green face solo out the Pass and with a " +
            		"stance that true of a grounded point surfer.  Kyuss’s surfing talents were soon noticed by the " +
            		"surf brands and was sponsored by Volcom at the age of 6. Kyuss loved competing and went on to win " +
            		"many national junior events over the past years and recently claimed the 2011 U12 NSW State Titles " +
            		"Championship and added 2 perfect 10 point rides at state level.", "kyussking", "Grom"))
    };
    
    for (int i = 0; i < NUM_OF_FIRST_SURFERS; i++) {
      SurferDB.store(firstSurfers[i]);
    }
  }
  
}
