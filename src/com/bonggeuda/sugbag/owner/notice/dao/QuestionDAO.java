package com.bonggeuda.sugbag.owner.notice.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bonggeuda.sugbag.common.config.ConfigLocation;
import com.bonggeuda.sugbag.model.dto.AdminQnADTO;
import com.bonggeuda.sugbag.model.dto.QnADTO;

public class QuestionDAO {

	private Properties prop = new Properties();

	public QuestionDAO() {

		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"/owner/notice/notice-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<QnADTO> selectQuestion(Connection con) {
				
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;

		List<QnADTO> selectQuestion = new ArrayList<>(); //모든 행을 다 받아서 최종 리스트를 만듬
		
		/* --> selectQuestion 가지고 xml감 */
		String query = prop.getProperty("selectQuestion");
		
		/*쿼리문 잘 실행되는지 출력*/
		System.out.println(query);

		/*디비에 들어가서 쿼리문에 따른 값 받아오기*/
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1); //업체번호 받아오기
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				QnADTO Question = new QnADTO();
				
				Question.setQnaNo(rset.getInt("ADMIN_QNA_NO"));
				Question.setQnaTitle(rset.getString("ADMIN_QNA_TITLE"));
				Question.setQnaDate(rset.getDate("ADMIN_QNA_DATE"));
				Question.setAnswerYn(rset.getString("ADMIN_ANSWER_YN"));
				Question.setWriter("관리자");
				Question.setQnaContent(rset.getString("ADMIN_QNA_CONTENT"));
				
				selectQuestion.add(Question); //한 행씩 저장됨
			}
			
			System.out.println(selectQuestion);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectQuestion;
	}

	public AdminQnADTO selectContent(Connection con, int qnaNo) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;

	    AdminQnADTO selectContent = new AdminQnADTO(); //모든 행을 다 받아서 최종 리스트를 만듬
		
		/* --> selectQuestion 가지고 xml감 */
		String query = prop.getProperty("selectContent");
		
		/*쿼리문 잘 실행되는지 출력*/
		System.out.println(query);

		System.out.println(qnaNo);
		
		/*디비에 들어가서 쿼리문에 따른 값 받아오기*/
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1); 	//업체번호 받아오기
			pstmt.setInt(2, qnaNo); //문의번호 받아오기
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
								
				selectContent.setAdminQnATitle(rset.getString("ADMIN_QNA_TITLE"));
				selectContent.setAdminQnADate(rset.getDate("ADMIN_QNA_DATE"));
				selectContent.setAdminAnswerYn(rset.getString("ADMIN_ANSWER_YN"));
				selectContent.setAdminQnAWriter("관리자");
				selectContent.setAdminQnAContent(rset.getString("ADMIN_QNA_CONTENT"));
			}
			
			System.out.println(selectContent);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectContent;
	}

	public int insertQuestion(Connection con, AdminQnADTO questionWrite) {

		PreparedStatement pstmt = null;
		
		/* 반환시킬 변수 지정 */
		int insert = 0;
		
		String query = prop.getProperty("insertQuestion");

		//잘 넘어왔는지 확인용 출력
		System.out.println(query);
		
		try {
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, questionWrite.getAdminQnATitle());
			pstmt.setString(2, questionWrite.getAdminQnAContent());
			pstmt.setInt(3, 1);
			
			insert = pstmt.executeUpdate();
			System.out.println(insert);
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
     
		return insert;
	}

	public AdminQnADTO selectAnswer(Connection con, int qnaNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;

	    AdminQnADTO selectAnswer = new AdminQnADTO(); //모든 행을 다 받아서 최종 리스트를 만듬
		
		/* --> selectQuestion 가지고 xml감 */
		String query = prop.getProperty("selectAnswer");
		
		/*쿼리문 잘 실행되는지 출력*/
		System.out.println(query);

		System.out.println(qnaNo);
		
		/*디비에 들어가서 쿼리문에 따른 값 받아오기*/
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1); 	//업체번호 받아오기
			pstmt.setInt(2, qnaNo); //문의번호 받아오기
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
								
				selectAnswer.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				selectAnswer.setAnswerDate(rset.getDate("ANSWER_DATE"));
			}
			
			System.out.println(selectAnswer);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selectAnswer;
	}

}
