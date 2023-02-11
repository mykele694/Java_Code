//package SerieAExcel;
//
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Iterator;
//
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        File myFile = new File("D://Michele//Java_Developer//new_Codici//src//SerieA//listone.xlsx");
//        FileInputStream fis = new FileInputStream(myFile);
//        // Finds the workbook instance for XLSX file
//        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
//        // Return first sheet from the XLSX workbook
//        Sheet mySheet = myWorkBook.getSheetAt(0);
//        // Get iterator to all the rows in current sheet
//        Iterator<Row> rowIterator = mySheet.rowIterator();
//        // Traversing over each row of XLSX file
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            // For each row, iterate through each columns
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                switch (cell.getCellType()) {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue() + "\t");
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t");
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue() + "\t");
//                        break;
//                    default :
//                }
//            }
//            System.out.println("");
//        }
//
//    }
//
//}
