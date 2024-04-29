package mensagens;

import interfaces.MensagemInterface;

public class MensagemLogar implements MensagemInterface{
	private String operacao = "loginCandidato";
	private String email;
	private String senha;
	
	public MensagemLogar() {
		// TODO Auto-generated constructor stub
	}
        
        public MensagemLogar(String email, String senha) {
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
