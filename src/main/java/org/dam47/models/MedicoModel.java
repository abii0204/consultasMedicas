package org.dam47.models;

public class MedicoModel {
    int id;
    String nombre;
    int telefono_contacto;
    String email;
    int id_especialidad;

    public MedicoModel() {
    }

    public MedicoModel(int id, String nombre, int telefono_contacto, String email, int id_especialiidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono_contacto = telefono_contacto;
        this.email = email;
        this.id_especialidad = id_especialiidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(int telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }


    @Override
    public String toString() {
        return getNombre();
    }
}
