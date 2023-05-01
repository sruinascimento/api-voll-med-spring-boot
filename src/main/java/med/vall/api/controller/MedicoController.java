package med.vall.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vall.api.model.endereco.Endereco;
import med.vall.api.model.endereco.EnderecoRepository;
import med.vall.api.model.medico.DadosCadastroMedico;
import med.vall.api.model.medico.DadosListagemMedico;
import med.vall.api.model.medico.Medico;
import med.vall.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

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
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return  medicoRepository.findAll(paginacao)
                .map(DadosListagemMedico::new);
    }
}
