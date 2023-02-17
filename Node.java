public class Node {
    private String name;
    private Node next;
    private Node previous;

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private int passTurn;

    public int getPassTurn() {
        return passTurn;
    }

    public void setPassTurn(int passTurn) {
        this.passTurn = passTurn;
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
