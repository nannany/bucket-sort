package sqlParser;

import java.io.StringReader;
import java.util.List;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.OrderByElementFinder;

public class Test {
	public static void main(String[] args) throws JSQLParserException{
		CCJSqlParserManager pm = new CCJSqlParserManager();
//		String sql = "SELECT * FROM MY_TABLE1"+
//		" WHERE ID = (SELECT MAX(ID) FROM MY_TABLE5) AND ID2 IN (SELECT * FROM MY_TABLE6)" ;
		GetSqlPath gsp = new GetSqlPath();
		String test = gsp.getPath("sql.txt");
		String sql = test;
		net.sf.jsqlparser.statement.Statement statement = pm.parse(new StringReader(sql));
		/*
		now you should use a class that implements StatementVisitor to decide what to do
		based on the kind of the statement, that is SELECT or INSERT etc. but here we are only
		interested in SELECTS
		*/
//		if (statement instanceof Select) {
//			Select selectStatement = (Select) statement;
//			TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//			List tableList = tablesNamesFinder.getTableList(selectStatement);
//			for(int i=0;i<tableList.size();i++){
//				System.out.println(tableList.get(i));
//			}
//		}

		if (statement instanceof Select) {
			Select selectStatement = (Select) statement;
			OrderByElementFinder orderByElementFinder = new OrderByElementFinder();
			List tableList = orderByElementFinder.getOrderByElements(selectStatement);
			for(int i=0;i<tableList.size();i++){
				System.out.println(tableList.get(i));
			}
		}
	}
}
