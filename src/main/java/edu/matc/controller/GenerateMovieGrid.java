package edu.matc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class GenerateMovieGrid extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public static void generateGrid(JspWriter out, HttpServletRequest request)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");

        /*
        The code below is just a mock-up.  The final version will access the user's movie table to build the
        movie grid.
         */
        out.print("<h1>" + userId + "</h1>");
        out.print("<table>");
        out.print("<tr>");
        out.print("<td><a href=\"clickedThumb?id=1\"><img src=\"images/thumbs/1.jpg\" width=\"100\" class=\"post-img\" alt=\"Sideways\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=2\"><img src=\"images/thumbs/2.jpg\" width=\"100\" class=\"post-img\" alt=\"Girl Happy\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=3\"><img src=\"images/thumbs/3.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=4\"><img src=\"images/thumbs/4.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=5\"><img src=\"images/thumbs/5.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=6\"><img src=\"images/thumbs/6.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=7\"><img src=\"images/thumbs/7.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=8\"><img src=\"images/thumbs/8.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td><a href=\"clickedThumb?id=9\"><img src=\"images/thumbs/9.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=10\"><img src=\"images/thumbs/10.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=11\"><img src=\"images/thumbs/11.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=12\"><img src=\"images/thumbs/12.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=13\"><img src=\"images/thumbs/13.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=14\"><img src=\"images/thumbs/14.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=15\"><img src=\"images/thumbs/15.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=16\"><img src=\"images/thumbs/16.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td><a href=\"clickedThumb?id=17\"><img src=\"images/thumbs/17.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=18\"><img src=\"images/thumbs/18.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=19\"><img src=\"images/thumbs/19.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=20\"><img src=\"images/thumbs/20.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=21\"><img src=\"images/thumbs/21.jpg\" width=\"100\" class=\"post-img\" alt=\"Bild\"></a></td>");
        out.print("</tr>");
        out.print("</table>");
    }
}


