package com.musu.repository;

import com.musu.model.AddressEntity;
import com.musu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Ortayol on 15.01.2017.
 */
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

    @Query(value = "select a from AddressEntity a,User u where a.user.id=?1 and a.user.id=u.id")
    User getAddressbyId(int id);


}
