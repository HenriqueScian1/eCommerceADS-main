package database;

import interfaces.PaginacaoAbstract;

/**
 *
 * @author Victor
 */
class PaginacaoMySQL extends PaginacaoAbstract {

    @Override
    public String getPaginacao() {
        return " LIMIT " + aPartirDe + "," + tamanhoPagina;
    }

}
