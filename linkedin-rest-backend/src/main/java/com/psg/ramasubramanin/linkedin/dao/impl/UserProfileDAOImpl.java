package com.psg.ramasubramanin.linkedin.dao.impl;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.exceptions.DriverException;
import com.google.gson.Gson;
import com.psg.ramasubramanin.linkedin.dao.UserProfileDAO;
import com.psg.ramasubramanin.linkedin.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.RowMapper;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class UserProfileDAOImpl implements UserProfileDAO {

    private CassandraOperations cassandraOperations;
    private Gson gson;

    @Autowired
    public UserProfileDAOImpl(CassandraOperations cassandraTemplate) {
        this.cassandraOperations = cassandraTemplate;
        this.gson = new Gson();
    }

    @Override
    public UserProfile findById(Integer id) {
        String query = "SELECT * FROM user_profile WHERE id = " + id;
        List<UserProfile> userProfileList = cassandraOperations.query(query, new UserProfileRowMapper());
        return userProfileList.get(0);
    }

}
class UserProfileRowMapper implements RowMapper<UserProfile> {
    @Override
    public UserProfile mapRow(Row row, int i) throws DriverException {
        if(i > 0)
            return null;
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(row.getUUID("id"));
        userProfile.setAbout(row.getString("about"));
        userProfile.setEmail(row.getString("email"));
        LocalDate localDate = row.getDate("dob");
        userProfile.setBirthDate(new Date(localDate.getYear(), localDate.getMonth(), localDate.getDay()));
        userProfile.setFirstname(row.getString("firstname"));
        userProfile.setLastname(row.getString("lastname"));
        return userProfile;
    }
}
