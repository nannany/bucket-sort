package expressions;

public class Equity {
    private String leftExpression;
    private String rightExpression;

    public Equity() {
    }

    public String getLeftExpression() {
        return leftExpression;
    }

    public String getRightExpression() {
        return rightExpression;
    }

    public void setLeftExpression(String expression) {
        leftExpression = expression;
    }

    public void setRightExpression(String expression) {
        rightExpression = expression;
    }

    @Override
    public String toString(){
        return leftExpression + "=" + rightExpression;
    }

}
