package hello;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;



public class QueryResult {

    private static String query;

    public QueryResult (String typedQuery) {

        query= typedQuery;

    }

    public  static void getResult ( ) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springboot", "root", "");
        Statement statement = connection.createStatement();

        statement = connection.createStatement();
        ResultSet resultset = statement
                .executeQuery(query);

        JFrame frame = new JFrame("Query Result");

        JTable table1 = new JTable(buildTableModel(resultset));
        JScrollPane tableContainer = new JScrollPane(table1);
        JPanel QueryP = new JPanel();
        QueryP.setLayout(new BorderLayout());
        QueryP.add(tableContainer, BorderLayout.CENTER);
        frame.getContentPane().add(QueryP);
        frame.pack();
        frame.setVisible(true);
    }

    public static DefaultTableModel buildTableModel(ResultSet resultset)
            throws SQLException {



        ResultSetMetaData metaData = resultset.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultset.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultset.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }


}

