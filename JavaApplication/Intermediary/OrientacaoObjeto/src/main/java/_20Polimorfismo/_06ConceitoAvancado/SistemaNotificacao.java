package _20Polimorfismo._06ConceitoAvancado;

/**
 * Principais Características:
 *     Classes final: Todas as classes concretas são marcadas como final para indicar que não devem ser estendidas.
 *     Estrutura completa em um arquivo:
 *         Interfaces (Notificacao, ProvedorNotificacao)
 *         Classes abstratas (NotificacaoBase, ProvedorNotificacaoBase)
 *         Implementações concretas (NotificacaoEmail, NotificacaoSMS, NotificacaoPush)
 *         Provedores concretos (ProvedorEmail, ProvedorSMS, ProvedorPush)
 *         Gerenciador principal (GerenciadorNotificacoes)
 *     Polimorfismo: O gerenciador trata todas as notificações de forma uniforme.
 *     Genéricos: Usados nos provedores para garantir type safety.
 *     Método principal: Inclui exemplos de uso no próprio arquivo.
 *     Imutabilidade: Campos marcados como final onde apropriado.
 * Este design mantém todos os benefícios da versão anterior (extensibilidade, SOLID, etc.) enquanto demonstra como organizar um sistema completo em um único arquivo quando necessário, usando classes final para implementações concretas que não devem ser estendidas.
 */


public final class SistemaNotificacao {

    public static void main(String[] args) {
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes();
        gerenciador.adicionarProvedor(new ProvedorEmail());
        gerenciador.adicionarProvedor(new ProvedorSMS());
        gerenciador.adicionarProvedor(new ProvedorPush());

        gerenciador.enviarNotificacao(new NotificacaoEmail("user@email.com", "Assunto", "Mensagem de email"));
        gerenciador.enviarNotificacao(new NotificacaoSMS("+5511988887777", "Mensagem SMS"));
        gerenciador.enviarNotificacao(new NotificacaoPush("device123", "Título Push", "Mensagem Push"));
    }

    // Interface para notificações
    interface Notificacao {
        void enviar();
        String getMensagem();
    }

    // Classe abstrata base para notificações
    abstract static class NotificacaoBase implements Notificacao {
        protected final String destinatario;
        protected final String mensagem;

        public NotificacaoBase(String destinatario, String mensagem) {
            this.destinatario = destinatario;
            this.mensagem = mensagem;
        }

        @Override
        public String getMensagem() {
            return mensagem;
        }
    }

    // Implementações finais de notificações
    public static final class NotificacaoEmail extends NotificacaoBase {
        private final String assunto;

        public NotificacaoEmail(String destinatario, String assunto, String mensagem) {
            super(destinatario, mensagem);
            this.assunto = assunto;
        }

        @Override
        public void enviar() {
            System.out.println("Enviando Email para: " + destinatario);
            System.out.println("Assunto: " + assunto);
            System.out.println("Mensagem: " + mensagem);
        }
    }

    public static final class NotificacaoSMS extends NotificacaoBase {
        public NotificacaoSMS(String destinatario, String mensagem) {
            super(destinatario, mensagem);
        }

        @Override
        public void enviar() {
            System.out.println("Enviando SMS para: " + destinatario);
            System.out.println("Mensagem: " + mensagem);
        }
    }

    public static final class NotificacaoPush extends NotificacaoBase {
        private final String titulo;

        public NotificacaoPush(String destinatario, String titulo, String mensagem) {
            super(destinatario, mensagem);
            this.titulo = titulo;
        }

        @Override
        public void enviar() {
            System.out.println("Enviando Push para: " + destinatario);
            System.out.println("Título: " + titulo);
            System.out.println("Mensagem: " + mensagem);
        }
    }

    // Interface para provedores
    interface ProvedorNotificacao<T extends Notificacao> {
        void enviar(T notificacao);
        boolean suportaTipo(Class<?> tipoNotificacao);
    }

    // Classe abstrata para provedores
    abstract static class ProvedorNotificacaoBase<T extends Notificacao> implements ProvedorNotificacao<T> {
        private final Class<T> tipoSuportado;

        protected ProvedorNotificacaoBase(Class<T> tipoSuportado) {
            this.tipoSuportado = tipoSuportado;
        }

        @Override
        public boolean suportaTipo(Class<?> tipoNotificacao) {
            return tipoSuportado.isAssignableFrom(tipoNotificacao);
        }
    }

    // Implementações finais de provedores
    public static final class ProvedorEmail extends ProvedorNotificacaoBase<NotificacaoEmail> {
        public ProvedorEmail() {
            super(NotificacaoEmail.class);
        }

        @Override
        public void enviar(NotificacaoEmail notificacao) {
            System.out.println("[PROVEDOR EMAIL] Processando...");
            notificacao.enviar();
        }
    }

    public static final class ProvedorSMS extends ProvedorNotificacaoBase<NotificacaoSMS> {
        public ProvedorSMS() {
            super(NotificacaoSMS.class);
        }

        @Override
        public void enviar(NotificacaoSMS notificacao) {
            System.out.println("[PROVEDOR SMS] Processando...");
            notificacao.enviar();
        }
    }

    public static final class ProvedorPush extends ProvedorNotificacaoBase<NotificacaoPush> {
        public ProvedorPush() {
            super(NotificacaoPush.class);
        }

        @Override
        public void enviar(NotificacaoPush notificacao) {
            System.out.println("[PROVEDOR PUSH] Processando...");
            notificacao.enviar();
        }
    }

    // Gerenciador final
    public static final class GerenciadorNotificacoes {
        private final java.util.List<ProvedorNotificacao<?>> provedores = new java.util.ArrayList<>();

        public void adicionarProvedor(ProvedorNotificacao<?> provedor) {
            provedores.add(provedor);
        }

        public void enviarNotificacao(Notificacao notificacao) {
            provedores.stream()
                    .filter(p -> p.suportaTipo(notificacao.getClass()))
                    .findFirst()
                    .ifPresentOrElse(
                            p -> enviarUsandoProvedor(p, notificacao),
                            () -> {
                                System.out.println("Nenhum provedor encontrado. Enviando diretamente:");
                                notificacao.enviar();
                            }
                    );
        }

        @SuppressWarnings("unchecked")
        private <T extends Notificacao> void enviarUsandoProvedor(ProvedorNotificacao<?> provedor, T notificacao) {
            ((ProvedorNotificacao<T>) provedor).enviar(notificacao);
        }
    }
}
