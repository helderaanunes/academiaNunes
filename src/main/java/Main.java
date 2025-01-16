
import model.dao.GenericDAOImpl;
import model.dao.UsuarioDAO;
import model.dao.UsuarioDAOImpl;
import model.entity.Usuario;

public class Main {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        try {
            Usuario usuario = new Usuario();
            usuario.setNome("Josecleidson");
            usuario.setLogin("cleidsim");
            usuarioDAO.save(usuario);
            Usuario usuarioEncontrado = usuarioDAO.findById(usuario.getId());
            System.out.println("Usuario encontrado: " + usuarioEncontrado.getNome());
            usuarioEncontrado.setNome("Josecleidson Silva");
            usuarioDAO.update(usuarioEncontrado);
        } finally {
            ((GenericDAOImpl<?, ?>) usuarioDAO).close();
        }
    }
}
