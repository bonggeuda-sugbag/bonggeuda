package com.bonggeuda.sugbag.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KakaoPayServlet
 */
@WebServlet("/payment/ready")
public class KakaoPayServlet extends HttpServlet {

	protected void Post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String realPath = "https://kapi.kakao.com";
		String path = "/v1/payment/ready Http/1.1";
		request.setAttribute("KakaoAK", "6fa475e63957e2d2c064fdcad2419067");
		request.getRequestDispatcher(realPath+path).forward(request, response);
	}

}
