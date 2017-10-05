
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author ashraf
 *
 */
public class View {

	public View() {
		// Create views swing UI components 
		JTextField searchTermTextField = new JTextField(26);
		JButton filterButton = new JButton("Search");
		JTable table = new JTable();

		// Create table model
		Model model = new Model();
		table.setModel(model);

		// Create controller
		Controller controller = new Controller(searchTermTextField, model);
		filterButton.addActionListener(controller);

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(searchTermTextField);
		ctrlPane.add(filterButton);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "My Collection 1",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("L-English demo v1.0");
//                                frame.setSize(5000, 5000);
//                                frame.setPreferredSize(new Dimension(1000, 1000));
//                                frame.setMinimumSize(new Dimension(1000, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                                JTabbedPane tabbedPane = new JTabbedPane();
                                JPanel tab1 = new JPanel();
                                tab1.add(new JButton("Tùy chọn 1"));
                                tab1.add(new JButton("Tùy chọn 2"));
                                tab1.add(new JButton("Tùy chọn 3"));
                                
                                JPanel tab2 = new JPanel();
                                tab2.add(new JTextField("TextField", 20));
                                
                                JPanel tab3 = new JPanel();
                                tab3.add(splitPane);
                                
                                tabbedPane.add("Tất cả",tab3);
                                tabbedPane.add("Thêm từ",tab2);
                                tabbedPane.add("Tùy chọn",tab1);
		frame.add(tabbedPane);
//                                frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
