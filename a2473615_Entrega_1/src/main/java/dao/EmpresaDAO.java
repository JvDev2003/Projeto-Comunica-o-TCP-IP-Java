/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import banco.DatabaseConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;
import model.Empresa;

/**
 *
 * @author jvspl
 */
public class EmpresaDAO {
    private EntityManager entityManager;
	
	public EmpresaDAO () {
		this.entityManager = DatabaseConnection.getConnection();
	}
	
	public Empresa getEmpresa(String email) {
		// Use para obter determinado Usuario
		return entityManager.find(Empresa.class, email);
	}
	
    public List<Empresa> getAllEmpresas() {
        // Use a conexão para obter todos os usuários do banco de dados
    	TypedQuery<Empresa> query = entityManager.createQuery("SELECT u FROM Empresa u", Empresa.class);
    	
    	return query.getResultList();
    }

    public void saveEmpresa(Empresa empresa) {
        // Use a conexão para salvar o usuário no banco de dados
    	entityManager.getTransaction().begin();
    	entityManager.persist(empresa);
    	entityManager.getTransaction().commit();
    }
    
    public void editEmpresa(Empresa empresa) {
    	entityManager.getTransaction().begin();
    	entityManager.merge(empresa);
    	entityManager.getTransaction().commit();
    }
    
    public String logarEmpresa(String email, String senha){
        
        try {
         TypedQuery<Empresa> query = entityManager.createQuery("SELECT m FROM Empresa m WHERE m.email = :email AND m.senha = :senha",Empresa.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        
        query.getSingleResult();
        
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
        } catch (NoResultException e) {
            return "Nenhum registro foi encontrado";
        }
    }   
    
    public boolean verificaSeExisteCNPJ(String cnpj){
        try {
            TypedQuery<Empresa> query = entityManager.createQuery("SELECT m FROM Empresa m WHERE m.cnpj = :cnpj",Empresa.class);
            query.setParameter("cnpj", cnpj);
        
            query.getSingleResult();

            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
    
    public boolean verificaSeExisteEmail(String email){
        try {
            TypedQuery<Empresa> query = entityManager.createQuery("SELECT m FROM Empresa m WHERE m.email = :email",Empresa.class);
            query.setParameter("email", email);
        
            query.getSingleResult();

            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
    
    public void excluirEmpresa(Empresa empresa){
        entityManager.getTransaction().begin();
        entityManager.remove(empresa);
        entityManager.getTransaction().commit();
    }
    
    public Empresa recebeEmpresa (String email){    
        try {
         TypedQuery<Empresa> query = entityManager.createQuery("SELECT m FROM Empresa m WHERE m.email = :email",Empresa.class);
        query.setParameter("email", email);
        
        return query.getSingleResult();
        
        } catch (NoResultException e) {
            return null;
        }
    }  
    
    public boolean apagarEmpresa(String email){
    try {
        Empresa empresa = this.recebeEmpresa(email);
        this.excluirEmpresa(empresa);
        return true;
     } catch (Exception e) {
         return false;
     } 
    }
}
