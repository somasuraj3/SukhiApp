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

/**
 * Servlet implementation class Users
 */
@WebServlet("/second")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = null;

        try {
            
	    // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("ps");
            
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
    		//out.print("Hello World !");
    		out.print("Here is the standard output of the command:\n");
    		while ((s = stdInput.readLine()) != null) {
                out.println(s);
            }
    		out.print("<br><br>");
    		out.print("Here is the standard error of the command (if any):\n");
    		while ((s = stdError.readLine()) != null) {
                out.print(s);
            }
    		out.print("</body>");
    		out.print("</html>");
        }
        catch (IOException e) {
            //out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            //System.exit(-1);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
