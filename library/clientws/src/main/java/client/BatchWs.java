
package client;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "batchWs", targetNamespace = "http://webService2.p3/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BatchWs {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webService2.p3/", className = "client.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webService2.p3/", className = "client.InitResponse")
    @Action(input = "http://webService2.p3/batchWs/initRequest", output = "http://webService2.p3/batchWs/initResponse")
    public void init();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendMailBorrowingExceeded", targetNamespace = "http://webService2.p3/", className = "client.SendMailBorrowingExceeded")
    @ResponseWrapper(localName = "sendMailBorrowingExceededResponse", targetNamespace = "http://webService2.p3/", className = "client.SendMailBorrowingExceededResponse")
    @Action(input = "http://webService2.p3/batchWs/sendMailBorrowingExceededRequest", output = "http://webService2.p3/batchWs/sendMailBorrowingExceededResponse")
    public String sendMailBorrowingExceeded();

}
