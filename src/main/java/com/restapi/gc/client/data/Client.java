package com.restapi.gc.client.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientID;
    private String nombre;
    private String apellidos;
    private String nombreRazonSocial;
    private int idEmpresa;
    private String correo;
    private String direccion;
    private String telefono;
}
