package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa extends Login{

    private String cnpj;
    
    @Column
    private String razaoSocial;
    
    @Column
    private String descricao;
    
    @Column
    private String ramo;

    public Empresa() {
    }

    public Empresa(String cnpj, String razaoSocial, String descricao, String ramo) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.descricao = descricao;
        this.ramo = ramo;
    }
    
    

    public Empresa(String cnpj, String razaoSocial, String decricao, String ramo, String email, String senha) {
        super(email, senha);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.descricao = decricao;
        this.ramo = ramo;
    }

    public Empresa(String cnpj, String razaoSocial, String ramo, String email, String senha) {
        super(email, senha);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.ramo = ramo;
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
     * @return the decricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the decricao to set
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
