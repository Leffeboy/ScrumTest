import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import PhysicalDBLayer.ScrumCertificateDatabase;
import PhysicalDBLayer.ScrumCertificateRecord;

public class ScrumCertificateForm 
{
	
	private JTextField _Question;
	private JTextField txtQuestion;
	private JTextField txtAnswer;
	private JTextField txtAnswer_1;
	private JTextField txtAnswer_2;
	private JTextField txtAnswer_3;
	private JTextField txtAnswer_4;
	private JTextField Answer1;
	private JTextField Answer2;
	private JTextField Answer3;
	private JTextField Answer4;
	private JTextField RightAnswer;
	

	private JTextArea  _TestQuestion;
	
	private JTextField _NrOfQuestions;
	private JTextField txtQuestions;
	private JTextField txtRightAnswer;
	private JTextField _NrOfRightAnswers;
	ArrayList<ScrumCertificateRecord> _Records=null;
	private JTextField txtTestOngoing;
	private int _CurrentQuestion=0;
	JRadioButton RB_Answer1;
	JRadioButton RB_Answer2;
	JRadioButton RB_Answer3;
	JRadioButton RB_Answer4;
	ButtonGroup _RadioBtnGroup;
	JButton btnStart;
	JButton btnFinish;
	
	private JTextField txtProcentage;
	private JTextField _Presentage;
	private ScrumCertificateDatabase _ScrumCertificateDatabase=null;
	
	public int  Ask(int nr)
	{
		_TestQuestion.setText("");
		RB_Answer1.setText("");
		RB_Answer2.setText("");
		RB_Answer3.setText("");
		RB_Answer4.setText("");
		UnselectRadioBtns();
	
		if(_Records.size() <= nr)
		{
			return -1;
		}
		_TestQuestion.setText(_Records.get(nr).Question);
		Collections.shuffle(_Records.get(nr)._Answers);
		RB_Answer1.setText(_Records.get(nr)._Answers.get(0));
		RB_Answer2.setText(_Records.get(nr)._Answers.get(1));
		RB_Answer3.setText(_Records.get(nr)._Answers.get(2));
		RB_Answer4.setText(_Records.get(nr)._Answers.get(3));
		return 0;
	}
	void ShowQuestions(boolean b)
	{
		_TestQuestion.setVisible(b);
		RB_Answer1.setVisible(b);
		RB_Answer2.setVisible(b);
		RB_Answer3.setVisible(b);
		RB_Answer4.setVisible(b);
	}
	void ShowResults(boolean b)
	{
		txtQuestions.setVisible(b);
		txtRightAnswer.setVisible(b);
		_NrOfQuestions.setVisible(b);
		_NrOfRightAnswers.setVisible(b);
		txtProcentage.setVisible(b);
		_Presentage.setVisible(b);
	}
	void UnselectRadioBtns()
	{
		_RadioBtnGroup.clearSelection();
	}
	

	public void InitCertificateGUI(JFrame testAppForm,ScrumCertificateDatabase database)
	{
		 _ScrumCertificateDatabase=database;
		
//		frmScrumAdminidtrator.getContentPane().addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentHidden(ComponentEvent arg0) {
//			}
//		});
		 
		 TabContainer cont=new TabContainer();
		 cont.AddTabs(testAppForm);
		
		_TestQuestion = new JTextArea ();
		_TestQuestion.setBackground(SystemColor.text);
		_TestQuestion.setLineWrap(true);
		_TestQuestion.setEditable(false);
		_TestQuestion.setVisible(false);
		_TestQuestion.setBounds(34, 51, 779, 83);
		cont.GetTestPanel().add(_TestQuestion);
		_TestQuestion.setColumns(10);
		
		_RadioBtnGroup=new ButtonGroup();
		 RB_Answer1 = new JRadioButton("");
		RB_Answer1.setName("1");
		RB_Answer1.setVisible(false);
		RB_Answer1.setBounds(34, 141, 779, 73);
		cont.GetTestPanel().add(RB_Answer1);
		_RadioBtnGroup.add(RB_Answer1);
		
		 RB_Answer2 = new JRadioButton("");
		RB_Answer2.setName("2");
		RB_Answer2.setVisible(false);
		RB_Answer2.setBounds(33, 234, 779, 73);
		cont.GetTestPanel().add(RB_Answer2);
		_RadioBtnGroup.add(RB_Answer2);
		
		 RB_Answer3 = new JRadioButton("");
		RB_Answer3.setName("3");
		RB_Answer3.setVisible(false);
		RB_Answer3.setBounds(33, 327, 779, 73);
		cont.GetTestPanel().add(RB_Answer3);
		_RadioBtnGroup.add(RB_Answer3);
		
		 RB_Answer4 = new JRadioButton("");
		RB_Answer4.setName("4");
		RB_Answer4.setVisible(false);
		RB_Answer4.setBounds(33, 420, 779, 73);
		cont.GetTestPanel().add(RB_Answer4);
		_RadioBtnGroup.add(RB_Answer4);
		
		JButton btnNext = new JButton("Next Question");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		
				if(_ScrumCertificateDatabase==null)
				{
					JOptionPane.showMessageDialog(null,"Please select Test type fisrt!");
					return;
				}
				//int selectedAnswer=0;
				String selectedAnswer=null;
				for(int i=0;i<4;++i)
				{
					
					if(RB_Answer1.isSelected())
					{
						selectedAnswer=RB_Answer1.getText();
						break;
					}
					if(RB_Answer2.isSelected())
					{
						selectedAnswer=RB_Answer2.getText();
						break;
					}
					if(RB_Answer3.isSelected())
					{
						selectedAnswer=RB_Answer3.getText();
						break;
					}
					if(RB_Answer4.isSelected())
					{
						selectedAnswer=RB_Answer4.getText();
						break;
					}
						
					
				}
				if(selectedAnswer==null)
				{
					JOptionPane.showMessageDialog(null,"Please select an answer!");
					return;
					
				}
				
				//int right=_Records.get(_CurrentQuestion).RightAnswer;
				String right=_Records.get(_CurrentQuestion).Answer;
				int nrOfRightAns=0;
				if(right==selectedAnswer)
				{
					nrOfRightAns=Integer.parseInt(_NrOfRightAnswers.getText());
					nrOfRightAns++;
					_NrOfRightAnswers.setText(Integer.toString(nrOfRightAns));
				}
				
				int x=Integer.parseInt(_NrOfQuestions.getText());
				x++;
				_NrOfQuestions.setText(Integer.toString(x));
				
				double pre= 100.00* ((1.0*nrOfRightAns) / (1.0*x));
				
				_Presentage.setText(Integer.toString((int) pre));
				_CurrentQuestion++;
					if(Ask(_CurrentQuestion)==-1)
				{
					btnNext.setEnabled(false);
					ShowQuestions(false);
					_TestQuestion.setVisible(true);
					_TestQuestion.setText("THERE ARE NO MORE QUESTIONS!!!");
				}

					
					
			}

		});
		btnNext.setBounds(256, 11, 118, 23);
		cont.GetTestPanel().add(btnNext);

		 btnStart = new JButton("Start New Test");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(_ScrumCertificateDatabase==null)
				{
					JOptionPane.showMessageDialog(null,"Please select Test type fisrt!");
					return;
				}
				btnNext.setEnabled(true);
				btnFinish.setEnabled(true);
				txtTestOngoing.setVisible(true);
				ShowQuestions(true);
				txtTestOngoing.setText("Test Ongoing ...");
				btnStart.setEnabled(false);
				ShowResults(false);				
				

				_Records=_ScrumCertificateDatabase.GetList();
				
				Collections.shuffle(_Records);
				
				_CurrentQuestion=0;
				_NrOfQuestions.setText("0");
				_NrOfRightAnswers.setText("0");
				
				Ask(_CurrentQuestion);
				
			}
		});
		btnStart.setBounds(84, 11, 118, 23);
		cont.GetTestPanel().add(btnStart);
		
		 btnFinish = new JButton("Finish Test");
		 btnFinish.setEnabled(false);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ShowQuestions(false);
				btnFinish.setEnabled(false);
				btnStart.setEnabled(true);
				ShowResults(true);
				txtTestOngoing.setVisible(false);				
				cont.GetTabContainer().setSelectedIndex(1);	
						
			}
		});
		btnFinish.setBounds(428, 11, 118, 23);
		cont.GetTestPanel().add(btnFinish);
				
		_NrOfQuestions = new JTextField();
		_NrOfQuestions.setEditable(false);
		_NrOfQuestions.setVisible(false);
		_NrOfQuestions.setText("0");
		_NrOfQuestions.setBounds(180, 67, 86, 20);
		
		cont.GetResultPanel().add(_NrOfQuestions);
		_NrOfQuestions.setColumns(10);
		
		txtQuestions = new JTextField();
		txtQuestions.setVisible(false);
		txtQuestions.setEditable(false);
		txtQuestions.setText("Questions");
		txtQuestions.setColumns(10);
		txtQuestions.setBounds(50, 67, 86, 20);
		cont.GetResultPanel().add(txtQuestions);
		
		txtRightAnswer = new JTextField();
		txtRightAnswer.setVisible(false);
		txtRightAnswer.setEditable(false);
		txtRightAnswer.setText("Right Answers");
		txtRightAnswer.setColumns(10);
		txtRightAnswer.setBounds(50, 126, 86, 20);
		cont.GetResultPanel().add(txtRightAnswer);
		
		_NrOfRightAnswers = new JTextField();
		_NrOfRightAnswers.setEditable(false);
		_NrOfRightAnswers.setVisible(false);
		_NrOfRightAnswers.setText("0");
		_NrOfRightAnswers.setColumns(10);
		_NrOfRightAnswers.setBounds(180, 126, 86, 20);
		cont.GetResultPanel().add(_NrOfRightAnswers);
		
		txtTestOngoing = new JTextField();
		txtTestOngoing.setEditable(false);
		txtTestOngoing.setVisible(false);
		txtTestOngoing.setText("Test Ongoing ...");
		txtTestOngoing.setBounds(50, 22, 180, 20);
		cont.GetResultPanel().add(txtTestOngoing);
		txtTestOngoing.setColumns(10);
		
		txtProcentage = new JTextField();
		txtProcentage.setVisible(false);
		txtProcentage.setEditable(false);
		txtProcentage.setText("Precentage");
		txtProcentage.setBounds(50, 174, 86, 20);
		cont.GetResultPanel().add(txtProcentage);
		txtProcentage.setColumns(10);
		
		_Presentage = new JTextField();
		_Presentage.setVisible(false);
		_Presentage.setEditable(false);
		_Presentage.setBounds(180, 174, 86, 20);
		cont.GetResultPanel().add(_Presentage);
		_Presentage.setColumns(10);
		
	
		  String twoLines = "Add\n to DB";
		  
		  JButton btnMyButton = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
		  btnMyButton.setForeground(Color.BLACK);
		  btnMyButton.setHorizontalTextPosition(SwingConstants.CENTER);
		  btnMyButton.setBounds(630, 230, 109, 116);
		  
		  cont.GetAddPanel().add(btnMyButton);
		  
		  txtQuestion = new JTextField();
		  txtQuestion.setBounds(12, 11, 86, 20);
		  cont.GetAddPanel().add(txtQuestion);
		  txtQuestion.setEditable(false);
		  txtQuestion.setText("Question");
		  txtQuestion.setColumns(10);
		  
		  Answer1 = new JTextField();
		  Answer1.setBounds(108, 75, 495, 47);
		  cont.GetAddPanel().add(Answer1);
		  Answer1.setColumns(10);
		  
		  txtAnswer = new JTextField();
		  txtAnswer.setBounds(12, 75, 86, 20);
		  cont.GetAddPanel().add(txtAnswer);
		  txtAnswer.setText("Answer1");
		  txtAnswer.setEditable(false);
		  txtAnswer.setColumns(10);
		  
		  _Question = new JTextField();
		  _Question.setDragEnabled(true);
		  _Question.setBounds(108, 11, 495, 47);
		  cont.GetAddPanel().add(_Question);
		  _Question.setColumns(10);
		  
		  txtAnswer_1 = new JTextField();
		  txtAnswer_1.setBounds(12, 139, 86, 20);
		  cont.GetAddPanel().add(txtAnswer_1);
		  txtAnswer_1.setText("Answer2");
		  txtAnswer_1.setEditable(false);
		  txtAnswer_1.setColumns(10);
		  
		  Answer2 = new JTextField();
		  Answer2.setBounds(108, 139, 495, 47);
		  cont.GetAddPanel().add(Answer2);
		  Answer2.setColumns(10);
		  
		  txtAnswer_2 = new JTextField();
		  txtAnswer_2.setBounds(12, 203, 86, 20);
		  cont.GetAddPanel().add(txtAnswer_2);
		  txtAnswer_2.setText("Answer3");
		  txtAnswer_2.setEditable(false);
		  txtAnswer_2.setColumns(10);
		  
		  Answer3 = new JTextField();
		  Answer3.setBounds(108, 203, 495, 47);
		  cont.GetAddPanel().add(Answer3);
		  Answer3.setColumns(10);
		  
		  txtAnswer_3 = new JTextField();
		  txtAnswer_3.setBounds(12, 266, 86, 20);
		  cont.GetAddPanel().add(txtAnswer_3);
		  txtAnswer_3.setText("Answer4");
		  txtAnswer_3.setEditable(false);
		  txtAnswer_3.setColumns(10);
		  
		  Answer4 = new JTextField();
		  Answer4.setBounds(108, 266, 495, 47);
		  cont.GetAddPanel().add(Answer4);
		  Answer4.setColumns(10);
		  
		  txtAnswer_4 = new JTextField();
		  txtAnswer_4.setBounds(12, 323, 149, 23);
		  cont.GetAddPanel().add(txtAnswer_4);
		  txtAnswer_4.setText("Number Of Right Answer");
		  txtAnswer_4.setEditable(false);
		  txtAnswer_4.setColumns(10);
		  
		  RightAnswer = new JTextField();
		  RightAnswer.setBounds(171, 324, 86, 20);
		  cont.GetAddPanel().add(RightAnswer);
		  RightAnswer.setColumns(10);
		  btnMyButton.addActionListener(new ActionListener() 
		  {
		  	public void actionPerformed(ActionEvent arg0) 
		  	{
		  		//JOptionPane.showMessageDialog(null,Question.getText());
		  		
		  		ScrumCertificateRecord rd=new ScrumCertificateRecord();
		  		rd.Question=_Question.getText();

		  		rd._Answers.add(Answer1.getText());
		  		rd._Answers.add(Answer2.getText());
		  		rd._Answers.add(Answer3.getText());
		  		rd._Answers.add(Answer4.getText());
		  		rd.RightAnswer=Integer.parseInt(RightAnswer.getText().toString());
		  	
		  		_ScrumCertificateDatabase.AddRecord(rd);
		  		JOptionPane.showMessageDialog(null,"Record added!");
		  	}
		  });
	}
	

}
