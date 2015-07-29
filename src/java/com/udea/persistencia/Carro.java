/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author Manuel Ochoa Loaiza
 */
@Entity
@Table(name = "carro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findByNumeromatricula", query = "SELECT c FROM Carro c WHERE c.numeromatricula = :numeromatricula"),
    @NamedQuery(name = "Carro.findByNombre", query = "SELECT c FROM Carro c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Carro.findByMarca", query = "SELECT c FROM Carro c WHERE c.marca = :marca"),
    @NamedQuery(name = "Carro.findByPrecio", query = "SELECT c FROM Carro c WHERE c.precio = :precio"),
    @NamedQuery(name = "Carro.findByImg", query = "SELECT c FROM Carro c WHERE c.img = :img")})
public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "numeromatricula")
    private String numeromatricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "img")
    private String img;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carro")
    private Collection<Venta> ventaCollection;

    public Carro() {
    }

    public Carro(String numeromatricula) {
        this.numeromatricula = numeromatricula;
    }

    public Carro(String numeromatricula, String nombre, String marca, String descripcion, BigDecimal precio, String img) {
        this.numeromatricula = numeromatricula;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.img = img;
    }

    public String getNumeromatricula() {
        return numeromatricula;
    }

    public void setNumeromatricula(String numeromatricula) {
        this.numeromatricula = numeromatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeromatricula != null ? numeromatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.numeromatricula == null && other.numeromatricula != null) || (this.numeromatricula != null && !this.numeromatricula.equals(other.numeromatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numeromatricula;
    }
    
}
