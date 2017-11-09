package org.dragon.hadoop.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * MapReduce 初级案例：wordCount程序
 * Created by Administrator on 2016/3/4.
 */
public class MyWordCount {

    //Mapper区域

    /**
     * KEYIN,      VALUEIN,     KEYOUT,     VALUEOUT
     *   |             |           |            |
     * 输入key类型 输入value类型 输出key类型 输出value类型
     */

    /**
     * WordCount 程序Map类
     * 输入是文本
     */
    static class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
        private final static IntWritable one=new IntWritable(1);
        private Text word=new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            //获取每行数据的值
            String lineValue=value.toString();
            //进行分割
            StringTokenizer stringTokenizer=new StringTokenizer(lineValue);
            //遍历
            while (stringTokenizer.hasMoreTokens()){
                //获取每个值
                String wordValue=stringTokenizer.nextToken();

                //设置map输出的key值
                word.set(wordValue);
                //上下文输出map的key和value
                context.write(word,one);
            }
        }
    }

    //Reducer区域

    /**
     * KEYIN,      VALUEIN,     KEYOUT,     VALUEOUT
     *   |             |           |            |
     * 输入key类型 输入value类型 输出key类型 输出value类型
     */
    /**
     * WordCount 程序reduce类
     */
    static class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
        private IntWritable result=new IntWritable();
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

            //用于累加
            int sum=0;
            //循环遍历InWritable
            for(IntWritable value:values){
                //累加
                sum+=value.get();
            }

            //设置总次数
            result.set(sum);
            context.write(key,result);
        }
    }

    //Client区域
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //获取配置信息
        Configuration configuration=new Configuration();
        
        String[] otherArgs=new GenericOptionsParser(configuration,args).getRemainingArgs();
        if(otherArgs.length!=2){
        	System.err.println("Usage: wordcount<in><out>");
        	System.exit(2);
        }
        
        //创建job,设置配置和Job名称
        Job job=new Job(configuration,"wc");

        //1：设置Job运行的类
        job.setJarByClass(MyWordCount.class);

        //2：设置Mapper和Reducer类
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        //3：设置输入文件的目录和输出文件的目录

        FileInputFormat.addInputPath(job,new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[1]));
        //4：设置输出结果的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //5：提交Job,等待运行结果，并在客户端显示运行信息
        boolean isSuccess=job.waitForCompletion(true);
        //结束 程序
        System.exit(isSuccess?0:1);
    }

}
