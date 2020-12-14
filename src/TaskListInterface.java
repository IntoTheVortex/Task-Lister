import javax.swing.*;
import java.awt.*;

/**
 * Created by Vortex on 12/14/2020.
 */
public class TaskListInterface {
    private JSpinner spinner1;
    private JPanel rootPanel;
    private JList list1;

    /**
     * Constructor
     */
    public TaskListInterface(){
        rootPanel.setPreferredSize(new Dimension(500,800));
    }


    /**
     * Returns the panel containing the components.
     * @return rootPanel
     */
    public JPanel getRootPanel () { return rootPanel; }
}
