package com.bonggeuda.sugbag.owner.manage.dao;



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
import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.RmAccomoInfoDTO;

public class ManagementRoomSelectDAO {
	
		private Properties prop = new Properties();

	
	public ManagementRoomSelectDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/roomManagement/roomManagement-mapper.xml"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int selectTotalRoom(Connection con, int ownerNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectRoomCount");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, ownerNo);		
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("DAO 토탈 카운트1 : " + totalCount);
		
		return totalCount;

		
	}

	public List<RmAccomoInfoDTO> selectAccomoListDAO(Connection con, int ownerNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<RmAccomoInfoDTO> selectAccomoList = new ArrayList<RmAccomoInfoDTO>();
		RmAccomoInfoDTO accomoDTO = new RmAccomoInfoDTO();
		
		String query = prop.getProperty("selectAccomoList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, ownerNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				accomoDTO = new RmAccomoInfoDTO();
				
				accomoDTO.setAccomoName(rset.getString("RM_ACCOMO_NAME"));
				accomoDTO.setAccomoType(rset.getString("RM_ACCOMO_TYPE"));
				accomoDTO.setApprovalYN(rset.getString("APPROVAL_YN"));
				accomoDTO.setRmType(rset.getString("RM_TYPE"));
				accomoDTO.setEnAccomoNO(rset.getInt("EN_ACCOMO_NO"));
				accomoDTO.setRmAccomoNo(rset.getInt("RM_ACCOMO_NO"));
				accomoDTO.setThumbNailPath(rset.getString("THUMBNAIL_PATH"));

				
				selectAccomoList.add(accomoDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return selectAccomoList;
	}

	public String selectRmImagePathDAO(Connection con, int ownerNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectRmAccomoImagePath");
		
		String selectRmImagePathDAO = "";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,ownerNo );
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectRmImagePathDAO = rset.getString("THUMBNAIL_PATH");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
			close(rset);
		}
		
		return selectRmImagePathDAO;
	}

	public int insertRmAccomoDAO(Connection con, RmAccomoInfoDTO rmAccomoInfoDTO) {
		
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertRmAccomo");
		
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rmAccomoInfoDTO.getRmAccomoNo());
			pstmt.setString(2, rmAccomoInfoDTO.getAccomoName());
			pstmt.setString(3, rmAccomoInfoDTO.getCeoName());
			pstmt.setString(4, rmAccomoInfoDTO.getAccomoType());
			pstmt.setString(5, rmAccomoInfoDTO.getRegistNo());
			pstmt.setString(6, rmAccomoInfoDTO.getAddress());
			pstmt.setString(7, rmAccomoInfoDTO.getEmail());
			pstmt.setString(8, rmAccomoInfoDTO.getHomepage());
			pstmt.setString(9, rmAccomoInfoDTO.getFacility());
			pstmt.setString(10, rmAccomoInfoDTO.getAccomoPath());
			pstmt.setString(11, rmAccomoInfoDTO.getNear());
			pstmt.setString(12, rmAccomoInfoDTO.getRule());
			pstmt.setString(13, rmAccomoInfoDTO.getParking());
			pstmt.setString(14, rmAccomoInfoDTO.getCheckIn());
			pstmt.setString(15, rmAccomoInfoDTO.getCheckOut());
			pstmt.setDate(16, rmAccomoInfoDTO.getPeakStart());
			pstmt.setDate(17, rmAccomoInfoDTO.getPeakEnd());
			pstmt.setInt(18, rmAccomoInfoDTO.getOwnerNo());
			
			insertResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
		}
		
		return insertResult;
	}

	   public List<AccomoDTO> selectApproveAccomoDAO(int ownerNo, Connection con) {

		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      
		      List<AccomoDTO> accomoList = new ArrayList<AccomoDTO>();
		      AccomoDTO accomoDTO = new AccomoDTO();
		      
		      String query = prop.getProperty("selectApproveAccomoList");
		      
		      try {
		         pstmt = con.prepareStatement(query);
		         
		         pstmt.setInt(1, ownerNo);
		         
		         rset = pstmt.executeQuery();
		         
		         while(rset.next()) {
		            accomoDTO = new AccomoDTO();
		            
		            accomoDTO.setAccomoName(rset.getString("ACCOMO_NAME"));
		            accomoDTO.setAccomoNo(rset.getInt("ACCOMO_NO"));
		            accomoDTO.setCeoName(rset.getString("CEO_NAME"));
		            accomoDTO.setAccomoType(rset.getString("ACCOMO_TYPE"));
		            accomoDTO.setImagePath(rset.getString("THUMBNAIL_PATH"));
		            
		            accomoList.add(accomoDTO);
		            
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }  finally {
		         close(pstmt);
		         close(rset);
		      }
		      
		      return accomoList;
		   }

	   public List<RmAccomoInfoDTO> selectApplyEnrollAccomoListDAO(int ownerNo, Connection con) {
		      
		      
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      
		      List<RmAccomoInfoDTO> accomoList = new ArrayList<RmAccomoInfoDTO>();
		      RmAccomoInfoDTO rmAccomoDTO = new RmAccomoInfoDTO();
		      
		      String query = prop.getProperty("selectApplyEnrollAccomoList");
		      
		      try {
		         pstmt = con.prepareStatement(query);
		         
		         pstmt.setInt(1, ownerNo);
		         
		         rset = pstmt.executeQuery();
		         
		         while(rset.next()) {
		            rmAccomoDTO = new RmAccomoInfoDTO();
		            
		            rmAccomoDTO.setAccomoName(rset.getString("RM_ACCOMO_NAME"));
		            
		            rmAccomoDTO.setEnAccomoNO(rset.getInt("EN_ACCOMO_NO"));
		            rmAccomoDTO.setCeoName(rset.getString("RM_CEO_NAME"));
		            rmAccomoDTO.setAccomoType(rset.getString("RM_ACCOMO_TYPE"));
		            rmAccomoDTO.setThumbNailPath(rset.getString("THUMBNAIL_PATH"));
		            
		            accomoList.add(rmAccomoDTO);
		            
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }  finally {
		         close(pstmt);
		         close(rset);
		      }
		      
		      return accomoList;   
		      
		   }

	public List<RmAccomoInfoDTO> selectApplyRejectAccomoListDAO(int ownerNo, Connection con) {

	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      List<RmAccomoInfoDTO> accomoList = new ArrayList<RmAccomoInfoDTO>();
	      RmAccomoInfoDTO rmAccomoDTO = new RmAccomoInfoDTO();
	      
	      String query = prop.getProperty("selectApplyRejectAccomoList");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         
	         pstmt.setInt(1, ownerNo);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            rmAccomoDTO = new RmAccomoInfoDTO();
	            
	            rmAccomoDTO.setAccomoName(rset.getString("RM_ACCOMO_NAME"));
	            
	            rmAccomoDTO.setEnAccomoNO(rset.getInt("EN_ACCOMO_NO"));
	            rmAccomoDTO.setAccomoType(rset.getString("RM_ACCOMO_TYPE"));
	            rmAccomoDTO.setThumbNailPath(rset.getString("THUMBNAIL_PATH"));
	            rmAccomoDTO.setRequestNo(rset.getInt("REQUEST_NO"));
	            
	            rmAccomoDTO.setInsPectionComment(rset.getString("INSPECTION_COMMENT"));

	            accomoList.add(rmAccomoDTO);
	            
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }  finally {
	         close(pstmt);
	         close(rset);
	      }
	      
	      return accomoList;   
	}
}
