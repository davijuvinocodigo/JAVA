package _11Associacao.Bidirecional;

import java.util.ArrayList;
import java.util.List;

class Medico {
    private String nome;
    private String especialidade;
    private List<Paciente> pacientes;

    public String getNome() {
        return nome;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.pacientes = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        if (!pacientes.contains(paciente)) {
            pacientes.add(paciente);
            paciente.adicionarMedico(this); // Mantém a bidirecionalidade
        }
    }

    public void listarPacientes() {
        System.out.println("Pacientes do Dr. " + nome + ":");
        pacientes.forEach(p -> System.out.println("- " + p.getNome()));
    }
}

class Paciente {
    private String nome;
    private List<Medico> medicos;

    public Paciente(String nome) {
        this.nome = nome;
        this.medicos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMedico(Medico medico) {
        if (!medicos.contains(medico)) {
            medicos.add(medico);
            if (!medico.getPacientes().contains(this)) {
                medico.adicionarPaciente(this); // Garante consistência
            }
        }
    }

    public void listarMedicos() {
        System.out.println("Médicos de " + nome + ":");
        medicos.forEach(m -> System.out.println("- Dr. " + m.getNome()));
    }
}

public class Bidirecional {
    public static void main(String[] args) {
        Medico cardiologista = new Medico("Carlos", "Cardiologia");
        Medico pediatra = new Medico("Ana", "Pediatria");

        Paciente paciente1 = new Paciente("Maria");
        Paciente paciente2 = new Paciente("José");

        cardiologista.adicionarPaciente(paciente1);
        paciente1.adicionarMedico(pediatra);
        paciente2.adicionarMedico(cardiologista);

        cardiologista.listarPacientes();
        paciente1.listarMedicos();
    }
}

/**
 *   Tipo	    Exemplo	            Característica Principal
 * Bidirecional	Médico ↔ Paciente	Ambos se conhecem e mantêm a relação atualizada
 */