package com.test;

public class SL13_1 implements Runnable{

	/**   
	 * @��������					:	main---->SL12.java  	
	 * @����						:	
	 * @author					:	Moffter
	 * @������˾					:		
	 * @COPYRIGHT				:	copyright(c) 2018,Rights Reserved
	 * @��������					:	2018-3-20 ����9:34:44  
	 * @param args
	 */
	private int count=10;//ʣ��Ʊ��
	private int num=0;//�ڼ���Ʊ
	private boolean flag=false;//��¼�Ƿ�����
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
					Thread.sleep(500);//�ӳ�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName()+"������"+num+"��Ʊ��ʣ��"+count+"��Ʊ��");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SL12 s=new SL12();
		Thread person1=new Thread(s,"Я����");
		Thread person2=new Thread(s,"��ţ��");
		Thread person3=new Thread(s,"ͬ�̹�");
		person1.start();
		person2.start();
		person3.start();
	}
}

