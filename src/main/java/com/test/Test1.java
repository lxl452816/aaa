package com.test;


public class Test1 implements Runnable{
	public static int product;
	public static final int MAX_PRODUCT=10;
	public static final int MIN_PRODUCT=0;
	/**
	   * ���������������Ĳ�Ʒ������Ա
	   */
	  public synchronized void produce()
	  {
	      if(this.product >= MAX_PRODUCT)
	      {
	          try
	          {
	              wait();  
	              System.out.println("��Ʒ����,���Ժ�������");
	          }
	          catch(InterruptedException e)
	          {
	              e.printStackTrace();
	          }
	          return;
	      }

	      this.product++;
	      System.out.println("������������" + this.product + "����Ʒ.");
	      notifyAll();   //֪ͨ�ȴ����������߿���ȡ����Ʒ��
	  }

	  /**
	   * �����ߴӵ�Աȡ��Ʒ
	   */
	  public synchronized void consume()
	  {
	      if(this.product <= MIN_PRODUCT)
	      {
	          try 
	          {
	              wait(); 
	              System.out.println("ȱ��,�Ժ���ȡ");
	          } 
	          catch (InterruptedException e) 
	          {
	              e.printStackTrace();
	          }
	          return;
	      }

	      System.out.println("������ȡ���˵�" + this.product + "����Ʒ.");
	      this.product--;
	      notifyAll();   //֪ͨ�ȴ�ȥ�������߿���������Ʒ��
	  }
	  
	  public void run() {
		  produce();
		  consume();
		  
	  }
	  public static void main(String[] args) {
		  Thread thread=new Thread("ason");
		  Thread thread1=new Thread("jean");
		  thread.start();
		  thread1.start();
	}
	  
}
