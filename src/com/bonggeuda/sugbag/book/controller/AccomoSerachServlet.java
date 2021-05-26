package com.bonggeuda.sugbag.book.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonggeuda.sugbag.model.dto.AccomoInfoDTO;
import com.bonggeuda.sugbag.model.dto.AccomoSearchDTO;
import com.bonggeuda.sugbag.service.BookService;


/**
 * Servlet implementation class AccomoSerchServlet
 */
@WebServlet("/accomoSelect/search")
public class AccomoSerachServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String,String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("key : " + key);
			for(int i = 0; i < value.length; i++) {
				System.out.println("value[" + i + "] : " +value[i]);
			}
		}
		//숙소타입
		String type = request.getParameter("type");
		//검색할 편의시설
		String[] checkList = request.getParameterValues("facility");
		//사진카테고리
		int category = 3;
		//인원수
		String personnel = request.getParameter("personnel");
		
		AccomoSearchDTO search = new AccomoSearchDTO();
		search.setType(type);
		search.setFacility(checkList);
		search.setCategory(3);
		if(personnel.length() > 0) {
			search.setPersonnal(Integer.parseInt(personnel));
		}
		//조건에 일치하는 숙소리스트 검색
		BookService booksvc = new BookService();
		List<AccomoInfoDTO> accomoList = booksvc.selectAccomoFacility(search);
		//최저가(0), 평점(1) 조회
		List<Map> priceNrvScore = booksvc.selectPriceNstar(type);
		
		String path="";
		if(accomoList != null) {
			for(int i = 0; i < accomoList.size(); i++) {
				int accomoNo = accomoList.get(i).getAccomoNo();
				if(priceNrvScore.get(0).get(accomoNo) != null) {
					accomoList.get(i).setMinPrice((int)priceNrvScore.get(0).get(accomoNo));
				}
				if(priceNrvScore.get(1).get(accomoNo) != null) {
					accomoList.get(i).setReviewScore((double)priceNrvScore.get(1).get(accomoNo));
				}
			}
			path = "/WEB-INF/views/guest/accomoInfo/list.jsp";
			System.out.println(accomoList);
			request.setAttribute("checkList", checkList);
			request.setAttribute("accomoList", accomoList);
			request.setAttribute("type", type);
		} else {
			System.out.println("숙소목록 조회에 실패했습니다.!!");
		}
		request.getRequestDispatcher(path).forward(request, response);
//		JSONArray jsonArr = new JSONArray();
//		for(AccomoInfoDTO accomo : accomoList) {
//			JSONObject json = new JSONObject();
//			json.put("accomoNo",accomo.getAccomoNo());
//			json.put("accomoName",accomo.getAccomoName());
//			json.put("path",accomo.getPath());
//			json.put("minPrice",accomo.getMinPrice());
//			json.put("attachment",accomo.getAttachment().getThumbnailPath());
//			
//			jsonArr.add(json);
//		}
//		System.out.println(jsonArr);
//		response.setContentType("application/json; charset=UTF-8;");
//	
//        PrintWriter out = response.getWriter();
//        out.print(jsonArr);
        
//        out.flush();
//        out.close();
		
	}
}
