/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author jvspl
 */
public class Singleton {
    private static Singleton instance;
    private String variavel;

    private Singleton() {
        variavel = "valor inicial";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getVariavel() {
        return this.variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }
  
}
