package com.cipy.jpa.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "clases")
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sesion")
    private Integer codSesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @ManyToMany(mappedBy = "sesionesList")
    private List<Alumno> alumnosList;
    @JoinColumn(name = "cod_asinatura", referencedColumnName = "cod_asinatura")
    @ManyToOne(optional = false)
    private Asignatura codAsinatura;
    @JoinColumn(name = "cod_Profesor", referencedColumnName = "cod_Profesor")
    @ManyToOne(optional = false)
    private Profesor codProfesor;

    public Sesion() {
    }

    public Sesion(Integer codSesion) {
        this.codSesion = codSesion;
    }

    public Sesion(Integer codSesion, Date horaEntrada) {
        this.codSesion = codSesion;
        this.horaEntrada = horaEntrada;
    }

    public Integer getCodSesion() {
        return codSesion;
    }

    public void setCodSesion(Integer codSesion) {
        this.codSesion = codSesion;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @XmlTransient
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Asignatura getCodAsinatura() {
        return codAsinatura;
    }

    public void setCodAsinatura(Asignatura codAsinatura) {
        this.codAsinatura = codAsinatura;
    }

    public Profesor getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(Profesor codProfesor) {
        this.codProfesor = codProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSesion != null ? codSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.codSesion == null && other.codSesion != null) || (this.codSesion != null && !this.codSesion.equals(other.codSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cipy.jpa.models.entity.Sesiones[ codSesion=" + codSesion + " ]";
    }
    
}
