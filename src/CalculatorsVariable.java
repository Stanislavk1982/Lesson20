public class CalculatorsVariable {
    private String number1="0";
    private String number2="0";
    private boolean first=false;
    private char symbol = 'a';
    private int num1 = 0;
    private int num2 = 0;

    public int getNum1() {
        num1 = Integer.valueOf(number1);
        return num1;
    }

    public int getNum2() {
        num2 = Integer.valueOf(number2);
        return num2;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
}
