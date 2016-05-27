package theredSQL;

import java.util.ArrayList;

public class ScrumTest 
{

	public static void main(String[] args) 
	{
		database db=new database();
//		ArrayList<Record> recs=db.GetList();
//		for(int i=0;i<recs.size();++i)
//		{
//			Record rec=recs.get(i);
//			
//			System.out.println("question is: " + rec.Question);
//			System.out.println("Answer1 is: " + rec.Answer1);
//			System.out.println("Answer2 is: " + rec.Answer2);
//			System.out.println("Answer3 is: " + rec.Answer3);
//			System.out.println("Answer4 is: " + rec.Answer4);
//			System.out.println("Right answer is: " + rec.RightAnswer);
//			
//			
//		}
			Record  rec=new Record();
			rec.Question="Question number x";
			rec.Answer1="Answer number 1";
			rec.Answer2="Answer number 2";
			rec.Answer3="Answer number 3";
			rec.Answer4="Answer number 4";
			rec.RightAnswer=3;
			int y=db.AddRecord(rec);
			}
		

}
