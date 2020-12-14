import javax.swing.*;

/**
 * This is an unfocused task lister app for fun.
 * @author Amber Shore
 * @version 2020.12.14
 */
public class Main {

    public static void showGUI(){
        JFrame frame = new JFrame("Task Lister");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new TaskListInterface().getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> showGUI());
    }
}
