package com.bonggeuda.sugbag.common.queryBuilder;

import com.bonggeuda.sugbag.model.dto.AccomoSearchDTO;

public class QueryBuilder {

	public StringBuilder queryBuiler(AccomoSearchDTO search) {
		
		String query = "";
		
		StringBuilder qr = new StringBuilder();
		String select = "SELECT\r\n"
				+ "       AI.ACCOMO_NO 번호\r\n"
				+ "     , AI.ACCOMO_NAME 이름\r\n"
				+ "     , MIN(RI.ROOM_FEE) 최저가\r\n"
				+ "     , AI.ACCOMO_PATH 경로\r\n"
				+ "     , AT.THUMBNAIL_PATH 사진\r\n"
				+ "  FROM ACCOMO_INFO AI\r\n"
				+ "  JOIN ROOM_INFO RI ON (AI.ACCOMO_NO = RI.ACCOMO_NO)\r\n"
				+ "  JOIN ATTACHMENT AT ON (AI.ACCOMO_NO = AT.REF_NO)\r\n"
				+ " WHERE ROOM_MAX >=?\r\n"
				+ "   AND VISIBLE_YN = 'Y'\r\n"
				+ "   AND ACCOMO_TYPE = ?\r\n"
				+ "   AND CATEGORY_NO = ?\r\n";
		qr.append(select);
		if(search.getFacility().length > 0) {
			String start = "AND(";
			qr.append(start);
			for(int i = 0; i < search.getFacility().length; i++) {
				if(i < search.getFacility().length - 1) {
					String condition = "ACCOMO_FACILITY LIKE '%" + search.getFacility()[i] +"%' AND ";
					qr.append(condition);
				} else {
					String condition = "ACCOMO_FACILITY LIKE '%" + search.getFacility()[i] +"%')\r\n";
					qr.append(condition);
				}
			}
		}
		String group = "GROUP BY AI.ACCOMO_NO, AI.ACCOMO_NAME, ACCOMO_PATH, AT.THUMBNAIL_PATH";
		qr.append(group);
		System.out.println(qr);
		return qr;
	}

}
