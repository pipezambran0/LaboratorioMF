/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.entity.Estudiante;
import lab.session.EstudianteFacadeLocal;

/**
 *
 * @author ifzs
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    
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
        String codEst = request.getParameter("codEstudiante");
        int codEstudiante = 0;
        if(codEst!=null && !codEst.equals("")){
            codEstudiante = Integer.parseInt(codEst);
        } 
        String nombreEstudiante = request.getParameter("nombreEstudiante");
        String apellidoEstudiante = request.getParameter("apellidoEstudiante");
        String semestreEst = request.getParameter("semestreEstudiante");
        int semestreEstudiante=Integer.parseInt(semestreEst);
        
        String action = request.getParameter("action");
        
        Estudiante student = new Estudiante(codEstudiante,nombreEstudiante,apellidoEstudiante,semestreEstudiante);
        
        if("Add".equalsIgnoreCase(action)){
            estudianteFacade.create(student);
        }else if("Edit".equalsIgnoreCase(action)){
            estudianteFacade.edit(student);
        }else if("Delete".equalsIgnoreCase(action)){
            estudianteFacade.remove(student);
        }else if("Search".equalsIgnoreCase(action)){
            //estudianteFacade.find(student.getCodEstudiante());
            student = estudianteFacade.find(codEstudiante);
        }
        
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("student", student);
        request.setAttribute("allStudents", estudianteFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward (request,response);
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
