package Trees;

/*
 Suppose an arithmetic expression is given as a tree. Each leaf is an integer and each internal node is one of the
 standard arithmetical operations (+,−,∗,/).
 For example, the expression 2+3∗4+(3∗4)/5 is represented by the tree in Figure (see book)(a).
(see book for figure)
(see book for figure) Give an O(n) algorithm for evaluating such an expression, where there are n nodes in the tree.

http://www.algorist.com/algowiki/index.php/TADM2E_5.9
 */




class GraphArithmetic {
    interface Node{
        int evaluate();
    }

    static class Literal implements Node{
        int val;

        @Override
        public int evaluate(){
            return val;
        }

        Literal(int val){
            this.val = val;
        }
    }

    static abstract class Operation implements Node{
        Node operand1;
        Node operand2;

        Operation(Node op1, Node op2){
            operand1 = op1;
            operand2 = op2;
        }
    }

    static class Addition extends Operation{
        @Override
        public int evaluate() {
            return operand1.evaluate() + operand2.evaluate();
        }

        Addition(Node op1, Node op2){
            super(op1, op2);
        }
    }

    static class Subtraction extends Operation{
        @Override
        public int evaluate(){
            return operand1.evaluate() - operand2.evaluate();
        }

        Subtraction(Node op1, Node op2){
            super(op1, op2);
        }
    }

    static class Division extends Operation{
        @Override
        public int evaluate(){
            return operand1.evaluate() / operand2.evaluate();
        }

        Division(Node op1, Node op2){
            super(op1, op2);
        }
    }

    static class Multiplication extends Operation{
        @Override
        public int evaluate(){
            return operand1.evaluate() * operand2.evaluate();
        }

        Multiplication(Node op1, Node op2){
            super(op1, op2);
        }
    }

    public static void main(String[] args){
        Node lit2 = new Literal(2);
        Node lit3 = new Literal(3);
        Node lit4 = new Literal(4);
        Node lit5 = new Literal(5);
        Node mul = new Multiplication(lit3, lit4);
        Node div = new Division(mul, lit5);
        Node add2 = new Addition(lit2, mul);
        Node root = new Addition(add2, div);
        System.out.println(root.evaluate());
    }
}
