// DBConn.java
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;

public class DBConn {
  static Connection con;
  public static Connection getConn() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sbb4_todo", "root", "");
    } catch(Exception e) {
      e.printStackTrace();
    }
    return con;
  }
}