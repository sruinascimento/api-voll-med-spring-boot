package med.vall.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vall.api.model.endereco.Endereco;
import med.vall.api.model.endereco.EnderecoRepository;
import med.vall.api.model.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        Endereco endereco = new Endereco(dados.endereco());
        enderecoRepository.save(endereco);
        Medico medico = new Medico(dados);
        medico.setEndereco(endereco);
        medicoRepository.save(medico);
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size= 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        return  medicoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void  atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        Medico medico = medicoRepository.getReferenceById(Long.valueOf(dados.id()));
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.tornarInativo();
    }
}
