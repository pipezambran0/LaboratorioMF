/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author ifzs
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByCodEstudiante", query = "SELECT e FROM Estudiante e WHERE e.codEstudiante = :codEstudiante"),
    @NamedQuery(name = "Estudiante.findByNombreEstudiante", query = "SELECT e FROM Estudiante e WHERE e.nombreEstudiante = :nombreEstudiante"),
    @NamedQuery(name = "Estudiante.findByApellidoEstudiante", query = "SELECT e FROM Estudiante e WHERE e.apellidoEstudiante = :apellidoEstudiante"),
    @NamedQuery(name = "Estudiante.findBySemestreEstudiante", query = "SELECT e FROM Estudiante e WHERE e.semestreEstudiante = :semestreEstudiante")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTUDIANTE")
    private Integer codEstudiante;
    @Size(max = 20)
    @Column(name = "NOMBRE_ESTUDIANTE")
    private String nombreEstudiante;
    @Size(max = 20)
    @Column(name = "APELLIDO_ESTUDIANTE")
    private String apellidoEstudiante;
    @Column(name = "SEMESTRE_ESTUDIANTE")
    private Integer semestreEstudiante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<Matricula> matriculaCollection;

    public Estudiante() {
    }

    public Estudiante(Integer codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public Estudiante(Integer codEstudiante, String nombreEstudiante, String apellidoEstudiante, Integer semestreEstudiante) {
        this.codEstudiante = codEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.semestreEstudiante = semestreEstudiante;
    }
    
    public Integer getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Integer codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public Integer getSemestreEstudiante() {
        return semestreEstudiante;
    }

    public void setSemestreEstudiante(Integer semestreEstudiante) {
        this.semestreEstudiante = semestreEstudiante;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstudiante != null ? codEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codEstudiante == null && other.codEstudiante != null) || (this.codEstudiante != null && !this.codEstudiante.equals(other.codEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab.entity.Estudiante[ codEstudiante=" + codEstudiante + " ]";
    }
    
}
