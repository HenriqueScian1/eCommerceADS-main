package bean;

import contexto.SessionContext;
import controller.LoginController;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import model.Usuario;

/**
 *
 * @author Victor
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private final LoginController controller;
    private final long INTERVALO_IMAGENS_SEGUNDOS = 10;
    private static List<String> listaCabecalhoTopBar;

    private String login = "";
    private String senha = "";
    private File[] listaImagensLogin;

    public LoginBean() {
        controller = new LoginController();

        listaCabecalhoTopBar = new ArrayList<>();
        listaCabecalhoTopBar.add("layout-topbar-stay");
        listaCabecalhoTopBar.add("layout-topbar-follow");

        if (SessionContext.getInstance() != null) {
            ExternalContext ext = SessionContext.getInstance().getExternalContext();
            if (ext != null) {
                ServletContext servletContext = (ServletContext) ext.getContext();
                String pathContexto = servletContext.getRealPath("/") + "resources\\imagensLogin\\";
                listaImagensLogin = new File(pathContexto).listFiles();
            }
        }
    }

    public String retornarImagemFundo() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        if (request != null && request.getRequestURL() != null) {
            long segundoHoje = LocalDateTime.now(ZoneId.systemDefault()).toEpochSecond(ZoneOffset.UTC);
            if (listaImagensLogin != null && listaImagensLogin.length > 0) {
                Long idx = (segundoHoje / INTERVALO_IMAGENS_SEGUNDOS % listaImagensLogin.length);
                int idxInt = Integer.parseInt(idx.toString());
                return "/resources/imagensLogin/" + listaImagensLogin[idxInt].getName();
            }
        }

        return "";
    }

    public void logar() {
        try {
            if (login == null || login.isEmpty()) {
                throw new Exception("O campo 'E-mail/CPF' não pode estar vazio.");
            } else if (senha == null || senha.isEmpty()) {
                throw new Exception("O campo 'Senha' não pode estar vazio.");
            }

            //Descomentar esta linha após subir o banco. TO-DO
//            Usuario usuarioLogado = controller.buscarUsuarioParaLogar(login, senha);
            Usuario usuarioLogado = new Usuario();
            usuarioLogado.setNome("Victor Santos");
            usuarioLogado.setCpf("111.111.111-11");
            usuarioLogado.setId(1L);
            usuarioLogado.setSenha(senha);
            usuarioLogado.setEmail(login);

            if (usuarioLogado != null) {
                SessionContext.getInstance().setAttribute("usuarioLogado", usuarioLogado);
                SessionContext.getInstance().setAttribute("userName", usuarioLogado.getNome());
                SessionContext.getInstance().getExternalContext().redirect("/telas/home.xhtml");
            }
        } catch (Exception ex) {

        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getListaCabecalhoTopBar() {
        return listaCabecalhoTopBar;
    }

    public SessionContext getSessionContext() {
        return SessionContext.getInstance();
    }
}
