/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.PlanMunDes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Esteban
 */
@Entity
@Table(name = "objetivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetivo.findAll", query = "SELECT o FROM Objetivo o")
    , @NamedQuery(name = "Objetivo.findByIdobjetivo", query = "SELECT o FROM Objetivo o WHERE o.idobjetivo = :idobjetivo")
    , @NamedQuery(name = "Objetivo.findByObjetivo", query = "SELECT o FROM Objetivo o WHERE o.objetivo = :objetivo")})
public class Objetivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idobjetivo")
    private Integer idobjetivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "objetivo")
    private String objetivo;
    @JoinColumn(name = "categorias_idcat", referencedColumnName = "idcat")
    @ManyToOne(optional = false)
    private Categoria categoriasIdcat;

    public Objetivo() {
    }

    public Objetivo(Integer idobjetivo) {
        this.idobjetivo = idobjetivo;
    }

    public Objetivo(Integer idobjetivo, String objetivo) {
        this.idobjetivo = idobjetivo;
        this.objetivo = objetivo;
    }

    public Integer getIdobjetivo() {
        return idobjetivo;
    }

    public void setIdobjetivo(Integer idobjetivo) {
        this.idobjetivo = idobjetivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Categoria getCategoriasIdcat() {
        return categoriasIdcat;
    }

    public void setCategoriasIdcat(Categoria categoriasIdcat) {
        this.categoriasIdcat = categoriasIdcat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobjetivo != null ? idobjetivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetivo)) {
            return false;
        }
        Objetivo other = (Objetivo) object;
        if ((this.idobjetivo == null && other.idobjetivo != null) || (this.idobjetivo != null && !this.idobjetivo.equals(other.idobjetivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Objetivo[ idobjetivo=" + idobjetivo + " ]";
    }
    
}
