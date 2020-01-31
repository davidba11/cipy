package com.cipy.jpa.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "asignaturas")
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_asinatura")
    private Integer codAsinatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<Sesion> sesionesList;

    public Asignatura() {
    }

    public Asignatura(Integer codAsinatura) {
        this.codAsinatura = codAsinatura;
    }

    public Asignatura(Integer codAsinatura, String descripcion) {
        this.codAsinatura = codAsinatura;
        this.descripcion = descripcion;
    }

    public Integer getCodAsinatura() {
        return codAsinatura;
    }

    public void setCodAsinatura(Integer codAsinatura) {
        this.codAsinatura = codAsinatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Sesion> getSesionesList() {
        return sesionesList;
    }

    public void setSesionesList(List<Sesion> sesionesList) {
        this.sesionesList = sesionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAsinatura != null ? codAsinatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.codAsinatura == null && other.codAsinatura != null) || (this.codAsinatura != null && !this.codAsinatura.equals(other.codAsinatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cipy.jpa.models.entity.Asignaturas[ codAsinatura=" + codAsinatura + " ]";
    }
    
}
