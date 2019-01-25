package app.servlets;
//import app.entities.Genre;
//import app.entities.Theater;
//import app.model.DbShowGenre;
//import app.model.DbShowTheaters;
//import app.model.DbShowUsers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;

@WebServlet("/MainControllerServlet")
public class MainControllerServlet extends HttpServlet {

//    private List<Theater> theaters = new ArrayList<>();
//    private Integer counter;
//
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init();
//        Theater theater1 = new Theater(1, "TheatreName_1", "City_1", "Address_1", "Phone_1", "site_1.com");
//        Theater theater2 = new Theater(2, "TheatreName_2", "City_2", "Address_2", "Phone_2", "site_2.com");
//        Theater theater3 = new Theater(3, "TheatreName_3", "City_3", "Address_3", "Phone_3", "site_3.com");
//        Theater theater4 = new Theater(4, "TheatreName_4", "City_4", "Address_4", "Phone_4", "site_4.com");
//
//        theaters.add(theater1);
//        theaters.add(theater2);
//        theaters.add(theater3);
//        theaters.add(theater4);
//        counter = theaters.size();
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        //index.html Кнопка перехода на форму добавления нового театра
        if (req.getParameter("addClientForm") != null){
            System.out.println("FromMainController: change addClientForm");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/newTheaterForm.jsp");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/addClientForm.jsp");
            requestDispatcher.forward(req, resp);
        }

        //addClientForm Кнопка добавить нового клиента
        else if (req.getParameter("addClient") != null){
            System.out.println("FromMainController: change addClient");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("model/AddClient");
            requestDispatcher.forward(req, resp);
        }


/*        //Кнопка показать все театры
        else if (req.getParameter("showTheaters") != null){
            ArrayList theaters = DbShowTheaters.testDatabase();
//            req.setAttribute("count", counter);
            req.setAttribute("teatrs", theaters);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showTheaters.jsp");
            requestDispatcher.forward(req, resp);
        }

        //Кнопка показать все жанры
        else if (req.getParameter("showGenres") != null){
            ArrayList genres = DbShowGenre.testDatabase();
            req.setAttribute("genres", genres);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showGenres.jsp");
            requestDispatcher.forward(req, resp);
        }

        //Кнопка добавить нового USER'a
        else if (req.getParameter("newUserForm") != null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tempNewUserForm.jsp");
            requestDispatcher.forward(req, resp);
        }

        //Кнопка показать всех User'ов
        else if (req.getParameter("showUsers") != null){
            ArrayList users = DbShowUsers.testShowUsers();
            req.setAttribute("users", users);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showUsers.jsp");
            requestDispatcher.forward(req, resp);
        }*/

        //Добавлять СЮДЫ 8-)

    }
}

//        Ещё один способ добавить данные в коллекцию:
//        ArrayList<Human> human = new ArrayList<>();
//        for (int i = 0; i < 100; i++)
//        {
//            human.add(new Human(HumanName, lastName, middle_name, date, id));
//        }
//        human.forEach(System.out::println);

//        Перенаправление на jsp страницу
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/return_form_data.jsp");


//          Кнопка показать все театры из ArrayList'a
//        } else if (req.getParameter("showTheaters") != null) {
//            req.setAttribute("count", counter);
//            req.setAttribute("teatrs", theaters);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showTheaters.jsp");
//            requestDispatcher.forward(req, resp);