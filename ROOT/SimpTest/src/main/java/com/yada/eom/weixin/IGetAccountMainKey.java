package com.yada.eom.weixin;

import java.util.List;

import com.yada.eom.weixin.model.Accuont;


/**
 * �ɿ��Ų�ѯ�ʻ�������ֵ
 * 
 * @author jiangfengming
 * 
 */
public interface IGetAccountMainKey {
	public List<Accuont> get(String accNo);
}
