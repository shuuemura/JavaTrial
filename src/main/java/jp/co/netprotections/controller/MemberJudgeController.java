package jp.co.netprotections.controller;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.dto.MemberJudgeResultDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//APIのControllerを定義
//Beanを定義する
@RequestMapping("/api")
//URLで「/api」に対して、HTTPのメソッドに関わらず、MemberJudgeAPIControllerクラスで実行する
public class MemberJudgeController {

	// URLで「/api/judge」とPOSTメソッドで、judgeメソッドを実行する
	@PostMapping("/judge")
	public MemberJudgeResponseDto judge(@RequestBody List<MemberJudgeRequestDto> requestList){
		MemberJudgeResponseDto response = new MemberJudgeResponseDto();
		response.setJudgedCandidatesResultList(new ArrayList<>());
		for(int i = 0; i < requestList.size(); i ++) {
			MemberJudgeRequestDto request = requestList.get(i);
			MemberJudgeResultDto result = new MemberJudgeResultDto();
			result.setMemberName(request.getMemberName());
			if(request.getEventPlanning() <= 1 || request.getCogitation() <= 1 ||request.getCoordination() <= 1) {
				result.setEnlistedPropriety(false);
	  		}else if(request.getEventPlanning()+request.getCogitation()+request.getCoordination()+request.getProgrammingAbility()+request.getInfrastructureKnowledge() <= 10) {
		  		result.setEnlistedPropriety(false);
		  	}else{
		  		result.setEnlistedPropriety(true);
		  	}
			response.getJudgedCandidatesResultList().add(result);
		}
		return response;
	}
}