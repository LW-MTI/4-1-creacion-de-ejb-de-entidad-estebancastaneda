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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "cuadrillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuadrilla.findAll", query = "SELECT c FROM Cuadrilla c")
    , @NamedQuery(name = "Cuadrilla.findByIdcuadrilla", query = "SELECT c FROM Cuadrilla c WHERE c.idcuadrilla = :idcuadrilla")
    , @NamedQuery(name = "Cuadrilla.findByClavecuadrilla", query = "SELECT c FROM Cuadrilla c WHERE c.clavecuadrilla = :clavecuadrilla")
    , @NamedQuery(name = "Cuadrilla.findByNombrecuadrilla", query = "SELECT c FROM Cuadrilla c WHERE c.nombrecuadrilla = :nombrecuadrilla")})
public class Cuadrilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuadrilla")
    private Integer idcuadrilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "clavecuadrilla")
    private String clavecuadrilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecuadrilla")
    private String nombrecuadrilla;
    @JoinTable(name = "empleado_cuadrilla", joinColumns = {
        @JoinColumn(name = "cuadrillas_idcuadrilla", referencedColumnName = "idcuadrilla")}, inverseJoinColumns = {
        @JoinColumn(name = "empleados_idempleado", referencedColumnName = "idempleado")})
    @ManyToMany
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuadrillasIdcuadrilla")
    private List<Atencion> atencionList;
    @JoinColumn(name = "dependencias_iddependencia", referencedColumnName = "iddependencia")
    @ManyToOne(optional = false)
    private Dependencia dependenciasIddependencia;
    @JoinColumn(name = "empleados_idempleado", referencedColumnName = "idempleado")
    @ManyToOne(optional = false)
    private Empleado empleadosIdempleado;

    public Cuadrilla() {
    }

    public Cuadrilla(Integer idcuadrilla) {
        this.idcuadrilla = idcuadrilla;
    }

    public Cuadrilla(Integer idcuadrilla, String clavecuadrilla, String nombrecuadrilla) {
        this.idcuadrilla = idcuadrilla;
        this.clavecuadrilla = clavecuadrilla;
        this.nombrecuadrilla = nombrecuadrilla;
    }

    public Integer getIdcuadrilla() {
        return idcuadrilla;
    }

    public void setIdcuadrilla(Integer idcuadrilla) {
        this.idcuadrilla = idcuadrilla;
    }

    public String getClavecuadrilla() {
        return clavecuadrilla;
    }

    public void setClavecuadrilla(String clavecuadrilla) {
        this.clavecuadrilla = clavecuadrilla;
    }

    public String getNombrecuadrilla() {
        return nombrecuadrilla;
    }

    public void setNombrecuadrilla(String nombrecuadrilla) {
        this.nombrecuadrilla = nombrecuadrilla;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    public Dependencia getDependenciasIddependencia() {
        return dependenciasIddependencia;
    }

    public void setDependenciasIddependencia(Dependencia dependenciasIddependencia) {
        this.dependenciasIddependencia = dependenciasIddependencia;
    }

    public Empleado getEmpleadosIdempleado() {
        return empleadosIdempleado;
    }

    public void setEmpleadosIdempleado(Empleado empleadosIdempleado) {
        this.empleadosIdempleado = empleadosIdempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuadrilla != null ? idcuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadrilla)) {
            return false;
        }
        Cuadrilla other = (Cuadrilla) object;
        if ((this.idcuadrilla == null && other.idcuadrilla != null) || (this.idcuadrilla != null && !this.idcuadrilla.equals(other.idcuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Cuadrilla[ idcuadrilla=" + idcuadrilla + " ]";
    }
    
}
