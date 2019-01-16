package cl.accenture.intento2;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private String userEmail;
    private String myHash;

    public Email(String userEmail, String myHash) {
        this.userEmail = userEmail;
        this.myHash = myHash;
    }

    public void Envio(){

        final String email = "holaestoesunaprueba@gmail.com";
        final String pword = "HOLA";
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session sesion  = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(email,pword);
            }

        });

        try{


            MimeMessage mensaje = new MimeMessage(sesion);

            mensaje.setFrom(new InternetAddress(email));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            mensaje.setSubject("InneFast esta en proceso de verificar tu email, porfavor espera un momento");
            mensaje.setText("Verificando el email...");
            mensaje.setText("La Verificacion de tu email :: " + "http://localhost:8084/manager/ActivateAccount?key1-" + userEmail+"&key2-"+myHash);
            Transport.send(mensaje);
        } catch(Exception e){
            System.out.println("Enviando email... " + e);
        }
    }

}
