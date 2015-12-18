package predictions3;
//** relevant imports

@Path("/")                                    /** line 1 **/
public class PredictionsRS {
    @Context                                  /** line 2 **/
    private ServletContext sctx; // dependency injection
    private static PredictionsList plist; 

    public PredictionsRS() { }

    @GET                                      /** line 3 **/
    @Path("/xml")                             /** line 4 **/
    @Produces({MediaType.APPLICATION_XML})    /** line 5 **/
    public Response getXml() {
	checkContext();
	return Response.ok(plist, "application/xml").build();
    }

    @GET                                      /** line 6 **/
    @Path("/xml/{id: \\d+}")                  /** line 7 **/
    @Produces({MediaType.APPLICATION_XML}) 
    public Response getXml(@PathParam("id") int id) {
	checkContext();
	return toRequestedType(id, "application/xml");
    }
    ...
    @GET                                      /** line 8 **/
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json/{id: \\d+}")
    public Response getJson(@PathParam("id") int id) {
	checkContext();
	return toRequestedType(id, "application/json");
    }
    ...
    @POST                                     /** line 9 **/
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/create")
    public Response create(@FormParam("who") String who, 
			   @FormParam("what") String what) {
	checkContext();
	String msg = null;
	// Require both properties to create.
	if (who == null || what == null) {
	    msg = "Property 'who' or 'what' is missing.\n";
	    return Response.status(Response.Status.BAD_REQUEST).
		                                   entity(msg).
		                                   type(MediaType.TEXT_PLAIN).
		                                   build();
	}	    
	// Otherwise, create the Prediction and add it to the collection.
	int id = addPrediction(who, what);
	msg = "Prediction " + id + " created: (who = " + who + " what = " + what + ").\n";
	return Response.ok(msg, "text/plain").build();
    }
    ...
    @DELETE                                   /** line 10 **/
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/delete/{id: \\d+}")
    public Response delete(@PathParam("id") int id) {
        ...
	return Response.ok(msg, "text/plain").build();
    }

    // Prediction --> JSON document           /** line 11 **/
    private String toJson(Prediction prediction) {
	String json = "If you see this, there's a problem.";
	try {
	    json = new ObjectMapper().writeValueAsString(prediction);
	} catch(Exception e) { }
	return json;
    }
    ...
}



