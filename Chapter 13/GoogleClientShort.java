import java.net.URL;
import javax.net.ssl.HttpsURLConnection;                                               /** line 1 **/
import java.net.MalformedURLException;
import java.security.cert.Certificate;
/* ... */
public class GoogleClient {
    private static final String endpoint = "https://www.google.com:443/";              /** line 2 **/
    public static void main(String[ ] args) {
	new GoogleClient().doIt();
    }
    private void doIt() {
	try {
	    URL url = new URL(endpoint);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();       /** line 3 **/
	    /* ... */
    }
    /**                                                                                
	Status code:  200                                                             
	Cipher suite: TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 (see below)

	Cert. type: X.509
	Hash code:  -636230198
	Algorithm:  RSA
	Format:     X.509

	Cert. type: X.509
	Hash code:  274418414
	Algorithm:  RSA
	Format:     X.509

	Cert. type: X.509
	Hash code:  349192256
	Algorithm:  RSA
	Format:     X.509

	Cipher suite: TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 (see below)

	TLS:         Transport Layer Security (the "S" in HTTPS, descended from SSL)
        ECDHE:       Elliptical Curve Diffie-Hellman Key Exchange (handshake algorithm) 
	RSA:         Public key cryptography algorithm (type of key pair)
	AES_128_GCM: Algorithm, key size, and mode of encryption for messages 
                     (American Encryption Standard, Galois Counter Mode)
	SHA256:      Hash value (fingerprint) algorithm
    **/
    private void dumpDetails(HttpsURLConnection conn) {
	try {
	    print("Status code:  " + conn.getResponseCode());
	    print("Cipher suite: " + conn.getCipherSuite());                           /** line 4 **/
	    Certificate[ ] certs = conn.getServerCertificates();                       /** line 5 **/
	    for (Certificate cert : certs) {
		print("\tCert. type: " + cert.getType());                              /** line 6 **/
		print("\tHash code:  " + cert.hashCode());
		print("\tAlgorithm:  " + cert.getPublicKey().getAlgorithm());
		print("\tFormat:     " + cert.getPublicKey().getFormat());
		print("");
	    }
	    /* ... */
}
