public class CircularList {

    private Node head;

    public void addNode(Node node){
        if(head == null){ //Caso cuando no hay ningún nodo creado
            head = node; //Referenciamos el nodo a la cabeza
            head.setNext(head); //Enlazamos el siguiente nodo a la cabeza, ya que solo hay un nodo, entonces sería él mismo
            head.setPrevious(head); //Enlazamos el anterior no a la cabeza, ya que solo hay un nodo, entonces sería él mismo
        }else{ //Caso cuando la cabeza ya está creada
            Node tail = head.getPrevious(); //Creamos una cola, que va a ser el que está antes de la cabeza
            node.setNext(head); //Enlazamos el next del nodo nuevo a la cabeza
            head.setPrevious(node); //Enlazamos el previous de la cabeza al nuevo nodo
            tail.setNext(node); //Enlazamos el next de la cola a la cabeza
            node.setPrevious(tail); //Enlazamos el previo del nodo nuevo a la cola
        }
    }

    //Referenciar al cliente
    public void addClient(Client client){head.setClient(client);}

    //Pasar turno
    public void passTurn(){
        passTurn(head);
    }

    //Pasar turno
    public void passTurn(Node current){
        if(current == head){
            return;
        }if(current.getClient() != null){
            if(current.getNext() != current){
                Client client = current.getClient();
                current.getNext().setClient(client);
                current.setClient(null);
                current.setPassTurn(+1);
            }else {
                current.setPassTurn(+1);
            }
            if(current.getPassTurn() == 3){
                delete();
            }
            return;
        }
        passTurn(current.getNext());
    }

    //Mostrar turno - método de activación
    public void showTurn() {
        if (head == null) {
            System.out.println("No hay turnos");
        } else {
            showTurn(head);
        }
    }

    public void showTurn(Node current) {
        if (current.getClient() != null) {
            System.out.println(current.getName() + "*");
            return;
        }
        System.out.println(current.getName());
        if (current.getNext() == head) {
            return;
        }
        showTurn(current.getNext());
    }

    //Método de activación
    public void print(){
        if(head == null){
            System.out.println("No hay turnos");
        }else{
            print(head);
        }
    }

    //Método recursivo
    private void print(Node current){
        if(current == head.getPrevious()){
            System.out.print("[" +current.getName() + "]\n");
            return;
        }
        System.out.print("[" +current.getName() + "]");
        print(current.getNext());
    }

    public void delete(){
        if(head == null){
            System.out.println("No hay turnos");
        } else if (head == head.getNext()) { //Caso cuando solo haya un nodo
            head = null;
        } else{
            delete(head);
        }
    }

    private void delete(Node current){
        if(current.getClient() != null){
            if(current == head){ //Caso cuando el nodo a eliminar sea la cabeza
                head.getPrevious().setNext(head.getNext());
                head.getNext().setPrevious(head.getPrevious());
                head = head.getNext();
            }else{ //Cualquier otro caso
                Node prev = current.getPrevious();
                Node next = current.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
                next.setClient(current.getClient());
            }
            return;
        }
        if(current.getNext() != head){
            delete(current.getNext());
        }

    }
}
