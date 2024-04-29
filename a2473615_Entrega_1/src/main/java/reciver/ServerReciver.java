/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciver;

import com.google.gson.Gson;
import mensagens.*;
import operacoes.OperacoesServerReciver;
/**
 *
 * @author jvspl
 */
public class ServerReciver {
    private static Gson gson = new Gson();
    
    public static String reciver(String menssagem){
        OperacaoMensagem operacao = gson.fromJson(menssagem, OperacaoMensagem.class);
        switch (operacao.getOperacao()) {
            case "loginCandidato":
                MensagemLogar mensagemLogin = gson.fromJson(menssagem, MensagemLogar.class);
                return OperacoesServerReciver.login(mensagemLogin);
            case "logout":
                MensagemLogout mensagemLogout = gson.fromJson(menssagem, MensagemLogout.class);
                return OperacoesServerReciver.logout(mensagemLogout);
            case "cadastrarCandidato":
                MensagemRegistrar mensagemRegistrar = gson.fromJson(menssagem, MensagemRegistrar.class);
                return OperacoesServerReciver.cadastrar(mensagemRegistrar);
            case "cadastrarEmpresa":
                MensagemRegistrarEmpresa mensagemRegistrarEmpresa = gson.fromJson(menssagem, MensagemRegistrarEmpresa.class);
                return OperacoesServerReciver.cadastrarEmpresa(mensagemRegistrarEmpresa);
            case "loginEmpresa":
                MensagemLogarEmpresa mensagemLogarEmpresa = gson.fromJson(menssagem, MensagemLogarEmpresa.class);
                return OperacoesServerReciver.loginEmpresa(mensagemLogarEmpresa);
            case "atualizarCandidato":
                MensagemEditar mensagemEditar = gson.fromJson(menssagem, MensagemEditar.class);
                return OperacoesServerReciver.atualizarCandidato(mensagemEditar);
            case "atualizarEmpresa":
                MensagemEditarEmpresa mensagemEditarEmpresa = gson.fromJson(menssagem, MensagemEditarEmpresa.class);
                return OperacoesServerReciver.atualizarEmpresa(mensagemEditarEmpresa);
            case "apagarCandidato":
                MensagemExcluirUsuario mensagemExcluirCandidato = gson.fromJson(menssagem, MensagemExcluirUsuario.class);
                return OperacoesServerReciver.excluirCandidato(mensagemExcluirCandidato);
            case "apagarEmpresa":
                MensagemExcluirEmpresa mensagemExcluirEmpresa = gson.fromJson(menssagem, MensagemExcluirEmpresa.class);
                return OperacoesServerReciver.excluirEmpresa(mensagemExcluirEmpresa);
            default:
                throw new AssertionError();
        }
    }
   
}
