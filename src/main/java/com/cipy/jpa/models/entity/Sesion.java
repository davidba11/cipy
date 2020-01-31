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
import org.springframework.format.annotation.DateTimeFormat;

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
//    @Temporal(TemporalType.TIME)
    private String horaEntrada;
    @Column(name = "hora_salida")
//    @Temporal(TemporalType.TIME)
    private String horaSalida;
    @ManyToMany(mappedBy = "sesionesList")
    private List<Alumno> alumnosList;
    @NotNull
    @Basic(optional = false)
    @Column(name = "fecha")
    @DateTimeFormat(pattern="yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cod_asinatura", referencedColumnName = "cod_asinatura")
    @ManyToOne(optional = false)
    private Asignatura asignatura;
    @JoinColumn(name = "cod_Profesor", referencedColumnName = "cod_Profesor")
    @ManyToOne(optional = false)
    private Profesor profesor;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sesion() {
    }

    public Sesion(Integer codSesion) {
        this.codSesion = codSesion;
    }

    public Sesion(Integer codSesion, String horaEntrada) {
        this.codSesion = codSesion;
        this.horaEntrada = horaEntrada;
    }

    public Integer getCodSesion() {
        return codSesion;
    }

    public void setCodSesion(Integer codSesion) {
        this.codSesion = codSesion;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @XmlTransient
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
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
