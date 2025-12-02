import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] equation =  str.split("-");

        int sum = 0;
        for(int i = 0; i < equation.length; i++){
            int temp = Calc(equation[i]);
            if(i == 0){
                sum += temp;
            }
            else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
    public static int Calc(String str){
        int sum = 0;
        String[] arr =  str.split("[+]");
        for(int i = 0; i < arr.length; i++){
            sum += Integer.parseInt(arr[i]);
        }
        return sum;
    }
}
