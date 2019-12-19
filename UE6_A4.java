//  DOCUMENTACIÓN  --------------------------------------------------
/*
  ARCHIVO: UE6_A4.java
  EFECTO:
  AUTOR: JMB
  GRUPO: 1O5M
  FECHA_CREACIÓN: 26/11/2010
  FECHA_ÚLTIMA_MODIFICACIÓN: 29/11/2010
*/

//  USO: UE6_A4 ue64 = new UE6_A4 ()

class UE6_A4
{
  
//  DECLARACIONES DE CONSTANTES  ------------------------------------ 
  
  final double pi = 3.141591;

//  DECLARACION DE FUNCIONES  ---------------------------------------

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
 * FUNCION cuantosCeros (Natural numero) ---> Natural
 * PRE: cierto
 * POST: resultado = CONT i IN [1,NumeroCifras (numero)] .
 *                       (Cifra (i,numero) = 0) 
*/
  int cuantosCeros (int numero)
  {
    int  totalCeros = 0;
    int n = numero;
    do
    {
      if ((n % 10) == 0)
        totalCeros = totalCeros + 1;
      n = n / 10;
    }
    while (n > 0);
    return totalCeros;
  }
/*
 * FUNCION sumaEntre (Natural m, n) ---> Natural
 * PRE: cierto
 * POST: res = SUM i IN [m,n] . i
*/
  int sumaEntre (int m, int n)
  {
    int res = 0;
    for (int i = m; i <= n; i++)
      res = res + i;
    return res;
  }
/*
 * FUNCION esTriangular (Natural n) ---> Boolean
 * PRE: n > 0
 * POST: res = ALGUN i IN [1,n].(n = sumaEntre (1,i))
*/
  boolean esTriangular (int n)
  {
    int i = 1;
    boolean encontrado = false;
    while ((i <= n) && !encontrado)
      if (sumaEntre (1,i) == n)
        encontrado = true;
      else
        i = i +1;
    return encontrado;
  }
/*
 * FUNCION esCapicua (Natural n) ---> Boolean
 * PRE: cierto
 * POST: resultado = TODOS i IN [1,Cociente (NC(n),2)] .
 *                        (Cifra (i,n) = Cifra (NC(n)-i+1,n))
 * DONDE: NC(n) = Numero_Cifras (n)
*/
  boolean esCapicua (int n)
  {
    boolean todosCumplen = true;
    int i = 1;
    int totalCifras = numeroCifras (n);
    while ((i <= totalCifras/2) && todosCumplen)
      if (cifraI (i,n) != cifraI (totalCifras-i+1,n))
        todosCumplen = false;
      else
        i = i + 1;
    return todosCumplen;
  }
/*
 * FUNCION inverso (Natural numero) ---> Natural
 * PRE: cierto
 * POST1: (NC (resultado) = NC (n)) /\
 *        TODOS i IN [1,NC(n)] . 
 *             (Cifra (NC(n)-i+1,resultado) = Cifra (i,n))
 * POST2: resultado = MAP i IN [1,NC(n)] . Cifra (NC(n)-i+1,n)
*/
  int inverso (int numero)
  {
    int parteInvertida = 0;
    int n = numero;
    do
    {
      parteInvertida = (parteInvertida * 10) + (n % 10);
      n = n / 10;
    }
    while (n > 0);
    return parteInvertida;
  }
/*
 * FUNCION esCapicua2 (Natural n) ---> Boolean
 * PRE: cierto
 * POST: resultado = TODOS i IN [1,NC(n)/2] .
 *                        (Cifra (i,n) = Cifra (NC(n)-i+1,n))
*/
  boolean esCapicua2 (int n)
  {
    return n == inverso (n);
  }
/*
  FUNCION max2 (Entero x, y) ---> Entero 
  PRE: cierto
                    | x  si (x >= y)
  POST: resultado = |
                    | y  e.o.c
*/
  int max2 (int x, int y)
  {
    return ((x >= y)? x : y);
  }

//  DECLARACIONES DE PRUEBAS  ---------------------------------------

  int prueba11 = cuantosCeros (20304005);
  int prueba12 = cuantosCeros (0);
  int prueba13 = cuantosCeros (12345);
  boolean prueba21 = esTriangular (9);
  boolean prueba22 = esTriangular (10);
  boolean prueba31 = esCapicua (1);
  boolean prueba32 = esCapicua (421024);
  boolean prueba33 = esCapicua (42024);
  int prueba41     = inverso (1024);
  boolean prueba51 = esCapicua2 (1);
  boolean prueba52 = esCapicua2 (421024);
  boolean prueba53 = esCapicua2 (42024);

  int prueba61 = max2 (2,8);
  int prueba62 = max2 (8,2);

}