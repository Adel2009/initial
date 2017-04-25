package hello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * Created by student on 4/4/17.
 */


public class QueryField {
    private JButton searchButton;
    private JPanel QueryP;
    private JTextArea textArea1;

    String getQueryField() {
        return textArea1.getText();
    }

    public QueryField ( ) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{



        JFrame frame = new JFrame("Query");
        JPanel QueryP= new JPanel();
        QueryP.setPreferredSize(new Dimension(500, 300));
        QueryP.add(textArea1);
        textArea1.setSize(250,200);
        QueryP.add(searchButton);
        frame.getContentPane().add(QueryP);

        frame.pack();
        frame.setVisible(true);
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                QueryResult result= new QueryResult(getQueryField());
                try {
                    QueryResult.getResult();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

