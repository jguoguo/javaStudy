package com.bjpowernode.struts2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.Action;

public class UploadTestAction {

	private String title;
	//可以得到上传文件的名称
	//规则：输入域的名称+固定字符串FileName
	private String myFileFileName;
	
	//取得文件数据
	//股则：File 输入域名称
	private File myFile;
	//取得文件类型
	//规格：输入域的名称+固定字符串ContentType
	private String myFileContentType;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public File getMyFile() {
		return myFile;
	}


	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}


	public String getMyFileContentType() {
		return myFileContentType;
	}


	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}


	public String getMyFileFileName() {
		return myFileFileName;
	}


	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}


	public String execute() throws Exception{
		InputStream is=null;
		OutputStream os=null;
		try{
			is=new BufferedInputStream(new FileInputStream(myFile));
			os=new BufferedOutputStream(new FileOutputStream("c:\\"+myFileFileName));
			byte[] buffer=new byte[1024];
			int len=0;
			while((len=is.read(buffer))>0){
				os.write(buffer,0,len);
			}
		}finally{
			if(is!=null){
				is.close();
			}
			if(os!=null){
				os.close();
			}
		}
		return Action.SUCCESS;
	}
}
