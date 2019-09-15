package web.api.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Servlet implementation class ShowFoodServlet
 */
@WebServlet("/SCG")
public class ShowFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static final String LOG_TAG = "APIBackProject";
    
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    
    private static final String TYPE_SEARCH = "/nearbysearch";
    
    private static final String OUT_JSON = "/json";
    
    private static final String LOCATION = "13.8235283,100.5081204";
    
    private static final String RADIUS = "50000";
    
    private static final String TYPES = "food";
    
    private static final String LANGUAGE = "th";
    
    private static final String KEYWORD = "restaurant";
    
    private static final String API_KEY = "AIzaSyDmg9bqY_li9fOWvhHUxA8C48yFGneSwbg";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE);
            sb.append(TYPE_SEARCH);
            sb.append(OUT_JSON);
            sb.append("?location=" + LOCATION);
            sb.append("&radius=" + RADIUS);
            sb.append("&types=" + TYPES);
            sb.append("&language=" + LANGUAGE);
            sb.append("&keyword=" + KEYWORD);
            sb.append("&key=" + API_KEY);

            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
            InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error processing Places API URL", e);
          
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error connecting to Places API", e);
      
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        
        try {
            // Create a JSON object hierarchy from the results
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(jsonResults);
            out.flush(); 

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error processing JSON results", e);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
