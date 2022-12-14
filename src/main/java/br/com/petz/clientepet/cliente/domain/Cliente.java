package br.com.petz.clientepet.cliente.domain;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",name = "id", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String celular;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteração;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.email = clienteRequest.getEmail();
        this.celular = clienteRequest.getCelular();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.cpf = clienteRequest.getCpf();
        this.aceitaTermos = clienteRequest.getAceitaTermos();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nomeCompleto = clienteAlteracaoRequest.getNomeCompleto();
        this.celular = clienteAlteracaoRequest.getCelular();
        this.telefone = clienteAlteracaoRequest.getTelefone();
        this.sexo = clienteAlteracaoRequest.getSexo();
        this.dataNascimento = clienteAlteracaoRequest.getDataNascimento();
        this.aceitaTermos = clienteAlteracaoRequest.getAceitaTermos();
        this.dataHoraDaUltimaAlteração = LocalDateTime.now();
    }
}

