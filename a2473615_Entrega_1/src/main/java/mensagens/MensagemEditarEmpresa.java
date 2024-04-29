package mensagens;

import interfaces.MensagemInterface;

public class MensagemEditarEmpresa implements MensagemInterface{
    private String operacao = "atualizarEmpresa";
    private String razaoSocial;
    private String email;
    private String cnpj;
    private String senha;
    private String descricao;
    private String ramo;

    public MensagemEditarEmpresa() {
    }

    public MensagemEditarEmpresa(String razaoSocial, String email, String cnpj, String senha, String descricao, String ramo) {
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.cnpj = cnpj;
        this.senha = senha;
        this.descricao = descricao;
        this.ramo = ramo;
    }  
    
    
    /**
     * @return the operacao
     */
    @Override
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
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the ramo
     */
    public String getRamo() {
        return ramo;
    }

    /**
     * @param ramo the ramo to set
     */
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
       
}
