package aphorism2;

import org.restlet.Component;
import org.restlet.data.Protocol;

//** In the executable JAR: RestletPublish.jar
public class Main {
    public static void main(String[ ] args) throws Exception {  
	// Create a new Component.  
	Component component = new Component();                 /** line 1 **/
	
	// Add a new HTTP server listening on port 8182.  
	component.getServers().add(Protocol.HTTP, 8182);       /** line 2 **/
	
	// Attach the application.  
	component.getDefaultHost().attach("/adages",           /** line 3 **/
					  new AdagesApplication());  
	
	// Start the web server.  
	component.start();                                     /** line 4 **/
    }          
}
