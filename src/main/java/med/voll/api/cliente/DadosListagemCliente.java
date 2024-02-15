package med.voll.api.cliente;

import med.voll.api.medico.Medico;

public record DadosListagemCliente(String nome, String email, String cpf) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }
}
