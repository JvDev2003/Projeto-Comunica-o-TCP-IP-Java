/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacoes;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import mensagens.*;
import utils.Singleton;

/**
 *
 * @author jvspl
 */
public class OperacoesUsuarioSender {

    private static Gson gson = new Gson();
    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    public static String realizaLogin() throws IOException {
        String email = utils.Inputs.getEmail();
        String senha = utils.Inputs.getSenha();

        String jsonLogin = gson.toJson(new MensagemLogar(email, senha));

        return jsonLogin;
    }

    public static String realizaLogout() throws IOException {
        String jsonLogout = gson.toJson(new MensagemLogout(Singleton.getInstance().getVariavel()));
        return jsonLogout;
    }
    
    public static String realizaCadastroUsuario() throws IOException{
        String email = utils.Inputs.getEmail();
        String nome = utils.Inputs.getNome();
        String senha = utils.Inputs.getSenha();
        
        String jsonRegistrar = gson.toJson(new MensagemRegistrar(nome, email, senha));

        return jsonRegistrar;
    }
    
    public static String realizaCadastroEmpresa() throws IOException{
        String razaoSocial = utils.Inputs.getNome();
        
        System.out.println("Insira o CNPJ da sua empresa");
        String cnpj = stdIn.readLine();
        
        System.out.println("Insira uma breve descrição sobre sua empresa:");
        String descricao = stdIn.readLine();
        
        System.out.println("Insira a qual ramo sua empresa pertence");
        String ramo = stdIn.readLine();
        
        String email = utils.Inputs.getEmail();
        
        String senha = utils.Inputs.getSenha();
        
        String jsonRegistrar = gson.toJson(new MensagemRegistrarEmpresa(razaoSocial, email, cnpj, senha, descricao, ramo));

        return jsonRegistrar;
    }
    
    public static String realizaLoginEmpresa() throws IOException{
        String email = utils.Inputs.getEmail();
        System.out.println("Insira sua senha:");
        String senha = utils.Inputs.getSenha();

        String jsonLogin = gson.toJson(new MensagemLogarEmpresa(email, senha));

        return jsonLogin;
    }
    
    public static String realizaEdicao() throws IOException{
        String email = utils.Inputs.getEmail();
        String nome = utils.Inputs.getNome();
        String senha = utils.Inputs.getSenha();
        
        String jsonRegistrar = gson.toJson(new MensagemEditar(nome, email, senha));

        return jsonRegistrar;
    }
    
    public static String realizaEdicaoEmpresa()throws IOException{
        String razaoSocial = utils.Inputs.getNome();
        
        System.out.println("Insira o CNPJ da sua empresa");
        String cnpj = stdIn.readLine();
        
        System.out.println("Insira uma breve descrição sobre sua empresa:");
        String descricao = stdIn.readLine();
        
        System.out.println("Insira a qual ramo sua empresa pertence");
        String ramo = stdIn.readLine();
        
        String email = utils.Inputs.getEmail();
        
        String senha = utils.Inputs.getSenha();
        
        String jsonEditar = gson.toJson(new MensagemRegistrarEmpresa(razaoSocial, email, cnpj, senha, descricao, ramo));
        
        return jsonEditar;
    }
    
    public static String excluirUsuario() throws IOException{
        System.out.println("Insira o email do usuario a ser excluido:");
        String email = stdIn.readLine();
        
        String jsonExcluir = gson.toJson(new MensagemExcluirUsuario(email));
        
        return jsonExcluir;
    }
       
    public static String excluirEmpresa() throws IOException{
        System.out.println("Insira o email da empresa a ser excluida:");
        String email = stdIn.readLine();
        
        String jsonExcluir = gson.toJson(new MensagemExcluirEmpresa(email));
        
        return jsonExcluir;
    }
}
