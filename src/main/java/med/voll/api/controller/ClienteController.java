package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.cliente.*;
import med.voll.api.medico.DadosAtualizarMedico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository ;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }
    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    public void atulizar(@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativar(@PathVariable Long id ){
        var cliente = repository.getReferenceById(id);
        System.out.println(id);
        cliente.excluir();
    }
}
