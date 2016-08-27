/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab_01.controller;

import com.Lab_01.DAO.UsuariosFacadeLocal;
import com.Lab_01.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.hibernate.validator.internal.util.privilegedactions.ConstructorInstance.action;

/**
 *
 * @author Mario
 */
public class ClienteServlet extends HttpServlet {
    
    @EJB
    private UsuariosFacadeLocal usuariosFacade;

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

        Usuarios usuario = null;
        String clienteIdStr = request.getParameter("Identificacion");
        int clienteId = 0;
        if (clienteIdStr != null && !clienteIdStr.equals("")) {
            clienteId = Integer.parseInt(clienteIdStr);
        }
        String action = request.getParameter("action");
        String name = request.getParameter("Nombre");
        String apellido = request.getParameter("Apellidos");
        String correoElectronico = request.getParameter("Correo electronico");
        String telefonoStr = request.getParameter("Telefono");
        int telefono = 0;
        if (telefonoStr != null && !telefonoStr.equals("")) {
            telefono = Integer.parseInt(telefonoStr);
        }
        String direccion = request.getParameter("Direccion");

        usuario = new Usuarios(clienteId, name, apellido, correoElectronico, telefono, direccion);
        if ("Agregar".equalsIgnoreCase(action)) {
            usuariosFacade.create(usuario);
            //usuariosFacade.clear();

        } else if ("Editar".equalsIgnoreCase(action)) {
            usuariosFacade.edit(usuario);

        } else if ("Eliminar".equalsIgnoreCase(action)) {
            usuariosFacade.remove(usuario);

        } else if ("Buscar".equalsIgnoreCase(action)) {
            usuario = usuariosFacade.find(clienteId);
        }
        
        request.setAttribute("cliente", usuario);
        request.setAttribute("allClientes", usuariosFacade.findAll());
        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
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
