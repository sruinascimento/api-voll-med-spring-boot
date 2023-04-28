package med.vall.api.model.medico;

import med.vall.api.model.endereco.EnderecoDto;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, EnderecoDto endereco) {
}
