package app.servlets;

import app.entities.Client;
import app.model.DbDeleteClient;
import app.model.DbShowClient;
import app.model.DbShowClients;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainControllerServlet")
public class MainControllerServlet extends HttpServlet {

//    private List<Theater> theaters = new ArrayList<>();
//    private Integer counter;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init();
//        Theater theater1 = new Theater(1, "TheatreName_1", "City_1", "Address_1", "Phone_1", "site_1.com");
//        Theater theater2 = new Theater(2, "TheatreName_2", "City_2", "Address_2", "Phone_2", "site_2.com");
//        Theater theater3 = new Theater(3, "TheatreName_3", "City_3", "Address_3", "Phone_3", "site_3.com");
//        Theater theater4 = new Theater(4, "TheatreName_4", "City_4", "Address_4", "Phone_4", "site_4.com");
//
//        theaters.add(theater1); theaters.add(theater2); theaters.add(theater3); theaters.add(theater4);
//        counter = theaters.size();
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Выбрано действие "Редактирования"
        if (req.getParameter("edit_id") != null){
            int record_id = Integer.parseInt(req.getParameter("edit_id"));
            System.out.println("FromMainController: Option Edit is onClick: " + record_id);

            Client client = DbShowClient.qweryDatabase(record_id);
            System.out.println(client);

            req.setAttribute("client", client);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/editClientForm.jsp");
            requestDispatcher.forward(req, resp);
        } else


            // Выбрано действие "Удаления"
        if (req.getParameter("delete_id") != null){
            int record_id = Integer.parseInt(req.getParameter("delete_id"));
            System.out.println("FromMainController: Option Delete is onClick: " + record_id);

            DbDeleteClient.qweryDatabase(record_id);

            List <Client> clients = DbShowClients.qweryDatabase();
            req.setAttribute("clients", clients);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showClients.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        //index.html Кнопка перехода на форму добавления нового клиента
        if (req.getParameter("addClientForm") != null){
            System.out.println("FromMainController: change addClientForm");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/addClientForm.jsp");
            requestDispatcher.forward(req, resp);
        }

        //views/addClientForm Кнопка добавить нового клиента
        else if (req.getParameter("addClient") != null){
            System.out.println("FromMainController: change addClient");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("model/AddClient");
            requestDispatcher.forward(req, resp);
        }

        //index.html Кнопка показать всех клиентов
        else if (req.getParameter("showClients") != null){
            List <Client> clients = DbShowClients.qweryDatabase();
//            ArrayList clients = DbShowClients.qweryDatabase();
            req.setAttribute("clients", clients);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showClients.jsp");
            requestDispatcher.forward(req, resp);
        }

        // Кнопка "Сохранить" после редактирования
        else if (req.getParameter("editClient") != null){
            System.out.println("FromMainController: change Button Save Client");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("model/EditClient");
            requestDispatcher.forward(req, resp);
        }

        //index.html Кнопка Найти клиента
        else if (req.getParameter("searchClients") != null){
            System.out.println("FromMainController: change FinClientForm");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/findClientForm.jsp");
            requestDispatcher.forward(req, resp);
        }

/*        //Кнопка
        else if (req.getParameter("showUsers") != null){
            ArrayList users = DbShowUsers.testShowUsers();
            req.setAttribute("users", users);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/showUsers.jsp");
            requestDispatcher.forward(req, resp);
        }*/


    }
}
