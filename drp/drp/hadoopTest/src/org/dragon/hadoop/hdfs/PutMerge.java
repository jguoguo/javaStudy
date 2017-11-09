package org.dragon.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * ���ܣ�����HDFS�ϴ������ļ��Ĺ����У����кϲ��ļ�
 * @author Administrator
 *
 */
public class PutMerge {
	
	/**
	 * �����ϴ��ļ��������ļ��ϲ�
	 * @param localDir ����Ҫ�ϴ����ļ�Ŀ¼
	 * @param hdfsFile HDFS�ϵ��ļ����ƣ�����·��
	 */
	public static void put(String localDir,String hdfsFile){
		//1����ȡ������Ϣ
		Configuration conf=new Configuration();
		
		//����·��
		Path localPath=new Path(localDir);
		//HDFS·��
		Path hdfsPath=new Path(hdfsFile);
		
		try{
			//��ȡ�����ļ�ϵͳ
			FileSystem localFs=FileSystem.getLocal(conf);
			//��ȡHDFS
			FileSystem hdfs=FileSystem.get(conf);
			
			//�����ļ�ϵͳ��ָ��Ŀ¼�е������ļ�
			FileStatus[] status=localFs.listStatus(localPath);
			
			//��HDFS���ļ��������
			FSDataOutputStream fsDataOutputStream=hdfs.create(hdfsPath);
			//ѭ������
			for(FileStatus filestatus:status){
				//��ȡ�ļ�
				Path path=filestatus.getPath();
				System.out.println("�ļ�Ϊ��"+path.getName());
				//���ļ�������
				FSDataInputStream fsDataInputStream=localFs.open(path); 
				
				//�������Ķ�д����
				byte[] buffer=new byte[1024];
				int len=0;
				while((len=fsDataInputStream.read(buffer))>0){
					fsDataOutputStream.write(buffer);
				}
				//�ر�ÿ���ļ�������
				fsDataInputStream.close();
			}
			//�ر������
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
