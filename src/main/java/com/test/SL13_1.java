package com.test;

public class SL13_1 implements Runnable{

	/**   
	 * @方法名称					:	main---->SL12.java  	
	 * @描述						:	
	 * @author					:	Moffter
	 * @开发公司					:		
	 * @COPYRIGHT				:	copyright(c) 2018,Rights Reserved
	 * @创建日期					:	2018-3-20 下午9:34:44  
	 * @param args
	 */
	private int count=10;//剩余票数
	private int num=0;//第几张票
	private boolean flag=false;//记录是否售完
	public void run() {
		// TODO Auto-generated method stub
		while(!flag){
			synchronized (this){
				if(count<=0){
					flag=true;
					return;
				}
				num++;
				count--;
				try {
					Thread.sleep(500);//延迟
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName()+"抢到第"+num+"张票，剩余"+count+"张票！");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SL12 s=new SL12();
		Thread person1=new Thread(s,"携程猪");
		Thread person2=new Thread(s,"黄牛党");
		Thread person3=new Thread(s,"同程狗");
		person1.start();
		person2.start();
		person3.start();
	}
}

