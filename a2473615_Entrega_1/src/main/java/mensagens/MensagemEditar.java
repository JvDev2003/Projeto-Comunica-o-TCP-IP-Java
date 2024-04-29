/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensagens;

import interfaces.MensagemInterface;

/**
 *
 * @author jvspl
 */
public class MensagemEditar implements MensagemInterface{
   	String operacao = "atualizarCandidato";
	String nome;
	String email;
	String senha;
	
	public MensagemEditar() {
		// TODO Auto-generated constructor stub
	}

    public MensagemEditar(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    } 
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
        @Override
	public String getOperacao() {
		return operacao;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
