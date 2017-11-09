package org.dragon.hadoop.hdfs.utils;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * HDFS������
 *
 */
public class HDFSUtils {
	public static FileSystem getFileSystem(){
//		String pathString = "hdfs://hadoop-master.dragon.org:9000";  
//        URI pathURI = URI.create(pathString);
		//��ȡ�����ļ���Ϣ
		
		//����FileSystem
		FileSystem hdfs=null;
		try{
			
			//��ȡ�����ļ���Ϣ
			Configuration conf=new Configuration();
			//��ȡ�ļ�ϵͳ
			hdfs=FileSystem.get(conf);
//			hdfs=FileSystem.get(pathURI,conf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hdfs;
	}
}
