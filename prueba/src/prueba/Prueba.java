package prueba;

public class Prueba {
	
	public static void torresHanoi(String a, String b, String c, int discos) {
		if(discos==1) {
			System.out.println("mover disco "+discos+" de torre" +a+" a torre "+c);
		}else {
			
			torresHanoi(a, c, b, discos-1);
			System.out.println("mover disco "+discos+" de torre" +a+" a torre "+c);
			torresHanoi(b, a, c, discos-1);
		}
	}
	
	
	
	public static int llenadooRecursivo(int[] vector, int indice){
		if(vector.length-indice==vector.length) {
			return indice;
		}else {
			vector[vector.length-indice]=1+vector.length-indice;
			indice--;
			llenadooRecursivo(vector, indice);
		}
		return 0;
	}
	

	public static void main(String[] args) {
		 torresHanoi("torre a", "torre b", "torre c", 3);
		 int[] vector=new int[4];
		 llenadooRecursivo(vector, 4);
		 for(int i=0;i<vector.length;i++) {
			 System.out.println(vector[i]);
			 System.out.println("llamada");
		 }
	}

}
