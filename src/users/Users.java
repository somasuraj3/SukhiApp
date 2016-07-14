package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = null;

        try {
            
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("w");
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            PrintWriter out = response.getWriter();
    		out.print("<html>");
    		out.print("<head>");
    		out.print("<title>Users</title>");
    		out.print("</head>");
    		out.print("<body>");
    		out.print("Information of logged in Users:\n");
    		while ((s = stdInput.readLine()) != null) {
                out.print(s + " <br>");
            }
    		out.print("</body>");
    		out.print("</html>");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
