package com.racing.model.repo;

import com.racing.model.mapper.MembersMapper;
import com.racing.model.po.Members;
import com.racing.model.po.MembersExample;
import com.racing.util.PageUtil;
import jodd.util.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MembersRepo {
    @Autowired
    MembersMapper mapper;

    public List<Members> select(Integer userId, String nickname, PageUtil pageUtil) {
        MembersExample example = new MembersExample();
        MembersExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
        if (StringUtil.isNotEmpty(nickname)) {
            criteria.andNickNameLike("%" + nickname + "%");
        }
        example.setOrderByClause(" id desc " + pageUtil.getLimit());
        List<Members> membersList = mapper.selectByExample(example);
        return membersList;
    }

    public Members getById(Integer id) {
        Members members = mapper.selectByPrimaryKey(id);
        return members;
    }

    public Members selectPoint(Integer userId, String wechatSn) {
        MembersExample example = new MembersExample();
        example.createCriteria().andUserIdEqualTo(userId).andWechatSnEqualTo(wechatSn);
        List<Members> list = this.mapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public int addMember(Members members) {
        return mapper.insert(members);
    }

    public int updateMember(Members members) {
        return mapper.updateByPrimaryKey(members);
    }
    
    public boolean updatePoints(Integer memberId, BigDecimal addPoints){
    	if(addPoints == null || addPoints.compareTo(BigDecimal.ZERO) == 0){
    		return true;
    	}
    	int i = mapper.updatePoints(memberId, addPoints);
    	if(i == 1){
    		return true;
    	}
    	return false;
    }
    
    public Members getByWechatSnAndUserId(String wechatSn, Integer userId){
    	MembersExample example = new MembersExample();
    	example.createCriteria().andUserIdEqualTo(userId).andWechatSnEqualTo(wechatSn);
    	List<Members> membersList = mapper.selectByExample(example);
    	if(CollectionUtils.isEmpty(membersList)){
    		return null;
    	}
    	return membersList.get(0);
    }
    
    public List<Members> getListByUserId(Integer userId){
    	MembersExample example = new MembersExample();
    	example.createCriteria().andUserIdEqualTo(userId);
    	return mapper.selectByExample(example);
    }
    
}
