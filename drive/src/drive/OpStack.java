package drive;

public class OpStack extends Stack {
    private String Ops = "+-*/";

    public void push(String data) {
        this.prepend(data);
    }

    public Node pop() {
        Node result = this.Head;
        this.removeHead();
        return result;
    }

    public Node peek() {
        return this.Head;
    }

    public boolean isOperator(char c) {
        return Ops.indexOf(c) != -1;
    }

    public int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }
}
