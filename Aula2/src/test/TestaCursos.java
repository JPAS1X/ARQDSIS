package test;

import model.CursosCRUD;

public class TestaCursos {

	public static void main(String[] args) {

		CursosCRUD cursos = new CursosCRUD("cod", "Informatica", "numLab", "regSoft", "material", "livro", "dataIni",
				"dataTer", "horario", 999, 2500.00);
		cursos.cadastrar();
		cursos.consultar();
		System.out.println(cursos);
		cursos.setNome("Matematica");
		cursos.alterar();
		cursos.consultar();
		System.out.println(cursos);
		cursos.deletar();

	}

}
