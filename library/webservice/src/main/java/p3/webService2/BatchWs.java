package p3.webService2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import p3.service.BorrowingService;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "batchWeb", name = "batchWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BatchWs {

	@Autowired
	BorrowingService borrowingService;

	@WebMethod
	public String sendMailBorrowingExceeded() {
		if (borrowingService == null) {
			init();
		}

		if (borrowingService.sendMailBorrowingExceeded()) {
			System.out.println("l'envoie s'est bien passé.");
			return " marche !";
		} else {
			System.out.println("problème lors de l'envoie de mails.");
			return " problème !";
		}
	}

	@WebMethod
	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
