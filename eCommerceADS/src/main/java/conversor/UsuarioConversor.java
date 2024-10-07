package conversor;

import interfaces.AbstractConversor;
import java.sql.ResultSet;
import model.Usuario;

/**
 *
 * @author Victor
 */
public class UsuarioConversor extends AbstractConversor<Usuario> {

    @Override
    protected Usuario getObject(ResultSet rs) throws Exception {
        Usuario obj = new Usuario();

        obj.setId(rs.getLong("usuario.id"));
        obj.setNome(rs.getString("usuario.nome"));
        obj.setEmail(rs.getString("usuario.email"));
        obj.setCpf(rs.getString("usuario.cpf"));
        obj.setSenha(rs.getString("usuario.senha"));
        obj.setDataCadastro(rs.getDate("usuario.daata_cadastro"));

        return obj;
    }

}
