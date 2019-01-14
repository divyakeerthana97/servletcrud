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
                <hr>
            </center>
            <div align="center">
                <c:if test="${fruit != null}">
                    <form action="/update" method="post">
                </c:if>
                <c:if test="${fruit == null}">
                    <form action="/insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h4>
                            <c:if test="${fruit != null}">
                                Edit Fruit
                            </c:if>
                            <c:if test="${fruit == null}">
                                Add New Fruit
                            </c:if>
                        </h4>
                    </caption>
                    <c:if test="${fruit != null}">
                        <input type="hidden" name="id" value="<c:out value='${fruit.id}' />" />
                    </c:if>
                    <tr>
                        <th>ID: </th>
                        <td>
                            <input type="text" name="id" size="45" value="<c:out value='${fruit.id}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Name: </th>
                        <td>
                            <input type="text" name="name" size="45" value="<c:out value='${fruit.name}' />" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
                </form>
            </div>
            
            </center>
            <div align="center">
                <table border="1" cellpadding="5">
                    <caption>
                        <h4>List of Fruits</h4>
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