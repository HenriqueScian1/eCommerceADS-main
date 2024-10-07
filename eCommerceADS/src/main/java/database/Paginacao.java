package database;

import interfaces.PaginacaoAbstract;

/**
 *
 * @author Victor
 */
public class Paginacao extends PaginacaoAbstract {

    private final PaginacaoAbstract paginacao;

    public Paginacao() {
        paginacao = new PaginacaoMySQL();
    }

    @Override
    public String getPaginacao() {
        return paginacao.getPaginacao();
    }

    @Override
    public int getTotalPaginas() {
        return paginacao.getTotalPaginas();
    }

    @Override
    public int getNumeroPagina() {
        return paginacao.getNumeroPagina();
    }

    @Override
    public void anterior() {
        paginacao.anterior();
    }

    @Override
    public void proximo() {
        paginacao.proximo();
    }

    @Override
    public void setTamanhoPagina(int tamanhoPagina) {
        paginacao.setTamanhoPagina(tamanhoPagina);
    }

    @Override
    public int getTamanhoPagina() {
        return paginacao.getTamanhoPagina();
    }

    @Override
    public int getTotalReg() {
        return paginacao.getTotalReg();
    }

    @Override
    public void reiniciar() {
        paginacao.reiniciar();
    }

    @Override
    public void setTotalReg(int totalReg) {
        paginacao.setTotalReg(totalReg);
    }

    @Override
    public int getaPartirDe() {
        return paginacao.getaPartirDe();
    }

}
