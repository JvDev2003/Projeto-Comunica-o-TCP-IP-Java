
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
import model.Sessao;

/**
 *
 * @author jvspl
 */
public class SessaoDao {
    	private EntityManager entityManager;
	
	public SessaoDao () {
		this.entityManager = DatabaseConnection.getConnection();
	}
        
        public Sessao getSessao(String id) {
        // Use para obter determinado Usuario
            return entityManager.find(Sessao.class, id);
	}
        
            public List<Sessao> getAllSessoes() {
        // Use a conexão para obter todos os usuários do banco de dados
    	TypedQuery<Sessao> query = entityManager.createQuery("SELECT u FROM Usuario u", Sessao.class);
    	
    	return query.getResultList();
    }

    public void saveSessao(Sessao sessao) {
        // Use a conexão para salvar o usuário no banco de dados
    	entityManager.getTransaction().begin();
    	entityManager.persist(sessao);
    	entityManager.getTransaction().commit();
    }
    
    public void deleteSessao(String sessao){
        entityManager.getTransaction().begin();
      
    // Encontra a sessão que deseja excluir
        Sessao registry = entityManager.find(Sessao.class, sessao);

        // Remove a sessão
        if (sessao != null) {
            entityManager.remove(registry);
        }

        // Confirma a transação
        entityManager.getTransaction().commit();
    }
    
    public boolean verificarSessao( String sessao){  
        try {
         TypedQuery<Sessao> query = entityManager.createQuery("SELECT m FROM Usuario m WHERE m.idSessao = :sessao",Sessao.class);
        query.setParameter("idSessao", sessao);
        
        query.getSingleResult();
      
        return true;
        } catch (NoResultException e) {
            return false;
        }

    }
}
