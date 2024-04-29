package dao;

import java.util.List;

import banco.DatabaseConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.UUID;
import model.Usuario;

public class UsuarioDAO {
	private EntityManager entityManager;
	
	public UsuarioDAO () {
		this.entityManager = DatabaseConnection.getConnection();
	}
	
	public Usuario getUsuario(String email) {
		// Use para obter determinado Usuario
		return entityManager.find(Usuario.class, email);
	}
	
    public List<Usuario> getAllUsers() {
        // Use a conexão para obter todos os usuários do banco de dados
    	TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
    	
    	return query.getResultList();
    }

    public void saveUsuario(Usuario usuario) {
        // Use a conexão para salvar o usuário no banco de dados
    	entityManager.getTransaction().begin();
    	entityManager.persist(usuario);
    	entityManager.getTransaction().commit();
    }
    
    public void editUsuario(Usuario usuario) {
    	entityManager.getTransaction().begin();
    	entityManager.merge(usuario);
    	entityManager.getTransaction().commit();
    }
    
    public String logarUsuario(String email, String senha){
        
        try {
         TypedQuery<Usuario> query = entityManager.createQuery("SELECT m FROM Usuario m WHERE m.email = :email AND m.senha = :senha",Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        
        query.getSingleResult();
        
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
        } catch (NoResultException e) {
            return "Nenhum registro foi encontrado";
        }
    }   
 
        public Usuario recebeUser (String email){
        
        try {
         TypedQuery<Usuario> query = entityManager.createQuery("SELECT m FROM Usuario m WHERE m.email = :email",Usuario.class);
        query.setParameter("email", email);
        
        return query.getSingleResult();
        
        } catch (NoResultException e) {
            return null;
        }
    }  
    
    public void excluirUsuario(Usuario usuario){
           entityManager.getTransaction().begin();
           entityManager.remove(usuario);
           entityManager.getTransaction().commit();
    }
        
    public boolean excluirCandidato(String email){
        try {
           Usuario usuario = this.recebeUser(email);
           this.excluirUsuario(usuario);
           return true;
        } catch (Exception e) {
            return false;
        }
    }
}
