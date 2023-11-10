package singlylinkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> disciples = new SinglyLinkedList<>();
        disciples.append("Simon Peter");
        disciples.append("Andrew");
        disciples.append("James son of Zebedee");
        disciples.append("John");
        disciples.append("Philip");
        disciples.append("Bartholomew");
        disciples.append("Thomas");
        disciples.append("Matthew the tax collector");
        disciples.append("James son of Alphaeus");
        disciples.append("Thaddaeus");
        disciples.append("Simon the Zealot");
        disciples.append("Judas Iscariot");

        disciples.remove("Judas Iscariot");
        disciples.sort();

        System.out.println("Disciples in reverse alphabetical order:");
        disciples.printReverse();
    }
}

