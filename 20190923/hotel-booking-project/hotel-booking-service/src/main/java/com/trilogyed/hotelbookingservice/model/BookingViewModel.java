package com.trilogyed.hotelbookingservice.model;

import java.util.Objects;

public class BookingViewModel {
    private Integer roomId;
    private Boolean rewardsMember;
    private Boolean doubleBonusDay;
    private Float baseRate;
    private Float memberDiscount;
    private Integer baseRewardsPoints;
    private Boolean canDouble;
    private Float finalCost;
    private Integer totalRewardsPoints;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Boolean getRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(Boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public Boolean getDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(Boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    public Float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Float baseRate) {
        this.baseRate = baseRate;
    }

    public Float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(Float memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public Integer getBaseRewardsPoints() {
        return baseRewardsPoints;
    }

    public void setBaseRewardsPoints(Integer baseRewardsPoints) {
        this.baseRewardsPoints = baseRewardsPoints;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }

    public Float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Float finalCost) {
        this.finalCost = finalCost;
    }

    public Integer getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public void setTotalRewardsPoints(Integer totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingViewModel that = (BookingViewModel) o;
        return getRoomId().equals(that.getRoomId()) &&
                getRewardsMember().equals(that.getRewardsMember()) &&
                getDoubleBonusDay().equals(that.getDoubleBonusDay()) &&
                getBaseRate().equals(that.getBaseRate()) &&
                getMemberDiscount().equals(that.getMemberDiscount()) &&
                getBaseRewardsPoints().equals(that.getBaseRewardsPoints()) &&
                getCanDouble().equals(that.getCanDouble()) &&
                getFinalCost().equals(that.getFinalCost()) &&
                getTotalRewardsPoints().equals(that.getTotalRewardsPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomId(), getRewardsMember(), getDoubleBonusDay(), getBaseRate(), getMemberDiscount(), getBaseRewardsPoints(), getCanDouble(), getFinalCost(), getTotalRewardsPoints());
    }


}
