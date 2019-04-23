package com.OuSoft.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义转换器，是最灵活的转换方式
 * @author Administrator
 *
 */
public class CustomDateFormateConverter implements Converter<String, Date> {
	@Override
	public Date convert(String source) {
		if(source !=null && !source.equals("")){
			SimpleDateFormat simpleDateFormat;
			try {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				return simpleDateFormat.parse(source);
			} catch (Exception e) {
				try {
					simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
					return simpleDateFormat.parse(source);
				} catch (Exception e2) {
					try {
						simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
						return simpleDateFormat.parse(source);
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		}
		return null;
	}

}
