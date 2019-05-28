package p3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import p3.model.borrowing.Borrowing;
import p3.repository.BorrowingRepository;
import p3.service.BorrowingService;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    BorrowingRepository borrowingRepository;

    public Boolean sendMailBorrowingExceeded() {

        Boolean toRet = true;
        Calendar date8week = Calendar.getInstance();
        date8week.add(Calendar.MONTH, -2);
        Calendar date4week = Calendar.getInstance();
        date4week.add(Calendar.MONTH, -1);

        List<Borrowing> borrowingList = (List<Borrowing>) borrowingRepository.findAll();
        try {

            for (Borrowing b : borrowingList) {
                if (b.getReturnDate() == null) {
//                    Session session = Session.getDefaultInstance(System.getProperties(), null);
                    String subject = "Le rendu du livre " //+ b.getTitle()
                    + " est en retard.";
                    String email = b.getUser().getEmail();
                    if (b.isExtended()) {

                        if (b.getIssueDate().before(date8week.getTime())) {
                            String body = "Veuillez rendre votre livre " + b.getTitle() + " le plus rapidement possible.";
                            // todo SendEmail
                            sendEmail(email, subject, body);
                        }
                    } else {
                        if (b.getIssueDate().before(date4week.getTime())) {

                            String body = "Veuillez rendre votre livre " + b.getTitle() + " le plus rapidement possible ou prolonger votre emprunt.";
                            // todo SendEmail
                            sendEmail(email, subject, body);
                        }
                    }
                }
            }
        } catch (Exception e) {
            toRet = false;
            e.getMessage();
        }

        return toRet;
    }

    private static void sendEmail(String toEmail, String subject, String body) {
        try {
            final String username = "testmail.alex.dodo@gmail.com";
            final String password = "!azerty123";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("testmail.alex.dodo@gmail.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
