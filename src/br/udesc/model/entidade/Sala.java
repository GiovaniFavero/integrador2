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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author phzpe
 */
@Entity
@SequenceGenerator(name = "sala_id", initialValue = 1, allocationSize = 1)
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_id")
    @Column(name = "id_sala")
    private Long id;

    @Column(name = "numero_sala")
    private String numero;

    @Column(name = "limite_sala")
    private int limite;

    @OneToMany(mappedBy = "sala")
    private List<SalaHorario> listSalaHorario;

    private boolean tipo;

    public Sala() {
        listSalaHorario = new ArrayList<>();
    }

    public Sala(String numero, int limite, boolean tipo) {
        this.numero = numero;
        this.limite = limite;
        this.tipo = tipo;
        listSalaHorario = new ArrayList<>();
    }

    public List<SalaHorario> getListSalaHorario() {
        return listSalaHorario;
    }

    public void setListSalaHorario(List<SalaHorario> listSalaHorario) {
        this.listSalaHorario = listSalaHorario;
    }

    public boolean getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
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
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.model.udesc.Sala[ id=" + id + " ]";
    }

}
