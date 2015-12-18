import client.RandServiceService;                                           /** line 1 **/
import client.RandService;                                                  /** line 2 **/
import java.util.List;

public class RandClient {
    public static void main(String[ ] args) {
	RandService port = new RandServiceService().getRandServicePort();   /** line 3 **/
	
	// sample calls
	System.out.println(port.next1());                                   /** line 4 **/
	System.out.println();
	List<Integer> nums = port.nextN(6);                                 /** line 5 **/
	for (Integer num : nums) System.out.println(num);
    }
}
