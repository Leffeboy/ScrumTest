package PhysicalDBLayer;

import java.util.ArrayList;

public class ScrumCertificateRecord 
{
	public ScrumCertificateRecord()
	{
		_Answers=new ArrayList<String>();
	}
	public String Question;
	public ArrayList<String> _Answers;
	public int RightAnswer;
	public String Answer;
}
