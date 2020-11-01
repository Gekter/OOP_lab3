package lab3.Tasks;


public class TaskBC {
    private String[] str;
   
    public TaskBC(String[] str) {
        this.str = str;
    }
    
    public TaskBC(TaskBC temp) {
        this.str = temp.str;
    }
    
    public TaskBC(String temp) {
        temp = temp.replace(',', ' '); // замена всех запятых на пробелы
        temp = temp.replace('.', ' '); // замена всех точек на пробелы        
        this.str = temp.split(" ");
    }
    
    public TaskBC() {
        String[] temp = {"deed", "nun", "pull", "noon"};
        this.str = temp;
    }
    
    public String[] getStr() {
        return str;
    }
    
    public void setStr(String[] str) {
        this.str = str;
    }
    
    
    public void sortBy3rdLetter() {
        int index1, index2;
        for (int i = str.length-1; i >= 1; i--) { // сортировка пузырьком
            for (int j = 0; j < i; j++) {
                if (str[j].length() < 3) { // проверка кол-ва букв
                    index1 =  str[j].length()-1;
                } 
                else {
                    index1 = 2;
                }
                
                if (str[j+1].length() < 3) { // проверка кол-ва букв
                    index2 =  str[j+1].length()-1;
                } 
                else {
                    index2 = 2;
                }
                
                if (str[j].charAt(index1) > str[j+1].charAt(index2)) {
                    String tmp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = tmp;
                }
            }
        }
    }
    
    public void print() {
        System.out.println("Результат: ");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }
    
    public void resultTaskC() {
        System.out.println("Результат: ");
        boolean checkPoly; // булевая переменная для проверки палиндрома
        boolean checkRes = true;
        for (String str1 : str) {
            // перебираем все слова в массиве
            checkPoly = true;
            for (int j = 0; j < str1.length() / 2; j++) {
                // перебираем все буквы до середины слова
                if (str1.charAt(j) != str1.charAt(str1.length() - j - 1)) {
                    // посимвольное сравнение
                    checkPoly = false; // если буквы различаются
                }
            }
            if (checkPoly) {
                // если это слово палиндром, то печатаем его
                System.out.print(str1 + " ");
                checkRes = false;
            }
        }
        if (checkRes) { // если палиндромы отсутствуют
            System.out.print("Палиндромы отсутствуют");
        }
        System.out.println();
    }
    
    
}
