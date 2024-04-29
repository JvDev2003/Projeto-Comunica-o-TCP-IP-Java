/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jvspl
 */
public class Inputs {
    private static Pattern patternSenha = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.[a-zA-Z]{2,})$");
    private static Pattern patternEmail = Pattern.compile("^\\d{3,8}$");
    private static Pattern patternNome = Pattern.compile("^.{6,30}$");
    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    
    
    public static String getSenha() throws IOException{
        boolean validacao;
        
        System.out.println("Insira sua senha:");
        String senha = stdIn.readLine();
        
        Matcher matcher = patternSenha.matcher(senha);
        
        validacao = matcher.matches();
    
        while (validacao) {            
                System.out.println("Sua senha precisa ser uma sequancia de 3 a 8 numeros inteiro, insira uma nova senha:");
                senha = stdIn.readLine();
                matcher = patternSenha.matcher(senha);
                validacao = matcher.matches();
        }
        
        return senha;
    }
    
    public static String getEmail() throws IOException{
        boolean validacao;
        
        System.out.println("Insira seu email:");
        String email = stdIn.readLine();
        
        Matcher matcher = patternEmail.matcher(email);
        
        validacao = matcher.matches();
    
        while (validacao) {            
                System.out.println("Seu email precisa ter de 7 a 50 caracteres com um @, :");
                email = stdIn.readLine();
                matcher = patternSenha.matcher(email);
                validacao = matcher.matches();
        }
        
        return email;
    }
    
    public static String getNome() throws IOException{
        boolean validacao;
        
        System.out.println("Insira seu Nome ou Razão Social:");
        String nome = stdIn.readLine();
        
        Matcher matcher = patternNome.matcher(nome);
        
        validacao = matcher.matches();
    
        while (validacao) {            
                System.out.println("O nome/razão social, precisa tem de 6 a 30 caracteres, insira o nome/razão social novamente:");
                nome = stdIn.readLine();
                matcher = patternNome.matcher(nome);
                validacao = matcher.matches();
        }
        
        return nome;
    }
}
