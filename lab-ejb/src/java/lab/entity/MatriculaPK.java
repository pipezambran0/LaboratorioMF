/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ifzs
 */
@Embeddable
public class MatriculaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CURSO")
    private int codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ESTUDIANTE")
    private int codigoEstudiante;

    public MatriculaPK() {
    }

    public MatriculaPK(int codigoCurso, int codigoEstudiante) {
        this.codigoCurso = codigoCurso;
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCurso;
        hash += (int) codigoEstudiante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaPK)) {
            return false;
        }
        MatriculaPK other = (MatriculaPK) object;
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        if (this.codigoEstudiante != other.codigoEstudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab.entity.MatriculaPK[ codigoCurso=" + codigoCurso + ", codigoEstudiante=" + codigoEstudiante + " ]";
    }
    
}
