package model;

import dao.UsuarioDAO;
import to.UsuarioTO;

public class Usuario {

	private String usuario;
	private String senha;
	private String permissao;
	
	public Usuario() {
	}

	public Usuario(String usuario, String senha, String permissao) {
		this.usuario = usuario;
		this.senha = senha;
		this.permissao = permissao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public boolean validar(){
		UsuarioTO to = getTO();
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(to);
	}
	public UsuarioTO getTO() {
		UsuarioTO to = new UsuarioTO();
		to.setUsuario(usuario);
		to.setSenha(senha);
		to.setPermissao(permissao);
		return to;
	}

	}
