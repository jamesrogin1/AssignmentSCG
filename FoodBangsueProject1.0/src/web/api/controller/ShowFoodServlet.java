package web.api.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import web.api.model.Restaurant;

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
    
    private static final String URL_API_BASE = "http://localhost:8080/APIBackProject1.0/SCG";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(URL_API_BASE);

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
            JSONArray predsJsonArray = jsonObj.getJSONArray("results");
            
            // Extract the Place descriptions from the results
            List<Restaurant> resultList = new ArrayList<Restaurant>(predsJsonArray.length());
            Restaurant resta = null;
            
            for (int i = 0; i < predsJsonArray.length(); i++) {
            	resta = new Restaurant();
            	resta.setName(predsJsonArray.getJSONObject(i).getString("name"));
            	resta.setRating(predsJsonArray.getJSONObject(i).getString("rating"));
            	resta.setUserRatingsTotal(predsJsonArray.getJSONObject(i).getString("user_ratings_total"));
            	resta.setVicinity(predsJsonArray.getJSONObject(i).getString("vicinity"));
                resultList.add(resta);
            }
            
            request.setAttribute("resultList", resultList);
            RequestDispatcher rd = request.getRequestDispatcher("view/showfood.jsp");
            rd.forward(request, response);

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
