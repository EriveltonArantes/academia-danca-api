package com.academiadancaapi.dto;

import jakarta.validation.constraints.*;

public class MatriculaRequestDTO {

    @NotNull(message = "AlunoId é obrigatório")
    @Positive(message = "AlunoId deve ser um ID válido (positivo)")
    private Long alunoId;
    @NotNull(message = "TurmaId é obrigatório")
    @Positive(message = "TurmaId deve ser um ID válido (positivo)")
    private Long turmaId;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @DecimalMin(value = "0.0", message = "mensalidade não pode ser negativo")
    @NotNull(message = "mensalidade não pode ser nulo")
    private java.math.BigDecimal mensalidade;
    @NotBlank(message = "forma pagamento não pode estar em branco")
    private String formaPagamento;

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.math.BigDecimal getMensalidade() { return mensalidade; }
    public void setMensalidade(java.math.BigDecimal mensalidade) { this.mensalidade = mensalidade; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}
