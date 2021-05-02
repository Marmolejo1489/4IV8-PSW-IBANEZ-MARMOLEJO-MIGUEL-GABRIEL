import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.servlet.ServletConfig;

public class Registro extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException{
        String URL = "jdbc:mysql://localhost/heroku_240a23234b292ea";
        String userName = "root";
        String password = "=/U_x12%aX";
                
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexión exitosa");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexión no exitosa");
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name, size, recipiente, tipo, ip, iph;
            int price, gram, puerto, puertoh;
            
            name = request.getParameter("name");
            price = Integer.parseInt(request.getParameter("price"));
            gram = Integer.parseInt(request.getParameter("gram"));
            size = request.getParameter("size");
            recipiente = request.getParameter("recipiente");
            tipo = request.getParameter("tipo");
            
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            iph = request.getRemoteAddr();
            puertoh = request.getRemotePort();
            
            try{
                String q = "insert into Mregistro (name_hel, price_hel, gram_hel, size_hel, recipiente_hel, tipo_hel) values ('"+name+"', '"+price+"', '"+gram+"', "+size+", '"+recipiente+"', '"+tipo+"')";
                set.executeUpdate(q);
                System.out.println("¡Registro exitoso!");
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registro</title>");
                out.println("<link rel=\"stylesheet\" href=\"./CSS/estilo2.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 class=\"title\">¡Registro exitoso!</h1>");
                out.println("<br>");
                out.println("<table class=\"tabla\" border='2'>"
                    + "<thead>"
                        + "<th>Nombre del helado</th>"
                        + "<th>Edad</th>"
                        + "<th>Email</th></tr>"
                    + "</thead>");
                out.println("<tbody>"
                            + "<td>"+name+"</td>"
                            + "<td>"+price+"</td>"
                            + "<td>"+gram+"</td></tr>"
                            + "<td>"+size+"</td>"
                            + "<td>"+recipiente+"</td>"
                            + "<td>"+tipo+"</td></tr>"
                            + "</tbody>");
                out.println("</table>");
                out.println("<a class=\"link1\" href='administra_helados.html'>Regresar al módulo de administrador.</a>");
                out.println("<br>");
                out.println("<a class=\"link2\" href='Consultar'>Consultar la tabla de helados.</a>");
                out.println("</body>");
                out.println("</html>");
            
            }catch(SQLException e){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Administrar | Ben & Jerry's</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registro no exitoso. Intente de nuevo.</h1>" + "<a href='administrar_helado.html'>Regresar al módulo de administrador.</a>");
                out.println("</body>");
                out.println("</html>");
                
                System.out.println("No se registró en la tabla");
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    //hace falta un destructor, el destructor libera las conexiones y la memoria de las variables
    
    @Override
    public void destroy(){
        try{
            con.close();
        }catch(SQLException e){
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
