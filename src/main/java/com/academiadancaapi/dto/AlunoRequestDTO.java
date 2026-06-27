package com.academiadancaapi.dto;

import jakarta.validation.constraints.*;

public class AlunoRequestDTO {

    @NotNull(message = "TurmaId é obrigatório")
    @Positive(message = "TurmaId deve ser um ID válido (positivo)")
    private Long turmaId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotNull(message = "data nascimento não pode ser nulo")
    private java.time.LocalDate dataNascimento;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "nivel não pode estar em branco")
    private String nivel;
    @NotBlank(message = "objetivo não pode estar em branco")
    private String objetivo;

    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public java.time.LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
}
