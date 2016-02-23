package nr.co.ahmedeid.pos.notification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.OraclePreparedStatement;

public class OrdersBasketNotification {
	
	@Autowired 
    private DataSource dataSource;
	
	private String username;
	
	private BlockingQueue<Long> orders;
	
	public OrdersBasketNotification(String username) throws SQLException
	{
		this.username = username;
		initialize();
	}
	
	private void initialize() throws SQLException
	{
		OracleConnection conn = (OracleConnection) dataSource.getConnection();
		Properties prop = new Properties();
		prop.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS,"true");
		prop.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION,"true");
		DatabaseChangeRegistration dcr = conn.registerDatabaseChangeNotification(prop);
		orders = new ArrayBlockingQueue<Long>(100);
		OrdersBasketListener listener = new OrdersBasketListener(orders, conn);
		dcr.addListener(listener);
		String query = "SELECT OB_ID FROM ORDER_BASKET WHERE USERNAME = ? AND READ_FLAG IS NULL";
		OraclePreparedStatement opstmt = (OraclePreparedStatement) conn.prepareStatement(query);
		opstmt.setString(1, username);
		opstmt.setDatabaseChangeRegistration(dcr);
		ResultSet rs = opstmt.executeQuery();
	    while (rs.next())
	    {}
	    rs.close();
	    opstmt.close();  
	}
	
	public Long getLastOrder() throws InterruptedException
	{
		return orders.poll(10, TimeUnit.MINUTES);
	}

}
