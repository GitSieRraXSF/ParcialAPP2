package com.example.appsebas2;

public class Usuarios {
    String User;
    String Pass;
    Usuarios Siguiente;
    public Usuarios(String User, String Pass){
        this.User = User;
        this.Pass = Pass;
        this.Siguiente = null;
    }
}