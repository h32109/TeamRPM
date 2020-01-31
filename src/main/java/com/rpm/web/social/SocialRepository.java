package com.rpm.web.social;

import com.rpm.web.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository extends CrudRepository<Social, Long>{
    public Social findSocialByUserSeq(User user);
}
