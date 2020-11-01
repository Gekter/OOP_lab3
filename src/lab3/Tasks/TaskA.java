package lab3.Tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TaskA implements Serializable {
    private int[] arr;
    
    public TaskA(){
        int[] Arr = {0, 1, 2, 3, 4, 5, 6};
        this.arr = Arr;
    }
    
    
    public TaskA(int[] arr){
        this.arr = arr;
    }
    
    public TaskA(String in) {
        
        String[] temp = in.split(" ");
        int[] Temp = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            Temp[i] = Integer.parseInt(temp[i]); // перевод чисел из string в int
        }
        this.arr = Temp;
    }
    
    public TaskA(TaskA temp) {
        this.arr = temp.arr;
    }
    
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    
    public int[] getArr() {
        return arr;
    }
    
    
    public void write(String str) throws FileNotFoundException, IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(str))) {
            objectOutputStream.writeObject(this);
        }
    }
    
    public TaskA read(String str) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("taskA.out"))) {
            TaskA aRestored = (TaskA) objectInputStream.readObject();
            return aRestored;
        }
    }
    
    
        
    public void result() {
        boolean check1 = true, check2 = true;
        for (int i = 0; i < arr.length-1; i++) {
            
            if (arr[i] > arr[i+1]) { // проверка сортировки
                check1 = false;
            }
            
            if (arr[i] < arr[i+1]) {
                check2 = false;
            }
            
        }
        
        if (check1 | check2) {
            if (check1 & check2) {
                System.out.println("Все элементы массива равны");
            }
            else {
                if (check2) {
                    System.out.println("Массив упорядочен по убыванию");
                }
                else {
                    System.out.println("Массив упорядочен по возрастанию");
                }
                
            }
        }
        else {
            System.out.println("Массив не отсортирован");
        }
    }
    
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
