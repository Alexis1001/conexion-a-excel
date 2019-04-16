package pruebaexcel;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ejecutable {

    public static void main(String[] args) {
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(new File("miLibritoDeExcel.xls"));
            WritableSheet hoja = libro.createSheet("Hoja 1", 0);
            
            //Label recibe 3 parámetros: el número de la columna, el número de la fila y el contenido.
            //Estos números empiezan con el 0
            Label celdaDeTexto = new Label(0, 1, "Hernández"); //Celda A1
            hoja.addCell(celdaDeTexto);
            
            //Agregar un número
            Number celdaNumerica = new Number(2, 5, 123.5); //Celda C4
            hoja.addCell(celdaNumerica);
            
            //Agregar celdas sin necesidad de guardar variables
            hoja.addCell(new Label(4, 5, String.format("Papas", " fritas"))); //E4
            hoja.addCell(new Number(1, 6, 12*7)); //B5
            
            libro.write();
            libro.close();
        } catch (Exception ex) {
            if(libro != null){
                try {
                    libro.close();
                } catch (Exception e) {}
            }
        }
        
        
    }//main string
    
}//ejecutable
