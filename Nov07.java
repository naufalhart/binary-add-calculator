import java.util.*;

class Node {
    char value;
    Node prev;

    Node(char value) {
        this.value = value;
    }
}

class Stack {
    Node top;
    int length = 0;

    Stack() {};

    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.length;
    }

    public void push(char value) {
        Node new_node = new Node(value);

        if (this.isEmpty()) {
            this.top = new_node;
        }
        else {
            new_node.prev = this.top;
            this.top = new_node;
        }
        this.length++;
    }

    public Node pop() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            Node current = this.top;
            this.top = this.top.prev;
            current.prev = null;
            this.length++;
            return current;
        }
    }
}

public class Nov07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Binary 1: ");
        String a = scan.nextLine();

        System.out.print("Enter Binary 2: ");
        String b = scan.nextLine();

        int total = Nov07.binToDec(a) + Nov07.binToDec(b);
        if (total == 0) {
            System.out.println(0);
            return;
        }

        String totalBinary = "";

        int temp = total;
        while (temp != 0) {
            if (temp % 2 == 1) {
                totalBinary = totalBinary + "1";
                temp = temp / 2;
            }
            else {
                totalBinary = totalBinary + "0";
                temp = temp / 2;
            }
        }
        
        Stack input = new Stack();
        for (int i = 0; i < totalBinary.length(); i++) {
            input.push(totalBinary.charAt(i));
        }

        ArrayList<Character> output = new ArrayList<>();
        int STACKSIZE = input.size();
        for (int i = 0; i < STACKSIZE; i++) {
            output.add(input.pop().value);
        }

        String stringOutput = "";
        for (int i = 0; i < output.size(); i++) {
            stringOutput = stringOutput + output.get(i);
        }

        System.out.println(stringOutput);
    }

    public static int binToDec(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1') {
                int rank = value.length() - i - 1;
                sum = sum + ((int) Math.pow(2, rank));
            }
        }
        return sum;
    }
}