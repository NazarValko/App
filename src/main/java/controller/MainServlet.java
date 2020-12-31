package controller;

import dao.entity.User;


import dao.entity.Users;
import dao.repository.ListOfUsers;
import dao.repository.UserRepository;
import view.MainView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "MainServlet", urlPatterns = {"/"})
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        MainView mainView = MainView.getOurInstance();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String welcome = "";


        String index = mainView.getIndex();
        String menu = mainView.getMenu();
        String login = mainView.getLogin();

        if (email != null && password != null) {
            UserRepository userRepository = new UserRepository();
            ListOfUsers listOfUsers = new ListOfUsers();
            User user = userRepository.getUserByEmailByPassword(email, password);
//            Users users = listOfUsers.getListOfUsers(userList);
            if (user != null) {
                welcome = "<h1>Welcome " + user.getName() + "</h1>";
            } else {
                welcome = "<h1 style=\"color:red;\"> Your email " + email + " or password is incorrect "+ "\n";
            }
        }
        String page = index.replace("<!--$$$###Insert-text###$$$-->", login)
                .replace("<!--$$$###Login###$$$-->", welcome);
        out.println(page);

//        out.println("<html><head><title>MyServlet</title></head><body>");
//        out.println("<h1>Hello servlet world</h1>");
//        out.println("<p>Enter email and password: </p>");
//        out.println("<p>Path: " + mainView.getPath() + "</p>");
//        out.println(welcome);
//        out.println("</body>");
//        out.println("</html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        MainView mainView = MainView.getOurInstance();
        mainView.setPath(getServletContext().getRealPath("/html/"));

    }
}
