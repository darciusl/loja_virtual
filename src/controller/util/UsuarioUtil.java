package controller.util;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import sistema.Consultas;
import dominio.Usuario;

public class UsuarioUtil {
	private Usuario usuarioLogado = null;
	@Inject
	private Consultas fachadaConsultas;

	@Produces
	@SessionScoped
	public Usuario getUsuarioLogado() {
		String login = org.springframework.security.core.context.SecurityContextHolder
				.getContext().getAuthentication().getName();
		if (usuarioLogado == null || !login.equals(usuarioLogado.getEmail())) {
			if (login != null) {
				usuarioLogado = fachadaConsultas.buscarPorEmail(login);
			}
		}
		return usuarioLogado;
	}

	public void close(@Disposes Usuario em) {
	}
}
