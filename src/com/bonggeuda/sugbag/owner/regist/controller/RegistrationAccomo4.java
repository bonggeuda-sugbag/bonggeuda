package com.bonggeuda.sugbag.owner.regist.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bonggeuda.sugbag.model.dto.AttachmentDTO;
import com.bonggeuda.sugbag.model.dto.RoomDTO;
import com.bonggeuda.sugbag.owner.regist.service.RoomService;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class RegistrationAccomo4
 */
@WebServlet("/registration4")
public class RegistrationAccomo4 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);
			
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
			
			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			/* 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성한다. */
			if(!directory.exists() || !directory2.exists()) {
				/* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하란 의미로 mkdirs를 이용한다. */
				System.out.println("폴더 생성 : " + directory.mkdirs());
				System.out.println("폴더 생성 : " + directory2.mkdirs());
			}
			
			/* 이게 최종적으로 request를 parsing하고 파일을 저장한 뒤 필요한 내용을 담을 리스트와 맵이다.
			 * 파일에 대한 정보는 리스트에, 다른 파라미터의 정보는 모두 맵에 담을 것이다.
			 * */
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			/* 파일을 업로드할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스이다. */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	        fileItemFactory.setRepository(new File(fileUploadDirectory));
	        fileItemFactory.setSizeThreshold(maxFileSize);
	        
	        /* 서블릿에서 기본 제공하는거 말고 꼭 commons fileupload 라이브러이에 있는 클래스로 임포트 해야 한다. */
	        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
//	        fileUpload.setHeaderEncoding(encodingType);		//별 의미 없는 듯 하다. 기본값은 null인데 파일명은 자동으로 UTF-8로 인코딩한 거 같다.
	        
	        try {
	        	/* request를 파싱하여 데이터 하나 하나를 FileItem 인스턴로 반환한다. */
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					/* 폼 데이터는 isFormField 속성이 true이고, 파일은 isFormField 속성이 false이다. */
					System.out.println(item);
				}
				
				/* 위에서 출력해본 모든 item들을 다 처리할 것이다. */
				for(int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						
						/* 파일 데이터인 경우 */
						if(item.getSize() > 0) {
							
							/* 파일의 사이즈가 0보다 커야 전송된 파일이 있다는 의미이다. 
							 * 전송된 파일이 있는 경우에만 처리하고, 0인 경우에는 무시하도록 로직을 작성한다.
							 * */
							String filedName = item.getFieldName();
							String originFileName = item.getName();
							
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							/* 저장할 파일 정보를 담은 인스턴스를 생성하고 */
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							/* 저장한다 */
							item.write(storeFile);
							
							/* 필요한 정보를 Map에 담는다. */
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							/* 제목 사진과 나머지 사진을 구분하고 썸네일도 생성한다. */
							int width = 0;
							int height = 0;
							if("thumbnailImg1".equals(filedName)) {
								fileMap.put("fileType", "TITLE");
								
								/* 썸네일로 변환 할 사이즈를 지정한다. */
								width = 350;
								height = 200;
							} else {
								fileMap.put("fileType", "BODY");
								
								width = 120;
								height = 100;
							}
							
							/* 썸네일로 변환 후 저장한다. */
							Thumbnails.of(fileUploadDirectory + randomFileName)
									.size(width, height)
									.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							/* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
							fileMap.put("thumbnailPath", "resources/upload/thumbnail/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
							
						}
						
					} else {
						/* 폼 데이터인 경우 */
						/* 전송된 폼의 name은 getFiledName()으로 받아오고, 해당 필드의 value는 getString()으로 받아온다. 
						 * 하지만 인코딩 설정을 하더라도 전송되는 파라미터는 ISO-8859-1로 처리된다.
						 * 별도로 ISO-8859-1로 해석된 한글을 UTF-8로 변경해주어야 한다.
						 * */
//						parameter.put(item.getFieldName(), item.getString());
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						
					}
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				
				/* 서비스를 요청할 수 있도록 BoardDTO에 담는다. */
				RoomDTO thumbnail = new RoomDTO();

			//	thumbnail.setWriterMemberNo(((MemberDTO) request.getSession().getAttribute("loginMember")).getNo());// int ownerNo으로 대체
				
				thumbnail.setAttachmentList(new ArrayList<AttachmentDTO>());
				
				List<AttachmentDTO> list = thumbnail.getAttachmentList();
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					AttachmentDTO tempFileInfo = new AttachmentDTO();
					tempFileInfo.setOriginName(file.get("originFileName"));
					tempFileInfo.setSavedName(file.get("savedFileName"));
					tempFileInfo.setSavePath(file.get("savePath"));
					tempFileInfo.setFileType(file.get("fileType"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					
					list.add(tempFileInfo);
				}
				
				System.out.println("thumbnail board : " + thumbnail);
				
				
				
				/* 성공 실패 페이지를 구분하여 연결한다. */
				String path = "";
					
					/* 값을 한번에 담아서 넘길 리스트 생성 */
					ArrayList<RoomDTO> roomList = new ArrayList<RoomDTO>();
					
					/*객실추가 1*/
//					String roomName = request.getParameter("roomName");
//					int roomMax = Integer.parseInt(request.getParameter("roomMax"));
//					//객실사진받아오기
//					String roomIntro = request.getParameter("roomIntro");
//					int roomFee = Integer.parseInt(request.getParameter("roomFee"));
//					int peakFee = Integer.parseInt(request.getParameter("peakFee"));
					
					/*전달받은 값을 넣어줄 객체 선언*/
					RoomDTO roomDTO = new RoomDTO();
					
					roomDTO.setRoomName(parameter.get("roomName"));
					roomDTO.setRoomMax(Integer.parseInt(parameter.get("roomMax")));
					roomDTO.setRoomIntro(parameter.get("roomIntro"));
					roomDTO.setRoomFee(Integer.parseInt(parameter.get("roomFee")));
					roomDTO.setPeakFee(Integer.parseInt(parameter.get("peakFee")));
					
					roomList.add(roomDTO);
					
					/*객실추가 2*/
					if (!parameter.get("roomName2").isEmpty()) { //값이 입력되면 저장
						
//						String roomName2 = request.getParameter("roomName2");
//						int roomMax2 = Integer.parseInt(request.getParameter("roomMax2"));
//						//객실사진받아오기
//						String roomIntro2 = request.getParameter("roomIntro2");
//						int roomFee2 = Integer.parseInt(request.getParameter("roomFee2"));
//						int peakFee2 = Integer.parseInt(request.getParameter("peakFee2"));
						
						RoomDTO roomDTO2 = new RoomDTO();
						
						roomDTO2.setRoomName(parameter.get("roomName2"));
						roomDTO2.setRoomMax(Integer.parseInt(parameter.get("roomMax2")));
						roomDTO2.setRoomIntro(parameter.get("roomIntro2"));
						roomDTO2.setRoomFee(Integer.parseInt(parameter.get("roomFee2")));
						roomDTO2.setPeakFee(Integer.parseInt(parameter.get("peakFee2")));
						
						roomList.add(roomDTO2);
					}
					
					/*객실추가 3*/
					if (!parameter.get("roomName3").isEmpty()) {
						
//						String roomName3 = request.getParameter("roomName3");
//						int roomMax3 = Integer.parseInt(request.getParameter("roomMax3"));
//						//객실사진받아오기
//						String roomIntro3 = request.getParameter("roomIntro3");
//						int roomFee3 = Integer.parseInt(request.getParameter("roomFee3"));
//						int peakFee3 = Integer.parseInt(request.getParameter("peakFee3"));
						
						RoomDTO roomDTO3 = new RoomDTO();
						
						roomDTO3.setRoomName(parameter.get("roomName3"));
						roomDTO3.setRoomMax(Integer.parseInt(parameter.get("roomMax3")));
						roomDTO3.setRoomIntro(parameter.get("roomIntro3"));
						roomDTO3.setRoomFee(Integer.parseInt(parameter.get("roomFee3")));
						roomDTO3.setPeakFee(Integer.parseInt(parameter.get("peakFee3")));
						
						roomList.add(roomDTO3);
					}
					
					/*객실추가 4*/
					if (!parameter.get("roomName4").isEmpty()) {
						
//						String roomName4 = request.getParameter("roomName4");
//						int roomMax4 = Integer.parseInt(request.getParameter("roomMax4"));
//						//객실사진받아오기
//						String roomIntro4 = request.getParameter("roomIntro4");
//						int roomFee4 = Integer.parseInt(request.getParameter("roomFee4"));
//						int peakFee4 = Integer.parseInt(request.getParameter("peakFee4"));
						
						RoomDTO roomDTO4 = new RoomDTO();
						
						roomDTO4.setRoomName(parameter.get("roomName4"));
						roomDTO4.setRoomMax(Integer.parseInt(parameter.get("roomMax4")));
						roomDTO4.setRoomIntro(parameter.get("roomIntro4"));
						roomDTO4.setRoomFee(Integer.parseInt(parameter.get("roomFee4")));
						roomDTO4.setPeakFee(Integer.parseInt(parameter.get("peakFee4")));
						
						roomList.add(roomDTO4);
					}
					
					/*객실추가 5*/
					if (!parameter.get("roomName5").isEmpty()) {
						
//						String roomName5 = request.getParameter("roomName5");
//						int roomMax5 = Integer.parseInt(request.getParameter("roomMax5"));
//						//객실사진받아오기
//						String roomIntro5 = request.getParameter("roomIntro5");
//						int roomFee5 = Integer.parseInt(request.getParameter("roomFee5"));
//						int peakFee5 = Integer.parseInt(request.getParameter("peakFee5"));
						
						RoomDTO roomDTO5 = new RoomDTO();
						
						roomDTO5.setRoomName(parameter.get("roomName5"));
						roomDTO5.setRoomMax(Integer.parseInt(parameter.get("roomMax5")));
						roomDTO5.setRoomIntro(parameter.get("roomIntro5"));
						roomDTO5.setRoomFee(Integer.parseInt(parameter.get("roomFee5")));
						roomDTO5.setPeakFee(Integer.parseInt(parameter.get("peakFee5")));
						
						roomList.add(roomDTO5);
					}
					
					System.out.println("리스트 값 저장 확인 : " + roomList);
					// 방금 인서트 된 숙소 EN_ACCOMO_NO 값 조회해 오기
					RoomService roomServaice = new RoomService();
					// 객실 인서트(사진아님) 할때 넘겨줄 값
					
					
					
					/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
					 * 사진 여기서 인서트 */
					/* 서비스 메소드를 요청한다. */
					int result = new RoomService().insertThumbnail(thumbnail,roomList);
					
					
					/*값을 전달하기 위한 비지니스 로직 호출*/
					RoomService roomService = new RoomService();
					
					/*결과값 반환*/
					//int insertRoom = roomService.InsertRoomServlet(roomList,enAccoMoNoMax); //값을 int형으로 반환받아야 함
					
					//request.setAttribute("successCode", "insertThumbnail");
					/*메인페이지로 이동*/
					
					path = "/WEB-INF/views/owner/main/main.jsp";
					
					request.getRequestDispatcher(path).forward(request, response);
					
					
				
				
				
			} catch (Exception e) {
				//어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다.
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
					System.out.println("업로드에실패한 모든 사진 삭제 완료!");
				} else {
					e.printStackTrace();
				}
				
			} 

		}

	}

}
