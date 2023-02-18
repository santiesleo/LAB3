import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        CircularList lista = new CircularList();
        int turn = 0;
        boolean flag = false;
        while (!flag){
            System.out.println("");
            System.out.println("1. Dar turno. \n2. Mostrar turno actual. \n3. Pasar turno. \n4. Seguir. \nIngrese una opción: ");
            int option = sc.nextInt();
            if(option == 1){
                turn++;
                lista.addNode(new Node(turn));
            }else if(option == 2){
                lista.currentTurn();
            } else if (option == 3) {
                lista.skipTurn();

            }else if(option == 4){
                lista.deleteTurn();
            }
        }


    }
}
