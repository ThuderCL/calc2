import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

        //Определяем арифметическое действие:
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if(data.length != 2){
            System.out.println("Должно быть два числа");
            return;
        }
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){

                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{

                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            int result;
            if(b<1||a<1){
                System.out.println("Число должно быть не меньше 1");
                return;
            } else if (b>10||a>10){
                System.out.println("Число должно быть не больше 10");
                return;
            }
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }

            if(isRoman){

                System.out.println(converter.intToRoman(result));
            }
            else{

                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }


    }
}