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
public class MensagemLogarEmpresa implements MensagemInterface{
    	private String operacao = "loginEmpresa";
	private String email;
	private String senha;
	
	public MensagemLogarEmpresa() {
		// TODO Auto-generated constructor stub
	}
        
        public MensagemLogarEmpresa(String email, String senha) {
		this.senha = senha;
                this.email = email;
	}

        @Override
        public String getOperacao() {
            return operacao;
        }
        
	
	public String getSenha() {
		return senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
