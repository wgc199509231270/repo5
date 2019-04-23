package com.OuSoft.system.service.hssfworkbook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OuSoft.system.dao.hssfworkbook.HssfworkbookDao;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.hssfworkbook.hssfworkbookService;

@Service
public class HssfworkbookImplService implements hssfworkbookService{

	@Autowired HssfworkbookDao dao;

	@Override
	public List<Tsuser> queryTsuserService() {
		List<Tsuser> list = null;
		list = dao.queryTsuserDao();
		// TODO Auto-generated method stub
		return list;
	}
	
	
	
	
	
	
	
	
}
