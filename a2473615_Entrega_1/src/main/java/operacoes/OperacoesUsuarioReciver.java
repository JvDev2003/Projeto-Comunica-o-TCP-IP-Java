/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacoes;

import respostas.*;
import utils.Singleton;

/**
 *
 * @author jvspl
 */
public class OperacoesUsuarioReciver {
    public static String LoginCandidato(RespostaLogar resposta){
        switch (resposta.getStatus()) {
            case 401:
                return resposta.getMensagem();
            case 200:
                Singleton.getInstance().setVariavel(resposta.getToken());
                return "Sucesso no Login!!!";
            default:
                return "Ocorreu um erro no login";
        }
    }
    
    public static String logoutCandidato(RespostaLogout resposta){
        return "Usuario deslogado com Sucesso";
    }
    
    public static String cadastrarCandidato(RespostaCadastrarUsuario resposta){
        switch (resposta.getStatus()) {
            case 422:
                return resposta.getMensagem();
            case 404:
                return "Ocorreu um erro durante o cadastro";
            case 201:
                Singleton.getInstance().setVariavel(resposta.getToken());
                return "Sucesso no cadastro, você já está conectado";
            default:
                throw new AssertionError();
        }
    }
    
        public static String cadastrarEmpresa(RespostaCadastrarEmpresa resposta){
        switch (resposta.getStatus()) {
            case 422:
                return resposta.getMensagem();
            case 404:
                return "Ocorreu um erro durante o cadastro";
            case 201:
                Singleton.getInstance().setVariavel(resposta.getToken());
                return "Sucesso no cadastro, você já está conectado";
            default:
                throw new AssertionError();
        }
    }
        
    public static String logarEmpresa(RespostaLogarEmpresa resposta){
            switch (resposta.getStatus()) {
                case 401:
                    return resposta.getMensagem();
                case 200:
                    Singleton.getInstance().setVariavel(resposta.getToken());
                    return "Sucesso no Login!!!";
                default:
                    return "Ocorreu um erro no login";
            }
        }
    public static String editarUsuario(RespostaEditar reposta){
        switch (reposta.getStatus()) {
            case 404:
                return reposta.getMensagem();
            case 201:
                return "Edição feita com sucesso";
            default:
                return "Ocorreu um erro durante a edição";
        }
    }
    
    public static String editarEmpresa(RespostaEditarEmpresa resposta){
        switch (resposta.getStatus()) {
            case 404:
                return resposta.getMensagem();
            case 201:
                return "Edição realizada com sucesso!";
            default:
                return "Ocorreu um erro durante a alteração";
        }
    }
    
    public static String excluirUsuario(RespostaExclusaoUsuario resposta){
        switch (resposta.getStatus()) {
            case 404:
                return resposta.getMensagem();
            case 201:
                return "O candidato foi excluido com sucesso";
            default:
                return "Ocorreu um erro durante a exclusão";
        }
    }
    
    public static String excluirEmpresa(RespostaExcluirEmpresa resposta){
        switch (resposta.getStatus()) {
            case 404:
                return resposta.getMensagem();
            case 201:
                return "A empresa foi excluida com sucesso";
            default:
                return "Ocorreu um erro durante a exclusão";
        }
    }
}
