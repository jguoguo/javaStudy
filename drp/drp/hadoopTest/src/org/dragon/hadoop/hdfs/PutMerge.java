package org.dragon.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * 功能：在向HDFS上传复制文件的过程中，进行合并文件
 * @author Administrator
 *
 */
public class PutMerge {
	
	/**
	 * 复制上传文件，并将文件合并
	 * @param localDir 本地要上传的文件目录
	 * @param hdfsFile HDFS上的文件名称，包括路径
	 */
	public static void put(String localDir,String hdfsFile){
		//1）获取配置信息
		Configuration conf=new Configuration();
		
		//本地路径
		Path localPath=new Path(localDir);
		//HDFS路径
		Path hdfsPath=new Path(hdfsFile);
		
		try{
			//获取本地文件系统
			FileSystem localFs=FileSystem.getLocal(conf);
			//获取HDFS
			FileSystem hdfs=FileSystem.get(conf);
			
			//本地文件系统中指定目录中的所有文件
			FileStatus[] status=localFs.listStatus(localPath);
			
			//打开HDFS上文件的输出流
			FSDataOutputStream fsDataOutputStream=hdfs.create(hdfsPath);
			//循环遍历
			for(FileStatus filestatus:status){
				//获取文件
				Path path=filestatus.getPath();
				System.out.println("文件为："+path.getName());
				//打开文件输入流
				FSDataInputStream fsDataInputStream=localFs.open(path); 
				
				//进行流的读写操作
				byte[] buffer=new byte[1024];
				int len=0;
				while((len=fsDataInputStream.read(buffer))>0){
					fsDataOutputStream.write(buffer);
				}
				//关闭每个文件输入流
				fsDataInputStream.close();
			}
			//关闭输出流
			fsDataOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		String localDir="d:/logs";
		String hdfsFile="hdfs://hadoop-master.dragon.org:9000/opt/data/test/logs.data";
		put(localDir,hdfsFile);
	}
}
