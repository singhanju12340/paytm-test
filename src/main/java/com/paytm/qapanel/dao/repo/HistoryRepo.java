package com.paytm.qapanel.dao.repo;

import com.paytm.qapanel.dao.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anjukumari on 18/01/19
 */
@Repository
public interface HistoryRepo  extends JpaRepository<History, Integer>{


}
