package clasesBanco;

import java.io.File;

import Forms.FormInicialBanco;
import Forms.FormLogin;

public class INICIO {

	public static void main(String[] args) {
		File archivoBanco = new File("london.txt");
		if(archivoBanco.exists()) {
			Banco banco = new Banco();
			banco = Utilidades.leerArchivoObjetoBanco("london.txt");
			FormLogin inicio = new FormLogin(banco);
			inicio.setVisible(true);
		}else {
			Banco banco = new Banco();
			FormInicialBanco inicio = new FormInicialBanco(banco);
			inicio.setVisible(true);
		}

	}

}
