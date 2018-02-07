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
        out.print("<h2>a</h2>");
        out.print("<tr>");
        out.print("<td><a href=\"clickedThumb?id=2\"><img src=\"https://image.tmdb.org/t/p/w92/rQocmooj7bFKS2vZfzWBB5O12eR.jpg\" width=\"100\" class=\"post-img\" title=\"WarGames\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=3\"><img src=\"https://image.tmdb.org/t/p/w92/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg\" width=\"100\" class=\"post-img\" title=\"Blade Runner 2049\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=4\"><img src=\"https://image.tmdb.org/t/p/w92/p64TtbZGCElxQHpAMWmDHkWJlH2.jpg\" width=\"100\" class=\"post-img\" title=\"Blade Runner\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=5\"><img src=\"https://image.tmdb.org/t/p/w92/A5cREO9NNFYg5OmTErWsghYQF9m.jpg\" width=\"100\" class=\"post-img\" title=\"Abattoir\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=6\"><img src=\"https://image.tmdb.org/t/p/w92/kRP5dGXDhKt7bDpXX4YBa4dRwlL.jpg\" width=\"100\" class=\"post-img\" title=\"Abyss\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=7\"><img src=\"https://image.tmdb.org/t/p/w92/afhAUuWVB7k7PjJUd4lwO3rzhSq.jpg\" width=\"100\" class=\"post-img\" title=\"The Accountant\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=8\"><img src=\"https://image.tmdb.org/t/p/w92/d0vReo0jcMhBjCLYZAFqWHcb7Lj.jpg\" width=\"100\" class=\"post-img\" title=\"After Earth\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=9\"><img src=\"https://image.tmdb.org/t/p/w92/kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg\" width=\"100\" class=\"post-img\" title=\"Atomic Blonde\"></a></td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td><a href=\"clickedThumb?id=10\"><img src=\"https://image.tmdb.org/t/p/w92/flnoqdC38mbaulAeptjynOFO7yi.jpg\" width=\"100\" class=\"post-img\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=11\"><img src=\"https://image.tmdb.org/t/p/w92/s5XkBqUMwE0wQv9NY0XERs64cgs.jpg\" width=\"100\" class=\"post-img\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=12\"><img src=\"https://image.tmdb.org/t/p/w92/cezWGskPY5x7GaglTTRN4Fugfb8.jpg\" width=\"100\" class=\"post-img\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=13\"><img src=\"https://image.tmdb.org/t/p/w92/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg\" width=\"100\" class=\"post-img\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=14\"><img src=\"https://image.tmdb.org/t/p/w92/we6igIU5gXVwuSL6M6pJP75TwEf.jpg\" width=\"100\" class=\"post-img\"></a></td>");
        out.print("<td><a href=\"clickedThumb?id=15\"><img src=\"https://image.tmdb.org/t/p/w92/u7vvexSU81Qk20yU7Vog23Ogob.jpg\" width=\"100\" class=\"post-img\"></a></td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("<h2>j</h2>");
        out.print("<table>");
        out.print("<tr>");
        out.print("<td><a href=\"clickedThumb?id=1\"><img src=\"https://image.tmdb.org/t/p/w92/38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg\" width=\"100\" class=\"post-img\" alt=\"Girl Happy\"></a></td>");
        out.print("</tr>");
        out.print("</table>");
    }
}


