<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Document</title>
        </head>

        <body>
            <center>
                <h1>Fruits Management</h1>
                <h2>
                    <a href="/new">Add New Fruit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/list">List All Fruits</a>

                </h2>
            </center>
            <div align="center">
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>List of Fruits</h2>
                    </caption>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="fruit" items="${listFruit}">
                        <tr>
                            <td>
                                <c:out value="${fruit.id}" />
                            </td>
                            <td>
                                <c:out value="${fruit.name}" />
                            </td>
                            <td>
                                <a href="/edit?id=<c:out value='${fruit.id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/delete?id=<c:out value='${fruit.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>