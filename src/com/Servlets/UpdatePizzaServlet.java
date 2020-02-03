package com.Servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBLayer.DaoLayer;
import com.Json.UtilityJson;
import com.Pojo.AddPizza;

/**
 * Servlet implementation class UpdatePizzaServlet
 */
@WebServlet("/UpdatePizzaServlet")
public class UpdatePizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		System.out.println("update");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		AddPizza lib = (AddPizza) UtilityJson.getObjectFromJSON(jsonobject, AddPizza.class);
		System.out.println(lib);

		 Map<String,String>mp=DaoLayer.update(lib);
		 
		   String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();

	}


	}


