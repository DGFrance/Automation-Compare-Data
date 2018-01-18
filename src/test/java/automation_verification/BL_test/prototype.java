package automation_verification.BL_test;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import automation_verification.BL_test.Bl_Class;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

public class prototype {

		public static Test suite() {
			return new TestSuite(prototype.class);
		}

		/**
		 * 
		 * 
		 * @throws AWTException
		 * @throws InterruptedException
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		public void testApp() throws AWTException, InterruptedException, ClassNotFoundException, SQLException {

			// selenium method
			WebDriver driver = new FirefoxDriver();
			// Robot robot = new Robot();
			driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

			driver.findElement(By.id("TRX_ID_UI"));// .sendKeys(BL_Class.TRX_ID);
			// get value from id
			WebElement d = driver.findElement(By.id("identifierId"));
			System.out.println("getText() " + d.getText());
			System.out.println("getAttribute() " + d.getAttribute("value"));
			Thread.sleep(2000);

			driver.findElement(By.id("ADDRESS_SHIP_UI"));// .sendKeys(BL_Class.ADDRESS_SHIP);
			// get value from id
			WebElement o = driver.findElement(By.id("identifierId"));
			System.out.println("getText() " + o.getText());
			System.out.println("getAttribute() " + o.getAttribute("value"));
			Thread.sleep(2000);

			driver.findElement(By.id("DATE_ORDER_UI"));// .sendKeys(BL_Class.DATE_ORDER);
			// get value from id
			WebElement n = driver.findElement(By.id("identifierId"));
			System.out.println("getText() " + n.getText());
			System.out.println("getAttribute() " + n.getAttribute("value"));
			Thread.sleep(2000);

			driver.findElement(By.id("SELLER_NAME_UI"));// .sendKeys(BL_Class.SELLER_NAME);
			// get value from id
			WebElement p = driver.findElement(By.id("identifierId"));
			System.out.println("getText() " + p.getText());
			System.out.println("getAttribute() " + p.getAttribute("value"));
			Thread.sleep(2000);

			driver.findElement(By.id("DELIVERY_SERVICE_UI"));// .sendKeys(BL_Class.DELIVERY_SERVICE);
			// get value from id
			WebElement aw = driver.findElement(By.id("identifierId"));
			System.out.println("getText() " + aw.getText());
			System.out.println("getAttribute() " + aw.getAttribute("value"));

			Thread.sleep(2000);
			// Database Connection
			Connection con = null;
			Statement stmt = null;
			Class.forName("org.postgresql.Driver");
			System.out.println("Connection to a selected Database");
			con = DriverManager.getConnection(Bl_Class.DB_URL2, Bl_Class.UserName, Bl_Class.Password);
			System.out.println("Conected database Successfully....");
			System.out.println("Creating Statement...");
			stmt = con.createStatement();

			// select data form database
			ResultSet rs = stmt.executeQuery(Bl_Class.sql);

			while (rs.next()) {
				// Compare the data form UI and Database
				String id = rs.getString("TRX_ID");
				Assert.assertEquals(id, d.getAttribute("value"));
				String address = rs.getString("ADDRESS_SHIP_UI");
				Assert.assertEquals(address, o.getAttribute("value"));
				String date_order = rs.getString("DATE_ORDER");
				Assert.assertEquals(date_order, n.getAttribute("value"));
				String seller_name = rs.getString("SELLER_NAME");
				Assert.assertEquals(seller_name, p.getAttribute("value"));
				String delivery = rs.getString("DELIVERY_SERVICE");
				Assert.assertEquals(delivery, aw.getAttribute("value"));

			}
			rs.close();

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
			System.out.println("All of the list already displayed");

		}

	}