/** A sample SOAP-based service with two operations: next1 and nextN 
    The operations are mutually independent, "pure" functions.

    This service can be published, without change, using a production-grade
    web server such as Tomcat or the utility class Endpoint.
 */

package rand;

import javax.jws.WebService;                                       /** line 1 **/
import javax.jws.WebMethod;                                        /** line 2 **/
import java.util.Random;

@WebService                                                        /** line 3 **/
public class RandService {                                         /** line 4 **/
    
    @WebMethod                                                     /** line 5 **/
    public int next1() { return new Random().nextInt(); }

    @WebMethod                                                     /** line 6 **/
    public int[ ] nextN(final int n) {
	final int maxRands = 16;
	final int k = (n > maxRands) ? maxRands : Math.abs(n);
	int[ ] rands = new int[k];

	Random r = new Random();
	for (int i = 0; i < k; i++) rands[i] = r.nextInt();
	return rands;
    }
}

