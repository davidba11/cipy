package com.cipy.jpa.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_profesor")
    private Integer codProfesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;

    public Profesor() {
    }

    public Profesor(Integer codProfesor) {
        this.codProfesor = codProfesor;
    }

    public Profesor(Integer codProfesor, String apellido, String cedula, String nombre) {
        this.codProfesor = codProfesor;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Integer getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(Integer codProfesor) {
        this.codProfesor = codProfesor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProfesor != null ? codProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.codProfesor == null && other.codProfesor != null) || (this.codProfesor != null && !this.codProfesor.equals(other.codProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cipy.jpa.models.entity.Profesores[ codProfesor=" + codProfesor + " ]";
    }
    
}
