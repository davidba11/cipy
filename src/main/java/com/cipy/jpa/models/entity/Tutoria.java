package com.cipy.jpa.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tutorias")
public class Tutoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tutoria")
    private Integer codTutoria;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "bandera")
    private boolean bandera;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    public Integer getCodTutoria() {
        return codTutoria;
    }

    public void setCodTutoria(Integer codTutoria) {
        this.codTutoria = codTutoria;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tutoria(Integer codTutoria) {
        this.codTutoria = codTutoria;
    }

    public Tutoria() {
        
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutoria)) {
            return false;
        }
        Tutoria other = (Tutoria) object;
        if ((this.codTutoria == null && other.codTutoria != null) || (this.codTutoria != null && !this.codTutoria.equals(other.codTutoria))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.cipy.jpa.models.entity.Tutorias[ codTutoria=" + codTutoria + " ]";
    }
}
