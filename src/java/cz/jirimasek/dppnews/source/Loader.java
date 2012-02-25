package cz.jirimasek.dppnews.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Loader
{

    public String load(URL url) throws IOException
    {
        InputStream ins = null;
        BufferedReader dis;
        String line;
        String html = "";

        ins = url.openStream(); // throws an IOException
        dis = new BufferedReader(new InputStreamReader(ins, "UTF-8"));

        while ((line = dis.readLine()) != null)
        {
            html += line;
        }

        return html;
    }

}
