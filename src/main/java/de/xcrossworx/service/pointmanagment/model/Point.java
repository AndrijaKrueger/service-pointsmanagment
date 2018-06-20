package de.xcrossworx.service.pointmanagment.model;

import de.xcrossworx.service.pointmanagment.model.enums.HitType;

import javax.persistence.*;

@Entity
@Table(name = "Points")
@NamedQueries({@NamedQuery(name = "Point.findAll", query = "select e from Point e")})
public class Point extends BaseEntity {

    private int userId;

    private String userName;

    private int arrowHit;

    @Enumerated(EnumType.STRING)
    private HitType hitType;

    private int points;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getArrowHit() {
        return arrowHit;
    }

    public void setArrowHit(int arrowHit) {
        this.arrowHit = arrowHit;
    }

    public HitType getHitType() {
        return hitType;
    }

    public void setHitType(HitType hitType) {
        this.hitType = hitType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void calculatePoints() {
        switch (hitType) {
            case None:
                points = arrowHit;
                break;
            case Rodney:
                arrowHit = 0;
                points = 0;
                break;
            case Double:
                points = arrowHit * 2;
                break;
            case Triple:
                points = arrowHit * 3;
                break;
            case BullsEye:
                points = 25;
                break;
            case DoubleBullsEye:
                points = 50;
                break;
        }
    }
}
