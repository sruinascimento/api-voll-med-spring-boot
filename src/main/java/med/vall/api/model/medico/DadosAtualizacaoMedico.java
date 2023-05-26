package med.vall.api.model.medico;

import jakarta.validation.constraints.NotBlank;
import med.vall.api.model.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotBlank
        String id,
        String nome,
        String telefone,


        DadosEndereco endereco) {
}
