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
import lab.entity.Curso;
import lab.session.CursoFacadeLocal;

/**
 *
 * @author ifzs
 */
@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;
    
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
        String codCur = request.getParameter("codCurso");
        int codCurso = 0;
        if(codCur!=null && !codCur.equals("")){
            codCurso = Integer.parseInt(codCur);
        } 
        String nombreCurso = request.getParameter("nombreCurso");
        String semestreCur = request.getParameter("semestreCurso");
        int semestreCurso = Integer.parseInt(semestreCur);
        String numCreCur = request.getParameter("numCreditosCurso");
        int numCreditosCurso = Integer.parseInt(numCreCur);
        String numEstAdmCur = request.getParameter("numEstudAdmitidosCurso");
        int numEstudAdmitidosCurso=Integer.parseInt(numEstAdmCur);
        
        String action = request.getParameter("action");
        
        Curso course = new Curso(codCurso,nombreCurso,numCreditosCurso,semestreCurso,numEstudAdmitidosCurso);
        
        if("Add".equalsIgnoreCase(action)){
            cursoFacade.create(course);
        }else if("Edit".equalsIgnoreCase(action)){
            cursoFacade.edit(course);
        }else if("Delete".equalsIgnoreCase(action)){
            cursoFacade.remove(course);
        }else if("Search".equalsIgnoreCase(action)){
            //cursoFacade.find(course.getCodCurso());
            course = cursoFacade.find(codCurso);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("course", course);
        request.setAttribute("allCourses", cursoFacade.findAll());
        request.getRequestDispatcher("courseInfo.jsp").forward (request,response);
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
