/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.PlanMunDes.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Esteban
 */
@Entity
@Table(name = "atencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atencion.findAll", query = "SELECT a FROM Atencion a")
    , @NamedQuery(name = "Atencion.findByIdatencion", query = "SELECT a FROM Atencion a WHERE a.idatencion = :idatencion")
    , @NamedQuery(name = "Atencion.findByFecha", query = "SELECT a FROM Atencion a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Atencion.findByHora", query = "SELECT a FROM Atencion a WHERE a.hora = :hora")
    , @NamedQuery(name = "Atencion.findByUbicacion", query = "SELECT a FROM Atencion a WHERE a.ubicacion = :ubicacion")})
public class Atencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idatencion")
    private Integer idatencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ubicacion")
    private String ubicacion;
    @JoinColumn(name = "categorias_idcat", referencedColumnName = "idcat")
    @ManyToOne(optional = false)
    private Categoria categoriasIdcat;
    @JoinColumn(name = "cuadrillas_idcuadrilla", referencedColumnName = "idcuadrilla")
    @ManyToOne(optional = false)
    private Cuadrilla cuadrillasIdcuadrilla;
    @JoinColumn(name = "estatus_idestatus", referencedColumnName = "idestatus")
    @ManyToOne(optional = false)
    private Estatus estatusIdestatus;
    @JoinColumn(name = "usuarios_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuariosIdusuario;

    public Atencion() {
    }

    public Atencion(Integer idatencion) {
        this.idatencion = idatencion;
    }

    public Atencion(Integer idatencion, Date fecha, Date hora, String ubicacion) {
        this.idatencion = idatencion;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
    }

    public Integer getIdatencion() {
        return idatencion;
    }

    public void setIdatencion(Integer idatencion) {
        this.idatencion = idatencion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Categoria getCategoriasIdcat() {
        return categoriasIdcat;
    }

    public void setCategoriasIdcat(Categoria categoriasIdcat) {
        this.categoriasIdcat = categoriasIdcat;
    }

    public Cuadrilla getCuadrillasIdcuadrilla() {
        return cuadrillasIdcuadrilla;
    }

    public void setCuadrillasIdcuadrilla(Cuadrilla cuadrillasIdcuadrilla) {
        this.cuadrillasIdcuadrilla = cuadrillasIdcuadrilla;
    }

    public Estatus getEstatusIdestatus() {
        return estatusIdestatus;
    }

    public void setEstatusIdestatus(Estatus estatusIdestatus) {
        this.estatusIdestatus = estatusIdestatus;
    }

    public Usuario getUsuariosIdusuario() {
        return usuariosIdusuario;
    }

    public void setUsuariosIdusuario(Usuario usuariosIdusuario) {
        this.usuariosIdusuario = usuariosIdusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idatencion != null ? idatencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atencion)) {
            return false;
        }
        Atencion other = (Atencion) object;
        if ((this.idatencion == null && other.idatencion != null) || (this.idatencion != null && !this.idatencion.equals(other.idatencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.PlanMunDes.entidades.Atencion[ idatencion=" + idatencion + " ]";
    }
    
}
