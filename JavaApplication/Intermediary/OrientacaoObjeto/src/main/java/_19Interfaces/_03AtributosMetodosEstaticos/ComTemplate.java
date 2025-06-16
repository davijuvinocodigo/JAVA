package _19Interfaces._03AtributosMetodosEstaticos;

// Interface para notificações que suportam templates
public interface ComTemplate {
    void setTemplate(String template);
    String getTemplate();

    // Template padrão como constante estática
    String TEMPLATE_PADRAO = "Mensagem: {mensagem}";
}
