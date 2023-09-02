package io.microservice.userservice.entities.Model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Calander {

    public long id;
    public String title;
    public String url;
    @Temporal(TemporalType.DATE)
    public Date start;
    @Temporal(TemporalType.DATE)
    public Date end;
}
