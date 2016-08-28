/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab_01.modelo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "autos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autos.findAll", query = "SELECT a FROM Autos a"),
    @NamedQuery(name = "Autos.findByMatricula", query = "SELECT a FROM Autos a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Autos.findByNombre", query = "SELECT a FROM Autos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Autos.findByModelo", query = "SELECT a FROM Autos a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Autos.findByColor", query = "SELECT a FROM Autos a WHERE a.color = :color"),
    @NamedQuery(name = "Autos.findByCosto", query = "SELECT a FROM Autos a WHERE a.costo = :costo")})
public class Autos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private Integer matricula;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "modelo")
    private Integer modelo;
    @Size(max = 10)
    @Column(name = "color")
    private String color;
    @Column(name = "costo")
    private Integer costo;
    @Column
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Autos() {
    }

    public Autos(Integer matricula, String nombre, Integer modelo, String color, Integer costo, byte[] foto) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.modelo = modelo;
        this.color = color;
        this.costo = costo;
        this.foto = foto;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getFotoBase64() throws IOException {
        String mimeType = "";
        try (InputStream is = new BufferedInputStream(new ByteArrayInputStream(foto))) {
            mimeType = URLConnection.guessContentTypeFromStream(is);
        } catch(NullPointerException e){
            return null;
        }
        
        String base64 = DatatypeConverter.printBase64Binary(foto);
        System.out.println("data:" + mimeType + ";base64," + base64);
        return "data:" + mimeType + ";base64," + base64;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autos)) {
            return false;
        }
        Autos other = (Autos) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Lab_01.controller.Autos[ matricula=" + matricula + " ]";
    }

}
