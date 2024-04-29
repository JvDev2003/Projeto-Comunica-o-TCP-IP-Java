/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensagens;

/**
 *
 * @author jvspl
 */
public class MensagemLogout {
    private String operacao = "logout";
    private String token;

    public MensagemLogout(String token) {
        this.token = token;
    }
    
    public String getOperacao() {
        return operacao;
    }

    public String getUuid() {
        return token;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public void setUuid(String uuid) {
        this.token = uuid;
    }
    
}
