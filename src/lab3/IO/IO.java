package lab3.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IO {
    
    public static int[] inputArrayFromFile(String fileName){
        
        try{
            DataInputStream din = new DataInputStream(new FileInputStream(fileName));
            int[] arr = new int[din.available()/4];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = din.readInt();
            }
            System.out.println("Файл прочитан");
            return arr;
        } 
        catch(IOException ex) {
            System.out.println("Файл не удалось прочитать");
            return null;
        } 
        
    }
    public static int[] inputArrayFromConsole(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите массив: ");
        String str = in.nextLine();
        String[] temp = str.split(" ");
        int[] arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            try{
                arr[i] = Integer.parseInt(temp[i]); // перевод чисел из string в int
            } catch (NumberFormatException ex) {
                System.out.print("Введите число вместо введённой строки(символа): ");
                arr[i] = inputNumber();
            }
        }
        return arr;
    }
    
    public static int inputNumber(){
        Scanner in = new Scanner(System.in);
        int choice;
        
        try {
            choice = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException ex){
            System.out.print("Введите число: ");
            choice = inputNumber();
        }
        return choice;
        
    }
    
    public static void outputArrayToFile(String fileName, int[] arr) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
            
            for (int i = 0; i < arr.length; i++) {
                dos.writeInt(arr[i]);
            }
            
            System.out.println("Файл сохранен"); 
        } catch (IOException ex) {
            System.out.println("Не удалось сохранить файл");
        }
        
    }   
    
    public static String inputFileName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = in.nextLine();
        return "file\\" + fileName + ".txt";
    }
    
    public static String[] inputStringArrayFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String temp = in.nextLine();
        temp = temp.replace(',', ' '); // замена всех запятых на пробелы
        temp = temp.replace('.', ' '); // замена всех точек на пробелы   
        return temp.split(" ");
    }
    
    public static String[] inputStringArrayFromFile(String fileName) {
        String str = "";
        try {
            BufferedReader br = new BufferedReader (new FileReader(fileName));
            try {
                String s;
                while ((s = br.readLine())!= null) {
                    str += s;
                    
                }
                if (str == "") {
                    System.out.println("Файл пуст");
                } else {
                    System.out.println("Файл прочитан");
                }
            } catch (IOException ex) {
                System.out.println("Файл не удалось прочитать");
            }
        } catch (IOException ex) {
            System.out.println("Файл не найден");
        }
        String[] temp;
        try {
            temp = str.split(" ");
        } catch (NullPointerException ex) {
            temp = null;
        }
        
        return temp;
    }
    
    public static void outputStringArrayFromFile(String fileName, String[] str) {
        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < str.length; i++) {
                bw.write(str[i] + " ");
            }
            bw.close();
            
            System.out.println("Файл сохранён");
        } catch (IOException ex) {
            System.out.println("Не удалось сохранить файл");
        }
    }
    
}
