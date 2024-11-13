// Define el paquete donde se encuentra la clase.
package com.corhuila.deportes.models.entity;

import jakarta.persistence.*; // Importa las anotaciones necesarias para JPA.
import java.io.Serializable; // Importa la interfaz Serializable para la persistencia de objetos.

// Marca esta clase como una entidad JPA que se mapeará a una tabla en la base de datos.
@Entity
// Especifica el nombre de la tabla correspondiente en la base de datos.
@Table(name="tenis")
public class Tenis implements Serializable { // Implementa Serializable para permitir la serialización de la clase.

    // Declara el campo id como clave primaria de la entidad.
    @Id
    // Configura la generación automática de valores para el campo id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único para cada registro en la tabla.

    // Define la columna 'nombre' con una longitud máxima de 100 caracteres.
    @Column(length = 100)
    private String nombre; // Nombre del deporte.

    private Long jugadoresPorEquipos; // Número de jugadores por equipo.

    private Long duracion; // Duración típica de un partido.

    // Define la columna 'popularidadGlobal' con una longitud máxima de 100 caracteres.
    @Column(length = 100)
    private String popularidadGlobal; // Popularidad global del deporte.

    // Define la columna 'origen' con una longitud máxima de 100 caracteres.
    @Column(length = 100)
    private String origen; // País o región de origen del deporte.

    // Métodos getter y setter para el campo id.
    public Long getId() {
        return id; // Devuelve el valor del id.
    }

    public void setId(Long id) {
        this.id = id; // Establece el valor del id.
    }

    // Métodos getter y setter para el campo nombre.
    public String getNombre() {
        return nombre; // Devuelve el nombre del deporte.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el nombre del deporte.
    }

    // Métodos getter y setter para jugadoresPorEquipos.
    public Long getJugadoresPorEquipos() {
        return jugadoresPorEquipos; // Devuelve la cantidad de jugadores por equipo.
    }

    public void setJugadoresPorEquipos(Long jugadoresPorEquipos) {
        this.jugadoresPorEquipos = jugadoresPorEquipos; // Establece la cantidad de jugadores por equipo.
    }

    // Métodos getter y setter para duracion.
    public Long getDuracion() {
        return duracion; // Devuelve la duración de un partido.
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion; // Establece la duración de un partido.
    }

    // Métodos getter y setter para popularidadGlobal.
    public String getPopularidadGlobal() {
        return popularidadGlobal; // Devuelve la popularidad global del deporte.
    }

    public void setPopularidadGlobal(String popularidadGlobal) {
        this.popularidadGlobal = popularidadGlobal; // Establece la popularidad global del deporte.
    }

    // Métodos getter y setter para origen.
    public String getOrigen() {
        return origen; // Devuelve el origen del deporte.
    }

    public void setOrigen(String origen) {
        this.origen = origen; // Establece el origen del deporte.
    }

    // Constante para la serialización que asegura la compatibilidad de la clase.
    private static final long serialVersionUID = 1L;
}
