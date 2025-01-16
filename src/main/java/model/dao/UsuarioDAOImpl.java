package model.dao;

import jakarta.persistence.Query;
import java.util.List;
import model.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Long> 
        implements UsuarioDAO {
    
    public UsuarioDAOImpl() {
        super(Usuario.class);
    }
    
    public boolean verificarLogin(String login, String senha){
                return entityManager.createQuery("from Usuario u where u.login=:login"
                        + " and u.senha=:senha")
                        .setParameter("login", login)
                        .setParameter("senha", senha)
                        .getResultList().size()>0;
    } 

    public List<Usuario> buscarComFiltro(String nome, String login) {
        String sql ="";
        if (!nome.isBlank()){
            sql+= " nome like :nome ";
        }
        if (!login.isBlank()){
            if (!nome.isBlank()){
                sql+= " and ";
            }
            sql+= " login like :login ";
        }
        if (!sql.isBlank()){
            sql = " where "+sql;
        }
        
        Query query = entityManager.createQuery("from Usuario  "+sql);
        if (!nome.isBlank()){
            query.setParameter("nome", "%"+nome+"%");
        }
        if (!login.isBlank()){
            query.setParameter("login", "%"+login+"%");
        }
        return query.getResultList();
    }
    
    
}
