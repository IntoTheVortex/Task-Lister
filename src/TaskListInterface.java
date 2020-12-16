import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author Amber Shore
 * @version 2020.12.14
 */
public class TaskListInterface {
    private JPanel rootPanel;
    private JList list1;
    private JSpinner spinner1;
    private JButton randNumGen;
    private JTextField inputTask;
    private JButton enterTask;
    private JLabel taskLabel;
    private final Color purple = new Color(47, 1, 90);

    Vector<String> tasks = new Vector<String>();




    /**
     * Constructor
     */
    public TaskListInterface(){
        //properties:
        rootPanel.setPreferredSize(new Dimension(500,800));
        rootPanel.setBackground(purple);

        setUpSpinner();
        setUpList();
        taskLabel.setForeground(Color.WHITE);

        //button setup:
        randNumGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get random number from API...
                JOptionPane.showMessageDialog(rootPanel, "Not implemented! \nHave a nonrandom number instead: 14");
            }
        });

        enterTask.addActionListener(new ActionListener(){ //works on 'enter'
            @Override
            public void actionPerformed(ActionEvent e) {
                tasks.add(inputTask.getText());
                JOptionPane.showMessageDialog(rootPanel, tasks.toString());
                inputTask.setText(null);
                //then update JList
                setUpList();

            }
        });
    }

    /**
     * Set up task list
     * Simple version - TODO implement changeable version, saving, action listeners etc
     */
    private void setUpList(){
        String[] taskList = new String[tasks.size()];
        for(int i = 0; i < tasks.size(); i++) {
            taskList[i] = tasks.elementAt(i);
        }

        ListModel<String> taskModel = new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return taskList.length;
            }

            @Override
            public String getElementAt(int index) {
                return taskList[index];
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
