/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package respostas;

/**
 *
 * @author jvspl
 */
public class RespostaExclusaoUsuario {
    private String operacao = "apagarCandidato";
    private Integer status;
    private String Mensagem;

    public RespostaExclusaoUsuario() {
    }

    public RespostaExclusaoUsuario(Integer status) {
        this.status = status;
    }
    
    public RespostaExclusaoUsuario(Integer status, String Mensagem) {
        this.status = status;
        this.Mensagem = Mensagem;
    }

    /**
     * @return the operacao
     */
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
     * @return the Mensagem
     */
    public String getMensagem() {
        return Mensagem;
    }

    /**
     * @param Mensagem the Mensagem to set
     */
    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }
    
    
}
