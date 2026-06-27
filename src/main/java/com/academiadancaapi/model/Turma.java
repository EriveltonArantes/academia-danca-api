package com.academiadancaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String estilo;
    @Column(nullable = false)
    private String nivel;
    @Column(nullable = false)
    private String diasSemana;
    @Column(nullable = false)
    private String horario;
    @Column(nullable = false)
    private String duracao;
    private Integer vagas;
    private java.math.BigDecimal mensalidade;
    private Boolean ativa;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
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
