/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab_01.controller;

import com.Lab_01.DAO.VentaFacadeLocal;
import com.Lab_01.modelo.Venta;
import com.Lab_01.modelo.VentaPK;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario
 */
@WebServlet(name = "VentasServlet", urlPatterns = {"/VentasServlet"})
public class VentasServlet extends HttpServlet {
    
    @EJB 
    private VentaFacadeLocal ventaFacade;

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
        
        String action = request.getParameter("action");
        Venta venta = null;
        String nCompra = request.getParameter("ncompra");
        String clienteIdStr = request.getParameter("Cliente");
        int clienteId = 0;
        if (clienteIdStr != null && !clienteIdStr.equals("")) {
            clienteId = Integer.parseInt(clienteIdStr);
        }
        String matriculaStr = request.getParameter("Vehiculo");
        int matricula = 0;
        if (matriculaStr != null && !matriculaStr.equals("")) {
            matricula = Integer.parseInt(matriculaStr);
        }
        String fecha = request.getParameter("fecha");
        
        venta = new Venta(matricula, clienteId, fecha);
        
        if ("Agregar".equalsIgnoreCase(action)) {
            ventaFacade.create(venta);
            ventaFacade.clear();

        } else if ("Editar".equalsIgnoreCase(action)) {
            ventaFacade.edit(venta);

        } else if ("Eliminar".equalsIgnoreCase(action)) {
            ventaFacade.remove(venta);

        } else if ("Buscar".equalsIgnoreCase(action)) {
            venta = ventaFacade.find(venta);
        }
        
        request.setAttribute("venta", venta);
        request.setAttribute("allClientes", ventaFacade.findAll());
        request.getRequestDispatcher("Ventas.jsp").forward(request, response);
        
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
