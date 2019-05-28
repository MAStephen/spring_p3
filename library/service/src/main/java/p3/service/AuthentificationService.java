package p3.service;

import p3.model.user.User;

public interface AuthentificationService {

    public User authentification(String username, String password);
    public String getResult();
    public Boolean getConnexionStatus();

}

