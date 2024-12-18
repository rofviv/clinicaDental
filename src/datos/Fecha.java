/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Roy Favio
 */
public class Fecha {

    private String dia, fecha, mes, mes_num, anho;

    public Fecha() {
        calcularFecha();
    }

    public String fechaActual() {
        return dia + ", " + fecha + " de " + mes + " de " + anho;
    }

    private void calcularFecha() {
        Date data = new Date();
        fecha = "" + data.getDate();
        anho = "" + (1900 + data.getYear());

        switch (data.getDay()) {
            case 0:
                dia = "Domingo";
                break;
            case 1:
                dia = "Lunes";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Miercoles";
                break;
            case 4:
                dia = "Jueves";
                break;
            case 5:
                dia = "Viernes";
                break;
            case 6:
                dia = "Sábado";
                break;
        }

        switch (data.getMonth()) {
            case 0:
                mes = "Enero";
                break;
            case 1:
                mes = "Febrero";
                break;
            case 2:
                mes = "Marzo";
                break;
            case 3:
                mes = "Abril";
                break;
            case 4:
                mes = "Mayo";
                break;
            case 5:
                mes = "Junio";
                break;
            case 6:
                mes = "Julio";
                break;
            case 7:
                mes = "Agosto";
                break;
            case 8:
                mes = "Setiembre";
                break;
            case 9:
                mes = "Octubre";
                break;
            case 10:
                mes = "Noviembre";
                break;
            case 11:
                mes = "Diciembre";
                break;
        }
//
//        switch (data.getMonth()) {
//            case 0:
//                mes_num = "01";
//                break;
//            case 1:
//                mes_num = "02";
//                break;
//            case 2:
//                mes_num = "03";
//                break;
//            case 3:
//                mes_num = "04";
//                break;
//            case 4:
//                mes_num = "05";
//                break;
//            case 5:
//                mes_num = "06";
//                break;
//            case 6:
//                mes_num = "07";
//                break;
//            case 7:
//                mes_num = "08";
//                break;
//            case 8:
//                mes_num = "09";
//                break;
//            case 9:
//                mes_num = "10";
//                break;
//            case 10:
//                mes_num = "11";
//                break;
//            case 11:
//                mes_num = "12";
//                break;
//        }
    }
}
