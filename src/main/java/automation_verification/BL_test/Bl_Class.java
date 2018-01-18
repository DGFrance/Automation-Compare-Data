package automation_verification.BL_test;

public class Bl_Class {
	// Database Conection
		public static final String JDBC_DRIVER = "org.postgresql.Driver";
		public static final String DB_URL2 = "jdbc:postgresql://localhost:5432/transaction";
		public static final String UserName = "postgres";
		public static final String Password = "postgress";

		// User Data for Automation 
		public static final String TRX_ID = "01023A9AC";
		public static final String ADDRESS_SHIP = "JALAN GURNEY ";
		public static final String DATE_ORDER  = "21/08/2016";
		public static final String SELLER_NAME = "FURHAN";
		public static final String DELIVERY_SERVICE  = "REX";

		// SQL method
		public static final String sql = "SELECT * FROM public.user where id = 01023A9AC";
}
