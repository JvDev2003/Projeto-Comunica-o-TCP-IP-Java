/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacoes;

import com.google.gson.Gson;
import dao.*;
import mensagens.*;
import model.*;
import respostas.*;

/**
 *
 * @author jvspl
 */
public class OperacoesServerReciver {
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static SessaoDao sessaoDAO = new SessaoDao();
    private static EmpresaDAO empresaDAO = new EmpresaDAO(); 
    private static Gson gson = new Gson();
    
    public static String login(MensagemLogar msg){
    String consult = usuarioDAO.logarUsuario(msg.getEmail(), msg.getSenha());
    RespostaLogar resposta;
    if("Nenhum registro foi encontrado".equals(consult)){
        resposta = new RespostaLogar(401, "Login ou senha incorretos", null);
    }else{   
        sessaoDAO.saveSessao(new Sessao(consult, msg.getEmail()));
        resposta = new RespostaLogar(200, null , consult);
    }

    return gson.toJson(resposta);
    }
    
    public static String logout(MensagemLogout msg){
        sessaoDAO.deleteSessao(msg.getUuid());

        return gson.toJson(new RespostaLogout());
    }
    
    public static String cadastrar (MensagemRegistrar msg){
        Usuario usuario = new Usuario(msg.getNome(), msg.getEmail(), msg.getSenha());
        Usuario existe = usuarioDAO.getUsuario(msg.getEmail());
        if(existe != null){
            return gson.toJson(new RespostaCadastrarUsuario(422, "E-mail já cadastrado", null));
        }
        try{
            usuarioDAO.saveUsuario(usuario);
        }catch(Exception ex){
            return gson.toJson(new RespostaCadastrarUsuario(404, "E-mail já cadastrado", null));
        }
        
        String consult = usuarioDAO.logarUsuario(msg.getEmail(), msg.getSenha());
        
        sessaoDAO.saveSessao(new Sessao(consult, msg.getEmail()));
        
        return gson.toJson(new RespostaCadastrarUsuario(201, null, consult));
    }
    
    public static String cadastrarEmpresa(MensagemRegistrarEmpresa msg){
        Empresa empresa = new Empresa(msg.getCnpj(), msg.getRazaoSocial(), msg.getDescricao(), msg.getRamo(), msg.getEmail(), msg.getSenha());
        try {
            if(empresaDAO.verificaSeExisteCNPJ(msg.getCnpj())){
                return gson.toJson(new RespostaCadastrarEmpresa(422, "CNPJ já cadastrado", null));
            }
            if(empresaDAO.verificaSeExisteEmail(msg.getEmail())){
                return gson.toJson(new RespostaCadastrarEmpresa(422, "Email já cadastrado", null));
            }
            
            empresaDAO.saveEmpresa(empresa);
            
            String consult = empresaDAO.logarEmpresa(msg.getEmail(), msg.getSenha());
            
            return gson.toJson(new RespostaCadastrarEmpresa(201, null, consult));
            
        } catch (Exception e) {
            return gson.toJson(new RespostaCadastrarEmpresa(404, "Ocorreu um problema na Conexão", null));
        }
    }
    
    public static String loginEmpresa(MensagemLogarEmpresa msg){
        String consult = empresaDAO.logarEmpresa(msg.getEmail(), msg.getSenha());
        RespostaLogarEmpresa resposta;
        if("Nenhum registro foi encontrado".equals(consult)){
            resposta = new RespostaLogarEmpresa(401, "Login ou senha incorretos", null);
        }else{   
            sessaoDAO.saveSessao(new Sessao(consult, msg.getEmail()));
            resposta = new RespostaLogarEmpresa(200, null , consult);
        }

        return gson.toJson(resposta);
    }
    
    public static String atualizarCandidato(MensagemEditar msg){
        Usuario usuario = new Usuario(msg.getNome(), msg.getEmail(), msg.getSenha());
        try {
            usuarioDAO.editUsuario(usuario);
            return gson.toJson(new RespostaEditar(201, null));
        } catch (Exception e) {
            return gson.toJson(new RespostaEditar(404, "E-mail não encontrado"));
        }
    }
    
    public static String atualizarEmpresa (MensagemEditarEmpresa msg){
        Empresa empresa = new Empresa(msg.getCnpj(), msg.getRazaoSocial(), msg.getDescricao(), msg.getRamo(), msg.getEmail(), msg.getSenha());
        try{
            empresaDAO.editEmpresa(empresa);
            return gson.toJson(new RespostaEditarEmpresa(201, null));
        }catch(Exception e){
            return gson.toJson(new RespostaEditarEmpresa(404, "E-mail não encontrado"));
        }
    }
    
    public static String excluirCandidato (MensagemExcluirUsuario msg){
        boolean exclusao = usuarioDAO.excluirCandidato(msg.getEmail());       
        if(exclusao){
           return gson.toJson(new RespostaExclusaoUsuario(201)); 
        }else{
           return gson.toJson(new RespostaExclusaoUsuario(404, "E-mail não encontrado"));
        }
    }
    
    public static String excluirEmpresa (MensagemExcluirEmpresa msg){
       boolean exclusao = empresaDAO.apagarEmpresa(msg.getEmail());
        if(exclusao){
           return gson.toJson(new RespostaExclusaoUsuario(201)); 
        }else{
           return gson.toJson(new RespostaExclusaoUsuario(404, "E-mail não encontrado"));
        }
    }
}
