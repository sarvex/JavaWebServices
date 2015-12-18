/** This publisher code and the RandService code are packaged, for convenience,
    in RandPublish.jar: 

    java -jar RandPublish.jar
*/

package rand;

import javax.xml.ws.Endpoint;                                               /** line 1 **/

public class RandPublisher {                                                /** line 2 **/
    public static void main(String[ ] args) {
	final String url = "http://localhost:8888/rs";                      /** line 3 **/
	System.out.println("Publishing RandService at endpoint " + url);

	Endpoint.publish(url, new RandService());                           /** line 4 **/
    }
}
