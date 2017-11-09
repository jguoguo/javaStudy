package org.dragon.hadoop.hdfs.utils;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * HDFS工具类
 *
 */
public class HDFSUtils {
	public static FileSystem getFileSystem(){
//		String pathString = "hdfs://hadoop-master.dragon.org:9000";  
//        URI pathURI = URI.create(pathString);
		//获取配置文件信息
		
		//声明FileSystem
		FileSystem hdfs=null;
		try{
			
			//获取配置文件信息
			Configuration conf=new Configuration();
			//获取文件系统
			hdfs=FileSystem.get(conf);
//			hdfs=FileSystem.get(pathURI,conf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hdfs;
	}
}
