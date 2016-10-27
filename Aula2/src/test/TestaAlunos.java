package test;

import model.AlunosCRUD;

public class TestaAlunos {

	public static void main(String[] args) {

    AlunosCRUD alunos = new AlunosCRUD("Paulo","rg","end","email",7887878,8766);
	alunos.cadastrar();
	alunos.consultar();
	System.out.println(alunos);
	alunos.setNome("Thais");
	alunos.alterar();
	alunos.consultar();
	System.out.println(alunos);
	alunos.deletar();
	
	}

}
