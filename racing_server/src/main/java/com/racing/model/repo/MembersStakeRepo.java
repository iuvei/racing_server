package com.racing.model.repo;

import com.racing.model.po.*;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racing.model.mapper.MemberStakeMapper;

import java.util.Date;
import java.util.List;

@Repository
public class MembersStakeRepo {

    @Autowired
    private MemberStakeMapper mapper;


    public MemberStake addNew(MemberStakeWithBLOBs memberStake) {
        memberStake.setCreateTime(new Date());
        mapper.insertSelective(memberStake);
        return memberStake;
    }

    public MemberStake selectByMembersIdAndTacingNum(Integer membersId, String racingNum) {
        MemberStakeExample example = new MemberStakeExample();
        example.createCriteria().andMembersIdEqualTo(membersId).andRacingNumEqualTo(racingNum);
        List<MemberStake> list = this.mapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public MemberStakeWithBLOBs getStakeInfoByMembersIdAndTacingNum(Integer membersId, String racingNum) {
        MemberStakeExample example = new MemberStakeExample();
        example.createCriteria().andMembersIdEqualTo(membersId).andRacingNumEqualTo(racingNum);
        List<MemberStakeWithBLOBs> list = this.mapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public void updateIncome(MemberStakeWithBLOBs record) {
        mapper.updateIncome(record);
    }
    public void updateStake(MemberStakeWithBLOBs record) {
    	mapper.updateStake(record);
    }

    public List<MemberStake> getStakeInfoByMembersIdAndDateAndRacingNum(Integer membersId,
                                                                        Date sDate, Date eDate,
                                                                        String racingNum, PageUtil pageUtil) {
        MemberStakeExample example = new MemberStakeExample();
        MemberStakeExample.Criteria criteria = example.createCriteria().andMembersIdEqualTo(membersId);
        if (sDate != null && eDate != null) {
            criteria.andCreateTimeBetween(sDate, eDate);
        }
        if (StringUtil.isNotEmpty(racingNum)) {
            criteria.andRacingNumEqualTo(racingNum);
        }
        example.setOrderByClause(" id desc " + pageUtil.getLimit());
        List<MemberStake> list = this.mapper.selectByExample(example);
        return list;
    }

    public int getCountByMembersIdAndDateAndRacingNum(Integer membersId, Date sDate, Date eDate, String racingNum) {
        MemberStakeExample example = new MemberStakeExample();
        MemberStakeExample.Criteria criteria = example.createCriteria().andMembersIdEqualTo(membersId);
        if (sDate != null && eDate != null) {
            criteria.andCreateTimeBetween(sDate, eDate);
        }
        if (StringUtil.isNotEmpty(racingNum)) {
            criteria.andRacingNumEqualTo(racingNum);
        }
        return this.mapper.countByExample(example);
    }

    public int delete(Integer membersId) {
        MemberStakeExample example = new MemberStakeExample();
        example.createCriteria().andMembersIdEqualTo(membersId);
        return mapper.deleteByExample(example);
    }
}
