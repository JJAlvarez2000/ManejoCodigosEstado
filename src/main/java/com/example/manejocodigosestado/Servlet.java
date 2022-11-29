package com.example.manejocodigosestado;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Simulamos los valores correctos, si el cliente responde de esta manera lo hizo
        // de forma correcta
        String usuarioOk = "Julio";
        String passwordOk = "123";

        // Obtenemos los valores que nos envió el cliente
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        // Si los valores son correctos, se lo enviamos al cliente
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.println("<h1>Bienvenido " + usuario + "</h1>");
        } else {
            // Si los valores son incorrectos, enviamos un código de estado unauthorized (401)
            response.sendError(response.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }
        out.close();
    }

    public void destroy() {
    }
}