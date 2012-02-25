package cz.jirimasek.dppnews;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.TwitterException;


public class DPPnewsServlet extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        
        DataProcessor processor = new DataProcessor();
        try
        {
            processor.process();
        }
        catch (TwitterException ex)
        {
        }
    }
}
