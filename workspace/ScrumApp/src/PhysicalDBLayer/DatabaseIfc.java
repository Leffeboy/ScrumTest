package PhysicalDBLayer;

import java.util.ArrayList;

public interface DatabaseIfc
{
	public ArrayList<ScrumCertificateRecord> GetList();
	public int AddRecord(ScrumCertificateRecord record);
	public void SetDBConstantst(databaseConsts dbConsts);
	

};

