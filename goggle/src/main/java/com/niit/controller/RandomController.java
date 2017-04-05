package com.niit.controller;

import java.util.Random;

public class RandomController {

	public static int randomNumberGeneration(){
		int min,max;
		min=1;
		max=9;
		Random ran=new Random();
		int value=ran.nextInt((max-min)+1)+min;
		return value;
	}
	 public static int randomNumforThumbnails(){
		 int min,max;
		 min=1;
		 max=11;
		 Random random=new Random();
		 int num=random.nextInt((max-min)+1)+min;
		 return num;
	 }
}
