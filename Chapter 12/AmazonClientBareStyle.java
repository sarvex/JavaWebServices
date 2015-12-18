package amazon;

/* imports */
public class AmazonClientBareStyle { 
    public static void main(String[ ] args) {
        /* ... */
	final String accessID = args[0];
	final String secretKey = args[1];

        AWSECommerceService service = new AWSECommerceService();                  /** line 1 **/
	service.setHandlerResolver(new AwsHandlerResolver(secretKey)); 
        AWSECommerceServicePortType port = service.getAWSECommerceServicePort();  /** line 2 **/

        ItemSearchRequest request = new ItemSearchRequest();                      /** line 3 **/
        request.setSearchIndex("Books");
        request.setKeywords("Austen");
	
        ItemSearch itemSearch= new ItemSearch();                                  /** line 4 **/
        itemSearch.setAWSAccessKeyId(accessID);
	itemSearch.setAssociateTag("kalin");
        itemSearch.getRequest().add(request);                                     /** line 5 **/

        ItemSearchResponse response = port.itemSearch(itemSearch);                /** line 6 **/
        List<Items> itemsList = response.getItems();                              /** line 7 **/

	int i = 1;
        for (Items next : itemsList)                                              /** line 8 **/
	    for (Item item : next.getItem())                                      /** line 9 **/
	       System.out.println(String.format("%2d: ", i++) + 
				  item.getItemAttributes().getTitle());           /** line 10 **/
    }
}
