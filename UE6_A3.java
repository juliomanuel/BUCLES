//  DOCUMENTACIÓN  --------------------------------------------------
/*
  ARCHIVO: UE6_A3.java
  EFECTO: Fecha correcta con agregados
  AUTOR: JMB
  GRUPO: 1O5M
  FECHA_CREACIÓN: 1/12/10
  FECHA_ÚLTIMA_MODIFICACIÓN: 3/12/10
  USA: Fecha, Intervalo
*/

//  Instancia del objeto: UE6_A3 ue63 = new UE6_A3 ()

class UE6_A3
{
  
//  CONSTANTES PARA NOMBRAR LOS DIAS DE LA SEMANA  ------------------
  
  final int domingo   = 1; 
  final int sabado    = 2;
  final int viernes   = 3;
  final int jueves    = 4;
  final int miercoles = 5;
  final int martes    = 6;
  final int lunes     = 0;

//  DECLARACION DE FUNCIONES  ---------------------------------------

/*
  FUNCION añoBisiesto (año : Entero) ---> Boolean
  PRE: año > 0
  POST: resultado es cierto si año es multiplo de 4 cuando no lo es
        de 100 o bien es multiplo de 400 y falso e.o.c.
*/
  boolean añoBisiesto (int año)
  {
    return ((año % 4 == 0) && (año % 100 != 0)) || (año % 400 == 0);
  }
/*
  FUNCION diasDelMes (Fecha fecha) ---> Entero
  PRE: (año > 0) /\ (mes IN [1,12])
                   | 31  si mes IN {1,3,5,7,8,10,12}
  POST: resultado =| 30  si mes IN {4,6,9,11}
                   | 29  si (mes = 2) /\ añoBisiesto (año)
                   | 28  si (mes = 2) /\ ¬añoBisiesto (año)
*/
  int diasDelMes (Fecha fecha)
  {
    switch (fecha.mes)
    {
      case 4: case 6 :
      case 9: case 11: return 30;
      case 2         : if (añoBisiesto (fecha.año))
                         return 29;
                       else
                         return 28;
      default        : return 31;
    }
  }
/*
  FUNCION siguienteFecha (Fecha fecha) ---> Fecha
  PRE: fechaCorrecta (fecha)
  POST: resultado es la fecha siguiente a "fecha"
*/
  Fecha siguienteFecha (Fecha fecha)
  {
    if (fecha.dia < diasDelMes (fecha))
      return new Fecha (fecha.dia+1,fecha.mes,fecha.año);
    else if (fecha.mes < 12)
      return new Fecha (1,fecha.mes+1,fecha.año);
    else
      return new Fecha (1,1,fecha.año+1);
  }
/*
 * FUNCION esPosterior (Fecha fecha1, fecha2) ---> Boolean
 * PRE: fechaCorrecta (fecha1) /\ fechaCorrecta (fecha2)
 * POST: res = (año1 > año2) \/
 *             ((año1 = año2) /\ (mes1 > mes2)) \/
 *             ((año1 = año2) /\ (mes1 = mes2) /\ (dia1 > dia2))
 * DONDE: (dia1,mes1,año1) = fecha1 /\
 *        (dia2,mes2,año2) = fecha2
*/
  boolean esPosterior (Fecha fecha1, Fecha fecha2)
  {
    return (fecha1.año > fecha2.año)     ||
           ((fecha1.año == fecha2.año) &&
            (fecha1.mes > fecha2.mes))   ||
           ((fecha1.año == fecha2.año) &&
            (fecha1.mes == fecha2.mes) &&
            (fecha1.dia > fecha2.dia));
  }
/*
 * FUNCION intervaloCorrecto (Intervalo inter) ---> Boolean
 * PRE: cierto
 * POST: resultado = fechaCorrecta (fecha1) /\
 *                   fechaCorrecta (fecha2) /\
 *                   NO esPosterior (fecha1, fecha2)
 * DONDE: (fecha1,fecha2) = inter
*/

/*
 * FUNCION diasEntre (Intervalo intervalo) ---> Natural
 * PRE: intervaloCorrecto (intervalo)
 * POST: resultado = SUM i IN intervalo . 1
*/
  int diasEntre (Intervalo intervalo)
  {
    int resultado = 0;
    Fecha fechaAnterior;
    Fecha fechaPosterior = intervalo.fin;
    Fecha fechaActual = intervalo.ppo;
    while (!esPosterior (fechaActual,fechaPosterior))
    {
      resultado = resultado + 1;
      fechaAnterior = fechaActual;
      fechaActual = siguienteFecha (fechaAnterior);
    }
    return resultado;
  }
/*
 * FUNCION cuantosBisiestos (Natural año1, año2) ---> Natural
 * PRE: añoCorrecto (año1) /\ añoCorrecto (año2) /\ (año1<=año2)
 * POST: resultado = SUM i IN (año1,año2) | añoBisiesto (i) . 1
*/
  int cuantosBisiestos (int año1, int año2)
  {
    int resultado = 0;
    for (int i = año1+1; i < año2; i++)
      if (añoBisiesto (i))
        resultado = resultado + 1;
    return resultado;
  }
/*
 * FUNCION diasEntreQuick (Intervalo intFechas) ---> Natural
 * PRE: intervaloCorrecto (intFechas)
 * POST: resultado = SUM fecha IN intFechas . 1
*/
  int diasEntreQuick (Intervalo intFechas)
  {
    int añoPpo = intFechas.ppo.año;
    int añoFin = intFechas.fin.año;
    if (añoFin - añoPpo < 1)
      return diasEntre (intFechas);
    else
    {
      Fecha fechaFinPrimerAño = new Fecha (31,12,añoPpo);
      Intervalo i1 = new Intervalo (intFechas.ppo,fechaFinPrimerAño);
      Fecha fechaPpoUltimoAño = new Fecha (1,1,añoFin);
      Intervalo i2 = new Intervalo (fechaPpoUltimoAño,intFechas.fin);
      return diasEntre (i1) + diasEntre (i2) +
             ((añoFin - añoPpo - 1) * 365) +
             cuantosBisiestos (añoPpo,añoFin);
    }
  }

/*
 * FUNCION diaSemana (Fecha fecha, hoy; int diaHoy) ---> Natural
 * PRE: fechaCorrecta (fecha)/\fechaCorrecta (hoy)/\(diaHoy IN [0,6])
 * POST: resultado es el dia de la semana de "fecha" 
*/
  int diaSemana (Fecha fecha, Fecha hoy, int diaHoy)
  {
    Intervalo inter = new Intervalo (fecha,hoy);
    return ((diasEntre(inter) % 7) - 1 + diaHoy) % 7;
  }
/*
  FUNCION verFecha (Fecha fecha) ---> Cadena
  PRE: cierto
  POST: resultado es la cadena de caracteres formada por '(' seguido
  de las componentes de "fecha" separadas por ',' y acabada en ')'
*/
  String verFecha (Fecha fecha)
  {
    return "(" + fecha.dia + "," +
                 fecha.mes + "," +
                 fecha.año + ")";
  }
/*
  FUNCION verDiaSemana (Natural dia) ---> Cadena
  PRE: cierto
  POST: resultado es la cadena de caracteres de la constante que
        da nombre a cada día de la semana, representado por "día"
*/
  String verDiaSemana (int dia)
  {
    switch (dia)
    {
      case 1 : return "domingo";
      case 2 : return "sábado";
      case 3 : return "viernes";
      case 4 : return "jueves";
      case 5 : return "miércoles";
      case 6 : return "martes";
      default: return "lunes";
    }
  }

//  DECLARACIONES DE CONSTANTES DE PRUEBAS  -------------------------
  
  final Fecha fecha1 = new Fecha (29,2,1920);
  final Fecha fecha2 = new Fecha (29,2,2010);
  final Fecha fecha3 = new Fecha (31,12,2010);
  final Fecha fecha4 = new Fecha (1,12,2010);
  final Fecha fecha5 = new Fecha (1,2,2012);
  final Fecha fecha6 = new Fecha (22,12,2010);
  final Intervalo i43 = new Intervalo (fecha4,fecha3);
  final Intervalo i45 = new Intervalo (fecha4,fecha5);
  
//  DECLARACIONES DE PRUEBAS  ---------------------------------------

  String prueba11 = verFecha (siguienteFecha (fecha1));
  String prueba12 = verFecha (siguienteFecha (fecha3));
  boolean prueba21 = esPosterior (fecha1,fecha2);  //  falso
  boolean prueba22 = esPosterior (fecha3,fecha2);  //  cierto
  int prueba31 = diasEntre (i43);       //  31
  int prueba32 = diasEntre (i45);       //  428
  int prueba41 = diasEntreQuick (i43);  //  31
  int prueba42 = diasEntreQuick (i45);  //  428
  String prueba51 = verDiaSemana (diaSemana(fecha4,fecha3,viernes));
  String prueba52 = verDiaSemana (diaSemana(fecha4,fecha6,miercoles));

}