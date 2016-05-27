import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabContainer 
{
	private Panel _AddPanel ;
	private JPanel _TestPanel;
	private JPanel _AdminPanel;
	JTabbedPane _TabContainer;
	private JPanel _ResultPanel;
	public JTabbedPane GetTabContainer()
	{

		return _TabContainer;
	}
	public JPanel GetTestPanel()
	{

		return _TestPanel;
	}
	public JPanel GetResultPanel()
	{

		return _ResultPanel;
	}
	public JPanel GetAdminPanel()
	{

		return _AdminPanel;
	}
	
	public Panel GetAddPanel()
	{

		return _AddPanel;
	}
	
	
	public void AddTabs(JFrame testAppForm)
	{

		testAppForm.getContentPane().removeAll();
		//Create tab container
		 _TabContainer = new JTabbedPane(JTabbedPane.TOP);
		_TabContainer.setBounds(10, 11, 850, 544);
		testAppForm.getContentPane().add(_TabContainer);
		
		//Create the tabs
		_TestPanel = new JPanel();
		_TabContainer.addTab("Test", null, _TestPanel, null);
		_TestPanel.setLayout(null);
		
		_ResultPanel = new JPanel();
		_ResultPanel.setFocusable(true);
		_TabContainer.addTab("Test Result", null, _ResultPanel, null);
		_ResultPanel.setLayout(null);
		
		 _AdminPanel = new JPanel();
		 _AdminPanel.setFocusable(true);
		_TabContainer.addTab("Admin", null, _AdminPanel, null);
		_AdminPanel.setLayout(null);
		
		//Add panel to admin tab
		 _AddPanel = new Panel();
		 _AddPanel.setBounds(10, 10, 825, 496);
		 _AdminPanel.add(_AddPanel);		  
		  _AddPanel.setLayout(null);		  
		
	}

}
