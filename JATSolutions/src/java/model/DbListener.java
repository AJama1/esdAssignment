package controller;

public class DbListener {
    private Connection connection = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String db = sc.getInitParameter("xyz_assoc");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/" + db.trim(), "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            sc.setAttribute("error", e);
        }
        sc.setAttribute("connection", connection);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }
}



}
