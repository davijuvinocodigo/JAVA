package _01PrincipioResponsabilidadeUnica;

public class BankService {
    public long deposit( long amount, String accountNo) {
        //depósito valor
        return 0;
    }

    public long withDraw( long valor, String accountNo) {
        //retirar valor
        return 0;
    }

    public void printPassbook() {
        //atualiza as informações da transação na caderneta
    }

    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals( "homeLoan" )) {
            //faz algum trabalho
        }
        if (loanType.equals("personalLoan" )) {
            //faça algum trabalho
        }
        if (loanType.equals( "car" )) {
            //faça algum trabalho
        }
    }

    public void sendOTP(String medium) {
        if (medium.equals( "email" )) {
            // escreve a lógica relacionada ao email
            // usa JavaMailSenderAPI
        }
    }

}
