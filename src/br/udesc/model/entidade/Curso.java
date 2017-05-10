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

@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_curso")
    private Long id;

    @Column(name = "nome_curso", nullable = false, unique = true)
    private String nome;

    @Column(name = "duracao_curso", nullable = false, unique = false)
    private int duracao;

    @OneToMany(mappedBy = "curso")
    private List<Disciplina> listaDisciplina;

    public Curso(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
        listaDisciplina = new ArrayList<>();
    }

    public Curso() {
        listaDisciplina = new ArrayList<>();
    }

    public void addListaDisciplina(Disciplina d) {
        listaDisciplina.add(d);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }

    public void setListaDisciplina(List<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", listaDisciplina=" + listaDisciplina + '}';
    }

}
