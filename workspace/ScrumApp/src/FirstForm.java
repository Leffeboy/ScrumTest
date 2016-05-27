import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import PhysicalDBLayer.ScrumCertificateDatabase;
import PhysicalDBLayer.databaseConsts;

import javax.swing.JMenuItem;

public class FirstForm {

	private JMenuBar menuBar;
	private JFrame _TestAppForm;
	private ScrumCertificateDatabase _ScrumCertificateDatabase=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstForm window = new FirstForm();
					
					window._TestAppForm.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() 
	{

		_TestAppForm = new JFrame();
		_TestAppForm.setTitle("Scrum Self Study");
		_TestAppForm.setBounds(200, 200, 886, 625);
		_TestAppForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_TestAppForm.getContentPane().setLayout(null);
		//menu bar
		menuBar= new JMenuBar();
		_TestAppForm.setJMenuBar(menuBar);
		JMenu Test=new JMenu("Test Type");
		menuBar.add(Test);
		
		JMenu mnNewMenu = new JMenu("Scrum");
		Test.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Certificate");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 _ScrumCertificateDatabase= new ScrumCertificateDatabase();
				databaseConsts consts=new databaseConsts();
				_ScrumCertificateDatabase.SetDBConstantst(consts);
				//ds.setServerName("localhost");
				//ds.setPortNumber(1433); 

				consts.DatabaseName="Scrum";
				consts.PortNumber=1433;
				consts.ServerName="localhost";
				ScrumCertificateForm frm=new ScrumCertificateForm();
				frm.InitCertificateGUI(_TestAppForm,_ScrumCertificateDatabase);

			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Agile Coach");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 _ScrumCertificateDatabase= new ScrumCertificateDatabase();
					databaseConsts consts=new databaseConsts();
					consts.DatabaseName="AgileCoach";
					consts.PortNumber=1433;
					consts.ServerName="localhost";
					
					_ScrumCertificateDatabase.SetDBConstantst(consts);
					TabContainer con=new TabContainer();
					con.AddTabs(_TestAppForm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		//move to agile coach form
		


	}
}
