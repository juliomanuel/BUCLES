//  DOCUMENTACI�N  --------------------------------------------------
/*
  ARCHIVO: UE6_A2.java
  EFECTO:
  AUTOR: JMB
  GRUPO: 1O5M
  FECHA_CREACI�N: 26/11/2010
  FECHA_�LTIMA_MODIFICACI�N: 29/11/2010
 */

//  USO: UE6_A2 ue62 = new UE6_A2 ()

class BuclesLib1
{

	//  DECLARACIONES DE CONSTANTES  ------------------------------------ 

	final double pi = 3.141591;


	public static int prodInt (int a, int b)
	{
		int resultado = 1;
		for (int i = a; i <=b; i++)
			resultado = resultado * i;
		return resultado;
	}


	public static int factorial2 (int n)
	{
		int resultado = 1;
		for (int i = n; i >= 1; i--)
			resultado = resultado * i;
		return resultado;
	}

	public static int sumaN (int n)
	{
		int resultado = 0;
		for (int i = 1; i <= n; i++)
			resultado = resultado + i;
		return resultado;
	}

	public static int sumaInt (int a, int b)
	{
		int resultado = 0;
		for (int i = a; i <= b; i++)
			resultado = resultado + i;
		return resultado;
	}

	public static int sumaN2 (int n)
	{
		int resultado = 0;
		for (int i = n; i >= 1; i--)
			resultado = resultado + i;
		return resultado;
	}


	// m * n = m + ..... + m
	// producto (m,n) = m * n
	public static int producto (int m, int n)
	{
		int resultado = 0;
		for (int i = 1; i <= n; i++)
			resultado = resultado + m;
		return resultado;
	}

	public static int factorialAPedal (int n)
	{
		int resultado = 1;
		for (int i = 1; i <= n; i++)
			//        resultado = resultado * i;
			resultado = producto (resultado,i);
		return resultado;
	}


	public static int cifraI (int i, int n)
	{
		return (n / (int)(Math.pow (10,i-1))) % 10;
	}


	public static int numeroCifras (int numero)
	{
		int totalCifras = 0;
		int n = numero;
		do
		{
			totalCifras = totalCifras + 1;
			n = n / 10;
		}
		while (n > 0);
		return totalCifras;
	}
	
	
	public static int potencia (int base, int exponente)
	{
		int producto = 1;
		for ( int i = 1; i <= exponente; i++)
			producto = producto * base;
		return producto;
	}
	
	public static int anillosDigito (int d)
	{
		if (d == 8)
			return 2;
		else if ((d == 0) || (d == 6) || (d == 9))
			return 1;
		else
			return 0;
	}
	/*
	 * FUNCION anillosNumero (Natural n) ---> Natural
	 * PRE: cierto
	 * POST: res = SUM i IN [1,NCifras(n)] | AnillosDigito (Cifra (i,n))
	 */
	
	public static int sumaDig (int n)
	{
		int resultado = 0;
		int numCifras = numeroCifras (n);
		for (int i = 1; i <= numCifras; i++)
			resultado = resultado + cifraI(i,n);
		return resultado;
	}
	
	
	public static int anillosNumero (int numero)
	{
		int totalAnillos = 0;
		int n = numero;
		do
		{
			totalAnillos = totalAnillos + anillosDigito (n % 10);
			n = n / 10;
		}
		while (n > 0);
		return totalAnillos;
	}
	/*
	 * FUNCION variaciones (Natural m, n) ---> Natural
	 * PRE: (m>0)/\(n>0)/\(m>=n)
	 * POST: resultado = MUL i IN [(m-n+1),m] . i
	 */
	public static int variaciones (int m, int n)
	{
		int resultado = 1;
		for (int i = m; i >= m-n+1; i--)
			resultado = resultado * i;
		return resultado;
	}
	/*
	 * FUNCION numeroCombinatorio (Natural m, n) ---> Natural
	 * PRE: (m>0)/\(n>0)/\(m>=n)
	 * POST: resultado = "m" sobre "n"
	 */
	public static int numeroCombinatorio (int m, int n)
	{
		return variaciones (m,n) / variaciones (n,n);
	}

	//  DECLARACIONES DE PRUEBAS  ---------------------------------------

	public static int prueba11 = producto (5,12);
	public static int prueba12 = producto (12,5);
	public static int prueba21 = factorial2 (5);
	public static int prueba22 = factorialAPedal (5);
	public static int prueba31 = cifraI (2,1024);
	public static int prueba32 = cifraI (4,1024);
	public static int prueba41 = numeroCifras (0);
	public static int prueba42 = numeroCifras (1024);
	public static int prueba51 = potencia (6,0);
	public static int prueba52 = potencia (6,2);
	public static int prueba61 = anillosNumero (0);
	public static int prueba62 = anillosNumero (1680);
	public static int prueba71 = variaciones (6,2);
	public static int prueba72 = variaciones (6,5);
	public static int prueba81 = numeroCombinatorio (6,0);
	public static int prueba82 = numeroCombinatorio (6,2);

}