package amazon; 

/* imports */
public class AwsHandlerResolver implements HandlerResolver {
    /* ... */
    public List<Handler> getHandlerChain(PortInfo portInfo) {                               /** line 1 **/
	List<Handler> handlerChain = new ArrayList<Handler>();
	QName serviceQName = portInfo.getServiceName();
	if(serviceQName.getLocalPart().equals("AWSECommerceService")) {
	    handlerChain.add(new AwsSoapHandler(awsSecretKey));
	}
	return handlerChain;
    }
}

class AwsSoapHandler implements SOAPHandler<SOAPMessageContext> {
    /* ... */    
    public boolean handleMessage(SOAPMessageContext mCtx) {
	Boolean outbound =                                                                  /** line 2 **/
	    (Boolean) mCtx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	if (outbound) {
	    try {
		SOAPMessage soapMessage = mCtx.getMessage();                                /** line 3 **/
		SOAPBody soapBody = soapMessage.getSOAPBody();
		Node firstChild = soapBody.getFirstChild(); // operation name
		
		String timeStamp = getTimestamp();                                          /** line 4 **/
		String signature =
		     getSignature(firstChild.getLocalName(), timeStamp, secretBytes);
		append(firstChild, "Signature", signature);                                 /** line 5 **/
		append(firstChild, "Timestamp", timeStamp);
	    }
	    ...


