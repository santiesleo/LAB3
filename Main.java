import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        CircularList lista = new CircularList();
        int turn = 0;
        boolean flag = false;
        while (!flag){
            System.out.println("1. Dar turno. \n2. Mostrar turno actual. \n3. Pasar turno. \n4. Seguir. \nIngrese una opción: ");
            int option = sc.nextInt();
            if(option == 1){
                turn++;
                Client client = new Client(String.valueOf(turn));
                lista.addNode(new Node(String.valueOf(turn)));
                if(turn == 1){
                    lista.addClient(client);
                }

            }else if(option == 2){
                lista.showTurn();

            } else if (option == 3) {
                lista.passTurn();

            }else if(option == 4){
                lista.delete();
            }
            lista.print();
        }


    }
}
