package clasesBanco;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

public class Utilidades {
	
	static String hora, minutos, segundos, ampm;
	static Calendar calendario;
	
	
	
	
	public static void calcula() {
		Calendar calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();

		calendario.setTime(fechaHoraActual);
		ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

		if (ampm.equals("PM")) {
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hora = h > 9 ? "" + h : "0" + h;
			if(h==0) {
				hora=""+"12";
			}
		} else {
			hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
					: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		}
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
	}
	
	
	public static void run(JLabel lbHora, Thread h1) {
		Thread ct = Thread.currentThread();
		while (ct == h1) {
			calcula();
			lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	
	


	/**
	 * Launch the application.
	 */
	
	
	
	
	
	
	
	
	

	public static boolean isNumeric(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}catch(NullPointerException e) {
			return false;
		}
	}
	public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
	
	public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

	
	public static synchronized Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (Exception ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (Exception ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
	
	
	
	public static void escribirArchivoObjeto(String archivo, ArrayList<Extracto> listaExtractos) {
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try {
			fo = new FileOutputStream(archivo);
			oI = new ObjectOutputStream(fo);
			for (Object o : listaExtractos) {
				try {
					oI.writeObject(o);
				} catch (IOException e) {
					System.out.println("problema al crear las clases");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para crear el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al crearse");
		} finally {
			try {
				if (fo != null) {
					fo.close();
				}
				if (oI != null) {
					oI.close();
				}

			} catch (IOException e) {
				System.out.println("no se pudo cerrar el archivo");
			}
		}
	}
	
	
	public static void escribirArchivoBanco(String archivo, Banco banco) {
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try {
			fo = new FileOutputStream(archivo);
			oI = new ObjectOutputStream(fo);
				try {
					oI.writeObject(banco);
				} catch (IOException e) {
					System.out.println("problema al crear las clases");
				}
			
		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para crear el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al crearse");
		} finally {
			try {
				if (fo != null) {
					fo.close();
				}
				if (oI != null) {
					oI.close();
				}

			} catch (IOException e) {
				System.out.println("no se pudo cerrar el archivo");
			}
		}
	}
	
	
	
	
	
	public static ArrayList<Extracto> leerArchivoObjeto(String archivo) {
		ObjectInputStream oI = null;
		FileInputStream fI = null;
		ArrayList<Extracto> listaExtractos = new ArrayList<Extracto>();
		try {
			fI = new FileInputStream(archivo);
			oI = new ObjectInputStream(fI);
			while (fI.available() > 0) {
				Extracto p = (Extracto) oI.readObject();
				listaExtractos.add(p);
			}
		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para leer el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al leerlo");
		} catch (ClassNotFoundException e) {
			System.out.println("problema al leer fichero");
		} finally {
			try {
				oI.close();
			} catch (IOException e) {
				System.out.println("el fichero tiene problemas al leerlo");
			}
		}
		if (listaExtractos.size() == 0) {
			return null;
		} else {
			return listaExtractos;
		}
	}
	
	public static String crearIdServicio() {
		Calendar calendario = Calendar.getInstance();
		calendario = new GregorianCalendar();
		String hora, minutos, segundos, milisegundos;
		hora = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = Integer.toString(calendario.get(Calendar.MINUTE));
		segundos = Integer.toString(calendario.get(Calendar.SECOND));
		milisegundos= Integer.toString(calendario.get(Calendar.MILLISECOND));
		String i = hora + minutos + segundos + milisegundos;
		return i;
	}
	
	public static Banco leerArchivoObjetoBanco(String archivo) {
		ObjectInputStream oI = null;
		FileInputStream fI = null;
		Banco banco = new Banco();
		try {
			fI = new FileInputStream(archivo);
			oI = new ObjectInputStream(fI);
			while (fI.available() > 0) {
				Banco p = (Banco) oI.readObject();
				banco=p;
			}
		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para leer el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al leerlo");
		} catch (ClassNotFoundException e) {
			System.out.println("problema al leer fichero");
		} finally {
			try {
				oI.close();
			} catch (IOException e) {
				System.out.println("el fichero tiene problemas al leerlo");
			}
		}
		if (banco==null) {
			return null;
		} else {
			return banco;
		}
	}
	
	
	
	

}
