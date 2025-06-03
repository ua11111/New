package TestingApp;

import org.testng.annotations.DataProvider;



public class DataPprovider {
	
	@DataProvider (name = "testdata")
	public Object[][] dpMethod()
	{
		String path=".\\TestData\\LoginData (1).xlsx";
		ExcelReader uexcel=new ExcelReader(path);
		int rowcount = uexcel.getRowCount("Sheet1");
		int colcount = uexcel.getColumnCount("Sheet1");
		
		String[][] data = new String[rowcount-1][colcount];
		
		for(int row=2;row<=rowcount;row++)
		{
			for(int col=0;col<colcount;col++)
				
			{
				data[row-2][col]=uexcel.getCellData("Sheet1", col, row);
				
			}
			
		}
		
		
		
		return data;
	}
	

}
