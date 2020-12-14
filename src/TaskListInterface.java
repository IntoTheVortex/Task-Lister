import javax.swing.*;
import java.awt.*;
import java.util.Collections;

/**
 * @author Amber Shore
 * @version 2020.12.14
 */
public class TaskListInterface {
    private JPanel rootPanel;
    private JList list1;
    private JSpinner spinner1;




    /**
     * Constructor
     */
    public TaskListInterface(){
        rootPanel.setPreferredSize(new Dimension(500,800));

        setUpSpinner();

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
