package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

import java.util.UUID;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;
    @Enumerated(EnumType.STRING)
    private Especialidades especialidades;
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.crm = dados.crm();
        this.ativo = true;
        this.especialidades = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }
    public void atualizar(DadosAtualizarMedico dados) {
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
