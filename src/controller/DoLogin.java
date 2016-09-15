package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// Perform business logic. Return a bean as a result.
		CustomerService service = (CustomerService) CustomerService.getInstance();

		String page;

		// customer가 유효한지 확인
		if (service.findCustomer(id) == null) {
			page = "/view/loginFail.jsp";
		} else {
			Customer customer = service.login(id, password);
			if (customer != null)
				page = "/view/loginSuccess.jsp";
			else
				page = "/view/loginFailNotMatch.jsp";
			request.setAttribute("customer", customer);
		}
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}