/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.PlanMunDes.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esteban
 */
@Entity
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdcat", query = "SELECT c FROM Categoria c WHERE c.idcat = :idcat")
    , @NamedQuery(name = "Categoria.findByClavecat", query = "SELECT c FROM Categoria c WHERE c.clavecat = :clavecat")
    , @NamedQuery(name = "Categoria.findByNombrecat", query = "SELECT c FROM Categoria c WHERE c.nombrecat = :nombrecat")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcat")
    private Integer idcat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "clavecat")
    private String clavecat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecat")
    private String nombrecat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriasIdcat")
    private List<Objetivo> objetivoList;
    @OneToMany(mappedBy = "idcatpadre")
    private List<Categoria> categoriaList;
    @JoinColumn(name = "idcatpadre", referencedColumnName = "idcat")
    @ManyToOne
    private Categoria idcatpadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriasIdcat")
    private List<Atencion> atencionList;

    public Categoria() {
    }

    public Categoria(Integer idcat) {
        this.idcat = idcat;
    }

    public Categoria(Integer idcat, String clavecat, String nombrecat) {
        this.idcat = idcat;
        this.clavecat = clavecat;
        this.nombrecat = nombrecat;
    }

    public Integer getIdcat() {
        return idcat;
    }

    public void setIdcat(Integer idcat) {
        this.idcat = idcat;
    }

    public String getClavecat() {
        return clavecat;
    }

    public void setClavecat(String clavecat) {
        this.clavecat = clavecat;
    }

    public String getNombrecat() {
        return nombrecat;
    }

    public void setNombrecat(String nombrecat) {
        this.nombrecat = nombrecat;
    }

    @XmlTransient
    public List<Objetivo> getObjetivoList() {
        return objetivoList;
    }

    public void setObjetivoList(List<Objetivo> objetivoList) {
        this.objetivoList = objetivoList;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Categoria getIdcatpadre() {
        return idcatpadre;
    }

    public void setIdcatpadre(Categoria idcatpadre) {
        this.idcatpadre = idcatpadre;
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcat != null ? idcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcat == null && other.idcat != null) || (this.idcat != null && !this.idcat.equals(other.idcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Categoria[ idcat=" + idcat + " ]";
    }
    
}
