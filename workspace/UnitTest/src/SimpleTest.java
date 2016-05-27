import java.util.ArrayList;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import PhysicalDBLayer.ScrumCertificateDatabase;
import PhysicalDBLayer.ScrumCertificateRecord;
import PhysicalDBLayer.databaseConsts;
import junit.framework.Assert;

import org.testng.annotations.Test;

public class SimpleTest {

	@Test()
	public void testEmailGenerator() 
	{

		ScrumCertificateDatabase obj = new ScrumCertificateDatabase();
		databaseConsts consts=new databaseConsts();
		consts.DatabaseName="Scrum";
		consts.PortNumber=1433;
		consts.ServerName="localhost";
		obj.SetDBConstantst(consts);
		
		obj.SetDBConstantst(consts);
		ArrayList<ScrumCertificateRecord> rec=obj.GetList();
	
		// String email = obj.generate();

		 //Assert.assertNotNull(rec);
		 Assert.assertEquals(27,rec.size());

	}

}

