package com.panditya.elements_logger.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.panditya.elements_logger.Entitys.Log;

@RepositoryRestResource
public interface LogRepo extends JpaRepository<Log , String >{
    //service_name,year,month,day,hour,minute,second,milisecond,method_details,message,level

    @Query(value="select * from dev.log where log_uuid= :UUID",nativeQuery=true)
    public Optional<Log> findLogById(@Param("UUID") String UUID);

    @Query(value="select * from dev.log where service_name= :serviceName limit :logLimit",nativeQuery=true)
    public List<Log> findLogByServiceName(@Param("serviceName") String serviceName,@Param("logLimit") Short logLmit);

    @Query(value="select * from dev.log where service_name=:serviceName AND log_uuid > :UUID limit :logLimit",nativeQuery=true)
    public List<Log> findLogByServiceNameAndId(@Param("serviceName") String serviceName,@Param("UUID") String UUID,@Param("logLimit") Short logLmit);

    @Query(value="select * from dev.log where service_name=:serviceName AND level= :logLevel  limit :logLimit",nativeQuery=true)
    public List<Log> findLogByServiceNameAndLevel(@Param("serviceName") String serviceName,@Param("logLevel") String logLevel,@Param("logLimit") Short logLmit);

    @Query(value="select * from dev.log where service_name=:serviceName AND level= :logLevel AND log_uuid > :UUID limit :logLimit",nativeQuery=true)
    public List<Log> findLogByServiceNameAndLevelAndId(@Param("serviceName") String serviceName,@Param("logLevel") String logLevel,@Param("UUID") String UUID,@Param("logLimit") Short logLmit);

    


}
