package com.academiadancaapi.dto;

public class MatriculaResponseDTO {

    private Long id;
    private Long alunoId;
    private Long turmaId;
    private java.time.LocalDateTime dataInicio;
    private String status;
    private java.math.BigDecimal mensalidade;
    private String formaPagamento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
