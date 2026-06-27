package com.academiadancaapi.dto;

public class TurmaResponseDTO {

    private Long id;
    private Long professorId;
    private String nome;
    private String estilo;
    private String nivel;
    private String diasSemana;
    private String horario;
    private String duracao;
    private Integer vagas;
    private java.math.BigDecimal mensalidade;
    private Boolean ativa;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getDiasSemana() { return diasSemana; }
    public void setDiasSemana(String diasSemana) { this.diasSemana = diasSemana; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
    public Integer getVagas() { return vagas; }
    public void setVagas(Integer vagas) { this.vagas = vagas; }
    public java.math.BigDecimal getMensalidade() { return mensalidade; }
    public void setMensalidade(java.math.BigDecimal mensalidade) { this.mensalidade = mensalidade; }
    public Boolean getAtiva() { return ativa; }
    public void setAtiva(Boolean ativa) { this.ativa = ativa; }
}
