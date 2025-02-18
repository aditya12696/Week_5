package com.bridgelabz.basicproblems.writedata;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void main(String[] args) {
        try(CSVWriter writer = new CSVWriter(new FileWriter("D:\\Capg\\Week_5\\ioprogramming\\src\\output.csv"))){
            String[] header = {"ID", "Name", "Department", "Salary"};
            String[] emp1 = {"104", "Alice Williams", "Finance", "62000"};
            String[] emp2 = {"105", "Bob Johnson", "Sales", "58000"};
            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            System.out.println("CSV file written successfully using OpenCSV!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
