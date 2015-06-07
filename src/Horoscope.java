import com.jaunt.UserAgent;
import com.jaunt.JauntException;
import com.jaunt.Element;

public class Horoscope {

    String name;
    String daily;
    static String website = "http://my.horoscope.com/astrology/free-daily-horoscope-";

    public Horoscope(String name) {
        this.name = name;
        this.daily = "";
    }

    public String getDaily() {
        if (daily.length() > 0) {
            return daily;
        }
        else {
            return scrapeDaily();
        }
    }

    String scrapeDaily() {
        try {
            UserAgent userAgent = new UserAgent();
            userAgent.visit(website + name + ".html");
            Element text = userAgent.doc.findFirst("<div id=textline");
            daily = text.innerHTML();

        } catch (JauntException e) {
            System.err.println(e);
        }
        return daily;
    }

    public String getName() {

        return name.substring(0,1).toUpperCase() + name.substring(1);
    }
}
