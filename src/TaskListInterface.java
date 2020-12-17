import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author Amber Shore
 * @version 2020.12.17
 */
public class TaskListInterface {
    private JPanel rootPanel;
    private JList list1;
    private JSpinner listSpinner;
    private JButton randNumGen;
    private JTextField inputTask;
    private JButton enterTaskButton;
    private JLabel taskLabel;
    private JButton deleteButton;
    private JLabel spinnerLabel;
    private final Color purple = new Color(47, 1, 90);

    Vector<String> tasks = new Vector<String>();




    /**
     * Constructor
     */
    public TaskListInterface(){
        //properties:
        rootPanel.setPreferredSize(new Dimension(500,800));
        rootPanel.setBackground(purple);

        //setUpSpinner(); don't do til action, can't use empty list. TODO: Or try catch?
        setUpList();
        taskLabel.setForeground(Color.WHITE);
        spinnerLabel.setForeground(Color.WHITE);

        //button setup:
        randNumGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get random number from API...
                JOptionPane.showMessageDialog(rootPanel, "Not implemented! \nHave a nonrandom number instead: 14");
            }
        });

        enterTaskButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tasks.add(inputTask.getText());
                inputTask.setText(null);
                //then update JList
                setUpList();
                setUpSpinner();

            }
        });

        deleteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO mostly implemented, but leaves last task in spinner even when deleted

                if (tasks.contains(listSpinner.getValue())){
                    tasks.remove(listSpinner.getValue());
                    setUpList();
                    setUpSpinner();
                }
            }
        });
    }

    /**
     * Set up task list
     * Simple version
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
        String[] taskList = new String[tasks.size()];
        for(int i = 0; i < tasks.size(); i++) {
            taskList[i] = tasks.elementAt(i);
        }
        try {
            SpinnerModel taskSpinner = new SpinnerListModel(taskList);
            listSpinner.setModel(taskSpinner);
        }
        catch (Exception e){
            String[] emptyList = {" "};
            SpinnerModel emptySpinner = new SpinnerListModel(emptyList);
            listSpinner.setModel(emptySpinner);
        }


    }

    /**
     * Returns the panel containing the components.
     * @return rootPanel
     */
    public JPanel getRootPanel () { return rootPanel; }


}
