package com.bonggeuda.sugbag.owner.report.dao;

import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.close;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.commit;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.getConnection;
import static com.bonggeuda.sugbag.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.bonggeuda.sugbag.owner.report.service.ReportWriteDAO;



public class ReportWriteService {
	
	private ReportWriteDAO reportDAO = new ReportWriteDAO();
	

	/**
	 * Owner Report 테이블 인서트
	 * @param writerType
	 * @param reportedType
	 * @param userNo
	 * @param ownerNo
	 * @param reportTitle
	 * @param reportContent
	 * @return
	 */
	public int reportInsertService(String writerType, String reportedType, int userNo, int ownerNo,
			String reportTitle, String reportContent) {
		
		Connection con = getConnection();
		
		int reportInsert = reportDAO.insertReport(con, writerType, reportedType, userNo, ownerNo, reportTitle, reportContent);
		

		
		if(reportInsert > 0) {
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return reportInsert;
	}

}
