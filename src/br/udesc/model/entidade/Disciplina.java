/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.model.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author phzpe
 */
@Entity
@SequenceGenerator(name = "disciplina_id", initialValue = 1, allocationSize = 1)
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_id")
    @Column(name = "id_disciplina")
    private Long id;

    @Column(name = "nome_disciplina")
    private String nome;

    @Column(name = "codigo_disciplina")
    private String codigo;

    @Column(name = "creditos_disciplina")
    private int creditos;

    @Column(name = "fase_disciplina")
    private String fase;

    @Column(name = "tipo_disciplina")
    private int tipo;

    @Column(name = "qtdAlunos_disciplina")
    private int qtdAlunos;

    @OneToMany(mappedBy = "disciplina")
    private List<RestricaoDisciplina> listaRestricaoDisciplina;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    private List<SalaHorario> listaSalaHorario;

    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = true)
    private Professor professor;

    public Disciplina() {
        listaRestricaoDisciplina = new ArrayList<>();
        listaSalaHorario = new ArrayList<>();
    }

    public Disciplina(String nome, int creditos, String fase, int tipo, int qtdAlunos, String codigo, Curso curso, Professor professor) {
        this.nome = nome;
        this.creditos = creditos;
        this.fase = fase;
        this.tipo = tipo;
        this.qtdAlunos = qtdAlunos;
        this.curso = curso;
        this.codigo = codigo;
        this.professor = professor;
        listaSalaHorario = new ArrayList<>();
        listaRestricaoDisciplina = new ArrayList<>();
    }

    public List<RestricaoDisciplina> getListaRestricaoDisciplina() {
        return listaRestricaoDisciplina;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<SalaHorario> getListaSalaHorario() {
        return listaSalaHorario;
    }

    public void setListaSalaHorario(List<SalaHorario> listaSalaHorario) {
        this.listaSalaHorario = listaSalaHorario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome
                + "\nCurso: " + curso.getNome()
                + "\nCódigo: " + codigo
                + "\nProfessor: " + professor
                + "\nCreditos: " + creditos
                + "\nFase:" + fase
                + "\nPreferência por sala: " + tipo
                + "\nQuantidade Máxima de Alunos: " + qtdAlunos
                + "\nLista de Horários: " + listaSalaHorario.size();
    }
}
