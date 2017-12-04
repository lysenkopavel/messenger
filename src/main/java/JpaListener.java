import mydao.factory.DAOFactory;
import mydao.service.ChatService;
import mydao.service.MessageService;
import mydao.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Locale;

public class JpaListener implements ServletContextListener{

//    public static UserService userService;
//    public static ChatService chatService;
//    public static MessageService messageService;

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        Locale.setDefault(Locale.ENGLISH);
        DAOFactory daoObject = DAOFactory.getDAOFactory(DAOFactory.ORACLE_JPA);
        UserService userService = daoObject.getUserDAO();
        ChatService chatService = daoObject.getChatDAO();
        MessageService messageService = daoObject.getMessageService();

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("chatService", chatService);
        servletContext.setAttribute("messageService", messageService);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */

    }
}
