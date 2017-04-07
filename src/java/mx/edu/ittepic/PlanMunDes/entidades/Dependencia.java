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
@Table(name = "dependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencia.findAll", query = "SELECT d FROM Dependencia d")
    , @NamedQuery(name = "Dependencia.findByIddependencia", query = "SELECT d FROM Dependencia d WHERE d.iddependencia = :iddependencia")
    , @NamedQuery(name = "Dependencia.findByClavedependencia", query = "SELECT d FROM Dependencia d WHERE d.clavedependencia = :clavedependencia")
    , @NamedQuery(name = "Dependencia.findByNombredependencia", query = "SELECT d FROM Dependencia d WHERE d.nombredependencia = :nombredependencia")})
public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddependencia")
    private Integer iddependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "clavedependencia")
    private String clavedependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombredependencia")
    private String nombredependencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependenciasIddependencia")
    private List<Departamento> departamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependenciasIddependencia")
    private List<Cuadrilla> cuadrillaList;

    public Dependencia() {
    }

    public Dependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public Dependencia(Integer iddependencia, String clavedependencia, String nombredependencia) {
        this.iddependencia = iddependencia;
        this.clavedependencia = clavedependencia;
        this.nombredependencia = nombredependencia;
    }

    public Integer getIddependencia() {
        return iddependencia;
    }

    public void setIddependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public String getClavedependencia() {
        return clavedependencia;
    }

    public void setClavedependencia(String clavedependencia) {
        this.clavedependencia = clavedependencia;
    }

    public String getNombredependencia() {
        return nombredependencia;
    }

    public void setNombredependencia(String nombredependencia) {
        this.nombredependencia = nombredependencia;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @XmlTransient
    public List<Cuadrilla> getCuadrillaList() {
        return cuadrillaList;
    }

    public void setCuadrillaList(List<Cuadrilla> cuadrillaList) {
        this.cuadrillaList = cuadrillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddependencia != null ? iddependencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependencia)) {
            return false;
        }
        Dependencia other = (Dependencia) object;
        if ((this.iddependencia == null && other.iddependencia != null) || (this.iddependencia != null && !this.iddependencia.equals(other.iddependencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Dependencia[ iddependencia=" + iddependencia + " ]";
    }
    
}
