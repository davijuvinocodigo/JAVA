package io.github.cursodsousa.arquiteturaspring;

import io.github.cursodsousa.arquiteturaspring.todos.TodoEntity;
import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//@Lazy(false)  // Ao incluir esta componente seu objeto só vai ser utilizado quando seu código for acionado(SO UTILIZAR NOS CASOS ESPECIFICOS PORQUE GERALMENTE ELE NÃO INICIALIZA O OBJETO ASSIM NÃO SABEMOS SEU COMPORTAMENTO AO INICIALIZAR UMA APLICAÇÃO) 
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // E uma instancia de objeto q server toda aplicação
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
//@Scope("request") // contem ciclo de vida quando acaba uma chamada. (WEB)
//@Scope("session") // aguarda o (estado) durante uma sessão unica do usuario. (WEB)
//@Scope("application") // aguarda o (estado) para toda aplicação (WEB)
public class BeanGerenciado {

    private String idUsuarioLogado;

    @Autowired
    private TodoValidator validator;

    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }
}
