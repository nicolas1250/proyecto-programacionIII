// Define el paquete donde se encuentra la clase.
package com.corhuila.deportes.models.entity;

import jakarta.persistence.*; // Importa las anotaciones necesarias para JPA.
import java.io.Serializable; // Importa la interfaz Serializable para la persistencia de datos.

// Indica que esta clase es una entidad JPA que se mapeará a una tabla de base de datos.
@Entity
// Especifica el nombre de la tabla en la base de datos.
@Table(name="baloncesto")
public class Baloncesto implements Serializable { // Implementa Serializable para permitir que la clase se pueda serializar y deserializar.

    // Define el campo id como clave primaria de la entidad.
    @Id
    // Especifica que el valor del id se generará automáticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Atributo que almacena el identificador único de cada registro.

    // Define la columna 'nombre' con una longitud máxima de 100 caracteres.
    @Column(length = 100)
    private String nombre; // Atributo para el nombre del deporte.

    private Long jugadoresPorEquipos; // Atributo que almacena la cantidad de jugadores por equipo.

    private Long duracion; // Atributo que almacena la duración típica de un partido.

    // Define la columna 'popularidadGlobal' con una longitud máxima de 100 caracteres.
    @Column(length = 100)
    private String popularidadGlobal; // Atributo que indica la popularidad global del deporte.

    // Define la columna 'origen' con una longitud máxima de 100 caracteres.
    @Column(length = 100)
    private String origen; // Atributo que indica el país o región de origen del deporte.

    // Métodos getter y setter para el atributo id.
    public Long getId() {
        return id; // Devuelve el valor del atributo id.
    }

    public void setId(Long id) {
        this.id = id; // Asigna un valor al atributo id.
    }

    // Métodos getter y setter para el atributo nombre.
    public String getNombre() {
        return nombre; // Devuelve el valor del atributo nombre.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Asigna un valor al atributo nombre.
    }

    // Métodos getter y setter para el atributo jugadoresPorEquipos.
    public Long getJugadoresPorEquipos() {
        return jugadoresPorEquipos; // Devuelve la cantidad de jugadores por equipo.
    }

    public void setJugadoresPorEquipos(Long jugadoresPorEquipos) {
        this.jugadoresPorEquipos = jugadoresPorEquipos; // Asigna un valor al atributo jugadoresPorEquipos.
    }

    // Métodos getter y setter para el atributo duracion.
    public Long getDuracion() {
        return duracion; // Devuelve la duración del partido.
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion; // Asigna un valor al atributo duracion.
    }

    // Métodos getter y setter para el atributo popularidadGlobal.
    public String getPopularidadGlobal() {
        return popularidadGlobal; // Devuelve la popularidad global.
    }

    public void setPopularidadGlobal(String popularidadGlobal) {
        this.popularidadGlobal = popularidadGlobal; // Asigna un valor al atributo popularidadGlobal.
    }

    // Métodos getter y setter para el atributo origen.
    public String getOrigen() {
        return origen; // Devuelve el origen del deporte.
    }

    public void setOrigen(String origen) {
        this.origen = origen; // Asigna un valor al atributo origen.
    }

    // Define un valor constante serialVersionUID para mantener la compatibilidad durante la serialización.
    private static final long serialVersionUID = 1L;
}
