package _07BlocoInicializacao;

import java.util.HashMap;
import java.util.Map;

public class BlocoInicializacao {

    // Método TesteCarro para demonstração
    public static void main(String[] args) {
        System.out.println("=== INÍCIO DO MÉTODO MAIN ===");

        // Mostra a configuração carregada pelos blocos estáticos
        SistemaCadastro.mostrarConfiguracao();

        // Criando instâncias de Aluno (o bloco estático já foi executado)
        System.out.println("\nCriando instâncias de Aluno:");
        SistemaCadastro.Aluno aluno1 = new SistemaCadastro.Aluno("João Silva", 2023001);
        SistemaCadastro.Aluno aluno2 = new SistemaCadastro.Aluno("Maria Santos", 2023002);

        System.out.println(aluno1);
        System.out.println(aluno2);

        System.out.println("\n=== FIM DO MÉTODO MAIN ===");
    }
}

class SistemaCadastro {
    // Variáveis estáticas
    private static final String NOME_SISTEMA;
    private static final String VERSAO;
    private static Map<String, Integer> configuracao;

    // Primeiro bloco estático
    static {
        System.out.println("Bloco estático 1: Inicializando nome do sistema");
        NOME_SISTEMA = "Sistema de Cadastro Acadêmico";
    }

    // Segundo bloco estático
    static {
        System.out.println("Bloco estático 2: Inicializando versão");
        VERSAO = "2.5.1";

        // Inicialização mais complexa
        configuracao = new HashMap<>();
        configuracao.put("max_usuarios", 1000);
        configuracao.put("timeout_minutos", 30);
        configuracao.put("tamanho_max_arquivo", 10);
    }

    // Método estático para mostrar configuração
    public static void mostrarConfiguracao() {
        System.out.println("\nConfiguração do Sistema:");
        System.out.println("Nome: " + NOME_SISTEMA);
        System.out.println("Versão: " + VERSAO);
        configuracao.forEach((chave, valor) ->
                System.out.println(chave + ": " + valor));
    }

    // Classe interna para demonstração
    public static class Aluno {
        private String nome;
        private int matricula;

        static {
            System.out.println("\nBloco estático da classe Aluno carregado");
        }

        public Aluno(String nome, int matricula) {
            this.nome = nome;
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return "Aluno: " + nome + " (Matrícula: " + matricula + ")";
        }
    }
}
