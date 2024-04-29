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
public class OperacaoMensagem implements MensagemInterface{
    private String operacao;

    public OperacaoMensagem(String operacao) {
        this.operacao = operacao;
    }

    @Override
    public String getOperacao() {
        return operacao;
    }
    
    
}
