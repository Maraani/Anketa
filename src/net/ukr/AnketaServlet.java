package net.ukr; /**
 * Created by Julia on 18.08.2016.
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class AnketaServlet extends HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>Anketa</title></head>" +
            "<body><h1>%s</h1></body></html>";

        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
            int indY=0;
            int indN=0;
            String [] answ = new String[3];
            for (int i=0;i<3;i++){
                answ[i]=req.getParameter("answer"+i);

              if (answ[i].equals("yes")){
              indY++;
              }
              else {
              indN++;

            }
            }


         String msg;

        msg= name+" "+surname+"<br> Answer Yes= "+indY+" "+"<br> Answer No = "+indN;

        resp.getWriter().println(String.format(TEMPLATE, msg));
    }
}
