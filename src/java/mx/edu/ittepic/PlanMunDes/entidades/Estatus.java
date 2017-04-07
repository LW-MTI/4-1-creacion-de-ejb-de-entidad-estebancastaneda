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
@Table(name = "estatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatus.findAll", query = "SELECT e FROM Estatus e")
    , @NamedQuery(name = "Estatus.findByIdestatus", query = "SELECT e FROM Estatus e WHERE e.idestatus = :idestatus")
    , @NamedQuery(name = "Estatus.findByClaveestatus", query = "SELECT e FROM Estatus e WHERE e.claveestatus = :claveestatus")
    , @NamedQuery(name = "Estatus.findByNombreestatus", query = "SELECT e FROM Estatus e WHERE e.nombreestatus = :nombreestatus")
    , @NamedQuery(name = "Estatus.findByNombrecortoestatus", query = "SELECT e FROM Estatus e WHERE e.nombrecortoestatus = :nombrecortoestatus")})
public class Estatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestatus")
    private Integer idestatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "claveestatus")
    private String claveestatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreestatus")
    private String nombreestatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecortoestatus")
    private String nombrecortoestatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatusIdestatus")
    private List<Atencion> atencionList;

    public Estatus() {
    }

    public Estatus(Integer idestatus) {
        this.idestatus = idestatus;
    }

    public Estatus(Integer idestatus, String claveestatus, String nombreestatus, String nombrecortoestatus) {
        this.idestatus = idestatus;
        this.claveestatus = claveestatus;
        this.nombreestatus = nombreestatus;
        this.nombrecortoestatus = nombrecortoestatus;
    }

    public Integer getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Integer idestatus) {
        this.idestatus = idestatus;
    }

    public String getClaveestatus() {
        return claveestatus;
    }

    public void setClaveestatus(String claveestatus) {
        this.claveestatus = claveestatus;
    }

    public String getNombreestatus() {
        return nombreestatus;
    }

    public void setNombreestatus(String nombreestatus) {
        this.nombreestatus = nombreestatus;
    }

    public String getNombrecortoestatus() {
        return nombrecortoestatus;
    }

    public void setNombrecortoestatus(String nombrecortoestatus) {
        this.nombrecortoestatus = nombrecortoestatus;
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
        hash += (idestatus != null ? idestatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatus)) {
            return false;
        }
        Estatus other = (Estatus) object;
        if ((this.idestatus == null && other.idestatus != null) || (this.idestatus != null && !this.idestatus.equals(other.idestatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Estatus[ idestatus=" + idestatus + " ]";
    }
    
}
