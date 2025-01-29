import java.util.Scanner;
public class Sahej {
    public static void main(String[] args) {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine+"\n\tHello! I'm Sahej\n\tWhat can I do for you?\n"+horizontalLine);
        Scanner userInput = new Scanner(System.in);
        String input = "";
        while(true){
            input = userInput.nextLine();
            System.out.println(horizontalLine);
            if (input.equals("bye")){
                break;
            }
            System.out.println("\t" + input);
            System.out.println(horizontalLine + "\n");
        }
        System.out.println("\tBye. Hope to see you again soon!\n" + horizontalLine);
    }
}

