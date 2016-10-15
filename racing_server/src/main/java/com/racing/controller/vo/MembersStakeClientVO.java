package com.racing.controller.vo;

import com.racing.model.po.MemberStake;
import com.racing.model.po.Members;

public class MembersStakeClientVO {
    private Members members;
    private MemberStake memberStake;

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public MemberStake getMemberStake() {
        return memberStake;
    }

    public void setMemberStake(MemberStake memberStake) {
        this.memberStake = memberStake;
    }
}
