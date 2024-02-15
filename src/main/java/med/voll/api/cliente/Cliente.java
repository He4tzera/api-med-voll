package med.voll.api.cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosAtualizarMedico;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente{
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private Boolean ativo;

    private String telefone;
    @Embedded
    private Endereco endereco;
    public Cliente (DadosCadastroCliente dados){

        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.ativo = true;
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());

    }

    public void atualizar(DadosAtualizarCliente dados) {
        if(dados.nome() !=null){
            this.nome = dados.nome();
        }
        if(dados.telefone() !=null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() !=null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}




