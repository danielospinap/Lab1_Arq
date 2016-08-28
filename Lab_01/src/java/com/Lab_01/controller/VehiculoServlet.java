/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab_01.controller;

import com.Lab_01.DAO.AutosFacadeLocal;
import com.Lab_01.modelo.Autos;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Mario
 */
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100,      // 100 MB
                 location="/")
public class VehiculoServlet extends HttpServlet {

    @EJB
    private AutosFacadeLocal autosFacade;

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

        byte[] foto = null;
        Autos auto = null;
        String action = request.getParameter("action");
        String matriculaStr = request.getParameter("Matricula");
        int matricula = 0;
        if (matriculaStr != null && !matriculaStr.equals("")) {
            matricula = Integer.parseInt(matriculaStr);
        }
        String name = request.getParameter("nombre");
        String modeloStr = request.getParameter("modelo");
        int modelo = 0;
        if (modeloStr != null && !modeloStr.equals("")) {
            modelo = Integer.parseInt(modeloStr);
        }
        String color = request.getParameter("color");
        String costoStr = request.getParameter("costo");
        int costo = 0;
        if (costoStr != null && !costoStr.equals("")) {
            costo = Integer.parseInt(costoStr);
        }

        if (request.getMethod().equals("POST")) {
            Part _foto = request.getPart("imagen");

            // Verify _foto is not null
            if (_foto != null && _foto.getSize() != 0) {
                // Read bytes from _foto
                try (InputStream is = _foto.getInputStream()) {
                    foto = new byte[is.available()];
                    is.read(foto);
                    is.close();
                }
                auto = new Autos(matricula, name, modelo, color, costo, foto);
            } else {
                foto = null;
                auto = new Autos(matricula, name, modelo, color, costo, foto);
            }

            if ("Agregar".equalsIgnoreCase(action)) {
                autosFacade.create(auto);

            } else if ("Editar".equalsIgnoreCase(action)) {
                autosFacade.edit(auto);

            } else if ("Eliminar".equalsIgnoreCase(action)) {
                autosFacade.remove(auto);

            } else if ("Buscar".equalsIgnoreCase(action)) {
                auto = autosFacade.find(auto);
            }
        }
        request.setAttribute("vehiculo", auto);
        request.setAttribute("allVehiculos", autosFacade.findAll());
        request.getRequestDispatcher("Veiculo.jsp").forward(request, response);

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
