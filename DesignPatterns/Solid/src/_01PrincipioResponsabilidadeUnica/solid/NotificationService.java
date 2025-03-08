package _01PrincipioResponsabilidadeUnica.solid;

/*
*     Podemos incluir a logica relacionado ao email
*     Podemos incluir a logica relacionado ao mobile
* */
public class NotificationService {
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
        if(medium.equals("mobile")){
            //write logic using twillio API
        }
    }
}
