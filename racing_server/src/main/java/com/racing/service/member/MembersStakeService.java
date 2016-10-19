package com.racing.service.member;

import com.racing.controller.vo.ApiResult;
import com.racing.controller.vo.MembersStakeClientVO;
import com.racing.model.po.MemberStake;
import com.racing.model.po.Members;
import com.racing.model.repo.MembersRepo;
import com.racing.model.repo.MembersStakeRepo;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersStakeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MembersStakeService.class);

    @Autowired
    MembersStakeRepo membersStakeRepo;
    @Autowired
    MembersRepo membersRepo;


    public Object selectByWechatSn(Integer userId, List<String> wechatSns, String racingNum) {
    	LOGGER.info("userId is : {}", userId);
    	LOGGER.info("racingNum is : {}", racingNum);
        List<MembersStakeClientVO> voList=new ArrayList<>();
        List<Members> membersList=new ArrayList<>();
        wechatSns.stream()
            .forEach(a -> {
            	LOGGER.info("wechatSns is : {}", a);
                Members members = membersRepo.getByWechatSnAndUserId(a, userId);
                membersList.add(members);
            });
        if(CollectionUtils.isNotEmpty(membersList)){
        	membersList.stream()
        	.forEach(a->{
        		MemberStake memberStake=membersStakeRepo.selectByMembersIdAndTacingNum(a.getId(),racingNum);
        		if(memberStake!=null){
        			MembersStakeClientVO vo=new MembersStakeClientVO();
        			vo.setMembers(a);
        			vo.setMemberStake(memberStake);
        			voList.add(vo);
        		}
        	});
        }
        return ApiResult.createSuccessReuslt(voList);
    }


}
