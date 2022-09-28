package com.sseda.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sseda.dao.QnaDao;
import com.sseda.dto.Qna;
import com.sseda.dto.Question;
import com.sseda.dto.QuestionFile;

public class QnaServiceimp implements QnaService {
	private QnaDao dao = new QnaDao();
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		DiskFileItemFactory f = new DiskFileItemFactory();
		f.setDefaultCharset("utf-8");
		ServletFileUpload u = new ServletFileUpload(f);
		Question q = new Question();
		
		try {
			List<FileItem> i = u.parseRequest(req);
			for(FileItem item : i) {
				if(item.isFormField()) {
					if(item.getFieldName().equals("sel")) {
						q.setCategory(item.getString());
					}
					if(item.getFieldName().equals("title")) {
						q.setTitle(item.getString());
					}
					if(item.getFieldName().equals("content")) {
						q.setContent(item.getString());
					}
					if(item.getFieldName().equals("id")) {
						q.setId(item.getString());
					}
				}else {
					long l = item.getSize();
					if(l > 0) {
						String filepath = "d:/sseda/upload/";
						String filename = item.getName();
						
						String s_filename = filename.substring(0,(filename.indexOf(".")));
						String s_exe = filename.substring(filename.lastIndexOf(".")+1);
						
						UUID uid = UUID.randomUUID();
						String savefilename = s_filename + "_" + uid + "." + s_exe;
						String filetype = item.getContentType();
						
						File file = new File(filepath + filename);
						item.write(file);
						String filesize = String.valueOf(l);
						QuestionFile qfile = new QuestionFile();
						qfile.setFilename(filename);
						qfile.setFilepath(filepath);
						qfile.setSavefile(savefilename);
						qfile.setFilesize(filesize);
						qfile.setFiletype(filetype);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.inset(q);
	}
	public Map<String,List<Qna>> qna() {
		return dao.qna();
	}
	public String[] detail(String no) {
		return dao.detail(no);
	}
	public List<Question> mylist(HttpServletRequest req) {
		return dao.mylist(req);
	}
	public Qna question(HttpServletRequest req) {
		return dao.question(req);
	}

}
