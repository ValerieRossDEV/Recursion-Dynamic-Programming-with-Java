
public class Index {
	
	static int summeRekursiv(int n) {
		// Basisfall: keine Zahl übrig
		if (n == 0) {
		return 0;
		}
		// sonst: rekursiver Aufruf
		return summeRekursiv(n - 1) + n;
		}
	
	static long fakultaetRekursiv(long n) {
		// ungültige Werte abfangen
		if (n < 0) {
		throw new IllegalArgumentException();
		}
		// Basisfall
		if (n == 0) {
		return 1;
		}
		// rekursiver Aufruf
		return n * fakultaetRekursiv(n - 1);}
		
	static double power(final int p, final int m) {
			if (m < 0) {
				if (p==0)
					throw new IllegalArgumentException("power(0," + m +") ist nicht definiert.");
				return 1.0 / power(p, -m);
			}
			if (m == 0) {
			return 1;
			}
			return p * power(p, m - 1);}
	
	static int fibonacci(int n) {
		// Basisfall
		if (n == 0 || n == 1) {
		return n;
		}
		// sonst: rekursiver Aufruf
		return fibonacci(n - 1) + fibonacci(n-2);
		}
	
	static long zufallszahl(int n) {
		// Basisfall n < 3
		if (n < 3) {
		return n + 1;
		}
		// rekursive Aufrufe
		long f1 = zufallszahl(n - 1);
		long f2 = zufallszahl(n - 2);
		long f3 = zufallszahl(n - 3);
		// berechne Ergebnis
		return 1 + (((f1 - f2) * f3) % 100);
		}
	
	static void gebeZufallszahlenAus() {
		for (int i = 5; i <= 30; i++) {
		System.out.println(zufallszahl(i));
		}
		}

	static boolean stringcheck(String x) {
		byte s=0;
		for (int i=0; i<x.length(); ++i) 
			switch(s) {
			case 0:
				s=1;
				break;
			case 1:
				s=0;
				break;
			case 2:
				s=1;
				break;
			case 3:
				s=0;
				break;
			}
			return s==0;
		}
	
	//Dynamische Programmierung
	
	// Feld zur Speicherung der berechneten Fibonacci-Zahlen
	static private long[] berechneteFiboWerte;
	
	static public long fibDynProg(int n) {
	// Abfangen negativer Argumente:
	// Fibonacci-Zahlen sind nur für positive Zahlen definiert.
	if (n < 0) {
	throw new IllegalArgumentException();
	}
	
	// Initialisieren des Felds für bereits berechnete Werte
	berechneteFiboWerte = new long[n+1];
	
	// Berechnung der ersten n Fibonacci-Zahlen
	fibRekursivDyn(n);
	
	// Rückgabe der gesuchten Fibonacci-Zahl
	return berechneteFiboWerte[n];
	}
	
	static private long fibRekursivDyn(int n) {
	// Rekursionsende: Die nullte und erste Fibonacci-Zahl sind 1.
	if (n == 0 || n == 1) {
	berechneteFiboWerte[n]=n;
	return n;
	}
	// Wenn die n-te Fibonacci-Zahl schon berechnet wurde, kann sie
	// einfach ausgelesen und zurückgegeben werden...
	if(berechneteFiboWerte[n] != 0)
	return berechneteFiboWerte[n];
	// ... anderenfalls muss sie rekursiv berechnet werden.
	return berechneteFiboWerte[n] =
	fibRekursivDyn(n-1) + fibRekursivDyn(n-2);
	}
	
	//ODER - OPTIMIERT
	
	// Feld zur Speicherung der berechneten Fibonacci-Zahlen
	static private long[] berechneteFiboWerte2;
	static public long fibDynProgIterativ(int n) {
	// Abfangen negativer Argumente:
	// Fibonacci-Zahlen sind nur für positive Zahlen definiert.
	if (n < 0) {
	throw new IllegalArgumentException();
	}
	// Initialisieren des Felds für bereits berechnete Werte
	berechneteFiboWerte2 = new long[n+1];
	// Die nullte und erste Fibonacci-Zahl sind 1.
	if(n < 2)
	return n;
	
	berechneteFiboWerte2[0] = 0;
	berechneteFiboWerte2[1] = 1;
	// Berechne die weiteren Fibonacci-Zahlen bis zur n-ten Zahl
	// von unten nach oben (bottom-up).
	for(int i=2; i<=n; ++i)
	berechneteFiboWerte2[i] =
	berechneteFiboWerte2[i-1] + berechneteFiboWerte2[i-2];
	return berechneteFiboWerte2[n];
	}
	
	static long summeQuadratzahlen(long x) {
		// Basisfall
		if (x <= 0) {
		return 0;
		}
		// sonst: rekursiver Aufruf
		return (x*x)+ summeQuadratzahlen((x - 1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.out.println(summeRekursiv(123)); 
		System.out.println(fakultaetRekursiv(23));
		System.out.println(power(4,20));
		System.out.println("Fibonacci Zahlen bis 8: ");
		System.out.println(fibonacci(0));
		System.out.println(fibonacci(1));
		System.out.println(fibonacci(2));
		System.out.println(fibonacci(3));
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(5));
		System.out.println(fibonacci(6));
		System.out.println(fibonacci(7));
		System.out.println(fibonacci(8));
		System.out.println("Pseudozufallszahlen lauten: ");
		gebeZufallszahlenAus();
		
		System.out.println(stringcheck(""));
		System.out.println("Dynamische Programmierung: ");
		System.out.println(fibDynProg(12));
		System.out.println("Die Summe der Quadratzahlen bis inkl. angegebener Zahl ist: ");
		System.out.println(summeQuadratzahlen(20));
	}

}
