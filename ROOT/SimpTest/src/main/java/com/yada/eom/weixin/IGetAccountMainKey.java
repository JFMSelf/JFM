package com.yada.eom.weixin;

import java.util.List;

import com.yada.eom.weixin.model.Accuont;


/**
 * 由卡号查询帐户主键等值
 * 
 * @author jiangfengming
 * 
 */
public interface IGetAccountMainKey {
	public List<Accuont> get(String accNo);
}
