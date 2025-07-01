package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //Taking excel file from testdata		
		ExcelUtility xlUtil= new ExcelUtility(path);
		
		int totalrows=xlUtil.getRowCount("Sheet1");
		int totalcols=xlUtil.getCellCount("Sheet1",1);
		
		String LoginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				LoginData[i-1][j]=xlUtil.getCellData("Sheet1",i,j);
			}
		}
		return LoginData;
		
		
		
	}

}
