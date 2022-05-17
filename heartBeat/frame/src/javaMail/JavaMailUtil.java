package JavaMail;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.MessagingException;

public class JavaMailUtil {

    private static final String USERNAME = "20520556@gm.uit.edu.vn";
    private static final String PASSWORD = "Giahuytrinh.26102002";

    public static void sendMail(String recipient, String code) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        // dang nhap gmail ngam
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        Message message = prepareMessage(session, USERNAME, recipient, code);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static Message prepareMessage(Session session, String USERNAME, String recipient, String code) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("freshfood2052@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject("Mã khôi phục mật khẩu ứng dụng HeartBeat");
            message.setText("	Xin chào TRỊNH GIA HUY!\n"//sửa chỗ tên người dùng này
                    + "Bạn hoặc một ai đó đã sử dụng chức năng quên mật khẩu. Mã khôi phục mật khẩu của bạn là: ."
                    + "\n\n" + code + "\n\nNếu không phải là bạn, hãy liên hệ hỗ trợ hoặc đổi sang một mật khẩu mới để bảo vệ tài khoản." + "\nHeartBeat,");
            return message;
        } catch (MessagingException em) {
            em.printStackTrace();
        }
        return null;
    }

}
