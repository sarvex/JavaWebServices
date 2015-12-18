package predictions3;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/resourcesP")                         /** 1 **/
public class RestfulPrediction extends Application {    /** 2 **/
    @Override
    public Set<Class<?>> getClasses() {
	Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(PredictionsRS.class);                   /** 3 **/             
        return set;
    }
}
