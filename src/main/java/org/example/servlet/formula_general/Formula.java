package org.example.servlet.formula_general;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//path o llave para poder enlazar servlet
@WebServlet("/servletParametros")


//Formula general
//x12:-b +- elevado:/b2-4ac
// 2ac
public class Formula extends HttpServlet {
    public double resultado1;
    public double resultado2;
    public String mensajeError;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        double c = Double.parseDouble(req.getParameter("c"));

        // calcular los resultados de la formula general por metodo
        FormulaGeneral(a, b, c);

        // Respuesta HTML
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Resultados</title>");
        out.println("</head>");
        out.println("<body>");

        // Condicional
        if (mensajeError != null) {
            out.println("<h1>Error</h1>");
            out.println("<p>" + mensajeError + "</p>");
        } else {
            out.println("<h1>Resultado de la fórmula general</h1>");
            out.println("<p>Para los valores de 'a', 'b' y 'c' dados:</p>");
            out.println("<p>a = " + a + "</p>");
            out.println("<p>b = " + b + "</p>");
            out.println("<p>c = " + c + "</p>");
            out.println("<p>Resultado 1: " + resultado1 + "</p>");
            out.println("<p>Resultado 2: " + resultado2 + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    public void FormulaGeneral(double a, double b, double c) {
        mensajeError = null;
        double discriminante = b * b - 4 * a * c;
        if(a == 0 || discriminante == 0){
            mensajeError = "Error 404";
        }
        else
        {
            resultado1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            resultado2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        }


    }

}
