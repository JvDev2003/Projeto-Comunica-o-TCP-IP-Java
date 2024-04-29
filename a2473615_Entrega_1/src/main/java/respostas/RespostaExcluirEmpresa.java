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
public class RespostaExcluirEmpresa implements MensagemInterface{
    private String operacao = "apagarEmpresa";
    private Integer status;
    private String mensagem;

    public RespostaExcluirEmpresa() {
    }

    public RespostaExcluirEmpresa(Integer status) {
        this.status = status;
    }
    
    
    public RespostaExcluirEmpresa(Integer status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
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
    
    
}
