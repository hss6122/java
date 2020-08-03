package com.mega.erp.service;

import java.util.List;

import com.mega.erp.dto.BbsDTO;

public interface BbsService {

	public void BbsWrite(BbsDTO bbsDTO) throws Exception;
	public List<BbsDTO> BbsList() throws Exception;
	public BbsDTO BContent(BbsDTO bbsDTO) throws Exception; //단일 항목
	public void BbsModify(BbsDTO bbsDTO) throws Exception;
	public void BbsDelete(BbsDTO bbsDTO) throws Exception;
	public BbsDTO BbsReplyView(BbsDTO bbsDTO) throws Exception;
	public void BbsReply(BbsDTO bbsDTO)throws Exception;
}	
