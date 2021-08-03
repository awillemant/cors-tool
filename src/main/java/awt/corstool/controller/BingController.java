package awt.corstool.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/bing")
public class BingController extends HttpServlet {


    public static final String BING_URL = "https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=10&mkt=fr-FR";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            URL url = new URL(BING_URL);
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            while ((i = stream.read()) != -1) {
                writer.print((char) i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

