package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoExistsException;
import xyz.itwill10.exception.UserinfoNotFoundException;

public interface UserinfoService {
	void addUserinfo(Userinfo userinfo) throws UserinfoExistsException;
	void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException;
	void removeUserinfo(String userid) throws UserinfoNotFoundException;
	Userinfo getUserinfo(String userid) throws UserinfoNotFoundException;
	List<Userinfo> getUserinfoList();
	void loginAuth(Userinfo userinfo) throws LoginAuthFailException;
}
