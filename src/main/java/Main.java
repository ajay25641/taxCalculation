import org.apache.poi.xssf.usermodel.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{

        String path="C:\\Users\\ajay1.kumar\\Desktop\\Tax.xlsx";
        FileInputStream fr=new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fr);
        XSSFSheet sheet=workbook.getSheetAt(0);

        int rows=sheet.getLastRowNum();
        int cols=sheet.getRow(0).getLastCellNum();
        //System.out.println(cols);

        ArrayList<Employee> arr=new ArrayList<>();


        //reading data
        for(int i=1;i<=rows;++i){
           XSSFRow row=sheet.getRow(i);
           String name=row.getCell(0).getStringCellValue().trim().toLowerCase();
           int id=(int)row.getCell(1).getNumericCellValue();
           String state=row.getCell(2).getStringCellValue().trim().toLowerCase();
           double salary=row.getCell(3).getNumericCellValue();
           Double bonus=row.getCell(4).getNumericCellValue();
           arr.add(new Employee(name,state,salary,bonus,id));

        }

        //calculating tax
        new CalculateTax().calculateTax(arr);


        //creating new workbook
        workbook=new XSSFWorkbook();
        sheet=workbook.createSheet("sheet 1");
        XSSFRow row1 = sheet.createRow(0);

        row1.createCell(0).setCellValue("Name");
        row1.createCell(1).setCellValue("Id");
        row1.createCell(2).setCellValue("State");
        row1.createCell(3).setCellValue("Bonus%");
        row1.createCell(4).setCellValue("Salary");
        row1.createCell(5).setCellValue("TotalTax");
        row1.createCell(6).setCellValue("Net amount");

        int n=arr.size();
        for(int i=1;i<=n;++i){

            Employee emp=arr.get(i-1);

            XSSFRow row=sheet.createRow(i);

            row.createCell(0).setCellValue(emp.name);
            row.createCell(1).setCellValue(emp.id);
            row.createCell(2).setCellValue(emp.state);
            row.createCell(3).setCellValue(emp.bonus);
            row.createCell(4).setCellValue(emp.salary);
            row.createCell(5).setCellValue(emp.totalTax);
            row.createCell(6).setCellValue(emp.salaryAfterTax);
        }

        //exporting above workbook
        path="C:\\Users\\ajay1.kumar\\Desktop\\Tax_Output.xlsx";
        FileOutputStream of=new FileOutputStream(path);
        workbook.write(of);
        workbook.close();
        fr.close();
        of.close();


    }
}
