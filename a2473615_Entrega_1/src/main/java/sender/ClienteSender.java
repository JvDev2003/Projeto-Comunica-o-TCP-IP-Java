/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sender;

import java.io.IOException;
import operacoes.OperacoesUsuarioSender;
/**
 *
 * @author jvspl
 */
public class ClienteSender {
    private static String message;
    
    public static String sender(String operacao) throws IOException{
        
        switch (operacao) {
           case ("logar"):
                try {
                    message = OperacoesUsuarioSender.realizaLogin();
                } catch (IOException e) {
                    System.out.println("Não foi Possivel fazer o login:" + e.getMessage());
                }
            break;
            case("logout"):
                    message = OperacoesUsuarioSender.realizaLogout();
                break;
            case("cadastrar"):
                    message = OperacoesUsuarioSender.realizaCadastroUsuario();
                break;
            case("cadastrarEmpresa"):
                    message = OperacoesUsuarioSender.realizaCadastroEmpresa();
                break;
            case("logarEmpresa"):
                    message = OperacoesUsuarioSender.realizaLoginEmpresa();
                break;
            case("atualizarCandidato"):
                    message = OperacoesUsuarioSender.realizaEdicao();
                break;
            case("atualizarEmpresa"):
                    message = OperacoesUsuarioSender.realizaEdicaoEmpresa();
                break;                
            case("apagarCandidato"):
                    message = OperacoesUsuarioSender.excluirUsuario();
                break;
            case("apagarEmpresa"):
                    message = OperacoesUsuarioSender.excluirEmpresa();
                break;
            default:
                message = "";
       }
       
        
       return message;
    }
    
}

