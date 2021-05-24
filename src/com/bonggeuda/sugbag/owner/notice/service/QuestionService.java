package com.bonggeuda.sugbag.owner.notice.service;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.bonggeuda.sugbag.model.dto.AdminQnADTO;
import com.bonggeuda.sugbag.model.dto.QnADTO;
import com.bonggeuda.sugbag.owner.notice.dao.QuestionDAO;

public class QuestionService {

	/*QuestionDAO와 연결할 필드 변수*/
	QuestionDAO questionDAO = new QuestionDAO();
	
	public List<QnADTO> selectQuestion() {

		Connection con = getConnection();
		
		List<QnADTO> selectQuestion = questionDAO.selectQuestion(con);
		
		close(con);

		return selectQuestion;
	}

	public AdminQnADTO selectContent(int qnaNo) {
		
		Connection con = getConnection();
		
		AdminQnADTO selectContent = questionDAO.selectContent(con, qnaNo);
		
		close(con);

		return selectContent;
	}

	public int InsertQuestion(AdminQnADTO questionWrite) {

		Connection con = getConnection();
		
		int insertQuestion = questionDAO.insertQuestion(con, questionWrite);
		
		if(insertQuestion > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return insertQuestion;
	}

	public AdminQnADTO selectAnswer(int qnaNo) {

		Connection con = getConnection();
		
		AdminQnADTO selectAnswer = questionDAO.selectAnswer(con, qnaNo);
		
		close(con);

		return selectAnswer;
	}

}
