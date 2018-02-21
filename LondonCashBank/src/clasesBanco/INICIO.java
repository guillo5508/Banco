package clasesBanco;

import java.io.File;
import java.io.Serializable;

import Forms.FormInicialBanco;
import Forms.FormLogin;

public class INICIO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6828093870346736256L;

	public static void main(String[] args) {
		File archivoBanco = new File("london.txt");
		if(archivoBanco.exists()) {
			Banco banco = new Banco();
			banco = Utilidades.leerArchivoObjetoBanco("london.txt");
			FormLogin inicio = new FormLogin(banco);
			inicio.setVisible(true);
		}else {
			Banco banco = new Banco();
			banco.setCajaFuerte(50000000);
			FormInicialBanco inicio = new FormInicialBanco(banco);
			inicio.setVisible(true);
		}

	}

}
