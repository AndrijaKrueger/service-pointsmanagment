package de.xcrossworx.service.pointmanagment.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Statistics")
@NamedQueries({@NamedQuery(name = "Point.findAll", query = "select e from StatisticData e")})
public class StatisticData extends BaseEntity{

    private int userId;

    private String userName;

    private int arrows;

    private int rodneies;

}
