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
	//读取文件内容
	
	@Test
	public void testRead() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//文件名称
		Path path=new Path("/opt/data/test/01.data");
		//打开文件输入流---open()
		FSDataInputStream inStream=hdfs.open(path);
		//读取文件内容到控制台显示---read()
		IOUtils.copyBytes(inStream, System.out, 4096,false);
		//关闭流---close()
		IOUtils.closeStream(inStream);
	}
	
	//查看目录
	@Test
	public void testList() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//目录
		Path path=new Path("/opt/data/");
		FileStatus[] fileStatus=hdfs.listStatus(path);
		for(FileStatus fs:fileStatus){
			Path p=fs.getPath();
			String info=fs.isDir()?"目录":"文件";
			System.out.println(info+":"+p);
		}
	}
	
	//创建目录
	@Test
	public void testDirectory() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//目录
		Path path=new Path("/opt/data/dir1");
		boolean isSuccess=hdfs.mkdirs(path);
		String info=isSuccess?"成功":"失败";
		System.out.println("创建目录【"+path+"】"+info);	
	}
	
	//上传文件
	@Test
	public void testPut() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//本地文件（目录+文件名称）
		Path srcPath=new Path("c:/0125.log");
		//HDFS文件上传路径
		Path dstPath=new Path("/opt/data/test");
		//文件上传
		hdfs.copyFromLocalFile(srcPath, dstPath);
	}
	
	//创建HDFS文件，并写入内容
	@Test
	public void testCreate() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		
		Path path=new Path("/opt/data/dir/touch.data");
		//创建文件并获取输出流
		FSDataOutputStream fsDataOutputStream=hdfs.create(path);
		//通过输出流写入数据
		fsDataOutputStream.writeUTF("Hello Hadoop!");
		
		fsDataOutputStream.close();
	}
	
	//对HDFS上文件进行重命名
	@Test
	public void testRename() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();

		Path srcpath=new Path("/opt/data/test/01.data");
		Path destpath=new Path("/opt/data/test/02.data");
		boolean flag=hdfs.rename(srcpath, destpath);
		System.out.print(flag);
	}
	
	//删除文件
	@Test
	public void testDelete() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		Path srcpath=new Path("/opt/data/test/0125.log");
		boolean flag=hdfs.deleteOnExit(srcpath);
		System.out.print(flag);
	}
	
	//查找某个文件在HDFS集群的位置
	@Test
	public void testLocation() throws Exception{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		//文件名称
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
	
	//获取HDFS集群上所有节点信息
	@Test
	public void testCluster() throws IOException{
		//获取文件系统
		FileSystem hdfs=HDFSUtils.getFileSystem();
		DistributedFileSystem distributedFileSystem=(DistributedFileSystem)hdfs;
		DatanodeInfo[] datanodeInfos=distributedFileSystem.getDataNodeStats();
		for(DatanodeInfo datanodeInfo:datanodeInfos){
			String hostName=datanodeInfo.getHostName();
			System.out.println(hostName);
		}
	}
}
