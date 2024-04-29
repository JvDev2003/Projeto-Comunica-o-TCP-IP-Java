/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "sessao")
public class Sessao{

    @Id
    private String idsessao;
    
    @Column
    private String emailLogin;
    
    public Sessao() {
    }

    public Sessao(String idsessao, String email) {
        this.emailLogin =  email;
        this.idsessao = idsessao;
    }
    
    public String getIdsessao() {
        return idsessao;
    }

    public void setIdsessao(String idsessao) {
        this.idsessao = idsessao;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }
    
}

