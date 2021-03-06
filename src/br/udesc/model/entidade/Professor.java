package br.udesc.model.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Entidade Professor
 * @author PIN2
 */
@Entity
@SequenceGenerator(name = "professor_id", initialValue = 1, allocationSize = 1)
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_id")
    @Column(name = "id_professor")
    private Long id;

    private String nome;

    private String cpf;

    @OneToMany(mappedBy = "professor")
    private List<PessoaHorarioPreferencia> listaHorario;

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> listaDisciplinaProfessor;

    public Professor() {
        listaHorario = new ArrayList<>();
        listaDisciplinaProfessor = new ArrayList<>();
    }

    public Professor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        listaHorario = new ArrayList<>();
        listaDisciplinaProfessor = new ArrayList<>();
    }

    public void addListHorario(PessoaHorarioPreferencia php) {
        listaHorario.add(php);
    }

    public void addDisciplina(Disciplina d) {
        listaDisciplinaProfessor.add(d);
    }

    public List<Disciplina> getListaDisciplinaProfessor() {
        return listaDisciplinaProfessor;
    }

    public void setListaDisciplinaProfessor(List<Disciplina> listaDisciplinaProfessor) {
        this.listaDisciplinaProfessor = listaDisciplinaProfessor;
    }

    public List<PessoaHorarioPreferencia> getListaHorario() {
        return listaHorario;
    }

    public void setListaHorario(List<PessoaHorarioPreferencia> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.udesc.model.entidade.Professor[ id=" + id + " ]";
    }

    public int getTotalCreditos() {
        int total = 0;
        for (Disciplina d : this.listaDisciplinaProfessor) {
            total = d.getCreditos();
        }
        return total;
    }

}
