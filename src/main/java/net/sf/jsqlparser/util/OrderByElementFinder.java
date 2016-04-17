package net.sf.jsqlparser.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.jsqlparser.expression.AllComparisonExpression;
import net.sf.jsqlparser.expression.AnalyticExpression;
import net.sf.jsqlparser.expression.AnyComparisonExpression;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.CaseExpression;
import net.sf.jsqlparser.expression.CastExpression;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.ExtractExpression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.IntervalExpression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.OracleHierarchicalExpression;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.SignedExpression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.TimeValue;
import net.sf.jsqlparser.expression.TimestampValue;
import net.sf.jsqlparser.expression.WhenClause;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Modulo;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.expression.operators.relational.RegExpMatchOperator;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.LateralSubSelect;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.OrderByVisitor;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.statement.select.ValuesList;
import net.sf.jsqlparser.statement.select.WithItem;

public class OrderByElementFinder implements OrderByVisitor,SelectVisitor, FromItemVisitor, ExpressionVisitor{

	private List<String> orderByElements;

	public List<String> getOrderByElements(Select select){
		init();
		select.getSelectBody().accept(this);
		return orderByElements;
	}

	@Override
	public void visit(OrderByElement orderBy) {
		orderByElements.add(orderBy.toString());
	}


	private void init() {
		orderByElements = new ArrayList<String>();
	}

	public void visitBinaryExpression(BinaryExpression binaryExpression) {
		binaryExpression.getLeftExpression().accept(this);
		binaryExpression.getRightExpression().accept(this);
	}

	@Override
	public void visit(PlainSelect plainSelect) {
		plainSelect.getFromItem().accept(this);
		List<OrderByElement> ele = plainSelect.getOrderByElements();
		if(ele !=null){
		orderByElements.add(plainSelect.getOrderByElements().toString());
		}
		if (plainSelect.getWhere() != null) {
			plainSelect.getWhere().accept(this);
		}
	}

	@Override
	public void visit(SetOperationList setOpList) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(WithItem withItem) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Table tableName) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(SubSelect subSelect) {
		subSelect.getSelectBody().accept(this);
	}

	@Override
	public void visit(SubJoin subjoin) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(LateralSubSelect lateralSubSelect) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(ValuesList valuesList) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(NullValue nullValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Function function) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(SignedExpression signedExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(JdbcParameter jdbcParameter) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(JdbcNamedParameter jdbcNamedParameter) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(DoubleValue doubleValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(LongValue longValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(DateValue dateValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(TimeValue timeValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(TimestampValue timestampValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Parenthesis parenthesis) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(StringValue stringValue) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Addition addition) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Division division) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Multiplication multiplication) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Subtraction subtraction) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(AndExpression andExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(OrExpression orExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Between between) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(EqualsTo equalsTo) {
		visitBinaryExpression(equalsTo);
	}

	@Override
	public void visit(GreaterThan greaterThan) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(GreaterThanEquals greaterThanEquals) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(InExpression inExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(IsNullExpression isNullExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(LikeExpression likeExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(MinorThan minorThan) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(MinorThanEquals minorThanEquals) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(NotEqualsTo notEqualsTo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Column tableColumn) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(CaseExpression caseExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(WhenClause whenClause) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(ExistsExpression existsExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(AllComparisonExpression allComparisonExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(AnyComparisonExpression anyComparisonExpression) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Concat concat) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Matches matches) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(BitwiseAnd bitwiseAnd) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(BitwiseOr bitwiseOr) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(BitwiseXor bitwiseXor) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(CastExpression cast) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(Modulo modulo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(AnalyticExpression aexpr) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(ExtractExpression eexpr) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(IntervalExpression iexpr) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(OracleHierarchicalExpression oexpr) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void visit(RegExpMatchOperator rexpr) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
