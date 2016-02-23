package nr.co.ahmedeid.pos.notification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.BlockingQueue;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.QueryChangeDescription;
import oracle.jdbc.dcn.RowChangeDescription;

public class OrdersBasketListener implements DatabaseChangeListener
{
	private OracleConnection conn;
	private BlockingQueue<Long> orders;

	public OrdersBasketListener(BlockingQueue<Long> orders, OracleConnection conn) {
		this.orders = orders;
		this.conn = conn;
	}

	@Override
	public void onDatabaseChangeNotification(DatabaseChangeEvent event) {
	 try{
		 QueryChangeDescription[] qcds = event.getQueryChangeDescription();
		 QueryChangeDescription qcd = qcds[0];
		 RowChangeDescription[] rcds = qcd.getTableChangeDescription()[0].getRowChangeDescription();
		 RowChangeDescription rcd = rcds[0];
		 PreparedStatement ps = conn.prepareStatement("SELECT ORDER_ID FROM ORDER_BASKET WHERE ROWID = ?");
		 ps.setRowId(1, rcd.getRowid());
		 ResultSet rs = ps.executeQuery();
		 rs.next();
		 Long orderId = rs.getLong("ORDER_ID");
		 orders.put(orderId);
	   }catch(Exception ex)
	   {
		 ex.printStackTrace();
	   }
	}

}
