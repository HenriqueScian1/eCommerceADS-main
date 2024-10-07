package interfaces;

import database.Conexao;
import database.FactoryConversor;
import database.Paginacao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 * @param <T>
 */
public abstract class DAOMySQL<T> implements Serializable {

    public Connection conexao;
    protected final Conexao classeConexao;
    protected AbstractConversor<T> conversor;
    protected Filtro filtro;
    protected Paginacao paginacao;

    public DAOMySQL() {
        conexao = null;
        classeConexao = new Conexao();
        criarConversor();
    }

////---------------------------------------------------------------------
////Gerenciamento da conexão 
    public boolean criarConexao(Connection c) throws SQLException {
        if (c != null && !c.isClosed()) {
            conexao = c;
            return false;
        }

        if (conexao == null || conexao.isClosed()) {
            conexao = Conexao.conectar();
            return true;
        } else {
            return false;
        }
    }

    public void fecharConexao() throws SQLException {
        if (conexao != null) {
            conexao.close();
            conexao = null;
        }
    }

////---------------------------------------------------------------------
////Criação do conversor 
    private void criarConversor() {
        try {
            FactoryConversor fc = new FactoryConversor();
            Class<T> obj = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            conversor = fc.fabricarConversor(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(DAOMySQL.class.getName()).log(Level.SEVERE, "Classe do conversor não implementada.", ex);
        }
    }

////---------------------------------------------------------------------
////Métodos genéricos para implementação
    public void insert(T obj) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public void update(T obj) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public void delete(T obj) throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public T getObject() throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public List<T> listar() throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public int getTotalRegistro() throws Exception {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    public void setPaginacao(Paginacao paginacao) {
        this.paginacao = paginacao;
    }

}
