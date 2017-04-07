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
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado")
    , @NamedQuery(name = "Empleado.findByPaterno", query = "SELECT e FROM Empleado e WHERE e.paterno = :paterno")
    , @NamedQuery(name = "Empleado.findByMaterno", query = "SELECT e FROM Empleado e WHERE e.materno = :materno")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempleado")
    private Integer idempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paterno")
    private String paterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "materno")
    private String materno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "empleadoList")
    private List<Cuadrilla> cuadrillaList;
    @JoinColumn(name = "departamentos_iddepto", referencedColumnName = "iddepto")
    @ManyToOne(optional = false)
    private Departamento departamentosIddepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadosIdempleado")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadosIdempleado")
    private List<Cuadrilla> cuadrillaList1;

    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado(Integer idempleado, String paterno, String materno, String nombre) {
        this.idempleado = idempleado;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Cuadrilla> getCuadrillaList() {
        return cuadrillaList;
    }

    public void setCuadrillaList(List<Cuadrilla> cuadrillaList) {
        this.cuadrillaList = cuadrillaList;
    }

    public Departamento getDepartamentosIddepto() {
        return departamentosIddepto;
    }

    public void setDepartamentosIddepto(Departamento departamentosIddepto) {
        this.departamentosIddepto = departamentosIddepto;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Cuadrilla> getCuadrillaList1() {
        return cuadrillaList1;
    }

    public void setCuadrillaList1(List<Cuadrilla> cuadrillaList1) {
        this.cuadrillaList1 = cuadrillaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Empleado[ idempleado=" + idempleado + " ]";
    }
    
}
