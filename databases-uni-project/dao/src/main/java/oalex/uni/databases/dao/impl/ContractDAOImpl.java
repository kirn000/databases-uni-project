package oalex.uni.databases.dao.impl;

import oalex.uni.databases.dao.ContractDAO;
import oalex.uni.databases.model.Contract;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "contractDAO")
@Transactional
public class ContractDAOImpl extends BaseObjectDAOImpl<Contract> implements ContractDAO {
    public ContractDAOImpl(){
        super(Contract.class);
    }
}
