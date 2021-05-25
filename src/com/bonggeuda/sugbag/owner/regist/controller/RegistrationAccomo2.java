package com.bonggeuda.sugbag.owner.regist.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bonggeuda.sugbag.model.dto.AccomoDTO;
import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.ReportDTO;
import com.bonggeuda.sugbag.service.ReportService;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class RegistrationAccomo2
 */
@WebServlet("/registration2")
public class RegistrationAccomo2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
			System.out.println(rootLocation);
			
			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			if(!directory.exists() || !directory2.exists()) {
				directory.mkdirs();
				directory2.mkdirs();
			}
			
			Map<String, String> parameter = new HashMap<>();
			List<Map<String,String>> fileList = new ArrayList<>();
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
			List<FileItem> fileItems;
			try {
				fileItems = fileUpload.parseRequest(request);
				
				for(int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						if(item.getSize() > 0) {
							String filedName = item.getFieldName();
							String originFileName = item.getName();
							
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							item.write(storeFile);
							
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							fileMap.put("fileType", "BODY");
							
							Thumbnails.of(fileUploadDirectory + randomFileName)
							.size(120, 100)
							.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							fileMap.put("thumbnailPath", "resources/upload/thumbnail/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
						}
					} else {
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					}
				}
				
				/*2단계 입력받기*/
				//숙소이미지받아오기
				String[] arrayFacility = request.getParameterValues("arrayFacility");
				String facility = "";
				String accomoPath = request.getParameter("accomoPath");
				String near = request.getParameter("near");
				String rule = request.getParameter("rule");
				String parking = request.getParameter("parking");
				
				for(int i=0; i < arrayFacility.length; i++) {
					
					facility += arrayFacility[i];
					
					if(i < arrayFacility.length - 1) {
						facility += ", ";
					}
				}
				
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
				
				//첨부파일
				report.setAttachmentList(new ArrayList<AttachmentDTO>());
				List<AttachmentDTO> list = report.getAttachmentList();
				for(int i =0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					AttachmentDTO fileInfo = new AttachmentDTO();
					fileInfo.setOriginName(file.get("originFileName"));
					fileInfo.setSavedName(file.get("savedFileName"));
					fileInfo.setSavePath(file.get("savePath"));
					fileInfo.setFileType(file.get("fileType"));
					fileInfo.setThumbnailPath(file.get("thumbnailPath"));
					fileInfo.setCategoryNo(6);
					
					list.add(fileInfo);
				}
				
				//신고내용 insert 하기
				
				ReportService rsvc = new ReportService();
				int result = rsvc.insertReport(report);
				
				String path ="";
				if(result > 0) {
					//성공경로
					System.out.println("성공!");
				} else {
					//실패경로
				}
			} catch (Exception e) {
				int cnt = 0;
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt == fileList.size()) {
					System.out.println(" 실패한 사진삭제 완료");
				} else {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
	
	
		
		/*1단계에서 값 넘어오는지 확인*/
//		System.out.println(request.getParameter("accomoName"));
//		System.out.println(request.getParameter("ceoName"));
//		System.out.println(request.getParameter("accomoType"));
//		System.out.println(request.getParameter("registNo"));
//		System.out.println(request.getParameter("address"));
//		System.out.println(request.getParameter("adrDetail"));
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("homepage"));
		
		/*2단계 입력받기*/
		//숙소이미지받아오기
		String[] arrayFacility = request.getParameterValues("arrayFacility");
		String facility = "";
		String accomoPath = request.getParameter("accomoPath");
		String near = request.getParameter("near");
		String rule = request.getParameter("rule");
		String parking = request.getParameter("parking");
		
		for(int i=0; i < arrayFacility.length; i++) {
			
			facility += arrayFacility[i];
			
			if(i < arrayFacility.length - 1) {
				facility += ", ";
			}
		}
		
		/*다시 DTO에 한번에 담아줌*/
		AccomoDTO accomoDTO = new AccomoDTO();
		
		accomoDTO.setAccomoName(request.getParameter("accomoName"));
		accomoDTO.setCeoName(request.getParameter("ceoName"));
		accomoDTO.setAccomoType(request.getParameter("accomoType"));
		accomoDTO.setRegistNo(request.getParameter("registNo"));
		accomoDTO.setAddress(request.getParameter("address"));
		accomoDTO.setAdrDetail(request.getParameter("adrDetail"));
		accomoDTO.setEmail(request.getParameter("email"));
		accomoDTO.setHomepage(request.getParameter("homepage"));
		accomoDTO.setFacility(facility);
		accomoDTO.setAccomoPath(accomoPath);
		accomoDTO.setNear(near);
		accomoDTO.setRule(rule);
		accomoDTO.setParking(parking);
		
		/*숙소등록3번 jsp로 값 넘기기*/
		request.setAttribute("accomoDTO", accomoDTO);
		
		String path="";

		path = "/WEB-INF/views/owner/registration/registration3.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
