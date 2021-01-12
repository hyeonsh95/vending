package com.simple.vm;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/vm")
public class VM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int MILK  = 300;
	private static final int CREAM = 300;
	private static final int BLACK = 200;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 초기화 메서드 호출됨. 단 한번.");
	}


	public void destroy() {
		//System.out.println("서버 종료시");
	}


	//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//		String method = request.getMethod();
	//		if(method.equals("POST")) {
	//			doPost(request, response);
	//		}else {
	//			doGet(request, response);
	//		}
	//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		System.out.println("get 처리됨");
		HttpSession session = request.getSession();
		int balance = 0;
		//jsp 처음 실행시  session.getAttribute("balance") == null
		if(session.getAttribute("balance") != null) {
			balance = (int)session.getAttribute("balance");			
		}
		balance = inMoney(request, balance);

		// 제품버튼 입력 처리
		String milk = request.getParameter("milk");//300원 받아옴
		String cream = request.getParameter("cream");
		String black = request.getParameter("black");

		if(milk != null) { //
			balance -= MILK;
		}
		
		String return_ = request.getParameter("return");
		int returnValue = 0;
		if(return_ != null) {
			returnValue = balance;			
			balance = 0;
		}

		// 제품버튼 활성화/비활성화 처리 -- 잔액을 기준으로 처리
		String btnMilk="disabled";
		String btnCream="disabled";
		String btnBlack="disabled";

		if(balance >= 300) {
			btnMilk = "";
			btnCream = "";
			btnBlack = "";
		}else if (balance >= 200) {
			btnBlack = "";
		}
		
		session.setAttribute("balance", balance);
		session.setAttribute("returnValue", returnValue);
		session.setAttribute("btnMilk", btnMilk);
		session.setAttribute("btnCream", btnCream);
		session.setAttribute("btnBlack", btnBlack);

		//int returnMoney = balance;
		session.setAttribute("balance", balance); //"balace" 는 jsp에서 ${balance}
		response.sendRedirect("index.jsp"); //3.페이지 전환 //서버에서 웹으로 보낸다 response//웹에서 서버로 request
	}

	private int inMoney(HttpServletRequest request, int balance) {
		// TODO Auto-generated method stub

		String coin500 = request.getParameter("coin500");//1.jsp coin500의 value를 coin500변수에 저장
		String coin100 = request.getParameter("coin100");
		String coin50 = request.getParameter("coin50");
		String coin10 = request.getParameter("coin10");

		//직접입력
		String inMoney_ = request.getParameter("inMoney");
		if(inMoney_ != null && !inMoney_.equals("")) {
			int inMoney = Integer.parseInt(inMoney_);
			balance += inMoney;
		}

		//지폐입력
		String cash_ = request.getParameter("cash");
		if(cash_ !=null) {
			int cash = Integer.parseInt(cash_);
			balance += cash;
		}

		//동전입력
		if(coin500 != null) {
			balance += 500;
		}
		if(coin100 != null) {
			balance += 100;
		}
		if(coin50 != null) {
			balance += 50;
		}
		if(coin10 != null) {
			balance += 10;
		}
		return balance;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		System.out.println("post");
		doGet(request, response);
	}
}
