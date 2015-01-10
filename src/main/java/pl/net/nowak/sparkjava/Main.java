package pl.net.nowak.sparkjava;

import com.google.gson.Gson;
import spark.*;

import java.util.logging.Logger;

import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;

/**
 * Created with IntelliJ IDEA.
 * User: Maciek
 * Date: 10.01.15
 * Time: 14:56
 */
public class Main {

    private static Logger log =Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        get("/hello/:name", (req, res) -> {
                log.info(req.params(":name"));
                halt(500);
                return "Hello World" + req.params(":name");
        });


        get("/",new Route() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView("hello","");
            }
        }, new ResponseTransformer() {
                    @Override
                    public String render(Object o) throws Exception {
                        return String.valueOf(((ModelAndView)o).getModel());
                    }
                });


        new UserService();




    }

}
