

package hello;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.util.Vector;


/**
 * Created by student on 4/4/17.
 */
public class Schedule {
    private JTable table1;
    private JPanel panel1;


    private JdbcTemplate jdbcTemplate;



    public static void show ( ) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springboot", "root", "");

        Statement statement = con.createStatement();

        statement = con.createStatement();
        ResultSet resultset = statement
                .executeQuery("  SELECT * from schedule ");

        JFrame frame = new JFrame("Schedule_Fall2016");


        JTable table1 = new JTable(buildTableModel(resultset));
        JScrollPane tableContainer = new JScrollPane(table1);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(tableContainer, BorderLayout.CENTER);
        frame.getContentPane().add(panel1);
        frame.pack();
        frame.setVisible(true);
    }

    public static DefaultTableModel buildTableModel(ResultSet result )
            throws SQLException {



        ResultSetMetaData metaData =result .getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (result.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(result.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

}

