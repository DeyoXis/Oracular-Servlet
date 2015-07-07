/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author info206
 */
public class OracularServlet extends HttpServlet {
    private String mensagem;
    
    public void init (ServletConfig config) throws ServletException {
        super.init( config );
    }
    
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //envia a página de formulário
        response.sendRedirect("form1.html");
    }
    
    public void dePost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recupera campos do form que vieram no request
        String nome = request.getParameter("nome");
        String ano = request.getParameter("ano");
        
        //trata campos
        if ( nome == null || ano == null || nome.trim().equals("") || ano.trim().equals("")) {
            response.sendRedirect("form1.html");
        }
        else {
            try {
                String mensagem = nome+"!";
                int ano2 = Integer.parseInt( ano );
                int idade = new Date().getYear() + 1900 - ano2;
        if ( idade < 25 ) {
            mensagem += "A juventude é Linda!";
        }
        else if ( idade <45 ) {
            mensagem += "A maturidade é Linda!";
        }
        else {
            mensagem += "A Velhice é Linda!";
        }
            processaRetorno( request, response, mensagem);
            }catch (NumberFormatException e) {
                e.printStackTrace();
                processaErro (request, response, e);
            }
        }
    }
    
    public void processaRetorno (HttpServletRequest request, HttpServletResponse response, String Mensagem) throws ServletException, IOException {
        
        //formata a saída da página de resultado 
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<Title>Resutado - OracularServlet</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\"\">");
        out.println("<b> Mensgem: "+mensagem+" </b>");
        out.println("</body>");
        out.println("</html>");
    }
    
    public void processaErro (HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
        
        //formata a saída da página de resultado
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<Title>Erro - OracularServlet</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\"\">");
        out.println("<pre>");
        out.println( e );
        out.println("</pre>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OracularServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OracularServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

}
