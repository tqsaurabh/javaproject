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
import com.Pojo.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		User lib = (User) UtilityJson.getObjectFromJSON(jsonobject, User.class);
		System.out.println(lib);

		Map<String, String> mp=null;
		try {
			mp = DaoLayer.createReg(lib);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(mp);
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		response.flushBuffer();
	}

}
