package lab3.Interface;

import lab3.Tasks.TaskA;
import lab3.Tasks.TaskBC;
import lab3.IO.IO;

public class Interface {
    public static void mainMenu() {
        int choice;
        do {
            System.out.println("---------------------------");
            System.out.println("Главное меню");
            System.out.println("1 - Работа с массивом");
            System.out.println("2 - Работа со строкой");
            System.out.println("0 - Выход");
            System.out.println("---------------------------");
            choice = IO.inputNumber();
            switch(choice){
                case 1:
                    inputArrayMenu();
                    break;
                case 2:
                    inputStringMenu();
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.print("Введите 1,2 или 0: ");
                    break;
                    
            }
            
        } while (choice != 0);
    }
    
    private static void inputArrayMenu(){
        int choice;
        do {
            System.out.println("----------------------------------");
            System.out.println("Меню ввода массива ");
            System.out.println("1 - Ввести массив из консоль");
            System.out.println("2 - Ввести массив из файла");
            System.out.println("3 - Демонстрационный вариант");
            System.out.println("0 - Назад");
            System.out.println("-------------------------------");
            choice = IO.inputNumber();
            TaskA a = new TaskA();
            switch (choice) {
                case 1:
                    a.setArr(IO.inputArrayFromConsole());
                    worksWithAnArrayMenu(a);
                    
                    break;
                case 2:
                    
                    a.setArr(IO.inputArrayFromFile(IO.inputFileName()));
                    if (a.getArr() == null) {
                        break;
                    }
                    worksWithAnArrayMenu(a);
                    
                    break;
                case 3:
                    int[] temp = new int[] {0, 1, 2, 3, 4, 5, 6};
                    a.setArr(temp);
                    worksWithAnArrayMenu(a);
                    
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.print("Введите 1,2,3 или 0: ");
                    break;
            }
        } while (choice != 0);
    }
    
    private static void worksWithAnArrayMenu(TaskA a) {
        int choice;
        do {
            System.out.println("----------------------------------");
            System.out.println("Меню работы с массивом");
            System.out.println("1 - Проверить сортировку массива");
            System.out.println("2 - Вывести в консоль массив");
            System.out.println("3 - Сохранить в файл");
            System.out.println("0 - Назад");
            System.out.println("----------------------------------");
            choice = IO.inputNumber();
            
            switch (choice) {
                case 1:
                    a.result();
                    break;
                case 2:
                    a.print();
                    break;
                case 3:
                    IO.outputArrayToFile(IO.inputFileName(), a.getArr());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Введите числа 1, 2 или 0");
                    break;
            }
        } while (choice != 0);
    }
    
    private static void inputStringMenu() {
        int choice;
        TaskBC bc = new TaskBC();
        do {
            
            System.out.println("----------------------------------");
            System.out.println("Меню ввода строки");
            System.out.println("1 - Ввести строку в консоль");
            System.out.println("2 - Ввести строку из файла");
            System.out.println("3 - Демонстрационный вариант");
            System.out.println("0 - Назад");
            System.out.println("----------------------------------");
            choice = IO.inputNumber();
            
            switch (choice) {
                case 1:
                    bc.setStr(IO.inputStringArrayFromConsole());
                    worksWithAnStringArrayMenu(bc);
                    break;
                case 2:
                    bc.setStr(IO.inputStringArrayFromFile(IO.inputFileName()));
                    if (bc.getStr() == null) {
                        break;
                    }
                    worksWithAnStringArrayMenu(bc);
                    break;
                case 3:
                    String[] temp = new String[] {"deed", "nun", "pull", "noon"};
                    bc.setStr(temp);
                    worksWithAnStringArrayMenu(bc);
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.println("Введите числа 1, 2, 3 или 0");
                    break;
            }
            
        } while (choice != 0);
    }
    
    
    private static void worksWithAnStringArrayMenu(TaskBC bc) {
        int choice;
        do {
            System.out.println("----------------------------------");
            System.out.println("Меню работы со строкой");
            System.out.println("1 - Отсортировать слова по третьей букве");
            System.out.println("2 - Вывести в консоль все слова являющиеся палиндромами");
            System.out.println("3 - Вывести в консоль строку");
            System.out.println("4 - Сохранить в файл");
            System.out.println("0 - Назад");
            System.out.println("----------------------------------");
            choice = IO.inputNumber();
            
            switch (choice) {
                case 1:
                    bc.sortBy3rdLetter();
                    System.out.println("Строка отсортированна");
                    break;
                case 2:
                    bc.resultTaskC();
                    break;
                case 3:
                    bc.print();
                    break;
                case 4:
                    IO.outputStringArrayFromFile(IO.inputFileName(), bc.getStr());
                    break;                                       
                case 0:
                    
                    break;
                default:
                    System.out.println("Введите числа 1-4 или 0");
                    break;
            }
        } while (choice != 0);
    }
}
