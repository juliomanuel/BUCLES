//  DOCUMENTACIÓN  --------------------------------------------------
/*
  ARCHIVO: UE6_A2.java
  EFECTO:
  AUTOR: JMB
  GRUPO: 1O5M
  FECHA_CREACIÓN: 26/11/2010
  FECHA_ÚLTIMA_MODIFICACIÓN: 29/11/2010
*/

//  USO: UE6_A2 ue62 = new UE6_A2 ()

class UE6_A2
{
  
//  DECLARACIONES DE CONSTANTES  ------------------------------------ 
  
  final double pi = 3.141591;

//  DECLARACION DE FUNCIONES  ---------------------------------------

/*
 * FUNCION factorial (Natural n) ---> Natural
 * PRE: cierto
 * POST1: resultado = n!
 * POST2: resultado = MUL j IN [1,n] . j
*/
  int factorial (int n)
  {
    int resultado = 1;
    for (int i = 1; i <= n; i++)
      resultado = resultado * i;
    return resultado;
  }
/*
 * FUNCION producto (Natural m, n) ---> Natural
 * PRE: cierto
 * POST1: resultado = m * n
 * POST2: resultado = SUM j IN [1,n] . m
*/
  int producto (int m, int n)
  {
    int resultado = 0;
    for (int i = 1; i <= n; i++)
      resultado = resultado + m;
    return resultado;
  }
/*
 * FUNCION factorialAPedal (Natural n) ---> Natural
 * PRE: cierto
 * POST1: resultado = n!
 * POST2: resultado = MUL j IN [1,n] . j
*/
  int factorialAPedal (int n)
  {
    int resultado = 1;
    for (int i = 1; i <= n; i++)
      resultado = producto (resultado,i);
    return resultado;
  }
/*
 * FUNCION cifraI (Natural i,n) ---> Natural
 * PRE: i IN [1,NC(n)]
 * POST: resultado = Resto (Cociente (n,Potencia (10,i-1),10)
*/
  int cifraI (int i, int n)
  {
    return (n / (int)(Math.pow (10,i-1))) % 10;
  }
/*
 * FUNCION numeroCifras (Natural numero) ---> Natural
 * PRE: cierto
 * POST: ((numero=0)/\(r=1)) \/ ((numero>0)/\(r>0)/\(10^r-1 <= 10^r))
*/
  int numeroCifras (int numero)
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
/*
 * FUNCION potencia (Natural base, exponente) ---> Natural
 * PRE: base > 0
 * POST: resultado = MUL i IN [1,exponente] . base
*/
  int potencia (int base, int exponente)
  {
    int producto = 1;
    for ( int i = 1; i <= exponente; i++)
      producto = producto * base;
    return producto;
  }
/*
 * FUNCION anillosDigito (Natural digito) ---> Natural
 * PRE : digito <= 9
 *                   | 2  si digito IN {8}
 * POST: resultado = | 1  si digito IN {0,6,9}
 *                   | 0  si digito IN {1,2,3,4,5,7}
*/
  int anillosDigito (int d)
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
  int anillosNumero (int numero)
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
  int variaciones (int m, int n)
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
  int numeroCombinatorio (int m, int n)
  {
    return variaciones (m,n) / variaciones (n,n);
  }

//  DECLARACIONES DE PRUEBAS  ---------------------------------------

  int prueba11 = producto (5,12);
  int prueba12 = producto (12,5);
  int prueba21 = factorial (5);
  int prueba22 = factorialAPedal (5);
  int prueba31 = cifraI (2,1024);
  int prueba32 = cifraI (4,1024);
  int prueba41 = numeroCifras (0);
  int prueba42 = numeroCifras (1024);
  int prueba51 = potencia (6,0);
  int prueba52 = potencia (6,2);
  int prueba61 = anillosNumero (0);
  int prueba62 = anillosNumero (1680);
  int prueba71 = variaciones (6,2);
  int prueba72 = variaciones (6,5);
  int prueba81 = numeroCombinatorio (6,0);
  int prueba82 = numeroCombinatorio (6,2);
  
}