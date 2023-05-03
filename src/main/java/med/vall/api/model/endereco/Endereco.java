package med.vall.api.model.endereco;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Endereco")
@Table(name = "enderecos")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) this.logradouro = dados.logradouro();
        if (dados.bairro() != null) this.bairro = dados.bairro();
        if (dados.cep() != null) this.bairro = dados.bairro();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.uf() != null) this.uf = dados.uf();
        if (dados.complemento() != null) this.complemento = dados.complemento();
    }
}
