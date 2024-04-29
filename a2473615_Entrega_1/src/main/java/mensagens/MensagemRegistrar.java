package mensagens;

import interfaces.MensagemInterface;

public class MensagemRegistrar implements MensagemInterface{
	String operacao = "cadastrarCandidato";
	String nome;
	String email;
	String senha;
	
	public MensagemRegistrar() {
		// TODO Auto-generated constructor stub
	}

    public MensagemRegistrar(String nome, String email, String senha) {
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
