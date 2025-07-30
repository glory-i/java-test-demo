package qucoon.mod.SpringServerless.service;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final String fromEmail = "authvalidationtest@gmail.com";
    public String MSG_DISABLE_BODY = "Your account has been disabled. To regain access, please begin the password reset process using the OTP verification.";

    public String MSG_DISABLE_TITLE ="Account Disabled - Reset Account";

    public String MSG_ENROLLMENT_BODY = "Please use the 6 digit code... %s  to complete your enrollment.";

    public String MSG_ENROLLMENT_TITLE ="Enrollment";

    public String MSG_OTP_BODY = "Please use the 6-digit OTP code %s to complete an authorized action on your profile. Do not share this code with anyone.";

    public String MSG_OTP_TITLE ="OTP";

    public String MSG_LOGINFAILED_TITLE = "LOGIN FAILED";
    public String MSG_LOGINFAILED_BODY = "LOG IN ATTEMPT FAILED\n" +
            "\n" +
            "Please be informed that a FAILED attempt was made on your profile at %s, %s.\n" +
            "\n" +
            "Your profile will be DISABLED after %s more failed login attempt.\n"+
            "\n" +
            "Why are we sending this? We take security very seriously and want to keep you in the loop of activities in your profile.";

    public String MSG_SUCCESS_TITLE = "LOGIN SUCCESSFUL";
    public String MSG_SUCCESS_BODY = "LOG IN CONFIRMATION\n" +
            "\n" +
            "Please be informed that your profile was accessed at %s, (GMT+1) %s.\n" +
            "\n" +
            "Why are we sending this? We take security very seriously and want to keep you in the loop of activities in your profile.";
    public EmailService(JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    /**
     * Sends a simple text email.
     *
     * @param to      recipient address
     * @param subject message subject
     * @param body    message body
     */
    public void sendSimpleEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(fromEmail);
            msg.setTo(to);
            msg.setSubject(subject);
            msg.setText(body);
            mailSender.send(msg);
        }catch(Exception s){
            s.printStackTrace();
            //Bury the exception
        }
    }
}

