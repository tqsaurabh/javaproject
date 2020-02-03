package com.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBLayer.DaoLayer;
import com.Json.UtilityJson;
import com.Pojo.AddPizza;
import com.Pojo.User;

/**
 * Servlet implementation class AddPizzaServlet
 */
@WebServlet("/AddPizzaServletr")
public class AddPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   	{
   		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		AddPizza lib = (AddPizza) UtilityJson.getObjectFromJSON(jsonobject, AddPizza.class);
		System.out.println(lib);

		Map<String, String> mapobject=null;
		try {
			mapobject = DaoLayer.addpizza(lib);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mapobject);
		
		String jsonString = (String) UtilityJson.getJSONFromObject(mapobject);
		
		response.getWriter().write(jsonString);
		
		System.out.println(jsonString);
		
		response.flushBuffer();
	}

	
   	
   	
   	}
