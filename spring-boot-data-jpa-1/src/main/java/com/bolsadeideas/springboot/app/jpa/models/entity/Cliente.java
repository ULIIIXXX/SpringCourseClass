package com.bolsadeideas.springboot.app.jpa.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Size(min=4,max=12)  Para un tamanio deifnido de carateres
    @NotEmpty                      //estas anotaciones requieren de una dependencia  spring-boot-starter-validation
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email                    //solo se usa con cadenas Strings
    private String email;

    @NotNull                   //para los demas tipos de datos
    @Column(name = "created_at") //Para que la columna s ellame diferente a nuestra declaracion en java
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    /*@PrePersist
    private void prePersist(){
        createdAt = new Date();     //solo s eusa en caso de querer agreagr valores sin especificalros en el fromulario
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private static final long serialVersionUID = 1L;


}
