package br.udesc.model.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Entidade PessoaHorarioPreferencia que se refere as restrições dos professores.
 * @author PIN2
 */
@Entity
@SequenceGenerator(name = "pes_hor_pre_id", initialValue = 1, allocationSize = 1)
public class PessoaHorarioPreferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pes_hor_pre_id")
    @Column(name = "id_pessoaHorarioPreferencia")
    private Long id;

    private int sequencia;

    private int valor;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    public PessoaHorarioPreferencia() {
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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
        if (!(object instanceof PessoaHorarioPreferencia)) {
            return false;
        }
        PessoaHorarioPreferencia other = (PessoaHorarioPreferencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.udesc.model.entidade.PessoaHorarioPreferencia[ id=" + id + " ]";
    }

}
