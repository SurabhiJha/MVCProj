package com.scb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.scb.bean.Mybean1;
import com.scb.dao.Mydao;

@Service
public class MyService {
	@Autowired
	private Mydao mydao;
	public int validate(Mybean1 mb)
	{
		return mydao.validate(mb);
	}
	
	
	public List<Mybean1> select(Mybean1 mb)
	{
		return mydao.select(mb);
	}
	
	public List<Mybean1> showdetails(Mybean1 mb)
	{
		return mydao.showall(mb);
	}


	public List<Mybean1> getName(Mybean1 mb) {
		// TODO Auto-generated method stub
		return mydao.getNameFromDatabase(mb);
	}


	public List<Mybean1> showLoandetails(Mybean1 mb) {
		// TODO Auto-generated method stub
		return mydao.getLoanFromDatabase(mb);
	}


	public List<Mybean1> showMinidetails(Mybean1 mb) {
		// TODO Auto-generated method stub
		return mydao.getMiniStatFromDatabase(mb);
	}


	public List<Mybean1> showMicrodetails(Mybean1 mb) {
		// TODO Auto-generated method stub
		return mydao.getMicroFromDatabase(mb);
	}

}
