package p3.controller;

import client.*;
import com.mchange.v2.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import p3.service.AuthentificationService;
//import p3.service.BorrowingService;
//import p3.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;


@Controller
public class UserController {

//    @Autowired
//    BorrowingService borrowingService;
//
//    @Autowired
//    AuthentificationService authentificationService;
//
//    @Autowired
//    UserService userService;

    @RequestMapping(value = "/acceuil/search", method = RequestMethod.POST)
    public String searchEngine(final ModelMap modelMap,
                               HttpServletRequest httpServletRequest) throws ServletException, IOException {

        String title = httpServletRequest.getParameter("title");
        String author = httpServletRequest.getParameter("author");

        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();
        if (!httpServletRequest.getParameter("title").isEmpty() && !httpServletRequest.getParameter("author").isEmpty()) {


            modelMap.addAttribute("works", userWs.searchEngineWorkByTitleAndAuthor(title, author));
//            modelMap.addAttribute("works", userService.searchEngineByTitleAndAuthor(title, author));
        } else if (!httpServletRequest.getParameter("title").isEmpty()) {

            List<Work> workListtest = userWs.searchEngineWorkByTitle(title);
            modelMap.addAttribute("works", userWs.searchEngineWorkByTitle(title));
//            modelMap.addAttribute("works", userService.searchEngineByTitle(title));
        } else if (!httpServletRequest.getParameter("author").isEmpty()) {

            modelMap.addAttribute("works", userWs.searchEngineWorkByAuthor(author));
//            modelMap.addAttribute("works", userService.searchEngineByAuthor(author));
        }
        modelMap.addAttribute("titleSearched", title);
        modelMap.addAttribute("authorSearched", author);

        return "acceuil";
    }

    @RequestMapping(value = "/acceuil", method = RequestMethod.GET)
    public ModelAndView acceuil(final ModelMap modelMap, HttpServletRequest request) throws ServletException, IOException {

        //borrowingService.sendMailBorrowingExceeded();
        Boolean connected;
        connected = (Boolean) request.getAttribute("connected");
        modelMap.addAttribute("connected", connected);
        ModelAndView modelAndView = new ModelAndView("acceuil");

        return modelAndView;
    }

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion(final ModelMap model, HttpServletRequest request)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("connected", false);
        session.setAttribute("connectedUser", null);

        return "acceuil";
    }

    @RequestMapping(value = "/connexion", method = {RequestMethod.GET, RequestMethod.POST})
    public String authentification(final ModelMap model, HttpServletRequest request)
            throws ServletException, IOException {

        if (request.getMethod().equals("GET")) {
            return "connexion";
        }

        AuthenticationWeb authenticationWeb = new AuthenticationWeb();
        AuthenticationWs authenticationWs = authenticationWeb.getAuthenticationWsPort();

        String result;
        String username = new String();
        String password = new String();
        User userInBase = new User();
        String pUsername = request.getParameter("username");
        String pPassword = request.getParameter("password");
        Boolean connexionStatus = new Boolean(false);
        HttpSession session = request.getSession();
        session.setAttribute("connected", new Boolean(false));
        session.setAttribute("connectedUser", null);

        try {
            userInBase = authenticationWs.authentification(pUsername, pPassword);
            connexionStatus = authenticationWs.getConnexionStatus();

            if (connexionStatus == true) {
                session.setAttribute("connected", new Boolean(true));
                session.setAttribute("connectedUserId", userInBase.getId());
//                model.addAttribute("usernameInBase", userInBase.getUsername());
                System.out.println("user : " + userInBase);
                System.out.println("user id : " + userInBase.getId());
//                model.addAttribute("borrowingList", userService.getBorrowingByUserId(userInBase.getId()));
            }
            result = authenticationWs.getResult();
        } catch (DataAccessException e) {
            System.out.println("usernot");
            result = "Echec de la connexion. Identifiant ou mot de passe incorrect";
        }
//        model.addAttribute("result", result);

        System.out.println("status " + connexionStatus);
        if (connexionStatus) {

            return "redirect:/borrowing";
        } else {

            return "connexion";
        }
    }

    @RequestMapping(value = "/borrowing", method = RequestMethod.GET)
    public ModelAndView getBorrows(HttpServletRequest request) {

        AuthenticationWeb authenticationWeb = new AuthenticationWeb();
        AuthenticationWs authenticationWs = authenticationWeb.getAuthenticationWsPort();

        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Boolean connected = (Boolean) session.getAttribute("connected");
        List<Borrowing> borrowingList = null;

        if (connected) {

            if (authenticationWs.getConnexionStatus()) {
                borrowingList = userWs.getBorrowingByUserId((Integer) session.getAttribute("connectedUserId"));
            }
            modelAndView.setViewName("borrowList");
        } else {
            System.out.println("non connecté : ");
            modelAndView.setViewName("connexion");
        }
        modelAndView.addObject("borrowingList", borrowingList);

        return modelAndView;
    }


    @RequestMapping(value = "/borrowinghistory", method = RequestMethod.GET)
    public ModelAndView getBorrowsHistory(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Boolean connected = (Boolean) session.getAttribute("connected");
        List<Borrowing> borrowingList = null;

        AuthenticationWeb authenticationWeb = new AuthenticationWeb();
        AuthenticationWs authenticationWs = authenticationWeb.getAuthenticationWsPort();
        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();

        if (connected) {

            if (authenticationWs.getConnexionStatus()) {
                borrowingList = userWs.getBorrowingByUserId((Integer) session.getAttribute("connectedUserId"));
            }
            modelAndView.setViewName("borrowList");
        } else {
            modelAndView.setViewName("connexion");
        }
        modelAndView.addObject("borrowingList", borrowingList);
        modelAndView.addObject("historic", true);

        return modelAndView;
    }

    @RequestMapping(value = "/borrowing/{workId}", method = RequestMethod.GET)
    public ModelAndView borrowBook(@PathVariable(value = "workId") Integer workId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Boolean connected = (Boolean) session.getAttribute("connected");
        ModelAndView model = new ModelAndView();
        System.out.println("connecté : " + connected);
        Integer userId = (Integer) session.getAttribute("connectedUserId");
        System.out.println("userControlle, borrowPhysicalBooks, userId => " + userId);

        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();

        AuthenticationWeb authenticationWeb = new AuthenticationWeb();
        AuthenticationWs authenticationWs = authenticationWeb.getAuthenticationWsPort();

        if (connected) {

            if (authenticationWs.getConnexionStatus()) {
                Borrowing borrowing = userWs.borrowingBook(workId, userId);

                if (borrowing != null) {
                    model.addObject("newBook", borrowing.getBook());
                }
                List<Borrowing> borrowingList = userWs.getBorrowingByUserId(userId);
                model.addObject("borrowingList", borrowingList);
            }
            model.setViewName("redirect:/borrowing");

            return model;
        } else {
            model.setViewName("connexion");

            return model;
        }
    }

    @RequestMapping(value = "/extended/{borrowingId}", method = RequestMethod.GET)
    public ModelAndView extendBorrowBook(@PathVariable(value = "borrowingId") Integer borrowingId, HttpServletRequest request) {


        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();
        ModelAndView modelAndView = new ModelAndView();
        Borrowing borrowing = userWs.extendBorrowing(borrowingId);

        if (borrowing != null) {
            modelAndView.setViewName("redirect:/borrowing"); // todo pas besoin de redirection : appeler la liste des borrow direct
            // todo faire un avertissement pour dire que ça c'est bien passé
            modelAndView.addObject("message", "la modification de l'emprunt s'est bien passé");
        } else {
            modelAndView.setViewName("redirect:/acceuil");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/returnbook/{borrowingId}", method = RequestMethod.GET)
    public ModelAndView returnBook(@PathVariable(value = "borrowingId") Integer borrowingId, HttpServletRequest request) {

        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();
        ModelAndView modelAndView = new ModelAndView();
        Borrowing borrowing = userWs.returnBorrowing(borrowingId);

        if (borrowing != null) {
            modelAndView.setViewName("redirect:/borrowing");
        } else {
            modelAndView.setViewName("redirect:/acceuil");
        }

        return modelAndView;
    }


    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public ModelAndView myAccount(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Boolean connected = (Boolean) session.getAttribute("connected");
        User user = null;

        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();

        AuthenticationWeb authenticationWeb = new AuthenticationWeb();
        AuthenticationWs authenticationWs = authenticationWeb.getAuthenticationWsPort();

        if(connected) {
            if (authenticationWs.getConnexionStatus()) {
                Integer userId = (Integer) session.getAttribute("connectedUserId");
                user = userWs.getUserInfo(userId);
            }
        }
        modelAndView.addObject("userinfo", user);
        if (user != null) {
            modelAndView.setViewName("addUser");
        } else {
            modelAndView.setViewName("redirect:/acceuil");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public ModelAndView updateAccount(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Boolean connected = (Boolean) session.getAttribute("connected");
        User user = null;

        AuthenticationWeb authenticationWeb = new AuthenticationWeb();
        AuthenticationWs authenticationWs = authenticationWeb.getAuthenticationWsPort();
        UserWeb userWeb = new UserWeb();
        UserWs userWs = userWeb.getUserWsPort();

        if(connected) {
            if (authenticationWs.getConnexionStatus()) {
                Integer userId = (Integer) session.getAttribute("connectedUserId");
                user = userWs.getUserInfo(userId);

                if(StringUtils.nonEmptyString(request.getParameter("firstName"))) {
                    user.setFirstName(request.getParameter("firstName"));
                }
                if(StringUtils.nonEmptyString(request.getParameter("lastName"))) {
                    user.setLastName(request.getParameter("lastName"));
                }
                if(StringUtils.nonEmptyString(request.getParameter("userName"))) {
                    user.setUsername(request.getParameter("userName"));
                }
                if(StringUtils.nonEmptyString(request.getParameter("email"))) {
                    user.setEmail(request.getParameter("email"));
                }
                if(StringUtils.nonEmptyString(request.getParameter("password"))) {
                    user.setPassword(request.getParameter("password"));
                }
                if(StringUtils.nonEmptyString(request.getParameter("inputAddress1"))) {
                    user.setAddress(request.getParameter("inputAddress1"));
                }
                user = userWs.updateUserInfo(user, userId);
                modelAndView.addObject("userinfo", user);
            }
            modelAndView.setViewName("addUser");
        } else {
            modelAndView.setViewName("acceuil");
        }

        return modelAndView;
    }

}
