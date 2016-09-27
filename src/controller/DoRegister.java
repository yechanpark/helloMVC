package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegister() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		CustomerService service = (CustomerService) CustomerService.getInstance();

		String page;

		if (service.findCustomer(id) == null) { // ���̵� ������ ����
			Customer customer = new Customer(id, password, name, gender, email);
			service.addCustomer(customer);
			request.setAttribute("customer", customer);
			page = "/view/registerSuccess.jsp";
		} else { // ���̵� ������ ����
			request.setAttribute("id", id); // �ش� ${id} �� �̹� �����մϴ�
			page = "/view/registerFail.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
