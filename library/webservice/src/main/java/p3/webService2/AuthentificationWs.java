package p3.webService2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import p3.model.user.User;
import p3.service.AuthentificationService;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "authenticationWeb", name = "authenticationWs")
public class AuthentificationWs {
	@Autowired
	AuthentificationService authentificationService;

	@WebMethod
	public User authentification(String username, String password) {
		if (authentificationService == null) {
			init();
		}
		return authentificationService.authentification(username, password);
	}

	@WebMethod
	public String getResult() {
		if (authentificationService == null) {
			init();
		}
		return authentificationService.getResult();
	}

	@WebMethod
	public Boolean getConnexionStatus() {
		if (authentificationService == null) {
			init();
		}
		return authentificationService.getConnexionStatus();
	}

	@WebMethod
	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
