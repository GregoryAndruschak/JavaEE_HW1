package servlets;

import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;



public class Servlet extends HttpServlet {

    private static final String HTML_page = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Login page</title>\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
            "    <style>\n" +
            "        html,\n" +
            "        body {\n" +
            "          height: 100%;\n" +
            "        }\n" +
            "\n" +
            "        body {\n" +
            "          display: -ms-flexbox;\n" +
            "          display: -webkit-box;\n" +
            "          display: flex;\n" +
            "          -ms-flex-align: center;\n" +
            "          -ms-flex-pack: center;\n" +
            "          -webkit-box-align: center;\n" +
            "          align-items: center;\n" +
            "          -webkit-box-pack: center;\n" +
            "          justify-content: center;\n" +
            "          padding-top: 40px;\n" +
            "          padding-bottom: 40px;\n" +
            "          background-color: #f5f5f5;\n" +
            "        }\n" +
            "\n" +
            "        .form-signin {\n" +
            "          width: 100%;\n" +
            "          max-width: 330px;\n" +
            "          padding: 15px;\n" +
            "          margin: 0 auto;\n" +
            "        }\n" +
            "        .form-signin .checkbox {\n" +
            "          font-weight: 400;\n" +
            "        }\n" +
            "        .form-signin .form-control {\n" +
            "          position: relative;\n" +
            "          box-sizing: border-box;\n" +
            "          height: auto;\n" +
            "          padding: 10px;\n" +
            "          font-size: 16px;\n" +
            "        }\n" +
            "        .form-signin .form-control:focus {\n" +
            "          z-index: 2;\n" +
            "        }\n" +
            "        .form-signin input[type=\"email\"] {\n" +
            "          margin-bottom: -1px;\n" +
            "          border-bottom-right-radius: 0;\n" +
            "          border-bottom-left-radius: 0;\n" +
            "        }\n" +
            "        .form-signin input[type=\"password\"] {\n" +
            "          margin-bottom: 10px;\n" +
            "          border-top-left-radius: 0;\n" +
            "          border-top-right-radius: 0;\n" +
            "        }\n" +
            "    </style>\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n" +
            "    <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n" +
            "</head>\n" +
            "<body class=\"text-center\">   \n" +
            "    <form class=\"form-signin\">\n" +
            "        <h1 class=\"h3 mb-3 font-weight-normal\">Please sign in</h1>\n" +
            "        <label for=\"inputLogin\" class=\"sr-only\">Login</label>\n" +
            "        <input type=\"text\" name=\"login\" id=\"inputLogin\" class=\"form-control\" placeholder=\"Login\" required autofocus>\n" +
            "        <label for=\"inputPassword\" class=\"sr-only\">Password</label>\n" +
            "        <input type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n" +
            "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Sign in</button>\n" +
            "    </form>   \n" +
            "  </body>\n" +
            "</html>";

    private static final String LOGGED_page = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Login page</title>\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n" +
            "    <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n" +
            "</head>\n" +
            "<body class=\"text-center\">   \n" +
            "    <h1>You are already logged in!</h1> \n" +
            "  </body>\n" +
            "</html>";

    private static final String login = "admin";
    private static final String password = "admin";

    private boolean logged_in = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {

            if(!logged_in){

                out.println(HTML_page);

                if (request.getParameter("login") != null) {

                    if ((!request.getParameter("login").equals(login))||(!request.getParameter("password").equals(password))) {

                        out.println("<br><br><h1>Wrong login or password!</h1>");

                    }

                    if(request.getParameter("login").equals(login)&&request.getParameter("password").equals(password)) {

                        logged_in = true;
                        out.println("<br><br><h1>Success</h1>");

                    }

                }

            }
            else {

                out.println(LOGGED_page);

            }

        } finally {

            out.close();

        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }

}