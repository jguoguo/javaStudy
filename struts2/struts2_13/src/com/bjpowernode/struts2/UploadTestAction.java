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
	//���Եõ��ϴ��ļ�������
	//���������������+�̶��ַ���FileName
	private String myFileFileName;
	
	//ȡ���ļ�����
	//����File ����������
	private File myFile;
	//ȡ���ļ�����
	//��������������+�̶��ַ���ContentType
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
