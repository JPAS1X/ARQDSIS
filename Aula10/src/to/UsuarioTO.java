   package to;

public class UsuarioTO {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	private String permissao;
	
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
	
	@Override
	public String toString() {
		return "UsuarioTO [usuario=" + usuario + ", senha=" + senha + ", permissao=" + permissao +"]";
	}
	
	
	
	
}
