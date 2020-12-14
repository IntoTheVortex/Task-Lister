import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Amber Shore
 * @version 2020.12.14
 */
public class TaskListInterface {
    private JPanel rootPanel;
    private JList list1;
    private JSpinner spinner1;
    private JButton randNumGen;
    private final Color purple = new Color(47, 1, 90);




    /**
     * Constructor
     */
    public TaskListInterface(){
        //properties:
        rootPanel.setPreferredSize(new Dimension(500,800));
        rootPanel.setBackground(purple);

        setUpSpinner();
        setUpList();

        //button setup:
        randNumGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get random number from API...
                JOptionPane.showMessageDialog(rootPanel, "Not implemented! \nHave a nonrandom number instead: 14");
            }
        });
    }

    /**
     * Set up task list
     * Simple version - TODO implement changeable version, saving, action listeners etc
     */
    private void setUpList(){
        String[] tasks = {"task one", "task two", "task three", "task four"};
        ListModel<String> taskModel = new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return tasks.length;
            }

            @Override
            public String getElementAt(int index) {
                return tasks[index];
            }
        };
        list1.setModel(taskModel);
    }

    /**
     * Set up the spinner model and characteristics
     */
    private void setUpSpinner(){
        SpinnerModel numTasks = new SpinnerNumberModel(1, 0,8,1);
        spinner1.setModel(numTasks);
    }

    /**
     * Returns the panel containing the components.
     * @return rootPanel
     */
    public JPanel getRootPanel () { return rootPanel; }


}
