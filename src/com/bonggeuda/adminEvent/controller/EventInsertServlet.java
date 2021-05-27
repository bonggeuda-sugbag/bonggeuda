package com.bonggeuda.adminEvent.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bonggeuda.adminEvent.dto.EventDTO;
import com.bonggeuda.adminEvent.service.AdminEventService;
import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.MemberDTO;
import com.bonggeuda.sugbag.model.dto.ReviewDTO;
import com.bonggeuda.sugbag.owner.modify.service.ModifyAccomoService;
import com.bonggeuda.sugbag.service.UserMypageService;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class EventInsertServlet
 */
@WebServlet("/event/insert")
public class EventInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/admin/event/eventWrite.jsp";
		
		System.out.println("서블릿");
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

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

				
				request.setCharacterEncoding("UTF-8");
				
				/* 이벤트 insert */
				EventDTO eventInfo = new EventDTO();
				
				eventInfo.setTitle(parameter.get("title"));
				eventInfo.setStartDate(java.sql.Date.valueOf(parameter.get("startDate")));
				eventInfo.setEndDate(java.sql.Date.valueOf(parameter.get("endDate")));
				
				System.out.println("2");
				//첨부파일
				eventInfo.setAttachmentList(new ArrayList<AttachmentDTO>());
				List<AttachmentDTO> list = eventInfo.getAttachmentList();
				for(int i =0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					AttachmentDTO reviewImg = new AttachmentDTO();
					reviewImg.setOriginName(file.get("originFileName"));
					reviewImg.setSavedName(file.get("savedFileName"));
					reviewImg.setSavePath(file.get("savePath"));
					reviewImg.setFileType(file.get("fileType"));
					reviewImg.setThumbnailPath(file.get("thumbnailPath"));
					reviewImg.setCategoryNo(8);
					
					list.add(reviewImg);
				}
				System.out.println("3");
				/* 리뷰내용 insert 하기 */
				AdminEventService eventInsertService = new AdminEventService();
				int result = eventInsertService.insertEvent(eventInfo);
				
				String path ="";
				if(result > 0) {
					//성공경로
					System.out.println("성공!");
					String page = "/WEB-INF/views/guest/moreNotice/narasuccess.jsp";
					request.setAttribute("successCode", "insertEvent");
					request.getRequestDispatcher(page).forward(request, response);
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

}


