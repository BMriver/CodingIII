package drive;

public class ShuntingYard {
    public LinkedList Tokens;
    public OutputQueue ReversePolish;

    public ShuntingYard() {
        this.Tokens = new LinkedList();
        this.ReversePolish = new OutputQueue();
    }

    // Parse the input string into tokens and store them in Tokens linked list
    public void parse(String input) {
        String token = "";
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                token += c;
            } else {
                if (!token.isEmpty()) {
                    Tokens.append(token);
                    token = "";
                }
                Tokens.append(Character.toString(c));
            }
        }
        if (!token.isEmpty()) {
            Tokens.append(token);
        }
    }

    // Convert the infix expression in Tokens to postfix expression in ReversePolish
    public void process() {
        OpStack opStack = new OpStack();
        Node current = this.Tokens.Head;
        while (current != null) {
            String data = current.Data;
            if (data.matches("\\d+")) { // If it's a number
                ReversePolish.enqueue(data);
            } else if (data.equals("(")) {
                opStack.push(data);
            } else if (data.equals(")")) {
                while (!opStack.isEmpty() && !opStack.peek().Data.equals("(")) {
                    ReversePolish.enqueue(opStack.pop().Data);
                }
                opStack.pop(); // Pop the '('
            } else if (opStack.isOperator(data.charAt(0))) { // If it's an operator
                while (!opStack.isEmpty() && opStack.precedence(opStack.peek().Data) >= opStack.precedence(data)) {
                    ReversePolish.enqueue(opStack.pop().Data);
                }
                opStack.push(data);
            }
            current = current.NextNode;
        }
        while (!opStack.isEmpty()) {
            ReversePolish.enqueue(opStack.pop().Data);
        }
    }

    // Evaluates the RPN expression stored in ReversePolish
    public int run() {
        Stack stack = new Stack() {
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
        };

        Node current = this.ReversePolish.Head;
        while (current != null) {
            String data = current.Data;
            if (data.matches("\\d+")) { // If it's a number
                stack.push(data);
            } else {
                int right = Integer.parseInt(stack.pop().Data);
                int left = Integer.parseInt(stack.pop().Data);
                int result = 0;
                switch (data) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                }
                stack.push(Integer.toString(result));
            }
            current = current.NextNode;
        }
        return Integer.parseInt(stack.pop().Data);
    }
}
