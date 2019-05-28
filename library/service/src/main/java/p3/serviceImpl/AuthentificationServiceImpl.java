package p3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import p3.consumerDao.AuthentificationDao;
import p3.model.user.User;
import p3.service.AuthentificationService;

@Component
public class AuthentificationServiceImpl implements AuthentificationService {

    @Autowired
    AuthentificationDao authentificationDao;
    private String result;
    private Boolean connexionStatus = new Boolean(false);

    public User authentification(String username, String password) throws DataAccessException {
        User userToReturn = new User();
        User userInBase;
        connexionStatus = false;
        System.out.println("1");
        System.out.println(password);
        if (username.isEmpty()) {
            result = "Identifiant ou mot de passe incorrect.";
        } else
            if (password.isEmpty()) {
                result = "Identifiant ou mot de passe incorrect.";
            } else {
                // System.out.println(username);

                userInBase = authentificationDao.authentification(username);


                System.out.println(userInBase);
                // System.out.println(passwordInBase);
                if ( userInBase != null ) {
                    if (userInBase.getPassword().equals(password)) {
                        result = "Succès de la connexion.";
                        userToReturn = userInBase;
                        connexionStatus = true;
                    }
                } else {
                    result = "Identifiant ou mot de passe incorrect.";
                }
            }
        System.out.println("serviceBoot");
        return userToReturn;
    }

    public String getResult() {
        return result;
    }

    public Boolean getConnexionStatus() {
        return connexionStatus;
    }
}

