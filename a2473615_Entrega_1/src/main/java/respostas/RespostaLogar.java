/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package respostas;

import interfaces.MensagemInterface;

/**
 *
 * @author jvspl
 */
public class RespostaLogar implements MensagemInterface{
    private String operacao = "loginCandidato";
    private Integer status;
    private String mensagem;
    private String token;

    public RespostaLogar() {
    }

    public RespostaLogar(Integer status, String mensagem, String token) {
        this.status = status;
        this.mensagem = mensagem;
        this.token = token;
    }
  
    /**
     *
     * @return
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
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
      
}
