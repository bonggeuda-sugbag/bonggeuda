package com.bonggeuda.sugbag.owner.book.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.PageInfoDTO;
import com.bonggeuda.sugbag.model.dto.QnADTO;
import com.bonggeuda.sugbag.owner.book.dao.BookingQnADAO;

public class BookingQnAService {

	/*QuestionDAO와 연결할 필드 변수*/
	BookingQnADAO qnaDAO = new BookingQnADAO();
	
	public int selectTotalCount() {

		Connection con = getConnection();
		
		int totalCount = qnaDAO.selectTotalCount(con);
		
		if(totalCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return totalCount;
	}

	public List<QnADTO> selectQuestion(PageInfoDTO pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
