/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciver;

import com.google.gson.Gson;
import mensagens.OperacaoMensagem;
import operacoes.OperacoesUsuarioReciver;
import respostas.*;

/**
 *
 * @author jvspl
 */
public class ClienteReciver {
    private static Gson gson = new Gson();
    
    public static String Reciver(String response){
        OperacaoMensagem operacao = gson.fromJson(response, OperacaoMensagem.class);
        
        switch (operacao.getOperacao()) {
            case "loginCandidato":
                RespostaLogar respostaLogar = gson.fromJson(response, RespostaLogar.class);
                return OperacoesUsuarioReciver.LoginCandidato(respostaLogar);
            case "logout":
                RespostaLogout respostaLogout = gson.fromJson(response, RespostaLogout.class);
                return OperacoesUsuarioReciver.logoutCandidato(respostaLogout);
            case "cadastrarCandidato":
                RespostaCadastrarUsuario respostaCadastrarUsuario = gson.fromJson(response, RespostaCadastrarUsuario.class);
                return OperacoesUsuarioReciver.cadastrarCandidato(respostaCadastrarUsuario);
            case "cadastrarEmpresa":
                RespostaCadastrarEmpresa respostaCadastrarEmpresa = gson.fromJson(response, RespostaCadastrarEmpresa.class);
                return OperacoesUsuarioReciver.cadastrarEmpresa(respostaCadastrarEmpresa);
            case "loginEmpresa":
                RespostaLogarEmpresa respostaLogarEmpresa = gson.fromJson(response, RespostaLogarEmpresa.class);
                return OperacoesUsuarioReciver.logarEmpresa(respostaLogarEmpresa);
            case "atualizarCandidato":
                RespostaEditar respostaEditar = gson.fromJson(response, RespostaEditar.class);
                return OperacoesUsuarioReciver.editarUsuario(respostaEditar);
            case "atualizarEmpresa":
                RespostaEditarEmpresa respostaEditarEmpresa = gson.fromJson(response, RespostaEditarEmpresa.class);
                return OperacoesUsuarioReciver.editarEmpresa(respostaEditarEmpresa);
            case "apagarCandidato":
                RespostaExclusaoUsuario respostaExclusaoUsuario = gson.fromJson(response, RespostaExclusaoUsuario.class);
                return OperacoesUsuarioReciver.excluirUsuario(respostaExclusaoUsuario);
            case "apagarEmpresa":
                RespostaExcluirEmpresa respostaExcluirEmpresa = gson.fromJson(response, RespostaExcluirEmpresa.class);
                return OperacoesUsuarioReciver.excluirEmpresa(respostaExcluirEmpresa);
            default:
                return "";
        }
    } 
}

