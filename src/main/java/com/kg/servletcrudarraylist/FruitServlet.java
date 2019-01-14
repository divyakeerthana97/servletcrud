package com.kg.servletcrudarraylist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FruitServlet
 */

@WebServlet("/")
public class FruitServlet extends HttpServlet {

    List<Fruit> listFruit = new ArrayList<Fruit>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertFruit(request, response);
                break;
            case "/delete":
                deleteFruit(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateFruit(request, response);
                break;
            default:
                listFruit(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFruit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // listFruit.add(new Fruit(1, "Apple"));
        // listFruit.add(new Fruit(2, "Orange"));
        // listFruit.add(new Fruit(3, "Mango"));

        request.setAttribute("listFruit", listFruit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("fruitform.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setAttribute("listFruit", listFruit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("fruitform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        // System.out.println("showEditForm called");
        request.setAttribute("listFruit", listFruit);
        int id = Integer.parseInt(request.getParameter("id"));
        Fruit existingFruit = new Fruit();
        for (Fruit fruit : listFruit) {
            if (fruit.getId() == id) {
                existingFruit = fruit;
            }
            // break;
        }

        // Fruit existingFruit = bookDAO.getBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("fruitform.jsp");
        request.setAttribute("fruit", existingFruit);
        dispatcher.forward(request, response);
    }

    private void insertFruit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        // System.out.println("insertFruit called");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Fruit newFruit = new Fruit(id, name);
        listFruit.add(newFruit);
        response.sendRedirect("list");
    }

    private void updateFruit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
                // System.out.println("updateFruit called");
                
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Fruit updateFruit = new Fruit(id, name);

        // listFruit.set(5, newFruit);        
        // bookDAO.updateBook(book);
        for (Fruit fruit : listFruit) {
            if (fruit.getId() == id) {
                listFruit.set(listFruit.indexOf(fruit),updateFruit);
            }
            // break;
        }
        response.sendRedirect("list");
    }

    private void deleteFruit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
                // System.out.println("delete fruit called");
                int id = Integer.parseInt(request.getParameter("id"));
                for (Fruit fruit : listFruit) {
                    if (fruit.getId() == id) {     
                        // System.out.println(studentList.indexOf(student));           
                        listFruit.remove(listFruit.indexOf(fruit));
                        break;
                    }
                    
                }      
                response.sendRedirect("list");
    }

}