package _14Heranca;

// Classe Endereço (composição)
class Endereco {
    private String rua;
    private String cidade;
    private String estado;

    public Endereco(String rua, String cidade, String estado) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Getters
    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    // Método para exibir endereço completo
    public String getEnderecoCompleto() {
        return rua + ", " + cidade + " - " + estado;
    }
}
