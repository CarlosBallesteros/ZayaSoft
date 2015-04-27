import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int a,b;
		Scanner leer=new Scanner(System.in);
		System.out.println("¿Que operacion desea realizar?\n1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir");
		switch(leer.nextInt()){
		case 1:System.out.println("Introduce el primer numero:");
			a=leer.nextInt();
			System.out.println("Introduce el segundo numero:");
			b=leer.nextInt();
			System.out.println("Resultado: "+Modulo2.sumar(a, b));
			break;
		case 2:System.out.println("Introduce el primer numero:");
			a=leer.nextInt();
			System.out.println("Introduce el segundo numero:");
			b=leer.nextInt();
			System.out.println("Resultado: "+Modulo2.restar(a, b));
			break;
		case 3:System.out.println("Introduce el primer numero:");
			a=leer.nextInt();
			System.out.println("Introduce el segundo numero:");
			b=leer.nextInt();
			System.out.println("Resultado: "+Modulo2.multiplicar(a, b));
			break;
		case 4:System.out.println("Introduce el primer numero:");
			a=leer.nextInt();
			System.out.println("Introduce el segundo numero:");
			b=leer.nextInt();
			System.out.println("Resultado: "+Modulo2.dividir(a, b));
			break;
		}
		
		
		
		
	}

}
