
class DigitosLib
{

	public final static int par = 0;
	public final static int impar = 1;
	public final static int primo = 2;
	public final static int anillos = 3;
	

	public static int digitoI (int i, int n)
	{
		return (n / (int)(Math.pow (10,i-1))) % 10;
	}


	public static int numeroDigitos(int numero)
	{
		int totalDigitos = 0;
		int n = numero;
		do
		{
			totalDigitos = totalDigitos + 1;
			n = n / 10;
		}
		while (n > 0);
		return totalDigitos;
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


	public static int sumaDigitos (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
			resultado = resultado + digitoI(i,n);
		return resultado;
	}

	
	public static int sumaDigPares (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
		{
			if (digitoI(i,n)%2 == 0)
				resultado = resultado + digitoI(i,n);
		}
		return resultado;
	}

	public static int anillosNumeroDoWhile (int numero)
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

	public static int anillosNumeroFor (int numero)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (numero);
		for (int i = 1; i <= numDigitos; i++)
		{
			resultado = resultado + anillosDigito (digitoI(i,numero));
		}
		return resultado;
	}

	public static boolean esDigitoPrimo (int dig)
	{
		switch (dig)
		{
		case 2 : 
		case 3 :
		case 5 :
		case 7 :  return true;
		default : return false;
		}

	}

	public static int cuantosDigitosPrimos (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
		{
			if (esDigitoPrimo(digitoI(i,n)))
				resultado = resultado + 1;		
		}
		return resultado;
	}
	
	public static boolean tieneAnillos (int dig)
	{
		return anillosDigito (dig)>= 1;
	}
	
	
	public static boolean esDigitoPar (int dig)
	{
		return dig % 2 == 0;
	}
	
	
		
	public static boolean esDigitoHK (int dig)
		{
		// aqui ponemos la condicion que queremos evaluar !!
			return esDigitoPar(dig);
		}
	
	public static int cuantosDigitosHK (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
		{
			if (esDigitoHK(digitoI(i,n)))
				resultado = resultado + 1;		
		}
		return resultado;
	}
	public static int cuantosDigitosPares (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
		{
			if (esDigitoPar(digitoI(i,n)))
				resultado = resultado + 1;		
		}
		return resultado;
	}
	public static int sumarDigitosPrimos (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
		{
			if (esDigitoPrimo(digitoI(i,n)))
				resultado = resultado + digitoI(i,n);		
		}
		return resultado;
	}

	public static int sumarDigitosHK (int n)
	{
		int resultado = 0;
		int numDigitos = numeroDigitos (n);
		for (int i = 1; i <= numDigitos; i++)
		{
			if (esDigitoHK(digitoI(i,n)))
				resultado = resultado + digitoI(i,n);		
		}
		return resultado;
	}
	
	public static boolean hayDigitoHK (int n)
	{
		boolean encHK = false;
		int numDigitos = numeroDigitos (n);
		int i = 1 ;
		while (i <= numDigitos && !encHK)
		{
			if (esDigitoHK(digitoI(i,n)))
				encHK = true;
			else
				i++;
		}
		return encHK;
	}
	
	public static int queDigitoHK (int n)
	{
		boolean encHK = false;
		int numDigitos = numeroDigitos (n);
		int i = 1 ;
		while (i <= numDigitos && !encHK)
		{
			if (esDigitoHK(digitoI(i,n)))
				encHK = true;
			else
				i++;
		}
		if (encHK)
			return digitoI(i,n);
		else
			return -1;
	}
	
	public static int quePosDigitoHK (int n)
	{
		boolean encHK = false;
		int numDigitos = numeroDigitos (n);
		int i = 1 ;
		while (i <= numDigitos && !encHK)
		{
			if (esDigitoHK(digitoI(i,n)))
				encHK = true;
			else
				i++;
		}
		if (encHK)
			return i;
		else
			return -1;
	}
	
	
	public static ResultadoBusqueda digitoHK (int n)
	{
		boolean encHK = false;
		int numDigitos = numeroDigitos (n);
		int i = 1 ;
		while (i <= numDigitos && !encHK)
		{
			if (esDigitoHK(digitoI(i,n)))
				encHK = true;
			else
				i++;
		}
		if (encHK)
			return new ResultadoBusqueda(encHK,i,digitoI(i,n));
		else
			return new ResultadoBusqueda(encHK,-1,-1);
					
	}
}