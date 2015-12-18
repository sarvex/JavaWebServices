/** 
  client ===> JSP script ===> backend Java code (POJOs)
  
  curl --request GET localhost:8080/predictions/predictions.jsp
  curl --request POST localhost:8080/predictions/predictions.jsp 
**/
<jsp:useBean id    = "preds" 
	     type  = "predictions.Predictions" 
	     class = "predictions.Predictions"> 
  <% 
     String verb = request.getMethod();                        /** 1 **/

     if (!verb.equalsIgnoreCase("GET")) {                      /** 2 **/
       response.sendError(response.SC_METHOD_NOT_ALLOWED,      /** 3 **/
                          "GET requests only are allowed.");
     }
     // If it's a GET request, return the predictions.
     else {
       // Object reference application has the value 
       // pageContext.getServletContext()
       preds.setServletContext(application);                   /** 4 **/
       out.println(preds.getPredictions());                    /** 5 **/
     }
  %>
</jsp:useBean>  
