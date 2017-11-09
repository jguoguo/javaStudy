package org.dragon.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.io.IOUtils;
import org.dragon.hadoop.hdfs.utils.HDFSUtils;
import org.junit.Test;

public class HDFSFsTest {
	//��ȡ�ļ�����
	
	@Test
	public void testRead() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//�ļ�����
		Path path=new Path("/opt/data/test/01.data");
		//���ļ�������---open()
		FSDataInputStream inStream=hdfs.open(path);
		//��ȡ�ļ����ݵ�����̨��ʾ---read()
		IOUtils.copyBytes(inStream, System.out, 4096,false);
		//�ر���---close()
		IOUtils.closeStream(inStream);
	}
	
	//�鿴Ŀ¼
	@Test
	public void testList() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//Ŀ¼
		Path path=new Path("/opt/data/");
		FileStatus[] fileStatus=hdfs.listStatus(path);
		for(FileStatus fs:fileStatus){
			Path p=fs.getPath();
			String info=fs.isDir()?"Ŀ¼":"�ļ�";
			System.out.println(info+":"+p);
		}
	}
	
	//����Ŀ¼
	@Test
	public void testDirectory() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//Ŀ¼
		Path path=new Path("/opt/data/dir1");
		boolean isSuccess=hdfs.mkdirs(path);
		String info=isSuccess?"�ɹ�":"ʧ��";
		System.out.println("����Ŀ¼��"+path+"��"+info);	
	}
	
	//�ϴ��ļ�
	@Test
	public void testPut() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//�����ļ���Ŀ¼+�ļ����ƣ�
		Path srcPath=new Path("c:/0125.log");
		//HDFS�ļ��ϴ�·��
		Path dstPath=new Path("/opt/data/test");
		//�ļ��ϴ�
		hdfs.copyFromLocalFile(srcPath, dstPath);
	}
	
	//����HDFS�ļ�����д������
	@Test
	public void testCreate() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		
		Path path=new Path("/opt/data/dir/touch.data");
		//�����ļ�����ȡ�����
		FSDataOutputStream fsDataOutputStream=hdfs.create(path);
		//ͨ�������д������
		fsDataOutputStream.writeUTF("Hello Hadoop!");
		
		fsDataOutputStream.close();
	}
	
	//��HDFS���ļ�����������
	@Test
	public void testRename() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();

		Path srcpath=new Path("/opt/data/test/01.data");
		Path destpath=new Path("/opt/data/test/02.data");
		boolean flag=hdfs.rename(srcpath, destpath);
		System.out.print(flag);
	}
	
	//ɾ���ļ�
	@Test
	public void testDelete() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		Path srcpath=new Path("/opt/data/test/0125.log");
		boolean flag=hdfs.deleteOnExit(srcpath);
		System.out.print(flag);
	}
	
	//����ĳ���ļ���HDFS��Ⱥ��λ��
	@Test
	public void testLocation() throws Exception{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//�ļ�����
		Path path=new Path("/opt/data/test/02.data");
		FileStatus fileStatus=hdfs.getFileStatus(path);
		
		BlockLocation[] blockLocations=hdfs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
		
		for(BlockLocation blockLocation:blockLocations){
			String[] hosts=blockLocation.getHosts();
			for(String host:hosts){
				System.out.println(host);
			}
		}
	}
	
	//��ȡHDFS��Ⱥ�����нڵ���Ϣ
	@Test
	public void testCluster() throws IOException{
		//��ȡ�ļ�ϵͳ
		FileSystem hdfs=HDFSUtils.getFileSystem();
		DistributedFileSystem distributedFileSystem=(DistributedFileSystem)hdfs;
		DatanodeInfo[] datanodeInfos=distributedFileSystem.getDataNodeStats();
		for(DatanodeInfo datanodeInfo:datanodeInfos){
			String hostName=datanodeInfo.getHostName();
			System.out.println(hostName);
		}
	}
}
