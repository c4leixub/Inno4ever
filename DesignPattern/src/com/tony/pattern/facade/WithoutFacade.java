package com.tony.pattern.facade;

import java.sql.Connection;

public class WithoutFacade {
	 
    public static void main(String[] args) {
        String tableName="Employee";
         
        //generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);
         
        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);
         
        //generating MySql HTML report and Oracle PDF report using Facade
        DBFacade.generateReport(DBFacade.DBTypes.MYSQL, DBFacade.ReportTypes.HTML, tableName);
        DBFacade.generateReport(DBFacade.DBTypes.ORACLE, DBFacade.ReportTypes.PDF, tableName);
    }
 
}

//As you can see that using Facade interface is a lot easier and cleaner way and avoid having a lot of logic at client side. JDBC Driver Manager class to get the database connection is a wonderful example of facade pattern.

