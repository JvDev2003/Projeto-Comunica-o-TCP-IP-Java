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
public class MensagemExcluirUsuario implements MensagemInterface{
    private String operacao = "apagarCandidato";
    private String email;

    public MensagemExcluirUsuario() {
    }
    
    public MensagemExcluirUsuario(String email) {
        this.email = email;
    }

    /**
     * @return the operacao
     */
    @Override
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
