package com.example.appsebas2;

public class ListaUsuarios {
    private Usuarios cabeza;
    public ListaUsuarios(){
        this.cabeza = null;
    }
    public void agregarAlFinal(String User, String Pass){
        Usuarios nuevoUsuario = new Usuarios(User, Pass);
        if (cabeza == null){
            cabeza = nuevoUsuario;
            return;
        }
        Usuarios actual = cabeza;
        while (actual.Siguiente != null){
            actual = actual.Siguiente;
        }
        actual.Siguiente = nuevoUsuario;
    }
    public boolean equalUser(String user, String pass) {
        Usuarios actual = cabeza;
        while (actual.Siguiente != null) {
            if (actual.User.equals(user) && actual.Pass.equals(pass)) {
                return true;
            }
        }
        return false;
    }
}