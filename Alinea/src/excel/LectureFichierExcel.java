package excel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LectureFichierExcel {

	
	public static void main(String[] args) {
		Workbook workbook = null;
		try {
			/* R�cup�ration du classeur Excel (en lecture) */
			workbook = Workbook.getWorkbook(new File("D:\\exemple.xls"));
			
			/* Un fichier excel est compos de plusieurs feuilles, on y accede de la maniere suivante*/
			Sheet sheet = workbook.getSheet(0);
			
			/* On acc�de aux cellules avec la m�thode getCell(indiceColonne, indiceLigne) */
			Cell a1 = sheet.getCell(0,0); 
			
			/* On peut �galement le faire avec getCell(nomCellule) */
			Cell c5 = sheet.getCell("C5");
			
			/* On peut r�cup�rer le contenu d'une cellule en utilisant la m�thode getContents() */
			String contenuA1= a1.getContents();
			String contenuC5 = c5.getContents();
			
			System.out.println(contenuA1);
			System.out.println(contenuC5);
		} 
		catch (BiffException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if(workbook!=null){
				/* On ferme le worbook pour lib�rer la m�moire */
				workbook.close(); 
			}
		}
	}

}
