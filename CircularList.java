public class CircularList {

    private Node head;
    private Node client;

    //Añadir nodo
    public void addNode(Node node) {
        if (head == null) {
            head = node;
            client = node;
            head.setNext(head);
            head.setPrevious(head);
        } else {
            Node tail = head.getPrevious();
            node.setNext(head);
            head.setPrevious(node);
            tail.setNext(node);
            node.setPrevious(tail);
        }
    }

    //Turno actual
    public void currentTurn() {
        if (head == null) {
            System.out.println("No hay turnos");
        } else {
            System.out.println(client.getName());
        }
    }

    //Activación desde el main
    public void deleteTurn() {
        if (head == null) {
            System.out.println("No hay turnos");
        } else {
            client = client.getNext();
            delete(client.getPrevious().getName());
        }
    }

    //Activación de recursividad
    public void delete(int goal) {
        if (head == null) {
            System.out.println("No hay turnos");
        } else {
            delete(head, goal);
        }
    }

    private void delete(Node current, int goal) {
        if (head.getNext().equals(head)) {
            head.setNext(null);
            head.setPrevious(null);
            head = null;
            client = null;
            return;
        }
        if (head.getName() == goal) {
            client = head.getNext();
            head.getNext().setPrevious(head.getPrevious());
            head.getPrevious().setNext(head.getNext());
            head = head.getNext();
            return;
        }
        if (current.getName() == goal) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            client = current.getNext();
            return;
        }
        delete(current.getNext(), goal);
    }


    //Pasar turno
    public void skipTurn() {
        if (head == null) {
            System.out.println("No hay turnos");
        } else if (client.getSkip() == 3) {
            client = client.getNext();
            delete(client.getPrevious().getName());
        } else {
            client.setSkip(client.getSkip() + 1);
            client = client.getNext();
        }
    }
}