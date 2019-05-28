
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetResultResponse_QNAME = new QName("http://webService2.p3/", "getResultResponse");
    private final static QName _Init_QNAME = new QName("http://webService2.p3/", "init");
    private final static QName _GetResult_QNAME = new QName("http://webService2.p3/", "getResult");
    private final static QName _Authentification_QNAME = new QName("http://webService2.p3/", "authentification");
    private final static QName _GetConnexionStatus_QNAME = new QName("http://webService2.p3/", "getConnexionStatus");
    private final static QName _AuthentificationResponse_QNAME = new QName("http://webService2.p3/", "authentificationResponse");
    private final static QName _GetConnexionStatusResponse_QNAME = new QName("http://webService2.p3/", "getConnexionStatusResponse");
    private final static QName _InitResponse_QNAME = new QName("http://webService2.p3/", "initResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link AuthentificationResponse }
     * 
     */
    public AuthentificationResponse createAuthentificationResponse() {
        return new AuthentificationResponse();
    }

    /**
     * Create an instance of {@link GetConnexionStatusResponse }
     * 
     */
    public GetConnexionStatusResponse createGetConnexionStatusResponse() {
        return new GetConnexionStatusResponse();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link Authentification }
     * 
     */
    public Authentification createAuthentification() {
        return new Authentification();
    }

    /**
     * Create an instance of {@link GetConnexionStatus }
     * 
     */
    public GetConnexionStatus createGetConnexionStatus() {
        return new GetConnexionStatus();
    }

    /**
     * Create an instance of {@link GetResult }
     * 
     */
    public GetResult createGetResult() {
        return new GetResult();
    }

    /**
     * Create an instance of {@link GetResultResponse }
     * 
     */
    public GetResultResponse createGetResultResponse() {
        return new GetResultResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "getResultResponse")
    public JAXBElement<GetResultResponse> createGetResultResponse(GetResultResponse value) {
        return new JAXBElement<GetResultResponse>(_GetResultResponse_QNAME, GetResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "getResult")
    public JAXBElement<GetResult> createGetResult(GetResult value) {
        return new JAXBElement<GetResult>(_GetResult_QNAME, GetResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authentification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "authentification")
    public JAXBElement<Authentification> createAuthentification(Authentification value) {
        return new JAXBElement<Authentification>(_Authentification_QNAME, Authentification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConnexionStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "getConnexionStatus")
    public JAXBElement<GetConnexionStatus> createGetConnexionStatus(GetConnexionStatus value) {
        return new JAXBElement<GetConnexionStatus>(_GetConnexionStatus_QNAME, GetConnexionStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthentificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "authentificationResponse")
    public JAXBElement<AuthentificationResponse> createAuthentificationResponse(AuthentificationResponse value) {
        return new JAXBElement<AuthentificationResponse>(_AuthentificationResponse_QNAME, AuthentificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConnexionStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "getConnexionStatusResponse")
    public JAXBElement<GetConnexionStatusResponse> createGetConnexionStatusResponse(GetConnexionStatusResponse value) {
        return new JAXBElement<GetConnexionStatusResponse>(_GetConnexionStatusResponse_QNAME, GetConnexionStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService2.p3/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

}
